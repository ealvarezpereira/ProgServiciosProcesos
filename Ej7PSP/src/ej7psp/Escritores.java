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
    //b Es el objeto de tipo bandeja
    Bandeja b;
    //numeroHilo es el numero de hilo que escribe
    int numeroHilo;
    //Mensaje es el mensaje que escribe
    String mensaje;

    //Constructor con parametros
    public Escritores(Bandeja b, int numeroHilo, String mensaje) {
        this.b = b;
        this.numeroHilo = numeroHilo;
        this.mensaje = mensaje;
    }

    public void run() {
        //Introducimos el mensaje en la bandeja de entrada
        b.setMensaje(mensaje);
        //Mostramos que hilo ha escrito
        System.out.println("Escribe el hilo " + numeroHilo);
    }
}
