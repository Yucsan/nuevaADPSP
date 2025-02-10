package chat05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
	public static final String ANSI_PURPLE = "\u001B[35m";

	public static void main(String[] args) {
		Scanner tecTxt = new Scanner(System.in);
		final int PUERTO = 5000;
		final String HOST = "127.0.0.1";
		String mensajeIns = "";
		DataInputStream in;
		DataOutputStream out;

		// System.out.print(ANSI_PURPLE + "Cliente-> ");

		while (!mensajeIns.equals("0")) {

			try {
				Socket socket = new Socket(HOST, PUERTO);
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());

				System.out.println(ANSI_PURPLE + "Mensaje : ");
				mensajeIns = tecTxt.nextLine();

				out.writeUTF(ANSI_PURPLE + mensajeIns);
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				
				out.close();
				in.close();
				socket.close();


			} catch (IOException e1) {
				Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e1);
			} finally {
				tecTxt.close();
			}
		}
	}
}
