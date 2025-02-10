package JPAControladorDao;

import java.util.List;

import entidades.Grupo;


public interface GrupoFacade extends AbstractFacadeJPA<Grupo>{
	public List<Grupo> mostrarTodos();
}
