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
public class Consumidor extends Thread{
    
    Transicion t;
    int quitar;
    
    public Consumidor(Transicion tt){
    this.t = tt;
    }
    
    public void run(){
    
        for (int i = 0; i < 5; i++) {
            
            quitar = (int) (Math.random() * 50 + 1);
            
            t.setDinero(t.getDinero()-quitar);
            
            System.out.println("Dinero retirado: "+quitar);
            System.out.println("Total en el banco: "+t.getDinero());
        }
    }
}
