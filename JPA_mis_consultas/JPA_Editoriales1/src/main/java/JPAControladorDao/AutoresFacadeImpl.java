package JPAControladorDao;

import java.util.List;

import entidades.Autorestitulo;
import entidades.Titulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class AutoresFacadeImpl extends AbstractFacadeJPAImpl<Autorestitulo> {

	public AutoresFacadeImpl() {
		super(Autorestitulo.class);
	}
	
	
	// consulta de prueba
	public List<Autorestitulo> mostrarTodos() {
		TypedQuery<Autorestitulo> q = em.createQuery("SELECT a FROM Autorestitulo as a", Autorestitulo.class);
		return q.getResultList();
	}
	
	
	//1. Mostrar en un listado todos los libros de género business o psycology y cuyos ejemplares a la venta
	// esten agotados. El listado debe aparecer ordenado por título de libro
	
	//psycology
	
	public List<Tuple> consulta1() {
		TypedQuery<Tuple> consulta1 = this.getEm()
				.createQuery(
						"SELECT T " 
						+ "FROM Titulo T "
						+ "WHERE  ( T.genero = 'business' OR  T.genero = 'psychology' )"
						+ "AND T.ventas = T.tirada "
						+ "ORDER BY T.titulo "
						+ " ",Tuple.class);
		return consulta1.getResultList();

	}
	
	
	/*Mostrar el código, título, género y precio de los libros que hayan sido escritos 
	  al menos por un número de autores mayor que el que se le pasa por parámetro a la consulta  
	  mostrar tambien el número de autores */
	
	public List<Tuple> consulta3(int numAutores) {
		TypedQuery<Tuple> consulta3 = this.getEm()
				.createQuery(
						"SELECT A.titulo.titulo, A.titulo.genero, A.titulo.precio, COUNT(A.autor.id) " 
						+ "FROM Autorestitulo A "
						+ "GROUP BY A.titulo.titulo, A.titulo.genero, A.titulo.precio "
						+ "HAVING COUNT(A.autor.id) >:seleccionado1 "
						+ " ",Tuple.class);
		consulta3.setParameter("seleccionado1", numAutores);
		return consulta3.getResultList();
	}
	
	//PRUEBA agregando que el parametro sea una Título por parametro
	public List<Tuple> consulta3PRUEBA(String titulo) {
		TypedQuery<Tuple> consulta3 = this.getEm()
				.createQuery(
						"SELECT A.titulo.titulo, A.titulo.genero, A.titulo.precio, COUNT(A.autor.id) " 
								+ "FROM Autorestitulo A "
								+ "GROUP BY A.titulo.titulo, A.titulo.genero, A.titulo.precio "
								+ "HAVING COUNT(A.autor.id) > (  SELECT COUNT(au) FROM Autorestitulo au WHERE au.titulo.titulo = :tituloParam ) "
						+ " ",Tuple.class);
		
		consulta3.setParameter("tituloParam", titulo);
		
		
		return consulta3.getResultList();
	}
	
	
	

	


}
