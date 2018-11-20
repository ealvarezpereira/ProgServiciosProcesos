/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7psp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quique
 */
public class Bandeja {
    
    String mensaje = "";
    boolean hayMensaje = false;
    
    public synchronized void setMensaje(String mensaje){
    
        while(hayMensaje){
        
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bandeja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        this.mensaje = mensaje;
        hayMensaje = true;
    }
    
    public synchronized String getMensaje(){
        
        while(!hayMensaje){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bandeja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        notify();
        hayMensaje = false;
        
        return mensaje;
    }
}
