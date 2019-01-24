/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspcalculadoracliente;

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

    //Metodo con el que el cliente se conecta al servidor
    public void conexion() {

        try {
            System.out.println("Creando socket cliente");
            clienteSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            clienteSocket.connect(addr);
        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param num1 recibe el numero 1 de la interfaz grafica
     * @param num2 recibe el numero 2 de la interfaz grafica
     * @param operacion recibe la operacion de la interfaz grafica
     */
    public void enviarOperacion(String num1, String num2, String operacion) {
        //Establecemos la conexion
        conexion();

        try {
            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();

            /*
            Escribimos el mensaje tal que así -> num1,operacion,num2#
            El asterisco es porque al definir un array de bytes si el mensaje es menor que elç
            tamaño de dicho array llena con espacios en blanco.
            */
            os.write((num1 + "," + operacion + "," + num2 + "#").getBytes());

            //Recibimos el total del servidor y lo leemos
            byte[] mensaje = new byte[2];
            is.read(mensaje);

            total = new String(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param num recibe el numero de la interfaz grafica
     * @param operacion recibe la operacion de la raiz
     */
    
    public void raiz(String num, String operacion) {
        //Establecemos la conexion del cliente
        conexion();

        try {
            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();
            //Escibimos la secuencia de la raiz
            os.write((num + "," + operacion+ "#").getBytes());
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

}
