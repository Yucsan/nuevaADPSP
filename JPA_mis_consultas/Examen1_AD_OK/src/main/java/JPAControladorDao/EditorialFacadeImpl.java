package JPAControladorDao;


import java.util.List;
import entidades.Editorial;
import jakarta.persistence.TypedQuery;

public class EditorialFacadeImpl extends AbstractFacadeJPAImpl<Editorial> {

	public EditorialFacadeImpl() {
		super(Editorial.class);
	}

	
	public List<Editorial> Editorials() {
		TypedQuery<Editorial> q = em.createQuery("SELECT T FROM Editorial as T "
				+ " ", Editorial.class);	
		return q.getResultList();
	}
	


}
