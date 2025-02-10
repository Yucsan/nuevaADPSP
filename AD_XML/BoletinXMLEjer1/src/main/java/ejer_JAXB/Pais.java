package ejer_JAXB;

import java.time.LocalDate;
import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Pais {
	private String nombre;
	private String capital;
	private Date fechaCenso;
	private String continente;
	private Integer habitantes;
	private Integer importancia;
	
	
	public Pais() {
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
	
	
	
	
}
