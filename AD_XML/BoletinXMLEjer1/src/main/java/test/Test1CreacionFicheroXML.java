package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dom.DomXML;

public class Test1CreacionFicheroXML {

	// BOLETIN XML EJERCICO 1 crea un fichero XML desde el principio llamadas entradas.xml
	public static void main(String[] args) {
		
		try {
			DomXML documentoNuevo = new DomXML(); //representa a un árbol DOM vacio
			crearDocumentoDesdeCero(documentoNuevo);
			
			documentoNuevo.escribirArchivo("./salidas/entradas.xml");
			
			System.out.println( documentoNuevo.convertirString() );
			System.out.println("---------------");
			documentoNuevo.escribirArchivo();
			
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(TransformerConfigurationException e) {
			e.printStackTrace();
		}catch(TransformerException e) {
			e.printStackTrace();
		}
		

	}
	
	
	private static void crearDocumentoDesdeCero(DomXML documentoNuevo) {
		Document documento = documentoNuevo.getDocumento();  // crea documento principal
		Element entrada = documento.createElement("entrada"); //Hacemos el elemento entrada descender directo del nodo XML principal
		documento.appendChild(entrada);
		
		Element titulo = documento.createElement("titulo"); // crea documento titulo
		titulo.setAttribute("num", "001");  // establece atributo del titulo
		titulo.setTextContent("Creacion de XML"); //indicamos contenido del titulo
		entrada.appendChild(titulo);
		
		Element autor = documento.createElement("autor");
		autor.setTextContent("hashRaygoza");
		entrada.appendChild(autor);
		
		Element fecha = documento.createElement("fecha");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fecha1=LocalDate.now();
		fecha.setTextContent(fecha1.format(dtf));
		entrada.appendChild(fecha);
		
	}
	
	/*
	 <estudiante rollno = "393">
<apellido> Luces </apellido>
<apellido> Zara </apellido>
<apodo> Luz </apodo>
<marcas> 85 </marcas>


<entrada>
  <titulo num="001">Creacion de XML</titulo>
  <autor>hashRaygoza</autor>
  <fecha>2025-01-09</fecha>
</entrada>
	 * */
	private static void crearEstu(DomXML documentoNuevo) {
		Document documento = documentoNuevo.getDocumento();  // crea documento principal
		Element estudianteMod = documento.createElement("clase"); //Hacemos el elemento entrada descender directo del nodo XML principal
		documento.appendChild(estudianteMod);
		
		Element apellido = documento.createElement("estudiante"); // crea documento titulo
		apellido.setAttribute("rollno", "001");  // establece atributo del titulo
		apellido.setTextContent("Creacion de XML"); //indicamos contenido del titulo
		estudianteMod.appendChild(apellido);
		
		Element autor = documento.createElement("autor");
		autor.setTextContent("hashRaygoza");
		estudianteMod.appendChild(autor);
		
		Element fecha = documento.createElement("fecha");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fecha1=LocalDate.now();
		fecha.setTextContent(fecha1.format(dtf));
		estudianteMod.appendChild(fecha);
		
	}
	

}
