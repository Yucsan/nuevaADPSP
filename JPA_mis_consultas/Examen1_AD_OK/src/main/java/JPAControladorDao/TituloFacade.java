package JPAControladorDao;

import java.util.List;
import entidades.Titulo;
import jakarta.persistence.Tuple;

public interface TituloFacade extends AbstractFacadeJPA<Titulo> {

	public List<Titulo> titulos();
	public List<Tuple> Consulta1();
	public List<Tuple> Consulta2();

}
