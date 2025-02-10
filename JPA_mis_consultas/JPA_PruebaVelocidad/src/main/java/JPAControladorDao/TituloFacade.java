package JPAControladorDao;

import java.util.List;

import entidades.Titulo;

public interface TituloFacade extends AbstractFacadeJPA<Titulo> {
	
	
	public List<Titulo>mostrarTodos();
	

	
	
	
}
