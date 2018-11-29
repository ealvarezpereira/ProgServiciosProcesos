/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej6psp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quique
 */
public class Transicion {

    //Establecemos el dinero base a 50
    int dinero = 50;

    //Booleans que nos permiten recoger y colocar
    static boolean recoger = true, colocar = true;

    //Con getDinero recogemos dinero
    public synchronized int getDinero() {
        //Mientras que no puedas recoger, puedes colocar
        while (recoger == false) {
            try {
                //Igualas colocar a true para que el hilo productor pueda insertar dinero
                colocar = true;
                //El hilo Consumidor espera a que termine el hilo Productor
                wait();
            } catch (Exception ex) {
                Logger.getLogger(Transicion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si el dinero es negativo no retiramos, introducimos dinero
        if (dinero <= 0) {
            recoger = false;
            colocar = true;
        }
        //Una vez se haya ejecutado la sentencia de recoger dinero notifica de que el hilo a finalizado su ejecucion
        notify();

        return dinero;
    }

    //Le pasamos por parametro el dinero introducido
    public synchronized void setDinero(int cash) {
        try {
            //Mientras que no podamos colocar, podemos recoger
            while (colocar == false) {
                //Igualamos recoger a true para que el hilo consumidor pueda recoger dinero
                recoger = true;
                //El hilo Productor espera al hilo Consumidor
                wait();

            }
            //A la variable dinero le asignamos 'cash' que es el dinero que introducimos / retiramos
            dinero = cash;        
            //Una vez se haya ejecutado la sentencia de insertar dinero notifica de que el hilo a finalizado su ejecucion
            notify();

        } catch (Exception ex) {
            Logger.getLogger(Transicion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
