package ejercicio2Abram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Integer cont=0;

		// Se abre un puente de comunicacion entre el servidor y el cliente
		Socket socket = null;
		
		final int PUERTO = 5000;
		
		// Los mensajes viajan a través de estos objetos.
		// Las clases DataInputStream y DataOutputStream
		// sirven para leer/escribir datos del tipo primitivo de una forma portable
		DataInputStream in;
		DataOutputStream out;
		
		try {
			servidor = new ServerSocket(PUERTO);
			
			System.out.println(ANSI_RED+"Servidor iniciado");
			/*El sevidor se mantiene a la escucha hasta que le llega a través del socket un mensaje*/
			socket=servidor.accept();
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			while(!in.readUTF().equalsIgnoreCase("N")) {
				out.writeUTF(ANSI_RED+"Mensaje "+ ++cont +" recibido. Ok");
			}
			
			System.out.println(ANSI_RED+"Sigo funcionando");
			
			/*socket.close();
			
			System.out.println(ANSI_RED+"Se cierra la conexion: Cliente desconectado");
			servidor.close();*/
			
		} catch (IOException e1) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e1);
		}
	}
}
