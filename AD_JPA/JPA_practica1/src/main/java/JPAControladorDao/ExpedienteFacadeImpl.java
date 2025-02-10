package JPAControladorDao;

import java.util.List;

import entidades.Expediente;
import jakarta.persistence.TypedQuery;

public class ExpedienteFacadeImpl extends AbstractFacadeJPAImpl<Expediente> {

	public ExpedienteFacadeImpl() {
		super(Expediente.class);
	}
	
	public List<Expediente> mostrarTodos(){
		TypedQuery<Expediente> q = em.createQuery("SELECT p FROM Libro as p",Expediente.class);
		return q.getResultList();
	}

}
