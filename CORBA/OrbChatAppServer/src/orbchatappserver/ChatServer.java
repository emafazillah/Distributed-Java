/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbchatappserver;

import OrbChat.ChatClientInt;
import OrbChat.ChatServerIntPOA;
import java.util.Vector;

/**
 *
 * @author g41113red
 */
public class ChatServer extends ChatServerIntPOA {

    private Vector v = new Vector();

    public boolean login(ChatClientInt a) {
        System.out.println(a.getName() + "  got connected....");
        a.tell("You have Connected successfully.");
        publish(a.getName() + " has just connected.");
        v.add(a);
        return true;
    }

    public void publish(String s) {
        System.out.println(s);
        for (int i = 0; i < v.size(); i++) {
            try {
                ChatClientInt tmp = (ChatClientInt) v.get(i);
                tmp.tell(s);
            } catch (Exception e) {
                //problem with the client not connected.
                //Better to remove it
            }
        }
    }

    public String getConnected() {
        return v.toString();
    }

    public void getConnected(String newGetConnected) {
        char[] sChars = newGetConnected.toCharArray();
        for (int i = 0; i < newGetConnected.length(); ++i) {
            v.add(sChars[i]);
        }
    }

}
