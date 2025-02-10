package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import ejer4_JAXB.Pais;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


public class Test_JAXB_Ejer4 {
	
	private static final String PAIS_DAT_FILE = "./salidas/pais.xml";

	public static void main(String[] args) throws JAXBException, IOException {
		
		System.out.println("-------------------- EJER 4 ---------------");
		
		JAXBContext context2 = JAXBContext.newInstance(Pais.class);
		Marshaller marshaller2 = context2.createMarshaller();
		marshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Pais pais = fillPais();
		marshaller2.marshal(pais, System.out);
		
		FileOutputStream fos2 = new FileOutputStream(PAIS_DAT_FILE);
		
		marshaller2.marshal(pais, fos2);
		fos2.close();
		
	}
	
	
	public static Pais fillPais() {
		
		String nombre = "Perú";
		String capital = "Lima";
		
		LocalDate fechaCenso = LocalDate.of(2025, 1, 28);
		//Date fechaCenso  = new Date();
		String continente = "Sudamerica";
		Integer habitantes = 25000000;
		Integer importancia = 30;
		
		Pais pais = new Pais(nombre,capital, fechaCenso, continente, habitantes, importancia);
		return pais;
		
	}
	
	

	
	
	
	
	
	

}
