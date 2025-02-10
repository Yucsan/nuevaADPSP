package JPAControladorDao;

import java.util.List;

import entidades.Alumno;


public interface AlumnoFacade extends AbstractFacadeJPA<Alumno>{
	public List<Alumno> mostrarTodos();
}
