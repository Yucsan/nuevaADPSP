package JPAControladorDao;

import java.util.List;

import entidades.Grupo;
import jakarta.persistence.TypedQuery;

public class GrupoFacadeImpl extends AbstractFacadeJPAImpl<Grupo> {

	public GrupoFacadeImpl() {
		super(Grupo.class);
	}
	
	public List<Grupo> mostrarTodos(){
		TypedQuery<Grupo> q = em.createQuery("SELECT p FROM Libro as p",Grupo.class);
		return q.getResultList();
	}

}
