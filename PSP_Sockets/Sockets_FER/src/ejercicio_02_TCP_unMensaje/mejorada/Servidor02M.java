package ejercicio_02_TCP_unMensaje.mejorada;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor02M {
public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		ServerSocket servidor=null;
		
		//se abre un puente de comunicación entre el servidor y el cliente
		Socket socket=null;
		String mensajeCli="";
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
			
			int cont=0;
			
			socket = servidor.accept();
			System.out.println(ANSI_RED+"Cliente conectado");
			in = new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			
			while (!mensajeCli.equals("0")) {
                mensajeCli = in.readUTF();
                
                if (mensajeCli.equalsIgnoreCase("0")) {
                    out.writeUTF(ANSI_RED + "Conexión cerrada. Cliente desconectado.");
                } else {
                    out.writeUTF(ANSI_RED + "Mensaje " + ++cont + " recibido. Ok");
                }
                
            }
				out.writeUTF(ANSI_RED+"OK desde el servidor!!"+"numero: "+cont);
				cont++;
						
				socket.close();
				System.out.println(ANSI_RED+"Se cierra la conexión: Cliente desconectado");
				servidor.close();
		
		}catch(IOException e1) {
			Logger.getLogger(Servidor02M.class.getName()).log(Level.SEVERE,null, e1);
			
			
		}	
	}
}
