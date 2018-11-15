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
    
    int dinero = 50;
    private int siguiente = 0;
    static boolean recoger = true, colocar = true;
    
    public synchronized int getDinero() {
        while (recoger == false) {
            try {
                colocar = true;
                wait();
            } catch (Exception ex) {
                Logger.getLogger(Transicion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       if (dinero <= 0) {
            recoger = false;
            colocar = true;
        }    
            notify();
        
        return dinero;
    }
    
    public synchronized void setDinero(int cash) {
        try {
            while (colocar == false) {
                wait();
                recoger = true;
            }
                dinero = cash;
                notify();
            
        } catch (Exception ex) {
            Logger.getLogger(Transicion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
