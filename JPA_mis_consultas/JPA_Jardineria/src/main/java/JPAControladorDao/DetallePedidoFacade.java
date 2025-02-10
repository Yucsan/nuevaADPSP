package JPAControladorDao;

import java.util.List;

import entidades.Cliente;
import entidades.DetallePedido;

public interface DetallePedidoFacade extends AbstractFacadeJPA<DetallePedido> {
	public List<DetallePedido>mostrarTodos();
	
	
	
	
}
