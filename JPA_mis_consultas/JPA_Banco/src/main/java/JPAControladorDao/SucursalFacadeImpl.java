package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Sucursal;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class SucursalFacadeImpl extends AbstractFacadeJPAImpl<Sucursal> {

	public SucursalFacadeImpl() {
		super(Sucursal.class);
	}

	public List<Tuple> mostrarTodos() {
		TypedQuery<Tuple> q = em.createQuery("SELECT e FROM Sucursal e", Tuple.class);
		return q.getResultList();
	}
	
	
	
	
	


}
