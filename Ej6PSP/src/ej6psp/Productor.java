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
public class Productor extends Thread {
    //T es un objeto de tipo Transicion sin instanciar
    Transicion t;
    //Es la cantidad que produce
    int ingreso;

    //A la variable t le asignamos el objeto que recogemos del main
    public Productor(Transicion tt) {
        this.t = tt;
    }

    public void run() {
        //Bucle for que produce 10 veces
        for (int i = 0; i < 10; i++) {
            //La cantidad que ingresamos es un numero random entre 1 y 50
            ingreso = (int) (Math.random() * 50 + 1);
            
            //Hacemos el ingreso, para ello recogemos el dinero que hay ya ingresado y le sumamos lo que ingresamos
            t.setDinero(t.getDinero()+ingreso);
            //Mostramos el dinero que ingresamos
            System.out.println("Dinero introducido: "+ingreso);
            //Mostramos el dinero total
            System.out.println("Dinero total: "+t.getDinero());
        }
    }
}
