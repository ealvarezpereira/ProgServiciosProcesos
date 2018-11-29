/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej6psp;

/**
 *
 * @author quique
 */
public class Ej6PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creamos el objeto transicion en el main porque al crearlo en el hilo se crean objetos infinitos
        Transicion t = new Transicion();
        //Les pasamos el objeto transicion para que puedan acceder a los metodos
        Consumidor c = new Consumidor(t);
        Productor p = new Productor(t);
        
        p.start();
        c.start();
    }
    
}
