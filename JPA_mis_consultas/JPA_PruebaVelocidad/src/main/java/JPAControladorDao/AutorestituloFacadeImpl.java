package JPAControladorDao;


import java.util.List;
import entidades.Titulo;

import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class AutorestituloFacadeImpl extends AbstractFacadeJPAImpl<Titulo> {

	public AutorestituloFacadeImpl() {
		super(Titulo.class);
	}
	
	public List<Tuple>consulta2(){
		TypedQuery<Tuple> q = this.getEm().createQuery(""
				+ "SELECT e, COUNT(t.titulo) "
				+ "FROM Editorial e LEFT JOIN e.titulos t "  // LEFT "e" -> para unir, "titulos"-> atributo en Editorial q ref a titulos t de selector pa titulos
				+ "GROUP BY e "
				+ "ORDER BY e.ciudad DESC, e.nombre "
				,Tuple.class);
		return q.getResultList();
	}
	
	// ESTO ES PARA QUE VEAS QUIEN ESTA A LA IZQUIERDA luego del Left Join e.titulos t   
	public List<Tuple>consulta22(){
		TypedQuery<Tuple> q = this.getEm().createQuery(""
				+ "SELECT e, COUNT(t.titulo) "
				+ "FROM Titulo t LEFT JOIN t.editorial e "
				+ "GROUP BY e "
				+ "ORDER BY e.ciudad DESC, e.nombre "
				,Tuple.class);
		return q.getResultList();
	}
	
	/* Mostrar el codigo, título, género y precio de los libros que hayan sido escritos al menos por
	   un número de autores mayor que el que se le pasa por parámetro a la consulta. 
	   Mostrar también el número de autores	*/
	
	
	public List<Tuple>consulta3ok(int numAutores){
		TypedQuery<Tuple> q = this.getEm().createQuery(""
				+ "SELECT at.titulo.titulo, at.titulo.genero, at.titulo.precio, COUNT(at.autor) "
				+ "FROM Autorestitulo at "
				+ "GROUP BY at.titulo.titulo, at.titulo.genero, at.titulo.precio "
				+ "HAVING COUNT(at.autor) > :numeroAutores "
				,Tuple.class);
		q.setParameter("numeroAutores", numAutores);
		return q.getResultList();
	}
	
	
	//esta version la llama desde titulo y al realizar un left Join sobre
	public List<Tuple>pruebaLEFTJOIN1(){
		TypedQuery<Tuple> q = this.getEm().createQuery(""
				+ "SELECT t.titulo, t.genero, t.precio, COUNT(at) "
				+ "FROM Titulo t LEFT JOIN t.autorestitulos at "
				+ "GROUP BY t.titulo, t.genero, t.precio "
				,Tuple.class);
		return q.getResultList();
	}
	// esta es solo para ver

	
	// LEFT JOIN desde Autorestitulo -> Autor, Autorestitulo -> Titulo
	public List<Tuple>pruebaLEFTJOIN2(){
		TypedQuery<Tuple> q = this.getEm().createQuery(""
				+ "SELECT t.titulo, a.nombre "
				+ "FROM Autorestitulo at LEFT JOIN at.autor a LEFT JOIN at.titulo t "
		
				,Tuple.class);
		return q.getResultList();
	}

	// LEFT JOIN desde Titulo ->  Autorestitulo -> Autor
	public List<Tuple>pruebaLEFTJOIN3(){
		TypedQuery<Tuple> q = this.getEm().createQuery(""
				+ "SELECT t.titulo, a.nombre "
				+ "FROM Titulo t LEFT JOIN t.autorestitulos at LEFT JOIN at.autor a "
		
				,Tuple.class);
		return q.getResultList();
	}
	
	//LEFT JOIN desde Autores - > Autorestitulo -> Titulo
	public List<Tuple>pruebaLEFTJOIN4(){
		TypedQuery<Tuple> q = this.getEm().createQuery(""
				+ "SELECT a.nombre, t.titulo "
				+ "FROM Autor a LEFT JOIN a.autorestitulos at LEFT JOIN at.titulo t "
		
				,Tuple.class);
		return q.getResultList();
	}

	

	
	
}	











