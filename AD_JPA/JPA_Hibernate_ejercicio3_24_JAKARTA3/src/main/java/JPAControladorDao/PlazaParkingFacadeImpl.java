package JPAControladorDao;

import java.util.List;

import entidades.PlazaParking;
import jakarta.persistence.TypedQuery;

public class PlazaParkingFacadeImpl extends AbstractFacadeJPAImpl<PlazaParking> {

	public PlazaParkingFacadeImpl() {
		super(PlazaParking.class);
	}
	
	public List<PlazaParking> mostrarTodos(){
		TypedQuery<PlazaParking> q = em.createQuery("SELECT p FROM Libro as p",PlazaParking.class);
		return q.getResultList();
	}

}
