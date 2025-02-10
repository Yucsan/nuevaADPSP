package JPAControladorDao;

import java.util.List;

import entidades.Departamento;


public interface DireccionFacade extends AbstractFacadeJPA<Departamento>{
	public List<Departamento> mostrarTodos();
}
