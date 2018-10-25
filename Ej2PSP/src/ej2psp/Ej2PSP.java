/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2psp;

/**
 *
 * @author quique
 */
public class Ej2PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo();
        Hilo hilo2 = new Hilo();
        Hilo hilo3 = new Hilo();
        Hilo hilo4 = new Hilo();
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
    
}
