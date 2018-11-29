/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4psp;

/**
 *
 * @author quique
 */
public class SumaMil extends Thread{
    
    int suma;
    
    public void run(){
        //Bucle for que suma los numeros pares
        for (int i = 1; i < 1001; i++) {
            //Si el resto de la division de i / 2 es 0 se incrementa la variable suma
            if (i%2 == 0) {       
                suma=suma+i;        
            }
        }
        //Se muestra el resultado de la suma por pantalla
        System.out.print(suma+" ");
    }
    
}
