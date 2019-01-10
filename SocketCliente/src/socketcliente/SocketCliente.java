/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketcliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author quique
 */
public class SocketCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");
            Socket clienteSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();

            for (int i = 0; i < 5; i++) {
                int numeros = (int) (Math.random() * 100) + 1;
                System.out.println("Enviando mensaje ");
                String mensajeCliente = String.valueOf(numeros);
                System.out.println(mensajeCliente);
                os.write(mensajeCliente.getBytes());
                System.out.println("Mensaje enviado");
            }

            byte[] mensaje = new byte[4];
            is.read(mensaje);

            System.out.println("Mensaje recibido: " + new String(mensaje));

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
