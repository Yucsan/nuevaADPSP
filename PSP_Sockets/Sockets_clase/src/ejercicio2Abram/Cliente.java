package ejercicio2Abram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	/*
	 * Una aplicacion cliente envia mensajes a una aplicacion servidor y el servidor contesta.
	 * El servidor
	 * - Siempre se mantiene a la escucha y no termina su ejecución
	 * - Recibe el mensaje y lo enumera.
	 * - Contesta ok al mensaje recibido por el cliente
	 * El cliente contesta en azul y el servido en rojo
	 * */
	
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_BLACK = "\u001B[30m";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		DataInputStream in;
		DataOutputStream out;
		String textoMensaje;
		Boolean escribir=true;
		
		try {
			Socket socket = new Socket(HOST,PUERTO);
			
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			while(escribir) {
				System.out.println(ANSI_BLACK+"Escriba el mensaje");
				textoMensaje=sc.nextLine();
				
				out.writeUTF(ANSI_BLUE+textoMensaje);
				
				String mensaje=in.readUTF();
				System.out.println(mensaje);
				
				System.out.println(ANSI_BLACK+"Desea enviar otro mensaje? Pulse N para salir");
				
				if (textoMensaje.equalsIgnoreCase("N")) {
					escribir=false;
					out.writeUTF("N");
				}
			}
			System.out.println(ANSI_BLUE+"Cliente finalizado");
			sc.close();
			socket.close();
		}catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}
