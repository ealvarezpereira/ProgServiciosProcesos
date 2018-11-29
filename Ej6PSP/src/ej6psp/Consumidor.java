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
    //T es un objeto de tipo Transicion sin instanciar
    Transicion t;
    //Quitar es la cantidad que recoge
    int quitar;
    
    //A la variable t le asignamos el objeto que recogemos del main 
    public Consumidor(Transicion tt){
    this.t = tt;
    }
    
    public void run(){
    
        for (int i = 0; i < 5; i++) {
            //La cantidad que retiramos es un numero random entre 1 y 50
            quitar = (int) (Math.random() * 50 + 1);
            //Hacemos el retiro, para ello recogemos el dinero que hay ya ingresado y le restamos lo que retiramos 
            t.setDinero(t.getDinero()-quitar);
            //Mostramos el dinero que quitamos
            System.out.println("Dinero retirado: "+quitar);
            //Mostramos el dinero total
            System.out.println("Total en el banco: "+t.getDinero());
        }
    }
}
