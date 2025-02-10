package chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        Scanner tecTxt = new Scanner(System.in);
        final int PUERTO = 5000;
        final String HOST = "127.0.0.1";
        String mensajeIns = "";
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket socket = new Socket(HOST, PUERTO);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            System.out.print(ANSI_PURPLE + "Cliente-> ");

            while (true) {
                // Leer el mensaje del cliente
                mensajeIns = tecTxt.nextLine();
                out.writeUTF(ANSI_PURPLE + "Cliente: " + mensajeIns);

                // Si el cliente escribe "N", finaliza la conexión
                if (mensajeIns.equalsIgnoreCase("N")) {
                    System.out.println(ANSI_PURPLE + "Cliente ha finalizado la conexión.");
                    break;
                }

                // Recibir respuesta del servidor y mostrarla
                String mensajeServidor = in.readUTF();
                System.out.println(mensajeServidor);

                System.out.print(ANSI_PURPLE + "Cliente-> ");
            }

            // Cerrar recursos
            out.close();
            in.close();
            socket.close();
            System.out.println(ANSI_PURPLE + "Conexión cerrada");

        } catch (IOException e1) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e1);
        } finally {
            tecTxt.close();
        }
    }
}
