/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.client;

import in.spiph.packets.iplookup.IpLookupPacket;
import in.spiph.packets.packetmanager.BufferedManager;
import in.spiph.packets.packetmanager.IPacketManager;
import in.spiph.packets.test.TestPacket;
import java.net.Socket;

/**
 *
 * @author Bennett.DenBleyker, Gabriel.Maxfield
 */
public class MultiClient {

    private final String url;
    private final int port;

    public MultiClient(String url, int port) {
        this.url = url;
        if (port == -1) {
            this.port = 4198;
        } else {
            this.port = port;
        }
    }

    public void dos(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println(i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket socket = new Socket(url, port);
                        IPacketManager man = new BufferedManager(socket);
                        man.sendPacket(new TestPacket());
                        System.out.println(man.readPacket());
                        man.sendPacket(new IpLookupPacket(1234));
                        System.out.println(man.readPacket());
                        man.sendPacket(new IpLookupPacket(666));
                        System.out.println(man.readPacket());
                        man.sendPacket(new IpLookupPacket(2222));
                        System.out.println(man.readPacket());
                        man.close(); 
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
            System.out.println(i + "f");
        }
    }
}
