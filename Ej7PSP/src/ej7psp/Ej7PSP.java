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
        Bandeja b = new Bandeja();
        Escritores e1 = new Escritores(b, 1, "Mensaje de hilo 1");
        Escritores e2 = new Escritores(b, 2, "Mensaje de hilo 2");
        Escritores e3 = new Escritores(b, 3, "Mensaje de hilo 3");

        Lectores l1 = new Lectores(b, 1);
        Lectores l2 = new Lectores(b, 2);
        Lectores l3 = new Lectores(b, 3);

        e1.start();
        e2.start();
        e3.start();

        l1.start();
        l2.start();
        l3.start();

    }

}
