package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.TempEquipoJugador;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public interface TempEquipoJugadorFacade extends AbstractFacadeJPA<TempEquipoJugador> {
	public List<TempEquipoJugador>mostrarTodos();
	
	
	
	
}
