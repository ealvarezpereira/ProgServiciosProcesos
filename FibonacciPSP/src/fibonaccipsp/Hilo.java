/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaccipsp;

/**
 *
 * @author quique
 */
class Hilo extends Thread {

    int n1 = 1;
    int n3;
    int n2 = 1;

    public void run() {
        System.out.println(n1);
        for (int i = 0; i < 10; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;

            System.out.println(n1);
        }
    }
}
