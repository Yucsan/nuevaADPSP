package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Autorestitulo;
import entidades.Titulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public interface TituloFacade extends AbstractFacadeJPA<Titulo> {
	public List<Titulo>mostrarTodos();
	

	
	
}
