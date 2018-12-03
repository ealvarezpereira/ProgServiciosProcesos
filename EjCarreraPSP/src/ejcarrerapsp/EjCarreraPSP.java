/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejcarrerapsp;

/**
 *
 * @author quique
 */
public class EjCarreraPSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creamos el objeto de tipo carrera
        Carrera c = new Carrera();
        
        //Creamos los objetos de tipo tortuga y liebre y les pasamos el objeto carrera
        Tortuga t = new Tortuga(c);
        Liebre l = new Liebre(c);
        
        //Iniciamos los hilos
        t.start();
        l.start();
    }

}
