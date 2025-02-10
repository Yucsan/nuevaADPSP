package JPAControladorDao;

import java.util.List;
import entidades.Expediente;


public interface ExpedienteFacade extends AbstractFacadeJPA<Expediente>{
	public List<Expediente> mostrarTodos();
}
