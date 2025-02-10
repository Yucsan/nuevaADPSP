package ejer5_JAXBS;


import java.util.Date;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlType
public class PaisHijo {
	private String nombre;
	private String capital;
	private Date fechaCenso;
	private String continente;
	private Integer habitantes;
	private Integer importancia;
	
	public PaisHijo() {
	}
	
	public PaisHijo(String nombre, String capital, Date fechaCenso, String continente, Integer habitantes,
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaisHijo other = (PaisHijo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getFechaCenso() {
		return fechaCenso;
	}

	
	public void setFechaCenso(Date fechaCenso) {
		this.fechaCenso = fechaCenso;
	}

	
	public String getContinente() {
		return continente;
	}

	
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

	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}
	
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", capital=" + capital + ", fechaCenso=" + fechaCenso + ", continente="
				+ continente + ", habitantes=" + habitantes + ", importancia=" + importancia + "]";
	}

	
	
	
	
}
