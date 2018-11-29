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
public class EjAscensorPSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Creamos el objeto ascensor para mandarselo a cada planta, puesto que si lo creamos en el hilo
       //crearía ascensores infinitos
       Ascensor a = new Ascensor();
       //Creamos los objetos tipo planta y les pasamos el numero de planta, el destino de la persona,
       //el nombre de la persona y el objeto de tipo ascensor
       Planta p3= new Planta(3, 20,"Quique",a);
       Planta p5 = new Planta(5, 0, "Alejandro",a);
       Planta p10 = new Planta(10, 15,"David",a);
       //Iniciamos todos los hilos
       p3.start();
       p5.start();
       p10.start();
    }
    
}
