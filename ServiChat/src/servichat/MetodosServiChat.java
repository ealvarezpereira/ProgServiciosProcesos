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
    public static boolean cierrateSesamo = false;
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
            while (!cierrateSesamo) {
                if (this.nConexiones < 10) {
                    //Aceptamos conexiones de clientes
                    newSocket = serverSocket.accept();
                    System.out.println("Conexion recibida");

                    //Abrimos el input y el output
                    InputStream is = newSocket.getInputStream();
                    os = newSocket.getOutputStream();

                    //Creamos un hilo por cada cliente
                    hilo h = new hilo(os, is, newSocket);
                    h.start();
                    this.nConexiones++;
                    System.out.println("Actualmente hay " + nConexiones + " usuarios conectados.");
                } else {
                    Thread.sleep(200);
                }
            }
            newSocket.close();
            serverSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(ServiChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MetodosServiChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class hilo extends Thread {

    String cadena = "";
    Socket newSocket;
    OutputStream os;
    InputStream is;
    //Igualamos las variables auxiliares al mensaje que recibimos de los clientes
    String mensajeAEnviar = MetodosServiChat.mensaje;
    String comprobacion = MetodosServiChat.mensaje;
    byte[] mensajeQueRecibes;

    public hilo() {
    }

    public hilo(OutputStream os, InputStream is, Socket newSocket) {
        this.os = os;
        this.is = is;
        this.newSocket = newSocket;
    }

    public void run() {

        while (true) {
            //Si el mensaje que recibes es distinto que el mensaje anterior sobreescribe el mensaje.
            if (!comprobacion.equalsIgnoreCase(MetodosServiChat.mensaje)) {
                comprobacion = MetodosServiChat.mensaje;
                mensajeAEnviar = MetodosServiChat.mensaje;
            }

            try {
                if (is.available() == 0) {

                    //Si hay algun mensaje ya recibido lo escribe directamente.
                    if (!mensajeAEnviar.equalsIgnoreCase("@")) {
                        enviar();
                    }

                } else {
                    mensajeQueRecibes = new byte[1024];

                    //con el stream imput leemos el array de bytes
                    is.read(mensajeQueRecibes);
                    //Creamos un string a partir del mensaje leido con el is.read()
                    String stringDelMensaje = new String(mensajeQueRecibes);
                    /**
                     * Creamos un array String puesto que el mensaje que nos
                     * llega tiene un # al final debido a que al definir el
                     * array de bytes si el tamaño es mayor que el mensaje mete
                     * espacios en blanco, Entonces hacemos un split de #.
                     */
                    String[] msg = new String[2];
                    msg = stringDelMensaje.split("#");

                    System.out.println("Mensaje recibido: " + msg[0]);

                    if (msg[0].contains("/nconexiones")) {
                        msg[0] = "El numero de conectados es " + MetodosServiChat.nConexiones;
                    }

                    /**
                     * Si alguien cierra sesión resta 1 a la variable
                     * nConexiones.
                     */
                    if (msg[0].contains("Ha cerrado sesión.") || newSocket.getKeepAlive()) {
                        is.close();
                        os.close();
                        newSocket.close();
                        MetodosServiChat.nConexiones--;
                        sleep(1000);
                        /**
                         * Si hay como minimo 1 usuario conectado que muestre el
                         * numero, si no hay ninguno que muestre que no hay
                         * usuarios conectados.
                         */
                        if (MetodosServiChat.nConexiones != 0) {
                            System.out.println("Actualmente hay " + MetodosServiChat.nConexiones + " usuarios conectados.");
                        } else {
                            System.out.println("No hay usuarios conectados.");
                            MetodosServiChat.serverSocket.close();
                            System.exit(0);
                        }
                    }

                    if (msg[0].contains("/cierratesesamo")) {

                        os.write("El servidor ha sido cerrado.".getBytes());
                        //MetodosServiChat.cierrateSesamo = true;
                        MetodosServiChat.serverSocket.close();
                        System.exit(0);
                    }

                    MetodosServiChat.mensaje = msg[0] + "\n";
                    enviar();
                    comprobacion = MetodosServiChat.mensaje;
                    MetodosServiChat.mensaje = "";
                }

            } catch (Exception ex) {
                break;
            }
        }
    }

    public void enviar() {
        try {
            os.write((MetodosServiChat.mensaje + "#").getBytes());
            //Le asignamos el valor "@" para avisar de que el mensaje ha sido enviado.
            mensajeAEnviar = "@";
        } catch (Exception ex) {
            try {
                os.close();
            } catch (IOException ex1) {
                Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
