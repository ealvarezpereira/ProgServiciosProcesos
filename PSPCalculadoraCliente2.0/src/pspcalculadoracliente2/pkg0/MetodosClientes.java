/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspcalculadoracliente2.pkg0;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quique
 */
public class MetodosClientes {

    Socket clienteSocket;
    String total;
    InputStream is;
    OutputStream os;

    //Metodo con el que el cliente se conecta al servidor
    public void conexion(String npuerto) {
        try {
            System.out.println("Creando socket cliente");
            clienteSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            
            InetSocketAddress addr = new InetSocketAddress("localhost", Integer.parseInt(npuerto));
            clienteSocket.connect(addr);

            is = clienteSocket.getInputStream();
            os = clienteSocket.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param num1 recibe el numero 1 de la interfaz grafica
     * @param num2 recibe el numero 2 de la interfaz grafica
     * @param operacion recibe la operacion de la interfaz grafica
     * @param m marca para la primera conexion del cliente
     */
    public void enviarOperacion(String num1, String num2, String operacion, int m) {
        try {
            
            /*Escribimos el mensaje tal que así -> num1,operacion,num2#
            El asterisco es porque al definir un array de bytes si el mensaje es menor que elç
            tamaño de dicho array llena con espacios en blanco.
             */
            os.write((num1 + "," + operacion + "," + num2 + "#").getBytes());

            //Recibimos el total del servidor y lo leemos
            byte[] mensaje = new byte[64];
            is.read(mensaje);

            total = new String(mensaje);

            System.out.println("total: " + total);
        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param num recibe el numero de la interfaz grafica
     * @param operacion recibe la operacion de la raiz
     * @param m marca para la primera conexion del cliente
     */
    public void raiz(String num, String operacion, int m) {
        try {
            is = clienteSocket.getInputStream();
            os = clienteSocket.getOutputStream();
            //Escibimos la secuencia de la raiz
            os.write((num + "," + operacion + "#").getBytes());
            //Recibimos el resultado del servidor y lo leemos
            byte[] mensaje = new byte[64];
            is.read(mensaje);

            total = new String(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    

    //Metodo que se ejecuta cuando escribes el comando 00 para cerrar el programa.
    public void cerrar() {
        try {
            //OutputStream os = clienteSocket.getOutputStream();
            //os.write("cerrar#".getBytes());
            is.close();
            os.close();
            clienteSocket.close();
            System.exit(0);
            
            
        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
