package JPAControladorDao;


import java.util.List;
import entidades.TempEquipoJugador;
import jakarta.persistence.Tuple;



public interface TempEquipoJugadorFacade extends AbstractFacadeJPA<TempEquipoJugador> {
	
	public List<Tuple>consulta2();
		
	public List<Tuple>consulta3();
	 
	public List<Tuple> sub1();

	public List<Tuple> consulta42();
		
	public List<Tuple> consulta5();

	public List<Tuple> consulta6();	
}
