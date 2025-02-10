package JPAControladorDao;

import java.util.List;

import entidad.Autor;

public interface AutorFacade extends AbstractFacadeJPA<Autor>{
	public List<Autor> mostrarTodos();
}
