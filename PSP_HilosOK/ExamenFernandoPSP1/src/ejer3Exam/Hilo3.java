package ejer3Exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Hilo3 extends Thread {
	public static final String RED = "\u001B[31m";
	public static final String CYAN = "\u001b[36m";
	public static final String MAG = "\u001B[35m";
	
	public void run() {
		String ruta="";
		int inicio = 0, tope = 0;
		try {
			if(this.getName().equals("H1")) {
				ruta = "./ficherosE3/fichero31.txt";
				inicio = 1;
				tope = 10;
			}else if(this.getName().equals("H2")) {
				ruta = "./ficherosE3/fichero32.txt";
				inicio = 10;
				tope = 20;
			}else if(this.getName().equals("H3"))  {
				ruta = "./ficherosE3/fichero33.txt";
				inicio = 20;
				tope = 30;
			}
			FileWriter fw = new FileWriter(ruta, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i=0; i<=9; i++) {
				int ale1= (int)(Math.random()*10)+inicio;
				bw.write(ale1+", "); //guarda
				
			}
			
			if( this.getName().equals("H1") )
				System.out.println(CYAN+"guarda en fichero hilo:"+this.getName());
			else if ( this.getName().equals("H2") )
				System.out.println(MAG+"guarda en fichero hilo:"+this.getName());
			else if ( this.getName().equals("H3") )
				System.out.println(RED+"guarda en fichero hilo:"+this.getName());
			
			
			bw.close(); fw.close();
			
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		if( this.getName().equals("H1") )
			System.out.println(CYAN+"FIN DE"+this.getName());
		else if ( this.getName().equals("H2") )
			System.out.println(MAG+"FIN DE"+this.getName());
		else if ( this.getName().equals("H3") )
			System.out.println(RED+"FIN DE"+this.getName());
		
	}
	
}
