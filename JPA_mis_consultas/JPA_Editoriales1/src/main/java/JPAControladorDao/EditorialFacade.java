package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Autorestitulo;
import entidades.Editorial;
import entidades.Titulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public interface EditorialFacade extends AbstractFacadeJPA<Editorial> {
	public List<Editorial>mostrarTodos();
	

	
	
}
