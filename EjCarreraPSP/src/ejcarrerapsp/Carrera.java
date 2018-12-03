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
public class Carrera {

    //tortuga: posicion de la tortuga
    //liebre: posicion de la liebre
    public int tortuga, liebre;
    //turnoTortuga: indica que es el turno del hilo de la tortuga
    //turnoLiebre: indica que es el turno del hilo de la liebre
    public boolean turnoTortuga = false, turnoLiebre = true;
    //boolean que indica si alguno de los dos ha ganado o no
    public static boolean ganador = false;

    /**
     * @param resbalo Boolean que indica si la tortuga/liebre resbalaron o no
     * @param tortugaLiebre Nombre del animal para conocer de quien es el turno
     * @param cantidad Numero de casillas que tienen que retroceder/avanzar
     */
    public synchronized void batalla(boolean resbalo, String tortugaLiebre, int cantidad) {

        //Mientras que sea el turno de la liebre, la tortuga espera
        while (turnoTortuga = false) {
            try {
                wait();
                turnoLiebre = true;
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Mientras que sea el turno de la tortuga, la liebre espera
        while (turnoLiebre = false) {
            try {
                wait();
                turnoTortuga = true;
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Si la tortuga aun no ha ganado se ejecuta el codigo
        if (tortuga < 100) {
            //Si es el turno de la tortuga se ejecuta el codigo
            if (tortugaLiebre.equals("tortuga")) {
                //Si la tortuga resbaló se ejecuta el codigo
                if (resbalo) {
                    //Si la tortuga resbalo en el primer turno se le asigna la posicion a 1
                    if (tortuga - cantidad < 0) {
                        tortuga = 1;
                    } else {
                        //Si no, resbala sin más
                        tortuga = tortuga - cantidad;
                    }
                } else {
                    //Si la tortuga no resbala, avanza
                    tortuga = tortuga + cantidad;
                }
            }
        } else {
            //Si la tortuga ha ganado, se imprime el mensaje
            System.out.println("Gano la tortuga!");
            ganador = true;
        }

        //Si la liebre aun no ha ganado se ejecuta el codigo
        if (liebre < 100) {
            //Si es el turno de la liebre se ejecuta el codigo
            if (tortugaLiebre.equals("liebre")) {
                //Si la liebre resbaló se ejecuta el codigo
                if (resbalo) {
                    //Si la liebre resbalo en el primer turno se le asigna la posicion a 1
                    if (liebre - cantidad < 0) {
                        liebre = 1;
                    } else {
                        //Si no, resbala sin más
                        liebre = liebre - cantidad;
                    }
                } else {
                    //Si la liebre no resbala, avanza
                    liebre = liebre + cantidad;
                }
            }
        } else {
            //Si la liebre ha ganado, se imprime el mensaje
            System.out.println("Gano la liebre!");
            ganador = true;
        }
        //Mostramos la posición de la liebre y la tortuga
        System.out.println("Posicion de la tortuga: " + tortuga);
        System.out.println("Posicion de la liebre: " + liebre);
        //Notificamos al siguiente hilo de que puede ser ejecutado
        notify();
    }
}
