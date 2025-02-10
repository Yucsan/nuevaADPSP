package ejer6_JAXBS;

public class Persona {
	private String nombre;
	private Integer edad;
	private boolean activo;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, Integer edad, boolean activo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", activo=" + activo + "]";
	}
	
	
	
	
	
	
}
