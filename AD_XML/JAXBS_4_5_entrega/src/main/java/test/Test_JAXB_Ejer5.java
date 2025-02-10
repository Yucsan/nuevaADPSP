package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ejer5_JAXBS.PaisHijo;
import ejer5_JAXBS.Paises;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;


public class Test_JAXB_Ejer5 {
	
	private static final String PAISES_GUARDA = "./salidas/paises.xml";
	
	public static void main(String[] args) throws JAXBException, IOException {
		
		System.out.println("-------------------- EJER 5 ---------------");

		JAXBContext context = JAXBContext.newInstance(Paises.class);  //crea
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
		
		Paises paises = leeFicheroPaises(); // agrega conte
		
		paises.muestra();
		
		marshaller.marshal(paises, System.out); // muestra en consola
		
		//persisto
		FileOutputStream fos = new FileOutputStream(PAISES_GUARDA);
		marshaller.marshal(paises, fos); 
		fos.close();
		
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Paises paisesAux = (Paises) unmarshaller.unmarshal(new File(PAISES_GUARDA));
		System.out.println("******** Paises cargado desde fichero XML ********");
		System.out.println(paisesAux);
		
	}
	
	
	public static Paises leeFicheroPaises() {
		
		Paises paises = new Paises();
		
		String texto="", nombre="", capital="", continente ="",anio="", mes="",dia="";
		Date fechaCenso = null;
		Integer habitantes=0, importancia=0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		List<PaisHijo>aux = new ArrayList<PaisHijo>();
		
		try {
			FileReader fr=new FileReader("./fuentes/paises.txt");
			BufferedReader br=new BufferedReader(fr);
				
			while(br.ready()) {
				texto = br.readLine();
				String[]result = texto.split(",");
				nombre = result[0].trim();
				capital = result[1].trim();
				
				anio = result[2].trim();
				mes = result[3].trim();
				dia = result[4].trim();
				fechaCenso = sdf.parse(anio+"/"+mes+"/"+dia);
		
				continente = result[5].trim();
				habitantes = Integer.valueOf(result[6].trim());
				importancia = Integer.valueOf(result[7].trim());
				
				PaisHijo paisAux = new PaisHijo(nombre, capital, fechaCenso, continente, habitantes, importancia);
	
				paises.agregarPais(paisAux);	
			}
			
			br.close(); fr.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println("falla la fecha");
		}
				
		return paises;
	}
	
	

	
	
	
	
	
	

}
