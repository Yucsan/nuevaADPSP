package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the titulo database table.
 * 
 */
@Entity
@Table(name="titulo")
@NamedQuery(name="Titulo.findAll", query="SELECT t FROM Titulo t")
public class Titulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codtitulo;

	@Column(name="derechos_autor")
	private double derechosAutor;

	@Temporal(TemporalType.DATE)
	private Date fechapub;

	private String genero;

	private double precio;

	private String sinopsis;

	private double tirada;

	private String titulo;

	private double ventas;

	//bi-directional many-to-one association to Autorestitulo
	@OneToMany(mappedBy="titulo")
	private List<Autorestitulo> autorestitulos;

	//bi-directional many-to-one association to Editorial
	@ManyToOne
	@JoinColumn(name="codeditorial")
	private Editorial editorial;

	public Titulo() {
	}

	public String getCodtitulo() {
		return this.codtitulo;
	}

	public void setCodtitulo(String codtitulo) {
		this.codtitulo = codtitulo;
	}

	public double getDerechosAutor() {
		return this.derechosAutor;
	}

	public void setDerechosAutor(double derechosAutor) {
		this.derechosAutor = derechosAutor;
	}

	public Date getFechapub() {
		return this.fechapub;
	}

	public void setFechapub(Date fechapub) {
		this.fechapub = fechapub;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getSinopsis() {
		return this.sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public double getTirada() {
		return this.tirada;
	}

	public void setTirada(double tirada) {
		this.tirada = tirada;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getVentas() {
		return this.ventas;
	}

	public void setVentas(double ventas) {
		this.ventas = ventas;
	}

	public List<Autorestitulo> getAutorestitulos() {
		return this.autorestitulos;
	}

	public void setAutorestitulos(List<Autorestitulo> autorestitulos) {
		this.autorestitulos = autorestitulos;
	}

	public Autorestitulo addAutorestitulo(Autorestitulo autorestitulo) {
		getAutorestitulos().add(autorestitulo);
		autorestitulo.setTitulo(this);

		return autorestitulo;
	}

	public Autorestitulo removeAutorestitulo(Autorestitulo autorestitulo) {
		getAutorestitulos().remove(autorestitulo);
		autorestitulo.setTitulo(null);

		return autorestitulo;
	}

	public Editorial getEditorial() {
		return this.editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

}