package JPAControladorDao;

import java.util.List;

import entidades.Departamento;
import entidades.Empleado;


public interface DepartametoFacade extends AbstractFacadeJPA<Departamento>{
	public List<Departamento> mostrarTodos();
}
