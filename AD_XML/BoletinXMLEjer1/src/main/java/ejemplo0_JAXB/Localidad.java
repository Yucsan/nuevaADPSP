package ejemplo0_JAXB;

import jakarta.xml.bind.annotation.XmlType;

@XmlType
public class Localidad {
	private String nombre;
	private int cp;
	
	public Localidad() {
		
	}
	
	public Localidad(String nombre, int cp) {
		super();
		this.nombre = nombre;
		this.cp = cp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}
	
	
	
	
	
	
	
	
	
	
}
