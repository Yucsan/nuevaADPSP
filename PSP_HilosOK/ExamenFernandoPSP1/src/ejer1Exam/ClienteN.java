package ejer1Exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClienteN {
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_CYAN = "\u001b[36m";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tecTxt = new Scanner(System.in);
		List<String> msn = new ArrayList<String>();

		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";

		String mensajeIns = "", mensajeServ="";
		Boolean escribir=true;
		
		DataInputStream in;
		DataOutputStream out;

		try {
			Socket socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			System.out.println("* CLIENTE *");
			
			while (!mensajeIns.equals("fin")) {
				
				
					System.out.print(ANSI_PURPLE+"Cliente-> ");
					System.out.println("Inserta NombreUsuario,edad");
					mensajeIns = tecTxt.nextLine();
					
					if(!mensajeIns.equals("fin")) {
						
						out.writeUTF(mensajeIns); //CUIDADO SIN ANSIS
						mensajeServ = in.readUTF();
						System.out.println(ANSI_RED+"Servidor -> "+mensajeServ);
						
					}else {
						System.out.println("con 0 SALIMOS");
					}
									
			}
			
			System.out.println(ANSI_PURPLE+"Cliente finalizado");
			
			out.close();
			in.close();
			socket.close();
			
		} catch(Exception e1) {
			System.out.println("fincli");
		} finally {
			tecTxt.close();
		}
		
	}

}
