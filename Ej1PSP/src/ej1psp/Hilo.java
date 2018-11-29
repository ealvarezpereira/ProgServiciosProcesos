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
                System.out.println(getName() + " " + i); //Imprime el nombre del hilo y el numero de ejecución del bucle for
                long sleep = (long) (Math.random() * 5000 + 2000); //Espera un tiempo aleatorio entre 5000ms y 2000ms
                Thread.sleep(sleep); //El hilo espera
                
            } catch (InterruptedException ex) {
                System.out.println("Error " + ex);
            }
        }
        System.out.println("Termina thread " + getName()); //Al terminar de recorrer el for indica que el hilo ha terminado
    }
}
