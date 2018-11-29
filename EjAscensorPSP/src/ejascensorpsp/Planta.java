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
    //Numero de planta desde la que se llama al ascensor
    int plantaLlamada;
    //Objeto ascensor sin instanciar
    Ascensor a;
    //Nombre de la persona que llama al ascensor
    String persona;
    //Numero de planta destino de cada persona
    int destino;
    //Constructor por parametros
    public Planta(int plantaLlamada,int destino,String persona, Ascensor a) {
        this.plantaLlamada = plantaLlamada;
        this.destino = destino;
        this.persona = persona;
        this.a = a;
    }
    
    public void run(){  
        //Llamamos al método del funcionamiento del ascensor y le pasamos
        //La planta desde que se llama al ascensor
        //El destino de la persona que llama
        //Y el nombre de la persona
        a.llamar(plantaLlamada, destino, persona);      
    }
}
