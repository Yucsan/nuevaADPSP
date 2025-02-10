package JPAControladorDao;

import java.util.List;

import entidad.Editorial;

public interface EditorialFacade extends AbstractFacadeJPA<Editorial>{
	public List<Editorial> mostrarTodos();
}
