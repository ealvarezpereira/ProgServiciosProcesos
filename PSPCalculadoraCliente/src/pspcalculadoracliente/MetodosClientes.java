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

    public void enviarOperacion(String num1, String num2, String operacion) {

        conexion();

        try {
            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();

            os.write((num1 + "," + operacion + "," + num2 + "#").getBytes());

            byte[] mensaje = new byte[2];
            is.read(mensaje);

            total = new String(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void raiz(String num, String operacion) {
        conexion();

        try {
            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();

            os.write((num + "," + operacion+ "#").getBytes());

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
