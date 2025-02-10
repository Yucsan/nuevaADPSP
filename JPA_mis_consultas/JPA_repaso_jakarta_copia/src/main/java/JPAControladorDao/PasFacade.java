package JPAControladorDao;

import java.util.List;

import entidades.Pas;
import jakarta.persistence.Tuple;

public interface PasFacade extends AbstractFacadeJPA<Pas> {
	
	
	public List<Pas>mostrarTodos();
	
	public Long salasDistintintas();
	
	public List<Tuple>todasPelisProyectadas();
	
	public List<Tuple>consulta4(); 
	
	public List<Tuple>consulta5();
	
	public List<Tuple>consulta6();
	
	public List<Tuple>consulta9(int codSala);
	
	
	
}
