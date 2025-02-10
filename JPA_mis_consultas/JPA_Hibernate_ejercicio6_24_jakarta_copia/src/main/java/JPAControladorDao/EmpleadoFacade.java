package JPAControladorDao;

import java.util.List;

import entidades.Empleado;


public interface EmpleadoFacade extends AbstractFacadeJPA<Empleado>{
	public List<Empleado> mostrarTodos(); // los metodos deben estar en la interface y el metodo
	public List<Empleado> mostrarTodosEmpleadosPorDepa(String id); 
}
