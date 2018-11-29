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
                System.out.println(getName() + " " + i); //Imprime el nombre del hilo y el numero de ejecución
                Thread.sleep(1000); //El hilo espera un tiempo de 1s

                if (i == 4) {
                    acabo++; //En cada hilo, si llega a la ultima ejecucion del for se suma +1 a la variable acabo
                }
            } catch (InterruptedException ex) {
                System.out.println("Error " + ex);
            }
        }
        System.out.println("Termina thread " + getName()); //Cuando termina un hilo se muestra el mensaje de fin de hilo
        if (acabo == 4) {
            System.out.println("Acabaron todos los hilos."); //Si han terminado los 4 hilos muestra el mensaje de que han terminado todos
        }
    }

}
