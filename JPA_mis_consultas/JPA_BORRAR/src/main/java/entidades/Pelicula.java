package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PELICULAS database table.
 * 
 */
@Entity
@Table(name="PELICULAS")
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codpelicula;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_prod")
	private Date fechaProd;

	private String genero;

	private String titulo;

	//bi-directional many-to-one association to Pas
	@OneToMany(mappedBy="pelicula1")
	private List<Pas> pases1;

	//bi-directional many-to-one association to Pas
	@OneToMany(mappedBy="pelicula2")
	private List<Pas> pases2;

	public Pelicula() {
	}

	public int getCodpelicula() {
		return this.codpelicula;
	}

	public void setCodpelicula(int codpelicula) {
		this.codpelicula = codpelicula;
	}

	public Date getFechaProd() {
		return this.fechaProd;
	}

	public void setFechaProd(Date fechaProd) {
		this.fechaProd = fechaProd;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Pas> getPases1() {
		return this.pases1;
	}

	public void setPases1(List<Pas> pases1) {
		this.pases1 = pases1;
	}

	public Pas addPases1(Pas pases1) {
		getPases1().add(pases1);
		pases1.setPelicula1(this);

		return pases1;
	}

	public Pas removePases1(Pas pases1) {
		getPases1().remove(pases1);
		pases1.setPelicula1(null);

		return pases1;
	}

	public List<Pas> getPases2() {
		return this.pases2;
	}

	public void setPases2(List<Pas> pases2) {
		this.pases2 = pases2;
	}

	public Pas addPases2(Pas pases2) {
		getPases2().add(pases2);
		pases2.setPelicula2(this);

		return pases2;
	}

	public Pas removePases2(Pas pases2) {
		getPases2().remove(pases2);
		pases2.setPelicula2(null);

		return pases2;
	}

}