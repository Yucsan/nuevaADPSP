package ejercicio3_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente3 {
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_CYAN = "\u001b[36m";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tecTxt = new Scanner(System.in);
		Scanner tecInt = new Scanner(System.in);
		List<String> msn = new ArrayList<String>();

		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";

		Integer mensajeIns = 0; //mensaje que insertas
		String mensajeServ=""; //mensaje envias
		
		Boolean letras=true; //para depurar letras
		
		DataInputStream in;
		DataOutputStream out;

		try {
			Socket socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			System.out.println("* CLIENTE *");
			
			while ( mensajeIns!= 0 || letras) {
				
				try {	
				
					letras = false;
					System.out.println(ANSI_PURPLE+"Inserta un número");
					System.out.print(ANSI_PURPLE+"Cliente-> ");
					mensajeIns = tecInt.nextInt();
					
					if(mensajeIns!= 0) {
						
						out.writeUTF( mensajeIns.toString() ); //enviamosnumero
						
						mensajeServ = in.readUTF().toString(); //recibe mensaje
						System.out.println(ANSI_RED+"Servidor el cuadrado es: "+mensajeServ);
						
					}else {
						System.out.println("con 0 SALIMOS");
					}
			} catch(InputMismatchException e) {
				tecInt=new Scanner(System.in);
				letras=true;
				System.out.println("Introduzca caracteres numéricos");
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
