package JPAControladorDao;


import java.util.List;
import entidades.Entrada;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public interface EntradaFacade extends AbstractFacadeJPA<Entrada> {
	public List<Entrada>mostrarTodos();
	
	
	
	
}
