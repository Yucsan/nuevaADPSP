package ejercicio_01_TCP_unMensaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente01 {
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int PUERTO = 5000;
		final String HOST="127.0.0.1";
		//mi vecino 72.25.9.183
		//local 127.0.0.1
		DataInputStream in;
		DataOutputStream out;
		
		try {
			Socket socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF(ANSI_BLUE+"Saludos desde el cliente !!!");
			
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			
			socket.close();
			
		}catch(IOException e1) {
			Logger.getLogger(Servidor01.class.getName()).log(Level.SEVERE,null, e1);
		}
	}

}
