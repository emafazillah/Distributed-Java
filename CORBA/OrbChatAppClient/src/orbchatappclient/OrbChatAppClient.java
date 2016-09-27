/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbchatappclient;

import OrbChat.ChatClientInt;
import OrbChat.ChatServerInt;
import OrbChat.ChatServerIntHelper;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManager;

/**
 *
 * @author g41113red
 */
public class OrbChatAppClient implements Runnable {

    private ChatClient client;
    private ChatServerInt server;
    protected static ORB orb;
    protected static OrbChatAppClient chatapp;

    public void doConnect(String[] args) {
        if (connect.getText().equals("Connect")) {
            if (name.getText().length() < 2) {
                JOptionPane.showMessageDialog(frame, "You need to type a name.");
                return;
            }
            if (ip.getText().length() < 2) {
                JOptionPane.showMessageDialog(frame, "You need to type an IP.");
                return;
            }
            try {

                client = new ChatClient(name.getText());
                client.setGUI(this);

                // initializing ORB
                orb = ORB.init(args, null);
                // getting NameService
                org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
                NamingContextExt ncRef = org.omg.CosNaming.NamingContextExtHelper.narrow(obj);

                // resolving servant name 
                obj = ncRef.resolve_str("chatserver_yzioaw");
                server = ChatServerIntHelper.narrow(obj);

                // connecting servant to ORB
                ChatClientInt chatclientint = client._this(orb);
                //Thread t = new Thread(new OrbChatAppClient(args));
                Thread t = new Thread(chatapp);
                t.start();
                server.login(chatclientint);
                //updateUsers(server.getConnected());
                updateUsers(chatclientint.getName());
                connect.setText("Disconnect");

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "ERROR, we wouldn't connect....");
            }

        } else {
            updateUsers(null);
            connect.setText("Connect");
            //Better to implement Logout ....
        }
    }

    public void sendText() {
        if (connect.getText().equals("Connect")) {
            JOptionPane.showMessageDialog(frame, "You need to connect first.");
            return;
        }
        String st = tf.getText();
        st = "[" + name.getText() + "] " + st;
        tf.setText("");
        //Remove if you are going to implement for remote invocation
        try {
            server.publish(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeMsg(String st) {
        tx.setText(tx.getText() + "\n" + st);
    }

    public void updateUsers(String v) {
        DefaultListModel listModel = new DefaultListModel();
        if (v != null) {
            try {
                char[] sChars = v.toCharArray();
                for (int i = 0; i < v.length(); ++i) {
                    listModel.addElement(sChars[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        lst.setModel(listModel);
    }

    public static void main(String[] args) {
        System.out.println("Hello World !");
        //OrbChatAppClient c = new OrbChatAppClient(args);
        chatapp = new OrbChatAppClient(args);
    }

    //User Interface code.
    public OrbChatAppClient(String[] args) {
        frame = new JFrame("Group Chat");
        JPanel main = new JPanel();
        JPanel top = new JPanel();
        JPanel cn = new JPanel();
        JPanel bottom = new JPanel();
        ip = new JTextField();
        tf = new JTextField();
        name = new JTextField();
        tx = new JTextArea();
        connect = new JButton("Connect");
        JButton bt = new JButton("Send");
        lst = new JList();
        main.setLayout(new BorderLayout(5, 5));
        top.setLayout(new GridLayout(1, 0, 5, 5));
        cn.setLayout(new BorderLayout(5, 5));
        bottom.setLayout(new BorderLayout(5, 5));
        top.add(new JLabel("Your name: "));
        top.add(name);
        top.add(new JLabel("Server Address: "));
        top.add(ip);
        top.add(connect);
        cn.add(new JScrollPane(tx), BorderLayout.CENTER);
        cn.add(lst, BorderLayout.EAST);
        bottom.add(tf, BorderLayout.CENTER);
        bottom.add(bt, BorderLayout.EAST);
        main.add(top, BorderLayout.NORTH);
        main.add(cn, BorderLayout.CENTER);
        main.add(bottom, BorderLayout.SOUTH);
        main.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Events
        connect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doConnect(args);
            }
        });
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });
        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });

        frame.setContentPane(main);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
    JTextArea tx;
    JTextField tf, ip, name;
    JButton connect;
    JList lst;
    JFrame frame;

    public void run() {
        try {
            // getting reference to POA
            org.omg.CORBA.Object obj = orb.resolve_initial_references("RootPOA");
            POA rootpoa = POAHelper.narrow(obj);
            // getting reference to POA manager
            POAManager manager = rootpoa.the_POAManager();
            // activating manager 
            manager.activate();
            orb.run();
        } catch (Exception e) {
        }
    }
}
