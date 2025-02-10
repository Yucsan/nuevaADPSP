package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Autorestitulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public interface AutoresTituloFacade extends AbstractFacadeJPA<Autorestitulo> {
	public List<Autorestitulo>mostrarTodos();
	

	
	
}
