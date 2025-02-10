package ejemplo0_JAXB;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Provincia {
	private String nombre;
	private Localidad[] localidad;
	
	public Provincia() {
		
	}
	
	
	public Provincia(String nombre, Localidad[] localidad) {
		super();
		this.nombre = nombre;
		this.localidad = localidad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Localidad[] getLocalidad() {
		return localidad;
	}


	public void setLocalidad(Localidad[] localidad) {
		this.localidad = localidad;
	}
	
	
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + "]";
	}

	
	
	
}
