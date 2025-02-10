package entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // poner esto siempre para que sea una entidad
@Table(name="LIBROS", catalog ="ejercicio2") // PARA PONER UNA TABLA EN WORBENCH
public class Libro implements Serializable {

	// atributos //
	private static final long serialVersionUID = 1L;
	
	@Id // clave principal o primary key
	@Column(name="ISBN", unique= true, nullable=false)
	private String isbn;
	
	@Column(name="AUTOR")
	private String autor;
	
	@Column(name="TITULO", unique= true, nullable=false)
	private String titulo;
	
	@Column(name="PRESTADO")
	private byte prestado;

	public Libro() {
		
	}
	
	public Libro(String isbn, String autor,String titulo,byte prestado) {
		this.isbn = isbn;
		this.autor = autor;
		this.prestado = prestado;
		this.titulo=titulo;
	}
	
	public Libro(String isbn) {
		this.isbn = isbn;
		this.autor = "";
		this.prestado = 0;
		this.titulo="";
	}


	@Override
	public int hashCode() {
		return Objects.hash(isbn);
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
		return "Libro isbn:" + isbn + ", autor:" + autor + ", titulo:" + titulo + ", prestado:" + prestado;
	}

	

	
	
	

}

