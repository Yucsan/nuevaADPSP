package JPAControladorDao;


import java.util.List;
import entidades.Autorestitulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class AutorestituloFacadeImpl extends AbstractFacadeJPAImpl<Autorestitulo> {

	public AutorestituloFacadeImpl() {
		super(Autorestitulo.class);
	}

	public List<Autorestitulo> Autorestitulos() {
		TypedQuery<Autorestitulo> q = em.createQuery("SELECT T FROM Autorestitulo as T "
				+ " ", Autorestitulo.class);	
		return q.getResultList();
	}
	
/*	Mostrar el código, titulo, género y precio de los libros que hayan sido escritos al menos
* 	por un número de autores mayor que el que se pasa por parámetro a la consulta 
* 	Mostrar también el número de autores  */	
	public List<Tuple> Consulta3(int numero) {
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT at.titulo.codtitulo, at.titulo.titulo, at.titulo.genero, "
				+ "at.titulo.precio, COUNT(at.autor.nombre) "
				+ "FROM Autorestitulo at "
				+ "GROUP BY at.titulo.codtitulo, at.titulo.titulo, at.titulo.genero, at.titulo.precio "
				+ "HAVING COUNT(at.autor.nombre) > :numAutores "
				, Tuple.class);
		q.setParameter("numAutores", numero);
				
		return q.getResultList();
	}
	


}
