/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1psp;

/**
 *
 * @author quique
 */
class Hilo extends Thread {

       public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(getName() + " " + i);
                long sleep = (long) (Math.random() * 5000 + 2000);
                Thread.sleep(sleep);
                
            } catch (InterruptedException ex) {
                System.out.println("Error " + ex);
            }
        }
        System.out.println("Termina thread " + getName());
    }
}
