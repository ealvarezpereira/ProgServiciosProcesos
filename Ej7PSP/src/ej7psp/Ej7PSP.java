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
public class Ej7PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creamos el objeto bandeja y se lo mandamos a los hilos porque si lo creas en los hilos se crean objetos infinitos
        Bandeja b = new Bandeja();
        //Creamos los hilos de cada escritor y les pasamos el objeto Bandeja, el numero de hilo y el mensaje que deben escribir
        Escritores e1 = new Escritores(b, 1, "Mensaje de hilo 1");
        Escritores e2 = new Escritores(b, 2, "Mensaje de hilo 2");
        Escritores e3 = new Escritores(b, 3, "Mensaje de hilo 3");
        //Creamos los hilos de cada lectro y les pasamos el objeto y el numero de hilo
        Lectores l1 = new Lectores(b, 1);
        Lectores l2 = new Lectores(b, 2);
        Lectores l3 = new Lectores(b, 3);
        //Iniciamos los hilos
        e1.start();
        e2.start();
        e3.start();
        //Iniciamos los hilos
        l1.start();
        l2.start();
        l3.start();

    }

}
