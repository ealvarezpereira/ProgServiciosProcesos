/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservichat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quique
 */
public class MetodosClientes {

    Socket clienteSocket;
    String msg, nickname;
    InputStream is;
    OutputStream os;
    InterfazChat intc;

    //Metodo con el que el cliente se conecta al servidor
    public void conexion(String ip, String npuerto, String nickname) {
        try {
            this.nickname = nickname;
            System.out.println("Creando socket cliente");
            clienteSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
            clienteSocket.connect(addr);

            is = clienteSocket.getInputStream();
            os = clienteSocket.getOutputStream();

            //Enviamos el nickname del cliente que se ha conectado.
            os.write((this.nickname + " ha iniciado sesión.#").getBytes());
        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(String mensaje) {
        try {
            if (!mensaje.equalsIgnoreCase("/bye")) {
                Date d = new Date();
                String fecha = "[" + d.getDay() + "/" + d.getMonth() + " " + d.getHours() + ":" + d.getMinutes() + "]";
                //Escribimos un mensaje con la fecha, el nick y el mensaje del cliente
                os.write((fecha + " " + this.nickname + ": " + mensaje + "#").getBytes());
            } else {
                os.write((this.nickname + " Ha cerrado sesión.").getBytes());
                os.close();
                is.close();
                clienteSocket.close();
                System.exit(0);
            }

        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String recibirMensaje() {
        byte[] mRecibido = new byte[1024];
        String[] mSpliteado = new String[2];
        try {
            is.read(mRecibido);

            msg = new String(mRecibido);

            mSpliteado = msg.split("#");

        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mSpliteado[0];
    }

}
