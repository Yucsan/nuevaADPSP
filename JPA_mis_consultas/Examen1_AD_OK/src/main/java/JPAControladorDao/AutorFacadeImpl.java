package JPAControladorDao;


import java.util.List;
import entidades.Autor;
import jakarta.persistence.TypedQuery;

public class AutorFacadeImpl extends AbstractFacadeJPAImpl<Autor> {

	public AutorFacadeImpl() {
		super(Autor.class);
	}

	public List<Autor> estitulos() {
		TypedQuery<Autor> q = em.createQuery("SELECT T FROM Autor as T "
				+ " ", Autor.class);	
		return q.getResultList();
	}



}
