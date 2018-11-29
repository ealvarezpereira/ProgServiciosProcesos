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
public class SumaDosTres extends Thread{
    
     int suma;
    
    public void run(){
        //Bucle for que suma los numeros terminados en dos y en tres
        for (int i = 1; i < 1001; i++) {
            //Si el resto de dividir i / 10 da 2 o 3, la variable de suma se incrementa
            if (i%10 == 2 || i%10 == 3) {       
                suma=suma+i;        
            }
        }
        //Se muestra el resultado de la suma por pantalla
        System.out.print(suma+" ");
    } 
}
