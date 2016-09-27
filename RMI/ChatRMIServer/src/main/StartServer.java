/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author EMA
 */
public class StartServer {

    public static void main(String[] args) {
        try {
            //System.setSecurityManager(new RMISecurityManager());
            //java.rmi.registry.LocateRegistry.createRegistry(1099);
            Registry reg = LocateRegistry.createRegistry(1099);

            ChatServerInt b = new ChatServer();
            //Naming.rebind("rmi://172.16.16.118/myabc", b);
            reg.rebind("server", b);
            System.out.println("[System] Chat Server is ready.");
        } catch (Exception e) {
            System.out.println("Chat Server failed: " + e);
        }
    }
}
