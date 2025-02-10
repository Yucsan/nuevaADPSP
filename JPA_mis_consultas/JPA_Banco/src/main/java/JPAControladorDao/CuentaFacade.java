package JPAControladorDao;


import java.util.List;
import entidades.Cuenta;


public interface CuentaFacade extends AbstractFacadeJPA<Cuenta> {
	public List<Cuenta>mostrarTodos();
	
	
	
}
