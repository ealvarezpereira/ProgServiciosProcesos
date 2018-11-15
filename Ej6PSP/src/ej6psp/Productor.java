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
    Transicion t;
    int ingreso;

    public Productor(Transicion tt) {
        this.t = tt;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {

            ingreso = (int) (Math.random() * 50 + 1);

            t.setDinero(t.getDinero()+ingreso);
            System.out.println("Dinero introducido: "+ingreso);
            System.out.println("Dinero total: "+t.getDinero());
        }
    }
}
