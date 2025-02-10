package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Autorestitulo;
import entidades.Editorial;
import entidades.Titulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class EditorialFacadeImpl extends AbstractFacadeJPAImpl<Editorial> {

	public EditorialFacadeImpl() {
		super(Editorial.class);
	}
	
	
	// Consulta 2 YO
	public List<Tuple> editorialLibrosVendidos(){
		TypedQuery<Tuple> q = this.getEm().createQuery(" SELECT E, COUNT(T.codtitulo) "
				+ "FROM Editorial E "
				+ "LEFT JOIN E.titulos T "
				+ "GROUP BY E "
				+ "ORDER BY E.ciudad DESC, E.nombre " 
				+"",Tuple.class);
		
		return q.getResultList();
	
	}
	// Consulta 2 Gala 
	public List<Tuple> editorialLibrosVendidosG(){
		TypedQuery<Tuple> q = this.getEm().createQuery("SELECT e, COUNT(t.codtitulo) as numLibros "
				+ "FROM Editorial e "
				+ "LEFT JOIN Titulo t ON e.codEditorial = t.editorial.codEditorial "
				+ "GROUP BY e "
				+ "ORDER BY e.ciudad DESC, e.nombre ",Tuple.class);
		return q.getResultList();
	
	}

	
	
	
	
	
	


}
