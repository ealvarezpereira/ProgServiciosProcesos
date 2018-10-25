/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej5psp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quique
 */
public class Hilo extends Thread {

   static int h;
    int id;

    public Hilo(int id) {
        this.id = id;
        try {
            
            if (h == 0) {
                h++;
                Hilo h2 = new Hilo(2);
                h2.setPriority(Thread.MAX_PRIORITY);
                //h2.join();
            }

        this.start();
        } catch (Exception ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {

        System.out.println("Soy el hilo " + id);
    }
}
