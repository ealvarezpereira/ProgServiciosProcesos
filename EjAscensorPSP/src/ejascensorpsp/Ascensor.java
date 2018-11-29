/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejascensorpsp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quique
 */
public class Ascensor {

    //Numero de piso inicial del ascensor
    int piso = 0;
    //Boolean que dice si el ascensor está en movimiento o no
    static boolean movimiento = false;

    //Metodo synchronized para que los hilos se sincronicen
    public synchronized void llamar(int plantaLlamada, int destino, String persona) {

        //Mientras que el hilo esté en movimiento las llamadas no harán que se pare
        while (movimiento) {
            try {
                //El hilo espera a que deje de estar en movimiento
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ascensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Si la planta desde que se llama al ascensor es mayor que la planta en la que está el ascensor, el ascensor sube
        if (plantaLlamada > piso) {
            //Muestra un mensaje que dice que el ascensor sube
            System.out.println("Subiendo a llamada");
            //Mientras que la planta desde que se llama sea mayor que el piso del ascensor, el ascensor asciende
            while (plantaLlamada > piso) {
                //Se suma la variable del numero de piso en el que se encuentra el ascensor
                piso++;
                //Se establece el ascensor en movimiento
                movimiento = true;
            }
            //Muestra un mensaje que dice el nombre de la persona y el piso en el que esta
            System.out.println("Llega al piso de " + persona + ".(" + piso + ") Sube al ascensor");

            //Mientras que el ascensor esté en proceso de llevar a una persona
            while (movimiento) {

                //Si el destino es mayor que el piso del ascensor, el ascensor asciende
                if (destino > piso) {

                    //Se suma la variable del numero de piso en el que se encuentra el ascensor
                    piso++;

                    //Si el destino es menor que el piso del ascensor, el ascensor desciende
                } else if (destino < piso) {

                    //Se resta la variable del numero de piso en el que se encuentra el ascensor
                    piso--;

                    //Si es igual muestra un mensaje en el que la persona ha llegado a su destino
                } else {
                    System.out.println(persona + " ha llegado a su destino. (" + piso + ")");
                    //El ascensor deja de estar en movimiento
                    movimiento = false;
                }
            }

            //Si la planta desde que se llama al ascensor es menor que la planta en la que está el ascensor, el ascensor baja
        } else {

            //Muestra un mensaje que dice que el ascensor baja
            System.out.println("Bajando a llamada");

            //Mientras que la planta desde que se llama sea menor que el piso del ascensor, el ascensor descende
            while (plantaLlamada < piso) {
                //Se resta la variable del numero de piso en el que se encuentra el ascensor
                piso--;
                //Se establece el ascensor en movimiento
                movimiento = true;
            }

            //Muestra un mensaje que dice el nombre de la persona y el piso en el que esta
            System.out.println("Llega al piso de " + persona + ".(" + piso + ") Sube al ascensor");

            //Mientras que el ascensor esté en proceso de llevar a una persona
            while (movimiento) {

                //Si el destino es mayor que el piso del ascensor, el ascensor asciende
                if (destino > piso) {
                    //Se suma la variable del numero de piso en el que se encuentra el ascensor
                    piso++;

                    //Si el destino es menor que el piso del ascensor, el ascensor desciende
                } else if (destino < piso) {

                    //Se resta la variable del numero de piso en el que se encuentra el ascensor
                    piso--;

                    //Si es igual muestra un mensaje en el que la persona ha llegado a su destino
                } else {
                    System.out.println(persona + " ha llegado a su destino. (" + piso + ")");

                    //El ascensor deja de estar en movimiento
                    movimiento = false;
                }
            }
        }
    }
}
