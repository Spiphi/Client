/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.client;

/**
 *
 * @author Bennett.DenBleyker & GABE MAXFIELD
 */
public class Application {

    public static void main(String[] args) {
        MultiClient clients = new MultiClient("localhost", 4198);
        clients.dos(100);
    }
}
