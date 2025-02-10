package JPAControladorDao;

import java.util.List;

import entidades.Editorial;

public interface EditorialFacade extends AbstractFacadeJPA<Editorial> {
	
	
	public List<Editorial>mostrarTodos();
	

	
	
	
}
