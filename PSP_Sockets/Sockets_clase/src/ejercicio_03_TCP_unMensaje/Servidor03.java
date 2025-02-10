package ejercicio_03_TCP_unMensaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 Ejercicio1
 Una aplicacion cliente senvia un mensaje
 a una aplicacion servidor y el servidor contesta
 cuando el servidor contesta, termina su ejecución.
 El cliente contesta en Morado y el servidor en rojo
 * */

public class Servidor03 {
	public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		Scanner tecTxt = new Scanner(System.in);
		ServerSocket servidor = null;

		// se abre un puente de comunicación entre el servidor y el cliente
		Socket socket = null;

		final int PUERTO = 5000;
		String mensajeIns = "";

		// LOS MENSAJE viajan a través de estos objetos.
		// Las clases DataInputStream y DataOutputStream
		// sirven para leer/escribir datos del tipo primitivo de una forma portable
		DataInputStream in;
		DataOutputStream out;

		while (!mensajeIns.equals("0")) {

			try {
				servidor = new ServerSocket(PUERTO);
				System.out.println(ANSI_RED + "Servidor iniciado");
				/*
				 * el servidor se mantiene a la escucha hasta que le llega a traves del socket
				 * un mensaje
				 */
				int cont = 0;
				while (true) {

					socket = servidor.accept();
					in = new DataInputStream(socket.getInputStream());
					out = new DataOutputStream(socket.getOutputStream());

					String mensaje = in.readUTF();
					System.out.println(mensaje);
					
					mensajeIns = tecTxt.nextLine();

					out.writeUTF(ANSI_RED + "Servidor!!  :" + mensajeIns);
					cont++;
					socket.close();

					
				}

			} catch (IOException e1) {
				Logger.getLogger(Servidor03.class.getName()).log(Level.SEVERE, null, e1);

			}

		}
		System.out.println(ANSI_RED+"Se cierra la conexión: Cliente desconectado");
		try {
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
