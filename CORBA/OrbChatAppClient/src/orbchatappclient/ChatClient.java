/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbchatappclient;

import OrbChat.ChatClientIntPOA;

/**
 *
 * @author g41113red
 */
public class ChatClient extends ChatClientIntPOA {

    private String name;
    private OrbChatAppClient ui;

    public ChatClient(String n) throws Exception {
        name = n;
    }

    public void tell(String name) {
        System.out.println(name);
        ui.writeMsg(name);
    }

    public String getName() {
        return name;
    }

    public void setGUI(OrbChatAppClient t) {
        ui = t;
    }

}
