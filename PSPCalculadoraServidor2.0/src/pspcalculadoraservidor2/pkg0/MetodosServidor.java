/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspcalculadoraservidor2.pkg0;

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
public class MetodosServidor {

    /**
     * @param total es el resultado total que el servidor devuelve al cliente
     * @param serverSocket es el socket del servidor
     * @param newSocket es un socket nuevo
     * @param cadena es el mensaje que recibes del cliente pero ya con el
     * formato n1,op,n2
     */
    double total;
    ServerSocket serverSocket;
    Socket newSocket;
    String cadena = "";
    OutputStream os;
    public static boolean m = false;

    //Metodo con el que establecemos la conexion servidor
    public void conexion() {
        try {
            while (true) {
                System.out.println("Creando socket servidor");
                //Creamos el socket
                serverSocket = new ServerSocket();

                System.out.println("Realizando el bind");
                //Nos conectamos con el socket a la ip
                String puerto = JOptionPane.showInputDialog("Introduce el puerto");
                InetSocketAddress addr = new InetSocketAddress("localhost", Integer.parseInt(puerto));
                serverSocket.bind(addr);

                System.out.println("Aceptando conexiones");
                //Aceptamos conexiones de clientes
                newSocket = serverSocket.accept();
                System.out.println("Conexion recibida");

                //Abrimos el input y el output
                InputStream is = newSocket.getInputStream();
                os = newSocket.getOutputStream();

                hilo h = new hilo(os, is);
                h.start();

                //Cuando envías la señal de apagado sale del bucle y sale del servidor
                if (m = false) {
                    System.out.println("Cerrando el nuevo socket");
                    newSocket.close();

                    System.out.println("Cerrando el socket servidor");
                    serverSocket.close();

                    System.out.println("Terminado");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PSPCalculadoraServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class hilo extends Thread {

    String cadena = "";
    double total;
    OutputStream os;
    InputStream is;

    public hilo() {
    }

    public hilo(OutputStream os, InputStream is) {
        this.os = os;
        this.is = is;
    }

    public void run() {

        //arraymensaje es el array de bytes que recoge el servidor del cliente
        byte[] mensajeQueRecibes = new byte[64];

        //Mientras que no envíes una señal de cerrado el programa sigue esperando mensajes
        while (!cadena.equalsIgnoreCase("cerrar")) {

            try {
                //con el stream imput leemos el array de bytes
                is.read(mensajeQueRecibes);
                //Creamos un string a partir del mensaje leido con el is.read()
                String cerrar = new String(mensajeQueRecibes);

                /*
                Creamos un array String puesto que el mensaje que nos llega tiene un # al final
                debido a que al definir el array de bytes si el tamaño es mayor que el mensaje
                mete espacios en blanco. Entonces hacemos un split de #
                 */
                String[] msg = new String[2];
                msg = cerrar.split("#");

                System.out.println("Mensaje recibido: " + msg[0]);
                cadena = msg[0];
                //Llamamos al metodo enviarMensaje() si el texto no es cerrar
                if (!cadena.equalsIgnoreCase("cerrar")) {

                    String[] cad = new String[3];
                    cad = cadena.split(",");

                    /*   Hacemos un switch donde comparamos la operación
                        Si es SUM recoge los numeros, los suma y envía el resultado al cliente
                        Si es RES recoge los numeros, los resta y envía el resultado al cliente
                        Si es MULT recoge los numeros, los multiplica y envía el resultado al cliente
                        Si es DIV recoge los numeros, los divide y envía el resultado al cliente
                     */
                    switch (cad[1]) {
                        case "SUM":
                            os.write(String.valueOf(total = Double.parseDouble(cad[0]) + Double.parseDouble(cad[2])).getBytes());
                            break;
                        case "RES":
                            os.write(String.valueOf(total = Double.parseDouble(cad[0]) - Double.parseDouble(cad[2])).getBytes());
                            break;
                        case "MULT":
                            os.write(String.valueOf(total = Double.parseDouble(cad[0]) * Double.parseDouble(cad[2])).getBytes());
                            break;
                        case "DIV":
                            os.write(String.valueOf(total = Double.parseDouble(cad[0]) / Double.parseDouble(cad[2])).getBytes());
                            break;
                        case "RZZ":
                            os.write(String.valueOf(total = Math.sqrt(Double.parseDouble(cad[0]))).getBytes());
                            break;
                    }
                } else {
                    MetodosServidor.m = false;
                }
            } catch (IOException ex) {
                Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
