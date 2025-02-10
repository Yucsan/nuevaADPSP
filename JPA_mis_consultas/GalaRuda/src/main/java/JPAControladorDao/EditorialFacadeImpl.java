package JPAControladorDao;

import java.util.List;

import entidad.Editorial;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class EditorialFacadeImpl extends AbstractFacadeJPAImpl<Editorial> implements EditorialFacade{

	public EditorialFacadeImpl() {
		super(Editorial.class);
	}

	@Override
	public List<Editorial> mostrarTodos() {
		TypedQuery<Editorial> q = this.getEm().createQuery("SELECT p FROM Editorial AS p",Editorial.class);
		return q.getResultList();
	}
	
	//Ejercicio 2
	public List<Tuple> editorialLibrosVendidos(){
		TypedQuery<Tuple> q = this.getEm().createQuery("SELECT e, COUNT(t.codtitulo) as numLibros "
				+ "FROM Editorial e "
				+ "LEFT JOIN Titulo t ON e.codEditorial = t.editorial.codEditorial "
				+ "GROUP BY e "
				+ "ORDER BY e.ciudad DESC, e.nombre ",Tuple.class);
		return q.getResultList();
	}
}
