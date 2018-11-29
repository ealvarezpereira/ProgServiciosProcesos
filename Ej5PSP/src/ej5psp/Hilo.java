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
    
   //H es el numero de hilo para la ejecucion del programa
   static int h;
   //Id es el numero de hilo que se muestra por pantalla
    int id;

    public Hilo(int id) {
        //En el constructor le pasamos como parámetro el número de hilo que mostramos por pantalla
        this.id = id;
        try {
            
            //Si se está ejecutando el primer hilo la variable h se suma para que no entre en esta condicion
            if (h == 0) {
                h++;
                //Se crea el segundo hilo pasandole el id de hilo
                Hilo h2 = new Hilo(2);
                //Al hilo dos le establecemos la prioridad máxima (b- Hazlo con prioridades)
                h2.setPriority(Thread.MAX_PRIORITY);
                //Con join hacemos que mientras que el hilo 2 no termine no empiece el hilo 1 (a- Hazlo con join)
                //(Descomentar .join y comentar .setPriority para verificar funcionamiento)
                /* h2.join(); */
            }
        //Cuando creamos un hilo éste se inicia con el .start()
        this.start();
        } catch (Exception ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        //Muestra el numero de hilo 
        System.out.println("Soy el hilo " + id);
    }
}
