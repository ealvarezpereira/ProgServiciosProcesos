/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servichat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author quique
 */
public class MetodosServiChat {

    public static String mensaje = "";
    public static ServerSocket serverSocket;
    Socket newSocket;
    OutputStream os;
    public static int nConexiones = 0;

    //Metodo con el que establecemos la conexion servidor
    public void conexion() {
        try {

            System.out.println("Creando socket servidor");
            //Creamos el socket
            serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");
            //Nos conectamos con el socket a la ip
            InetSocketAddress addr = new InetSocketAddress("localhost",
                    Integer.parseInt(JOptionPane.showInputDialog("Introduzca el puerto")));
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");
            System.out.println("Ningun usuario conectado.");
            while (true) {
                    //Aceptamos conexiones de clientes
                    newSocket = serverSocket.accept();
                    System.out.println("Conexion recibida");
                    this.nConexiones++;
                    //Abrimos el input y el output
                    InputStream is = newSocket.getInputStream();
                    os = newSocket.getOutputStream();

                    //Creamos un hilo por cada cliente
                    hilo h = new hilo(os, is, newSocket);
                    h.start();
                    
                    System.out.println("Actualmente hay " + nConexiones + " usuarios conectados.");
            }
        } catch (IOException ex) {
            Logger.getLogger(ServiChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
