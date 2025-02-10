package JPAControladorDao;

import java.util.List;

import entidades.Sala;
import jakarta.persistence.Tuple;

public interface SalaFacade extends AbstractFacadeJPA<Sala>{
	
	public List<Sala>mostrarTodos();
	public List<Long>salasDetermGenero(String genero);
	public List<Tuple>salasComediaMasAnhos();
	public List<Tuple>recaudacionTotal();
	

}
