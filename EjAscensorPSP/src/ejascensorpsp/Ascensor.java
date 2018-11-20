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

    int piso = 0;
    static boolean movimiento = false;

    public synchronized void llamar(int plantaLlamada, int destino, String persona) {

        while (movimiento) {

            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ascensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (plantaLlamada > piso) {

            System.out.println("Subiendo a llamada");

            while (plantaLlamada > piso) {
                piso++;
                movimiento = true;
            }

            System.out.println("Llega al piso de " + persona + ".(" + piso + ") Sube al ascensor");

            while (movimiento) {
                if (destino > piso) {
                    piso++;
                } else if (destino < piso) {
                    piso--;
                } else {
                    System.out.println(persona+" ha llegado a su destino. ("+piso+")");
                    movimiento = false;
                }
            }

        } else {
            System.out.println("Bajando a llamada");
            while (plantaLlamada < piso) {
                piso--;
                movimiento = true;
            }

            System.out.println("Llega al piso de " + persona + ".(" + piso + ") Sube al ascensor");

            while (movimiento) {
                if (destino > piso) {
                    piso++;
                } else if (destino < piso) {
                    piso--;
                } else {
                    System.out.println(persona+" ha llegado a su destino. ("+piso+")");
                    movimiento = false;
                }
            }
        }

    }
}
