/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1psp;

/**
 *
 * @author quique
 */
public class Ej1PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creacion de los hilos e iniciación
        Hilo hilo1 = new Hilo();
        Hilo hilo2 = new Hilo();
        hilo1.start();
        hilo2.start();

    }

}
