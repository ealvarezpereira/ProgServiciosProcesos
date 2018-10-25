/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2psp;

/**
 *
 * @author quique
 */
class Hilo extends Thread {

    static int acabo = 0;

    public void run() {

        for (int i = 0; i < 5; i++) {

            try {
                System.out.println(getName() + " " + i);
                Thread.sleep(1000);

                if (i == 4) {
                    acabo++;
                }
            } catch (InterruptedException ex) {
                System.out.println("Error " + ex);
            }
        }
        System.out.println("Termina thread " + getName());
        if (acabo == 4) {
            System.out.println("Acabaron todos los hilos.");
        }
    }

}
