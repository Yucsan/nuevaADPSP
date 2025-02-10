package JPAControladorDao;


import java.util.List;

import entidades.Analisi;
import entidades.Cita;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public interface CitaFacade extends AbstractFacadeJPA<Cita> {
	public List<Cita>mostrarTodos();
	
	
	
	
}
