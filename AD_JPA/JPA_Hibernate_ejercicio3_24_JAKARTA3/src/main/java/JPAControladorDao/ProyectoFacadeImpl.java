package JPAControladorDao;

import java.util.List;

import entidades.PlazaParking;
import entidades.Proyecto;
import jakarta.persistence.TypedQuery;

public class ProyectoFacadeImpl extends AbstractFacadeJPAImpl<Proyecto> {

	public ProyectoFacadeImpl() {
		super(Proyecto.class);
	}
	
	public List<Proyecto> mostrarTodos(){
		TypedQuery<Proyecto> q = em.createQuery("SELECT p FROM Libro as p",Proyecto.class);
		return q.getResultList();
	}

}
