package socketAgustin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor01 {
	public static int contadorMen=0;
	public static final String ANSI_RED="\u001B[31m";
	
	
	public static void main(String[] args) {
		ServerSocket servidor =null; // asi se declara que es un servidor 
		//abrimos u puente de comunicacion:
		Socket socket=null;
		
		final int PUERTO=5000;
		
		//Los mensajes viajan a través de estos objetos
		//Las clases DataInputStream y DataOutputStream
		//servira para leer y escribir datos de tipo primitivo de una forma portable
		DataInputStream in;
		DataOutputStream out;
		
		try {
			servidor= new ServerSocket(PUERTO);
			
			System.out.println(ANSI_RED+"SERVIDOR INICIADO");
			
			/*
			 el servidor se mantiene a la escucha hasta
			 que le llega a través del socket un mensaje
			 */
			socket=servidor.accept();
			System.out.println("Cliente conectado");
			
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			while(true) {

				String mensaje= in.readUTF();
				contadorMen++;
				
				if(mensaje.equalsIgnoreCase("salir")) {
					socket.close();
					servidor.close();
				}else {
					System.out.println("Mensaje recibido (" + contadorMen + "): " + mensaje);
					
					out.writeUTF(ANSI_RED+"ok");
					
				}
				
					
			}
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
			
		}
	}
}
