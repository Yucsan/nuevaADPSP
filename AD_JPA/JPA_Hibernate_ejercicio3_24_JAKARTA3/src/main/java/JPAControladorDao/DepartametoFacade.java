package JPAControladorDao;

import java.util.List;

import entidades.Empleado;


public interface DepartametoFacade extends AbstractFacadeJPA<Empleado>{
	public List<Empleado> mostrarTodos();
}
