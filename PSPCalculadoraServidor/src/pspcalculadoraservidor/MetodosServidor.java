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
    /**
     * @param total es el resultado total que el servidor devuelve al cliente
     * @param serverSocket es el socket del servidor
     * @param newSocket es un socket nuevo
     */
    double total;
    ServerSocket serverSocket;
    Socket newSocket;

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
            //Aceptamos conexiones de clientes
            newSocket = serverSocket.accept();

            System.out.println("Conexion recibida");
        } catch (IOException ex) {
            Logger.getLogger(PSPCalculadoraServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Llamamos al metodo enviarMensaje()
        enviarMensaje();
    }

    //Metodo que recibe los datos, hace la operacion y devuelve el resultado.
    public void enviarMensaje() {
        try {
            //Abrimos los stream de entrada y salida
            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();

            //arraymensaje es el array de bytes que recoge el servidor del cliente
            byte[] arraymensaje = new byte[64];
            
            //con el stream imput leemos el array de bytes
            is.read(arraymensaje);
            
            //Creamos un string a partir del mensaje leido con el is.read()
            String mensaje = new String(arraymensaje);

            /*
               Creamos un array String puesto que el mensaje que nos llega tiene un # al final
               debido a que al definir el array de bytes si el tamaño es mayor que el mensaje
               mete espacios en blanco. Entonces hacemos un split de #
            */
            String[] msg = new String[2];
            msg = mensaje.split("#");

            System.out.println("Mensaje recibido: " + msg[0]);
            
            //Creamos un String con la secuencia que es la posicion 0 del array msg
            String cadena = msg[0];

            /*
               Creamos un array que divide la secuencia. La secuencia está dividida por comas de este modo:
               num1,operacion,num2
            */
            String[] cad = new String[3];
            cad = cadena.split(",");

            //Hacemos un switch donde comparamos la operación
            switch (cad[1]) {
                
                /*
                  Si es SUM recoge los numeros, los suma y envía el resultado al cliente
                  Si es RES recoge los numeros, los resta y envía el resultado al cliente
                  Si es MULT recoge los numeros, los multiplica y envía el resultado al cliente
                  Si es DIV recoge los numeros, los divide y envía el resultado al cliente
                */
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

            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

            //Volvemos a llamar al método conexión para que el servidor no se cierre al terminar la ejecución de la operación
            conexion();

        } catch (IOException ex) {
            Logger.getLogger(PSPCalculadoraServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
