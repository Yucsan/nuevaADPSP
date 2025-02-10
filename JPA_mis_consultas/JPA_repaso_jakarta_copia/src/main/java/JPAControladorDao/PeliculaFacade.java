package JPAControladorDao;

import java.util.List;

import entidades.Entrada;
import entidades.Pelicula;

public interface PeliculaFacade extends AbstractFacadeJPA<Pelicula> {
	
	
	public List<Pelicula>mostrarTodos();
	

	
	
	
}
