package JPAControladorDao;

import java.util.List;

import entidades.Empleado;
import jakarta.persistence.TypedQuery;

public class EmpleadoFacadeImpl extends AbstractFacadeJPAImpl<Empleado> {

	public EmpleadoFacadeImpl() {
		super(Empleado.class);
	}
	
	public List<Empleado> mostrarTodos(){
		TypedQuery<Empleado> q = em.createQuery("SELECT p FROM Libro as p",Empleado.class);
		return q.getResultList();
	}

}
