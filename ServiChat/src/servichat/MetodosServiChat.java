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

/**
 *
 * @author quique
 */
public class MetodosServiChat {

    public static String mensaje = "";
    ServerSocket serverSocket;
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
            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            while (true) { //Cambiar para no permitir mas conexiones
                if (nConexiones <=10) {
                //Aceptamos conexiones de clientes
                newSocket = serverSocket.accept();
                System.out.println("Conexion recibida");

                //Abrimos el input y el output
                InputStream is = newSocket.getInputStream();
                os = newSocket.getOutputStream();

                //Creamos un hilo por cada cliente
                hilo h = new hilo(os, is);
                h.start();
                nConexiones++;
                }
            }

            //JOptionPane.showMessageDialog(null, "No hay mas conexiones disponibles");
        } catch (IOException ex) {
            Logger.getLogger(ServiChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class hilo extends Thread {

    String cadena = "";
    OutputStream os;
    InputStream is;
    //Igualamos las variables auxiliares al mensaje que recibimos de los clientes
    String mensajeAEnviar = MetodosServiChat.mensaje;
    String comprobacion = MetodosServiChat.mensaje;
    byte[] mensajeQueRecibes;

    public hilo() {
    }

    public hilo(OutputStream os, InputStream is) {
        this.os = os;
        this.is = is;
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
                    String cerrar = new String(mensajeQueRecibes);
                    System.out.println("Cerrar: " + cerrar);
                    /**
                     Creamos un array String puesto que el mensaje que nos llega tiene un # al final
                     debido a que al definir el array de bytes si el tamaño es mayor que el mensaje
                     mete espacios en blanco, Entonces hacemos un split de #.
                     */
                    String[] msg = new String[2];
                    msg = cerrar.split("#");

                    System.out.println("Mensaje recibido: " + msg[0]);
                    
                    //Si alguien cierra sesión que no permita más conexiones.
                    if (msg[0].contains("Ha cerrado sesión.")) {
                        MetodosServiChat.nConexiones--;
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
