package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Autorestitulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public interface AutorestituloFacade extends AbstractFacadeJPA<Autorestitulo> {
	public List<Autorestitulo>mostrarTodos();
	
	
	
	
}
