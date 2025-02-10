package JPAControladorDao;


import java.util.List;

import entidades.Entrada;
import entidades.Pas;

import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class EntradaFacadeImpl extends AbstractFacadeJPAImpl<Entrada> {

	public EntradaFacadeImpl() {
		super(Entrada.class);
	}
	
	public List<Entrada>mostrarTodos(){
		TypedQuery<Entrada> q = this.getEm().createQuery("SELECT e FROM Entrada e ",Entrada.class);
		return q.getResultList();
	}
	
	
	
	
	
	
	
}	











