package entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="SOCIOS", catalog ="ejercicio4")
public class Socio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_SOCIO", unique= true, nullable=false)
	private int idSocio;
	
	@Column(name="APELLIDOS")
	private String apellidos;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@ManyToMany(mappedBy="socios")
	private Set<Libro> librosPrestados;
	
	
	public Socio() {
		super();
	}
	

	public Socio(int idSocio, String nombre, String apellidos) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.librosPrestados = new HashSet<Libro>();
	}
	



	public int getIdSocio() {
		return idSocio;
	}


	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}


	public Set<Libro> getLibrosPrestados() {
		return librosPrestados;
	}


	public void setLibrosPrestados(Set<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}


	public int getId_socio() {
		return idSocio;
	}


	public void setId_socio(int idSocio) {
		this.idSocio = idSocio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	@Override
	public String toString() {
		return "Socio [id_socio=" + idSocio + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
	

}
