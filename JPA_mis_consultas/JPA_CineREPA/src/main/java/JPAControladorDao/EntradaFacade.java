package JPAControladorDao;


import java.util.List;

import entidades.Sala;


public interface EntradaFacade extends AbstractFacadeJPA<Sala> {
	public List<Sala>mostrarTodos();
	
	
	
	
}
