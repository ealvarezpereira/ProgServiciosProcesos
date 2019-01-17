/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspcalculadoraservidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quique
 */
public class MetodosServidor {

    /**
     * @param args the command line arguments
     */
     double total;
     ServerSocket serverSocket;
     Socket newSocket;
    
    public void conexion() {
        try {
            System.out.println("Creando socket servidor");
            
            serverSocket = new ServerSocket();
            
            System.out.println("Realizando el bind");
            
            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            serverSocket.bind(addr);
            
            System.out.println("Aceptando conexiones");
            
            newSocket = serverSocket.accept();
            
            System.out.println("Conexion recibida");
        } catch (IOException ex) {
            Logger.getLogger(PSPCalculadoraServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        enviarMensaje();
    }

    public void enviarMensaje() {
        try {
            
            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();

            byte[] arraymensaje = new byte[64];

            String[] cad = new String[3];

            is.read(arraymensaje);

            String[] msg = new String[2];

            String mensaje;

            mensaje = new String(arraymensaje);

            msg = mensaje.split("#");

            System.out.println("Mensaje recibido: " + msg[0]);

            String cadena = msg[0];

            cad = cadena.split(",");

            switch (cad[1]) {
                case "SUM":
                    System.out.println("Llega a la suma");
                    os.write(String.valueOf(total = Double.parseDouble(cad[0]) + Double.parseDouble(cad[2])).getBytes());

                case "RES":
                    os.write(String.valueOf(total = Double.parseDouble(cad[0]) - Double.parseDouble(cad[2])).getBytes());

                case "MULT":
                    os.write(String.valueOf(total = Double.parseDouble(cad[0]) * Double.parseDouble(cad[2])).getBytes());

                case "DIV":
                    os.write(String.valueOf(total = Double.parseDouble(cad[0]) / Double.parseDouble(cad[2])).getBytes());

                case "RZZ":
                    os.write(String.valueOf(total = Math.sqrt(Double.parseDouble(cad[0]))).getBytes());

            }
            
            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

            conexion();

        } catch (IOException ex) {
            Logger.getLogger(PSPCalculadoraServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
