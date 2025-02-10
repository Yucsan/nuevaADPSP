package ejercicio_02_TCP_unMensaje;

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

public class Cliente02 {
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tecTxt = new Scanner(System.in);
		List<String> msn = new ArrayList<String>();

		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";

		String mensajeIns = "";


		DataInputStream in;
		DataOutputStream out;

		while (!mensajeIns.equals("0")) {

			try {
				Socket socket = new Socket(HOST, PUERTO);
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());

				System.out.println(ANSI_PURPLE + "Mensaje : ");
				mensajeIns = tecTxt.nextLine();

				out.writeUTF(ANSI_PURPLE + mensajeIns);
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				
				out.close();
				in.close();
				socket.close();

			} catch (IOException e1) {
				Logger.getLogger(Servidor02.class.getName()).log(Level.SEVERE, null, e1);
			}

		}
		tecTxt.close();
		

	}

}
