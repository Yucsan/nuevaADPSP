package ejercicio_03_TCP_chat1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor03_chat1 {
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_PURPLE = "\u001B[35m";

	public static void main(String[] args) {
		Scanner tecTxt = new Scanner(System.in);
		String mensaje = "";
		String mensajeCliente = "";
		ServerSocket servidor=null;
		
		//se abre un puente de comunicación entre el servidor y el cliente
		Socket socket=null;
		
		final int PUERTO = 5000;
		
		//LOS MENSAJE viajan a través de estos objetos.
		// Las clases DataInputStream y DataOutputStream
		//sirven para leer/escribir datos del tipo primitivo de una forma portable
		DataInputStream in;
		DataOutputStream out;
		
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println(ANSI_RED+"Servidor iniciado");
			/* el servidor se mantiene a la escucha hasta que le llega a traves del socket un mensaje*/
			
			
			
			socket = servidor.accept();
			System.out.println(ANSI_RED+"Cliente conectado");
			in = new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				
				mensajeCliente = in.readUTF();
                
                if (mensajeCliente.equalsIgnoreCase("N")) {
                    // Si el cliente envía "N", se cierra la comunicación
                    System.out.println(ANSI_RED + "Cliente ha finalizado la conexión.");
                    out.writeUTF(ANSI_RED + "OK desde el servidor!!");
                    break;
                }

                // Mostrar el mensaje recibido en la consola del servidor
                System.out.println(ANSI_PURPLE + "Cliente: " + mensajeCliente);

                // Leer el mensaje de respuesta del servidor
                System.out.print(ANSI_RED + "Servidor-> ");
                mensaje = tecTxt.nextLine();
                out.writeUTF(ANSI_RED + "**Servidor: " + mensaje); //pinta en cliente
            }

            // Cerrar recursos
            socket.close();
            servidor.close();
            System.out.println(ANSI_RED + "Se cierra la conexión: Cliente desconectado");
			
			
		}catch(IOException e1) {
			Logger.getLogger(Servidor03_chat1.class.getName()).log(Level.SEVERE,null, e1);
			
			
		}
		
		
		
	}

}
