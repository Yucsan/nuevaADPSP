package JPAControladorDao;

import java.util.List;

import entidades.Departamento;
import jakarta.persistence.TypedQuery;

public class DepartamentoFacadeImpl extends AbstractFacadeJPAImpl<Departamento> {

	public DepartamentoFacadeImpl() {
		super(Departamento.class);
	}
	
	public List<Departamento> mostrarTodos(){
		TypedQuery<Departamento> q = em.createQuery("SELECT p FROM Libro as p",Departamento.class);
		return q.getResultList();
	}

}
