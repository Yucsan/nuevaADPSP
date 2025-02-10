package ejercicio5_TCP;

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

public class Cliente5 {
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_CYAN = "\u001b[36m";
	 public static final String GREEN = "\033[0;32m";   // GREEN

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tecTxt = new Scanner(System.in);

		int cont = 1;
		boolean letras = false;

		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";

		String mensajeIns = "", mensajeServ = "";
		Boolean escribir = true;

		DataInputStream in;
		DataOutputStream out;

		try {
			Socket socket = new Socket(HOST, PUERTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			System.out.println("*CALCULADORA*  suma 4+5 | resta 80-20 | multi 5*9 | divi 50/100 |");
			System.out.println("solo 1 oprecación por mensaje, para salir escribe fin");

			while (!mensajeIns.equalsIgnoreCase("fin")) {

				System.out.print(GREEN + cont + " Cliente-> ");
				cont++;

				mensajeIns = tecTxt.nextLine();

				if (!mensajeIns.equals("fin")) {

					out.writeUTF(mensajeIns); // CUIDADO SIN ANSIS
					mensajeServ = in.readUTF();
					System.out.println(GREEN + "Servidor -> " + mensajeServ);
				}

			}

			System.out.println(GREEN + "Cliente finalizado");

			out.close();
			in.close();
			socket.close();

		} catch (Exception e1) {
			System.out.println("Fin Cliente");
		} finally {
			tecTxt.close();
		}

	}

}
