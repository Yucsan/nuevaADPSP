package ejercicio5_TCP;

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

public class Servidor5 {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_CYAN = "\u001b[36m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	

	public static int suma(String texto) {
		int num1=0 ,num2=0, cord1, cord2; 
		String aux="";
		
		cord1 = texto.indexOf("a")+1;
    	cord2 = texto.indexOf("+");
    	
    	aux = texto.substring(cord1, cord2).trim();
    	num1 = Integer.valueOf(aux);
    	
    	aux= texto.substring(cord2+1).trim();
    	num2 = Integer.valueOf(aux);
		
		return num1+num2;
	}
	
	public static int resta(String texto) {
		int num1=0 ,num2=0, cord1, cord2; 
		String aux="";
		
		cord1 = texto.indexOf("a")+1;
    	cord2 = texto.indexOf("-");
    	
    	aux = texto.substring(cord1, cord2).trim();
    	num1 = Integer.valueOf(aux);
    	
    	aux= texto.substring(cord2+1).trim();
    	num2 = Integer.valueOf(aux);
    	
		return num1-num2;
	}
	
	public static int multi(String texto) {
		int num1=0 ,num2=0, cord1, cord2; 
		String aux="";
		
		cord1 = texto.indexOf("i")+1;
    	cord2 = texto.indexOf("*");
    	
    	aux = texto.substring(cord1, cord2).trim();
    	num1 = Integer.valueOf(aux);
    	
    	aux= texto.substring(cord2+1).trim();
    	num2 = Integer.valueOf(aux);
    	
		return num1*num2;
	}
	
	public static int divi(String texto) {
		int num1=0 ,num2=0, cord1, cord2, resulDivi; 
		String aux="";
		
		cord1 = texto.lastIndexOf("i")+1;
    	cord2 = texto.indexOf("/");
    	
    	System.out.println("cord1: "+cord1);
    	System.out.println("cord2: "+cord2);
    	
    	aux = texto.substring(cord1, cord2).trim();
    	num1 = Integer.valueOf(aux);
    	
    	aux= texto.substring(cord2+1).trim();
    	num2 = Integer.valueOf(aux);
    	
    	if(num2== 0) {
    		resulDivi =0;
    	}else {
    		resulDivi= num1/num2;
    	}
    	
		return resulDivi;
	}
	
	
	
	
	public static void main(String[] args) {
		ServerSocket servidor = null;

		String mensajeCli = "", mensajeServ = "pin del servidor";
		Scanner tecTxt = new Scanner(System.in);
		
		//variables Calculadora
		Integer num1=0, num2=0, resultado=0;
		String aux="";
		
		
		
		// Se abre un puente de comunicacion entre el servidor y el cliente
		Socket socket = null;

		final int PUERTO = 5000;

		DataInputStream in;
		DataOutputStream out;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println(ANSI_CYAN + "Servidor iniciado");
			/*
			 * El sevidor se mantiene a la escucha hasta que le llega a través del socket un
			 * mensaje
			 */
			socket = servidor.accept();
			System.out.println(ANSI_CYAN + "Cliente conectado");
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			int cord1=0, cord2=0;
			
			System.out.println("* SERVIDOR*");
			while (!mensajeCli.equals("fin")) {
				
					mensajeCli = in.readUTF();
					
			    if (!mensajeCli.equals("fin")) {
			        System.out.println(ANSI_PURPLE+"Cliente: " + mensajeCli);
			        
			        //trabajamos aquí las operaciones
			        if(mensajeCli.contains("suma")) {
			        	
			        	resultado = Servidor5.suma(mensajeCli);
			        	mensajeServ = resultado.toString();
			        	
			        }else if(mensajeCli.contains("resta")) {
			        	
			        	resultado = Servidor5.resta(mensajeCli);
			        	mensajeServ = resultado.toString();
			        	
			        }else if(mensajeCli.contains("multi")) {
			        	
			        	resultado = Servidor5.multi(mensajeCli);
			        	mensajeServ = resultado.toString();
			        	
			        }else if(mensajeCli.contains("divi")) {
			        	
			        	resultado = Servidor5.divi(mensajeCli);
			        	mensajeServ = resultado.toString();
			        	
			        }else {
			        	mensajeServ ="Sintaxis Incorrecta";
			        }
			        	

			        out.writeUTF(mensajeServ); // Enviar respuesta //CUIDADO SIN ANSIS
			    }
					
			}

			socket.close();
			System.out.println(ANSI_CYAN + "Se cierra la conexión: Servidor desconectado");
			servidor.close();
			tecTxt.close();

		} catch (EOFException e1) {
			System.out.println(ANSI_PURPLE+"Cierra cliente Conexión");
		} catch (Exception e1) {
			Logger.getLogger(Servidor5.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			tecTxt.close();
		}

	}
}
