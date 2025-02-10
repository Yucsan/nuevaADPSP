package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PASES database table.
 * 
 */
@Entity
@Table(name="PASES")
@NamedQuery(name="Pas.findAll", query="SELECT p FROM Pas p")
public class Pas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codpase;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pase")
	private Date fechaPase;

	@Column(name="tipo_pase")
	private String tipoPase;

	//bi-directional many-to-one association to Entrada
	@OneToMany(mappedBy="pas1")
	private List<Entrada> entradas1;

	//bi-directional many-to-one association to Entrada
	@OneToMany(mappedBy="pas2")
	private List<Entrada> entradas2;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="codpelicula", insertable=false, updatable=false)
	private Pelicula pelicula1;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="codpelicula", insertable=false, updatable=false)
	private Pelicula pelicula2;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="codsala", insertable=false, updatable=false)
	private Sala sala1;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="codsala")
	private Sala sala2;

	public Pas() {
	}

	public int getCodpase() {
		return this.codpase;
	}

	public void setCodpase(int codpase) {
		this.codpase = codpase;
	}

	public Date getFechaPase() {
		return this.fechaPase;
	}

	public void setFechaPase(Date fechaPase) {
		this.fechaPase = fechaPase;
	}

	public String getTipoPase() {
		return this.tipoPase;
	}

	public void setTipoPase(String tipoPase) {
		this.tipoPase = tipoPase;
	}

	public List<Entrada> getEntradas1() {
		return this.entradas1;
	}

	public void setEntradas1(List<Entrada> entradas1) {
		this.entradas1 = entradas1;
	}

	public Entrada addEntradas1(Entrada entradas1) {
		getEntradas1().add(entradas1);
		entradas1.setPas1(this);

		return entradas1;
	}

	public Entrada removeEntradas1(Entrada entradas1) {
		getEntradas1().remove(entradas1);
		entradas1.setPas1(null);

		return entradas1;
	}

	public List<Entrada> getEntradas2() {
		return this.entradas2;
	}

	public void setEntradas2(List<Entrada> entradas2) {
		this.entradas2 = entradas2;
	}

	public Entrada addEntradas2(Entrada entradas2) {
		getEntradas2().add(entradas2);
		entradas2.setPas2(this);

		return entradas2;
	}

	public Entrada removeEntradas2(Entrada entradas2) {
		getEntradas2().remove(entradas2);
		entradas2.setPas2(null);

		return entradas2;
	}

	public Pelicula getPelicula1() {
		return this.pelicula1;
	}

	public void setPelicula1(Pelicula pelicula1) {
		this.pelicula1 = pelicula1;
	}

	public Pelicula getPelicula2() {
		return this.pelicula2;
	}

	public void setPelicula2(Pelicula pelicula2) {
		this.pelicula2 = pelicula2;
	}

	public Sala getSala1() {
		return this.sala1;
	}

	public void setSala1(Sala sala1) {
		this.sala1 = sala1;
	}

	public Sala getSala2() {
		return this.sala2;
	}

	public void setSala2(Sala sala2) {
		this.sala2 = sala2;
	}

}