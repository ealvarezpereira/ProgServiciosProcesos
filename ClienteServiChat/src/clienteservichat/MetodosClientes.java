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
import javax.swing.JOptionPane;

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

    /**
     * Meotodo para la conexion al servidor.
     *
     * @param ip es la ip del servidor.
     * @param npuerto es el numero de puerto del servidor.
     * @param nickname es el nombre de usuario del cliente.
     */
    public void conexion(String ip, int npuerto, String nickname) {
        try {
            this.nickname = nickname;
            System.out.println("Creando socket cliente");
            clienteSocket = new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr = new InetSocketAddress(ip, npuerto);

            clienteSocket.connect(addr);

            is = clienteSocket.getInputStream();
            os = clienteSocket.getOutputStream();

            //Enviamos el nickname del cliente que se ha conectado.
            os.write((this.nickname + " ha iniciado sesión.#").getBytes());
            System.out.println("Sesion iniciada correctamente.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "El servidor está cerrado.");
            System.exit(0);
        }
    }

    /**
     * Método que envía el mensaje que recibe de la interfaz al servidor.
     *
     * @param mensaje es el mensaje que recibe.
     */
    public void enviarMensaje(String mensaje) {
        try {
            if (!mensaje.equalsIgnoreCase("/bye")) {
                Date d = new Date();
                String fecha = "[" + d.getDay() + "/" + d.getMonth() + " " + d.getHours() + ":" + d.getMinutes() + "]";
                //Escribimos un mensaje con la fecha, el nick y el mensaje del cliente
                os.write((fecha + " " + this.nickname + ": " + mensaje + "#").getBytes());
            } else {
                //Si recibe el comando /bye se cierra el cliente.
                os.write((this.nickname + " Ha cerrado sesión.#/bye#").getBytes());
                os.close();
                is.close();
                clienteSocket.close();
                System.exit(0);
            }

        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Servidor cerrado.");
            System.exit(0);
        }
    }

    /**
     * Recibe el mensaje que devuelve el servidor y lo retorna a la interfaz
     * gráfica para mostrarlo.
     *
     * @return mspliteado[0] es el mensaje con el split.
     */
    public String recibirMensaje() {
        byte[] mRecibido = new byte[1024];
        String[] mSpliteado = new String[2];
        try {
            is.read(mRecibido);

            msg = new String(mRecibido);

            mSpliteado = msg.split("#");
            if (mSpliteado[1].contains("/cerrarCliente")) {
                JOptionPane.showMessageDialog(null,"No se ha podido conectar, demasiados usuarios.");
                is.close();
                os.close();
                clienteSocket.close();
                System.exit(0);
            }

        } catch (IOException ex) {
            Logger.getLogger(MetodosClientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Servidor cerrado.");
        }
        return mSpliteado[0];
    }

}
