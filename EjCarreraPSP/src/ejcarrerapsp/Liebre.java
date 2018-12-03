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
public class Liebre extends Thread {

    Carrera c;

    //Asignamos el objeto de tipo carrera
    public Liebre(Carrera c) {
        this.c = c;
    }

    public void run() {
        //Mensaje que da el comienzo a la liebre
        System.out.println("Comienza la liebre!");
        //Mientras que no haya un ganador se ejecuta el código
        while (Carrera.ganador == false) {
            try {
                //Sleep de 1 segundo
                Thread.sleep(1000L);
                //Math.random que asigna un numero aleatorio de probabilidad
                int probabilidad = (int) (Math.random() * 100) + 1;

                if (probabilidad <= 20) {
                    //Probabilidad del 20% -> La liebre duerme
                    System.out.println("La liebre duerme");
                    //Le pasamos los parametros: boolean -> si resbaló o no, string -> el nombre del animal, int -> la cantidad que 
                    //avanza o retrocede
                    c.batalla(false, "liebre", 0);
                } else if (probabilidad > 20 && probabilidad <= 40) {
                    //Probabilidad del 20% -> La liebre avanza rápido
                    System.out.println("La liebre sacó gran salto! Avanza 9 casillas.");
                    //Le pasamos los parametros: boolean -> si resbaló o no, string -> el nombre del animal, int -> la cantidad que 
                    //avanza o retrocede
                    c.batalla(false, "liebre", 9);
                } else if (probabilidad > 40 && probabilidad <= 50) {
                    //Probabilidad del 10% -> La liebre resbala muy fuerte
                    System.out.println("La liebre resbaló muy fuerte! Retrocede 12 casillas");
                    //Le pasamos los parametros: boolean -> si resbaló o no, string -> el nombre del animal, int -> la cantidad que 
                    //avanza o retrocede
                    c.batalla(true, "liebre", 12);
                } else if (probabilidad > 50 && probabilidad <= 80) {
                    //Probabilidad del 30% -> La liebre avanza lento
                    System.out.println("La liebre sacó un pequeño salto! Avanza 1 casilla");
                    //Le pasamos los parametros: boolean -> si resbaló o no, string -> el nombre del animal, int -> la cantidad que 
                    //avanza o retrocede
                    c.batalla(false, "liebre", 1);
                } else if (probabilidad > 80 && probabilidad <= 100) {
                    //Probabilidad del 20% -> La liebre resbala lento
                    System.out.println("La liebre resbaló despacio! Retrocede 2 casillas");
                    //Le pasamos los parametros: boolean -> si resbaló o no, string -> el nombre del animal, int -> la cantidad que 
                    //avanza o retrocede
                    c.batalla(true, "liebre", 2);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
