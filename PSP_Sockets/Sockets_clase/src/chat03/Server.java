package chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        Scanner tecTxt = new Scanner(System.in);
        String mensaje = "";
        ServerSocket servidor = null;
        Socket socket = null;
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println(ANSI_RED + "Servidor iniciado y esperando conexión...");

            socket = servidor.accept();
            System.out.println(ANSI_RED + "Cliente conectado");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                // Leer mensaje del cliente
                String mensajeCliente = in.readUTF();

                // Verificar si el cliente quiere terminar la conexión
                if (mensajeCliente.equalsIgnoreCase("N")) {
                    System.out.println(ANSI_RED + "Cliente ha finalizado la conexión.");
                    out.writeUTF(ANSI_RED + "Servidor: Conexión finalizada.");
                    break;
                }

                // Mostrar el mensaje del cliente en consola
                System.out.println(ANSI_RED + mensajeCliente);

                // Leer el mensaje del servidor para responder
                System.out.print(ANSI_RED + "Servidor-> ");
                mensaje = tecTxt.nextLine();
                out.writeUTF(ANSI_RED + "Servidor: " + mensaje);

                // Si el servidor escribe "N", también termina la conexión
                if (mensaje.equalsIgnoreCase("N")) {
                    System.out.println(ANSI_RED + "Servidor ha finalizado la conexión.");
                    out.writeUTF(ANSI_RED + "Servidor: Conexión finalizada.");
                    break;
                }
            }

            // Cerrar recursos
            socket.close();
            servidor.close();
            System.out.println(ANSI_RED + "Conexión cerrada");

        } catch (IOException e1) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e1);
        } finally {
            tecTxt.close();
        }
    }
}
