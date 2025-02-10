package JPAControladorDao;

import java.util.List;

import entidades.Direccion;
import jakarta.persistence.TypedQuery;

public class DireccionFacadeImpl extends AbstractFacadeJPAImpl<Direccion> {

	public DireccionFacadeImpl() {
		super(Direccion.class);
	}
	
	public List<Direccion> mostrarTodos(){
		TypedQuery<Direccion> q = em.createQuery("SELECT p FROM Libro as p",Direccion.class);
		return q.getResultList();
	}

}
