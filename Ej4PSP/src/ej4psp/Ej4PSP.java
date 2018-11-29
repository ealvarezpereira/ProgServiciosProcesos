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
public class Ej4PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SumaMil sm = new SumaMil();
        SumaImpares si = new SumaImpares();
        SumaDosTres sdt = new SumaDosTres(); 
        
        sm.start();
        si.start();
        sdt.start();
    }
    
}
