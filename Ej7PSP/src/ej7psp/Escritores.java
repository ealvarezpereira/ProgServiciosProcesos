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
public class Escritores extends Thread {
        Bandeja b;
    int numeroHilo;
    String mensaje;

    public Escritores(Bandeja b, int numeroHilo,String mensaje) {
        this.b = b;
        this.numeroHilo = numeroHilo;
        this.mensaje = mensaje;
    }
    
    public void run(){
        b.setMensaje(mensaje);
        System.out.println("Escribe el hilo "+numeroHilo);
    }
}
