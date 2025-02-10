package JPAControladorDao;


import java.util.List;
import entidades.Sucursal;


public interface SucursalFacade extends AbstractFacadeJPA<Sucursal> {
	public List<Sucursal>mostrarTodos();
	
	
	
}
