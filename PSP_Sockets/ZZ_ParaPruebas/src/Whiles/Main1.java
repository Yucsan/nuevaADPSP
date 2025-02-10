package Whiles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main1 {

	
	public static int menuOpera() {
		boolean letras=true;
		int opcion= 0;
		Scanner tecInt = new Scanner(System.in);
		
		while (letras || opcion > 4 || opcion < 1) {
			try {
				letras = false;
				System.out.print("(1 Suma), (2 Resta), (3 Multiplica), (4 Divide)");
				opcion = tecInt.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("Solo Números de del 1 al 4");
				letras = true;
				tecInt = new Scanner(System.in);
			}

		}
		return opcion;
	}
	
	
	public static void main(String[] args) {
		Scanner tecTxt= new Scanner(System.in); 
		boolean letras = false;
		String mensajeIns = "";
		
		while (letras || !mensajeIns.equals("fin") ) {
			
				System.out.print(" Presiona Intro para ver Calculadora o escribe fin para salir -> ");
				mensajeIns = tecTxt.nextLine();
				
				//si no sales entras al menu de las operaciones
				if(!mensajeIns.equals("fin")) {					
					int numerito = Main1.menuOpera(); //menu calculadora
					System.out.println("numerito: "+numerito);
					
					//aqui insertas operacion
				}

		}
		System.out.println("sales");

	}

}
