package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import ejemplo0_JAXB.Localidad;
import ejemplo0_JAXB.Provincia;
import ejer_JAXB.Pais;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Test_JAXBSerializacion {
	
	private static final String PROVINCIA_DAT_FILE = "./salidas/provincia.xml";
	
	private static final String PAIS_DAT_FILE = "./salidas/pais.xml";

	public static void main(String[] args) throws JAXBException, IOException {
		
		JAXBContext context = JAXBContext.newInstance(Provincia.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // opional formato de tabuladores
		
		Provincia provincia = fillProvincia();
		//mostramos el documento XML generado en la sálida estándar
		marshaller.marshal(provincia, System.out);
		
		//  GUARDO EN FICHERO -------------------------------------
		
		FileOutputStream fos = new FileOutputStream(PROVINCIA_DAT_FILE);
		//guardamos el objeto serializacion en un documento xml
		marshaller.marshal(provincia, fos);
		fos.close();
		
		// convierte de xml a objeto java
		Unmarshaller unmarshaller = context.createUnmarshaller();
		//Deserializamos a partir de un documento XML
		Provincia provinciaAux = (Provincia) unmarshaller.unmarshal(new File(PROVINCIA_DAT_FILE));
		System.out.println("******** Provincia cargado desde fichero XML ********");
		System.out.println(provinciaAux);
		// Mostramos por linea de comandos el objeto Java obtenido
		// producto de desearilizacion
		//marshaler.marshal(provinciaAux, System.out);
		
		System.out.println("-------------------- EJER 4 ---------------");
		
		JAXBContext context2 = JAXBContext.newInstance(Pais.class);
		Marshaller marshaller2 = context.createMarshaller();
		marshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // opional formato de tabuladores
		
		Pais pais = fillPais();
		//mostramos el documento XML generado en la sálida estándar
		marshaller2.marshal(pais, System.out);
		
		
		
		
		
		
	}
	
	
	private static Provincia fillProvincia() {
		
		String[] nombreLocalidad = {"Madrid", "Coslada"};
		int[] cpLocalidad = {28028, 28820};
		Localidad[] localidades = new Localidad[2];
		
		for(int i=0; i<2; i++) {
			localidades[i] = new Localidad();
			localidades[i].setCp(cpLocalidad[i]);
			localidades[i].setNombre(nombreLocalidad[i]);	
		}
		
		Provincia provincia = new Provincia();
		provincia.setNombre("Madrid");
		provincia.setLocalidad(localidades);
		
		return provincia;
	}
	
	public static Pais fillPais() {
		
		String nombre = "Perú";
		String capital = "Lima";
		Date fechaCenso  = new Date();
		String continente = "Sudamerica";
		Integer habitantes = 25000000;
		Integer importancia = 30;
		
		Pais pais = new Pais();
		pais.setNombre(nombre);
		pais.setCapital(capital);
		pais.setFechaCenso(fechaCenso);
		pais.setContinente(continente);
		pais.setHabitantes(habitantes);
		pais.setImportancia(importancia);
		
		return pais;
		
	}
	
	
	
	
	
	
	

}
