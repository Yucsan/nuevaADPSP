package entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity // poner esto siempre para que sea una entidad
@Table(name = "LIBROS", catalog = "ejercicio4") // PARA PONER UNA TABLA EN WORBENCH
public class Libro implements Serializable {

	// atributos //
	private static final long serialVersionUID = 1L;

	@Id // clave principal o primary key
	@Column(name = "ISBN", unique = true, nullable = false)
	private String isbn;

	@Column(name = "AUTOR")
	private String autor;

	@Column(name = "TITULO", unique = true, nullable = false)
	private String titulo;

	@Column(name = "PRESTADO")
	private byte prestado;

	@ManyToMany(targetEntity = Socio.class, cascade = CascadeType.ALL) // ascade = CascadeType.ALL esto es opcional para borrar en todo lo relacionaldo
	@JoinTable(name = "PRESTAMOS", // la tabla nueva que se crea
	joinColumns = @JoinColumn(name = "ISBN"), 
	inverseJoinColumns = @JoinColumn(name = "ID_SOCIO"))
	private Set<Socio> socios;

	public Libro() {

	}

	public Libro(String isbn, String autor, String titulo, byte prestado) {
		super();
		this.isbn = isbn;
		this.autor = autor;
		this.prestado = prestado;
		this.titulo = titulo;
		this.socios = new HashSet<Socio>();
	}

	// agrega y borra socio
	public void addSocio(Socio s) {
		if (this.socios.add(s))
			s.getLibrosPrestados().add(this);
		else
			System.out.println("el socio " + s.getIdSocio() + "ya tiene el libro" + this.getIsbn() + " alquilado");
	}

	public void removeSocio(Socio s) {
		this.socios.remove(s);
		s.getLibrosPrestados().remove(this);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public byte getPrestado() {
		return prestado;
	}

	public void setPrestado(byte prestado) {
		this.prestado = prestado;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", prestado=" + prestado + "]";
	}

}
