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
public class SumaImpares extends Thread{
    
    int suma;
    
    public void run(){
    
        for (int i = 1; i < 1001; i++) {
            
            if (i%2 != 0) {       
                suma=suma+i;        
            }
        }
        System.out.print(suma+" ");
    }
}
