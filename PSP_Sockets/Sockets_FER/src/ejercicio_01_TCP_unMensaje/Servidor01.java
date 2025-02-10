package ejercicio_01_TCP_unMensaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 Ejercicio1
 Una aplicacion cliente senvia un mensaje
 a una aplicacion servidor y el servidor contesta
 cuando el servidor contesta, termina su ejecución.
 El cliente contesta en azul y el servidor en rojo
 * */

public class Servidor01 {
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
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
			/* el servidor se mantiene a la escucha hasta
			 * que le llega a traves del socket un mensaje*/
			socket = servidor.accept();
			in = new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			String mensaje=in.readUTF();
			System.out.println(mensaje);
			
			out.writeUTF(ANSI_RED+"Saludos desde el servidor!!");
			socket.close();
			
			System.out.println(ANSI_RED+"Se cierra la conexión: Cliente desconectado");
			servidor.close();
			
			
		}catch(IOException e1) {
			Logger.getLogger(Servidor01.class.getName()).log(Level.SEVERE,null, e1);
			
			
		}
		
		
		
	}

}
