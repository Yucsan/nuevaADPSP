package JPAControladorDao;

import java.util.List;

import entidades.Sala;
import jakarta.persistence.TypedQuery;

public class SalaFacadeImpl extends AbstractFacadeJPAImpl<Sala> {

	public SalaFacadeImpl() {
		super(Sala.class);
	}
	
	public List<Sala> mostrarSalas(){
		TypedQuery<Sala> q = em.createQuery("SELECT p FROM Sala as p",Sala.class);
		return q.getResultList();
	}

}
