/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejascensorpsp;

/**
 *
 * @author quique
 */
public class Planta extends Thread{
    
    int plantaLlamada;
    Ascensor a;
    String persona;
    int destino;
    public Planta(int plantaLlamada,int destino,String persona, Ascensor a) {
        this.plantaLlamada = plantaLlamada;
        this.destino = destino;
        this.persona = persona;
        this.a = a;
    }
    
    public void run(){  
        a.llamar(plantaLlamada, destino, persona);      
    }
}
