package ejercicio3_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor3 {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_CYAN = "\u001b[36m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	
	public static void main(String[] args) {
		ServerSocket servidor = null;

		String mensajeCli = "", mensajeServ = "pin del servidor";
		
		Integer num=0;
		
		
		//Scanner tecTxt = new Scanner(System.in);
		// Se abre un puente de comunicacion entre el servidor y el cliente
		Socket socket = null;

		final int PUERTO = 5000;

		DataInputStream in;
		DataOutputStream out;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println(ANSI_RED + "Servidor iniciado");
			/*
			 * El sevidor se mantiene a la escucha hasta que le llega a través del socket un
			 * mensaje
			 */
			socket = servidor.accept();
			System.out.println(ANSI_RED + "Cliente conectado");
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			
			System.out.println("* SERVIDOR*");
			while (!mensajeCli.equals("0")) {
				
					mensajeCli = in.readUTF();
					
					System.out.println("Entramos "+mensajeCli);
					
					num = Integer.valueOf(mensajeCli);
					num = num*num;
					
					out.writeUTF(num.toString()); // Enviar respuesta 
				
				// Si el mensaje cliente es "0" salimos...
			    if (!mensajeCli.equals("0")) {
			        System.out.println(ANSI_PURPLE+"Cliente: " + mensajeCli);	
			    }
				
			
				
			}

			socket.close();
			System.out.println(ANSI_RED + "Se cierra la conexión: Servidor desconectado");
			servidor.close();
			

		} catch (EOFException e1) {
			System.out.println(ANSI_PURPLE+"Cierra cliente Conexión");
		} catch (Exception e1) {
			Logger.getLogger(Servidor3.class.getName()).log(Level.SEVERE, null, e1);
		}

	}
}
