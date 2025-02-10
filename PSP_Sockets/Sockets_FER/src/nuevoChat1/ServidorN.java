package nuevoChat1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorN {

	public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Integer cont=0;
		String mensajeCli="", mensajeServ="pin del servidor";
		Scanner tecTxt = new Scanner(System.in);
		// Se abre un puente de comunicacion entre el servidor y el cliente
		Socket socket = null;
		
		final int PUERTO = 5000;
		
		DataInputStream in;
		DataOutputStream out;
		
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println(ANSI_RED+"Servidor iniciado");
			/*El sevidor se mantiene a la escucha hasta que le llega a través del socket un mensaje*/
			socket=servidor.accept();
			System.out.println(ANSI_RED+"Cliente conectado");
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			while (!mensajeCli.equals("0")) {
				
                mensajeCli = in.readUTF();
                
                
             
                	System.out.print("Servidor");
                	mensajeServ = tecTxt.nextLine();
                	
                	out.writeUTF(ANSI_RED + "Servidor "+mensajeServ);
                	
                    //out.writeUTF(ANSI_RED + "Mensaje " + ++cont + " recibido. Ok");
                
                
            }
				out.writeUTF(ANSI_RED+"OK desde el servidor!!"+"numero: "+cont);
				cont++;
						
				socket.close();
				System.out.println(ANSI_RED+"Se cierra la conexión: Cliente desconectado");
				servidor.close();
		} catch(EOFException e1) {
			System.out.println("fin");
		} catch (SocketException e1) {
	           System.out.println("Cliente Cierra Conexion");	
		} catch (IOException e1) {
			Logger.getLogger(ServidorN.class.getName()).log(Level.SEVERE, null, e1);
		}
		
	}
}
