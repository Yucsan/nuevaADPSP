package JPAControladorDao;

import java.util.List;

import entidades.Departamento;
import entidades.Empleado;
import entidades.Proyecto;
import jakarta.persistence.TypedQuery;

public class DepartamentoFacadeImpl extends AbstractFacadeJPAImpl<Departamento> implements DepartametoFacade {

	public DepartamentoFacadeImpl() {
		super(Departamento.class);
	}
	
	public List<Departamento> mostrarTodos(){
		TypedQuery<Departamento> q = em.createQuery("SELECT p FROM Proyecto as p",Departamento.class);
		return q.getResultList();
	}

}
