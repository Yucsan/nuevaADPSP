package ejercicio_02_TCP_unMensaje.mejorada;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Ejercicio2
Una app cliente envia mensajes(varios) a una app servidor y el servidor contesta
el servidor : 
	-Siempre se mantiene a la escucha y no termina su ejecución
	-Recibe el mensaje y lo enumera
	-Contesta Ok al mensaje recibido por el cliente
* */

public class Cliente02M {
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tecTxt = new Scanner(System.in);
		List<String> msn = new ArrayList<String>();

		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";

		String mensajeIns = "";
		Boolean escribir=true;
		
		DataInputStream in;
		DataOutputStream out;

		try {
			Socket socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			System.out.println(ANSI_PURPLE + "Mensaje : ");
			
			
			while (!mensajeIns.equals("0")) {

				mensajeIns = tecTxt.nextLine();
				
				out.writeUTF(ANSI_PURPLE + mensajeIns);
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				
				System.out.println(ANSI_PURPLE+"Desea enviar otro mensaje? Pulse 0 para salir");
				
				if (mensajeIns.equalsIgnoreCase("0")) {
					out.writeUTF("0");
					//escribir=false;
					System.out.println("SALIMOS");
				}
				
				
			}
			System.out.println(ANSI_PURPLE+"Cliente finalizado");
			
			out.close();
			in.close();
			socket.close();

		} catch (IOException e1) {
			Logger.getLogger(Servidor02M.class.getName()).log(Level.SEVERE, null, e1);

		}
		tecTxt.close();

	}

}
