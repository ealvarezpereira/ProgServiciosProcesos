/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7psp;

/**
 *
 * @author quique
 */
public class Lectores extends Thread {

    Bandeja b;
    int numeroHilo;

    public Lectores(Bandeja b, int numeroHilo) {
        this.b = b;
        this.numeroHilo = numeroHilo;
    }
    
    public void run(){
        System.out.println("Lee el hilo "+numeroHilo+": "+b.getMensaje());
    }
}
