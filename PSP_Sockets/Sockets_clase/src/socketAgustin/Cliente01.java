package socketAgustin;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente01 {
	/*
	 * UNA APLICACION CLIENTE ENVIAUN MENSJAE AUNA 
	 * APLICACION SERVIDOR Y EL SERVIDOR CONTESTA 
	 * 
	 * EL SERVIDOR:
	 * 	-Siempre se mantiene a la escucha y nunca detiene su ejecucion 
	 * 	-Recibe el mensaje y lo enumera
	 * 	-Le contesta ok al mensaje recibido por el cliente
	 * 	
	 * */
	public static final String ANSI_BLUE="\u001B[34m";
	
	public static void main(String[] args) {
		Scanner tecTxt=new Scanner(System.in);
		final int PUERTO=5000;
		
		final String HOST="127.0.0.1";
		
		DataInputStream in;
		DataOutputStream out;
		
		try {
			Socket socket= new Socket(HOST,PUERTO);
			
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			String mensajeEs="as";	
			while(!mensajeEs.equalsIgnoreCase("salir")) {
			
				
				mensajeEs=tecTxt.nextLine();	
				out.writeUTF(ANSI_BLUE+mensajeEs);

				
			}
			
			
			socket.close();
			
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
			
		}
	}
}
