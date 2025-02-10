package JPAControladorDao;

import java.util.List;

import entidad.Autorestitulo;

public interface AutorestituloFacade extends AbstractFacadeJPA<Autorestitulo>{
	public List<Autorestitulo> mostrarTodos();
}
