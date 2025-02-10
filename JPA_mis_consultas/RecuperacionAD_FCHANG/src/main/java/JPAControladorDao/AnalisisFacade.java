package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Analisi;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public interface AnalisisFacade extends AbstractFacadeJPA<Analisi> {
	public List<Analisi>mostrarTodos();
	
	
	
	
}
