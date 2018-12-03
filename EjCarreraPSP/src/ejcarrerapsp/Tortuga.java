/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejcarrerapsp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quique
 */
public class Tortuga extends Thread {

    Carrera c;

    //Asignamos el objeto de tipo carrera
    public Tortuga(Carrera c) {
        this.c = c;
    }

    public void run() {
        //Mensaje que da el comienzo a la tortuga
        System.out.println("Comienza la tortuga!");

        //Mientras que no haya un ganador se ejecuta el código
        while (Carrera.ganador == false) {
            try {
                //Sleep de 1 segundo
                Thread.sleep(1000L);
                //Math.random que asigna un numero aleatorio de probabilidad
                int probabilidad = (int) (Math.random() * 100) + 1;

                if (probabilidad <= 50) {
                    //Probabilidad del 50% -> La tortuga avanza rapido
                    System.out.println("La tortuga sacó avance rápido! Avanza 3 casillas");
                    //Le pasamos los parametros: boolean -> si resbaló o no, string -> el nombre del animal, int -> la cantidad que 
                    //avanza o retrocede
                    c.batalla(false, "tortuga", 3);
                } else if (probabilidad > 50 && probabilidad <= 70) {
                    //Probabilidad del 20% -> La tortuga resbala
                    System.out.println("La tortuga resbaló! Retrocede 6 casillas");
                    //Le pasamos los parametros: boolean -> si resbaló o no, string -> el nombre del animal, int -> la cantidad que 
                    //avanza o retrocede
                    c.batalla(true, "tortuga", 6);
                } else if (probabilidad > 70 && probabilidad <= 100) {
                    //Probabilidad del 30% -> La tortuga avanza lento
                    System.out.println("La tortuga sacó avance lento! Avanza 1 casilla");
                    //Le pasamos los parametros: boolean -> si resbaló o no, string -> el nombre del animal, int -> la cantidad que 
                    //avanza o retrocede
                    c.batalla(false, "tortuga", 1);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Tortuga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
