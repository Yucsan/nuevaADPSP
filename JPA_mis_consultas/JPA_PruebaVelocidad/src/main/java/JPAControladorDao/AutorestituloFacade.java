package JPAControladorDao;

import java.util.List;

import entidades.Titulo;

public interface AutorestituloFacade extends AbstractFacadeJPA<Titulo> {
	
	
	public List<Titulo>mostrarTodos();
	

	
	
	
}
