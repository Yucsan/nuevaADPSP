package JPAControladorDao;

import java.util.List;

import entidad.Titulo;

public interface TituloFacade extends AbstractFacadeJPA<Titulo>{
	public List<Titulo> mostrarTodos();
}
