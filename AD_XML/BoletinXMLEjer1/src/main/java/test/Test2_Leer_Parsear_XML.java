package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import dom.DomXML;

public class Test2_Leer_Parsear_XML {

	public static void main(String[] args) throws SAXException, IOException, TransformerConfigurationException, TransformerException {
		
		try{
			DomXML documento = new DomXML("./fuentes/estudiantes.xml");
			System.out.println("PRIMERA FORMA");
			//documento.imprimirNodos(documento.getDocumento());
			System.out.println("SEGUNDA FORMA");
			System.out.println(documento.convertirString());
			System.out.println("TERCERA FORMA");
			documento.escribirArchivo();
			
			
			
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(TransformerConfigurationException e) {
			e.printStackTrace();
		}catch(TransformerException e) {
			e.printStackTrace();
		}
		

	}

}
