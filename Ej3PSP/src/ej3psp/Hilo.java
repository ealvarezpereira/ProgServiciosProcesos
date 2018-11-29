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
    
    //h es el numero de hilo para la ejecucion del programa
    int h;   
    //id es el numero de hilo que se muestra por pantalla
    static int id; 

    public Hilo(int h, int id) {
        //le asignamos un constructor por parametros
        this.h = h;
        this.id = id;
        
        try {
            //Cuando instanciamos un hilo se ejecuta con el start en el constructor
            this.start();
            //Con el join mientras que el hilo que se esté ejecutando no termine no se ejecuta otro nuevo
            this.join();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {

        try {
            //Imprimimos el numero de hilo
            System.out.println("Soy el hilo " + id);
            for (int i = 1; i < 11; i++) {
                
                //Imprimimos un mensaje junto el numero de hilo y el numero de ejecución
                System.out.println("Hola " + id + ": " + i); 
                
                //Hacemos que el hilo espere un tiempo random entre 600 y 100 ms
                Thread.sleep((long) (Math.random() * 600 + 100));
                
                //Cuando el for llegue a la ultima ejecucion se incrementa la variable de numero de hilo
                if (i == 10) {
                    h++;
                    //Mientras que el numero de hilo sea mayor o igual a 5(numero maximo de hilos) se crea un hilo nuevo
                    //al que se le pasan el numero de hilo y el numero de hilo que se muestra
                    if (h <= 5) {
                        id++;
                        Hilo h1 = new Hilo(h, id);
                    }
                }
            }
            //Cuando termina la ejecución de un hilo se muestra un mensaje de fin
            System.out.println("Termina hilo " + id);
            id--;

        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
