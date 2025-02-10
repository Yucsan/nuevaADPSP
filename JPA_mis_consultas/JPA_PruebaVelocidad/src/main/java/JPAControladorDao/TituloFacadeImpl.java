package JPAControladorDao;


import java.util.List;
import entidades.Titulo;

import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class TituloFacadeImpl extends AbstractFacadeJPAImpl<Titulo> {

	public TituloFacadeImpl() {
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
	

	


	

	
	
}	











