/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3psp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quique
 */
public class Hilo extends Thread {

    int h;
    static int id;

    public Hilo(int h, int id) {

        this.h = h;
        this.id = id;
        try {
            this.start();
            this.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {

        try {
            System.out.println("Soy el hilo " + id);
            for (int i = 1; i < 11; i++) {

                System.out.println("Hola " + id + ": " + i);
                
                Thread.sleep((long) (Math.random() * 600 + 100));
                
                if (i == 10) {
                    h++;
                    if (h <= 5) {
                        id++;
                        Hilo h1 = new Hilo(h, id);
                    }
                }
            }

            System.out.println("Termina hilo " + id);
            id--;

        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
