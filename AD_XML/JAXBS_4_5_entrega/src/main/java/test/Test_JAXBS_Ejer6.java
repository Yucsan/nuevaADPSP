package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ejer6_JAXBS.Persona;

public class Test_JAXBS_Ejer6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static void crearArchivoBinario(String rutaArchivo) {
		
		
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
			oos.writeObject(new Persona("Javier Mendoza Jimenez", 28, true));
			oos.writeObject(new Persona("Salvador Buena", 21, false));
			oos.writeObject(new Persona("Jose Angulo", 19, true));
			oos.close();
		}catch(IOException e) {
			e.fillInStackTrace();
		}
	}

}
