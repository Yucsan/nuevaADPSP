package dom;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DomXML {

	private Document documento;
	
	public DomXML() throws ParserConfigurationException {
		// objetos de creacion xml
		DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
		DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
		this.documento = creadorDocumento.newDocument(); // crea el documento xml
	}
	//probar
	public DomXML(String fichero) throws ParserConfigurationException, SAXException, IOException {
		// objetos de creacion xml
		DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = fabricaCreadorDocumento.newDocumentBuilder();
		this.documento = constructor.parse(fichero); // crea el documento xml
	}

	public Document getDocumento() {
		return documento;
	}

	public void setDocumento(Document documento) {
		this.documento = documento;
	}

	public void escribirArchivo(String nombreFichero)  {
		
	TransformerFactory Fabricatransformador = TransformerFactory.newInstance();
		Transformer transformador;
		try {
			transformador = Fabricatransformador.newTransformer();
			transformador.setOutputProperty(OutputKeys.INDENT, "yes");
			transformador.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformador.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			
			File archivo = new File(nombreFichero);
			// prueba hacer la de si existe archivo borra y sobrescriba
			
			DOMSource origen = new DOMSource(documento);
			StreamResult destino = new StreamResult(archivo);
			
			transformador.transform(origen, destino);
			
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}

		
	}
	

	 //Envia el documento xml a la consola
	public void escribirArchivo() throws TransformerConfigurationException, TransformerException {
		
		TransformerFactory Fabricatransformador = TransformerFactory.newInstance();
		Transformer transformador = Fabricatransformador.newTransformer();

		transformador.setOutputProperty(OutputKeys.INDENT, "yes");
		transformador.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformador.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		
		DOMSource origen = new DOMSource(documento);
		StreamResult destino = new StreamResult(System.out);
		transformador.transform(origen, destino);
	}
	
	// convierte a String
	public String convertirString() throws TransformerConfigurationException, TransformerException {
		
		TransformerFactory Fabricatransformador = TransformerFactory.newInstance();
		Transformer transformador = Fabricatransformador.newTransformer();

		transformador.setOutputProperty(OutputKeys.INDENT, "yes");
		transformador.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformador.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		
		StringWriter writer = new StringWriter();
		DOMSource origen = new DOMSource(documento);
		StreamResult destino = new StreamResult(writer);
		transformador.transform(origen, destino);
		String output = writer.getBuffer().toString();
		return output;
		
	}
	
	
	

}
