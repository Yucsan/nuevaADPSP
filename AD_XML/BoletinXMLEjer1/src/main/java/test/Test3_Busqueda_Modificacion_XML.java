package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dom.DomXML;

public class Test3_Busqueda_Modificacion_XML {

	public static void main(String[] args) throws TransformerConfigurationException, TransformerException {
		
		try{
			DomXML documento = new DomXML("./fuentes/estudiantes.xml");
			
			//buscamos
			NodeList listaNodos = documento.getDocumento().getElementsByTagName("apodo");
			for(int i=0; i<listaNodos.getLength(); i++) {
				Node nodo = listaNodos.item(i);
				if(nodo instanceof Element) {
					System.out.println(nodo.getTextContent());
				}
			}
			
			//Buscamos una etiqueta mediante xPath
			//implementamos de Xpath
			System.out.println("Xpath muestra todos los estudiantes");

			Node nodoClase = (Node)(XPathFactory.newInstance().newXPath().
						evaluate("/clase", documento.getDocumento(), 
						XPathConstants.NODE));
			
			if(nodoClase!=null) {
				System.out.println(nodoClase.getTextContent());
				System.out.println(nodoClase.getNodeName());
			}
			
			//muestra los elementos del estudiante 493
	
			System.out.println("Xpath muestra estudiante 493");
			////libro[autor="Mario Vargas Llosa"]
			Node nodoBusca = (Node)(XPathFactory.newInstance().newXPath().
						evaluate("/clase/estudiante[@rollno = '493']", documento.getDocumento(), 
						XPathConstants.NODE));
			if(nodoBusca!=null) {
				System.out.println("*******");
				System.out.println(nodoBusca.getTextContent());
			}
			
			// OTRA FORMA DE RECOGER NODOS -----------------------------------------------
			/*
			System.out.println("Xpath muestra ... ");
			XPath xpath = XPathFactory.newInstance().newXPath();
			String xPathExpresion = "/clase/estudiante";
			NodeList nodos =(NodeList) xpath.evaluate(xPathExpresion, documento.getDocumento(),XPathConstants.NODESET);
			for( int i=0 ; i<nodos.getLength(); i++) {
				System.out.println(nodos.item(i).getNodeName()+" : "+ nodos.item(i).getTextContent() );
			}*/
			// ------------------------------------------------------------------------------------------
			
			/* 4 Añade una nueva etiqueta llamada beca a ese estudiante
				crea estudiantesmodificado.xml con esta nueva informacion y muestralo en pantalla  */
			
			Element beca = documento.getDocumento().createElement("beca");
			beca.setTextContent("Si");
			nodoBusca.appendChild(beca);
			System.out.println("\n\nMOSTRAR MODIFICACIÓN");
			System.out.println(documento.convertirString());
			documento.escribirArchivo("./salidas/estudianteModificado.xml");
			documento.escribirArchivo("./fuentes/estudiante.xml");
			
			//-------
			// Ejemplo crear objetos java y los vamos a transforma a fichero xml
			
			
			
			
			
			
			
			
			
			
			
			
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch (XPathExpressionException e) {
			e.printStackTrace();
		}catch(SAXException e) {
			
		}catch(IOException e) {
			
		}
		

	}

}
