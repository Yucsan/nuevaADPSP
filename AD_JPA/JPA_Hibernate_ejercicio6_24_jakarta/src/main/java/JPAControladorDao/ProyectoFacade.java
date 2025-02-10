package JPAControladorDao;

import java.util.List;

import entidades.PlazaParking;
import entidades.Proyecto;

public interface ProyectoFacade extends AbstractFacadeJPA<Proyecto>{
	public List<Proyecto> mostrarTodos();
	public List<Proyecto> buscarProyectoDeDpto(String dep); //busqueda con ID
	public List<Proyecto> buscarProyectoDeDptoNombre(String nombre); //busqueda con nombre
	public List<Proyecto> buscarProyectoDeDptoNombre2(String nombre); //busqueda con nombre2
	 
	
}
