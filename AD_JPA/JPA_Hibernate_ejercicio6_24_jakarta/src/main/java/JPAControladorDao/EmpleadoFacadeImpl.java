package JPAControladorDao;

import java.util.List;

import entidades.Empleado;
import jakarta.persistence.TypedQuery;

public class EmpleadoFacadeImpl extends AbstractFacadeJPAImpl<Empleado> implements EmpleadoFacade {

	public EmpleadoFacadeImpl() {
		super(Empleado.class);
	}
	
	public List<Empleado> mostrarTodos(){
		TypedQuery<Empleado> q = em.createQuery("SELECT p FROM Empleado as p",Empleado.class);
		return q.getResultList();
	}

	@Override
	public List<Empleado> mostrarTodosEmpleadosPorDepa(String id) {
		TypedQuery<Empleado> q = em.createQuery("SELECT p.empleados FROM Departamento p WHERE p.codDept=:seleccionado",Empleado.class);
		q.setParameter("seleccionado", id);
		return q.getResultList();
	}
	

}
