package JPAControladorDao;

import java.util.List;
import entidades.Titulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class TituloFacadeImpl extends AbstractFacadeJPAImpl<Titulo> {

	public TituloFacadeImpl() {
		super(Titulo.class);
	}

	
	public List<Titulo> titulos() {
		TypedQuery<Titulo> q = em.createQuery("SELECT T FROM Titulo as T "
				+ " ", Titulo.class);	
		return q.getResultList();
	}
	
/*  Mostrar en un listado todos los libros de género business o psychology y cuyos ejemplares a la venta
 *  estén agotados. El listado debe aparecer ordenado por título de libro	*/
	public List<Tuple> Consulta1() {
		TypedQuery<Tuple> q = em.createQuery("SELECT t FROM Titulo as t "
				+ "WHERE t.tirada = t.ventas "
				+ "AND t.genero = :g1 OR t.genero = :g2 "
				+ "ORDER BY t.titulo "
				, Tuple.class);
		q.setParameter("g1", "business");
		q.setParameter("g2", "psychology");		
		return q.getResultList();
	}
	
/*		Mostrar el listado con toda la información de todas las editoriales de nuestra 
 		base de datos(tanto si tienen libros publicados como si no) junto con el número de libros que han publicado. 
		El listado estrá ordenado jerárquicamente por la ciudad de la editorial en orden descendente 
		y el nombre de la editorial en ascendente    */
		public List<Tuple> Consulta2() {
			TypedQuery<Tuple> q = em.createQuery("SELECT e, COUNT(t.codtitulo) "
					+ "FROM Editorial e "
					+ "LEFT JOIN e.titulos t "
					+ "GROUP BY e.nombre "
					+ "ORDER BY e.ciudad DESC, e.nombre "
					, Tuple.class);	
			return q.getResultList();
		}


		
		
		
		
		
		
		
		

}
