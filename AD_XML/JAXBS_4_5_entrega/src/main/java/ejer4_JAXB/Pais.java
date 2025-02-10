package ejer4_JAXB;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlType( propOrder = { "nombre", "fechaCenso", "capital","habitantes"} )// orden para el fichero

@XmlRootElement
public class Pais {
	private String nombre;
	private String capital;
	private LocalDate fechaCenso;
	private String continente;
	private Integer habitantes;
	private Integer importancia;
	
	public Pais() {
	}
	
	public Pais(String nombre, String capital, LocalDate fechaCenso, String continente, Integer habitantes,
			Integer importancia) {
		super();
		this.nombre = nombre;
		this.capital = capital;
		this.fechaCenso = fechaCenso;
		this.continente = continente;
		this.habitantes = habitantes;
		this.importancia = importancia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	
	@XmlElement(name = "Pais_Nombre")  // para que en el fichero aparesca este nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name = "Pais_Capital") 
	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}


	public LocalDate getFechaCenso() {
		return fechaCenso;
	}

	@XmlElement (name = "Pais_censo")
	@XmlJavaTypeAdapter( AdaptadorFecha.class )
	public void setFechaCenso(LocalDate fechaCenso) {
		this.fechaCenso = fechaCenso;
	}


	public String getContinente() {
		return continente;
	}
	
	
	// si quieres que aparesca y usas @XmlType( propOrder tienes que agregarlo al orden
	
	@XmlTransient // esto es para que pase de esta informacion en el fichero
	public void setContinente(String continente) {
		this.continente = continente;
	}


	public Integer getHabitantes() {
		return habitantes;
	}


	public void setHabitantes(Integer habitantes) {
		this.habitantes = habitantes;
	}


	public Integer getImportancia() {
		return importancia;
	}

	@XmlAttribute( name = "importancia", required = true ) 
	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}
	
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", capital=" + capital + ", fechaCenso=" + fechaCenso + ", continente="
				+ continente + ", habitantes=" + habitantes + ", importancia=" + importancia + "]";
	}

	
	
	
	
}
