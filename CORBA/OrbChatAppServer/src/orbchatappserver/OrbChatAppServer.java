/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbchatappserver;

import OrbChat.ChatServerInt;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManager;

/**
 *
 * @author g41113red
 */
public class OrbChatAppServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // initializing ORB
            ORB orb = ORB.init(args, null);

            // getting reference to POA
            org.omg.CORBA.Object obj = orb.resolve_initial_references("RootPOA");
            POA rootpoa = POAHelper.narrow(obj);
            // getting reference to POA manager
            POAManager manager = rootpoa.the_POAManager();
            // activating manager 
            manager.activate();

            // getting NameService
            obj = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = org.omg.CosNaming.NamingContextExtHelper.narrow(obj);

            // creating servant
            ChatServer cs = new ChatServer();
            // connecting servant to ORB 
            ChatServerInt csi = cs._this(orb);
            // binding servant reference to NameService
            ncRef.rebind(ncRef.to_name("chatserver_yzioaw"), csi);

            System.out.println("Object activated");
            // starting orb
            orb.run();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
