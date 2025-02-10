package JPAControladorDao;


import java.util.List;
import entidades.DetallePedido;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class DetallePedidoFacadeImpl extends AbstractFacadeJPAImpl<DetallePedido> {

	public DetallePedidoFacadeImpl() {
		super(DetallePedido.class);
	}

	public List<DetallePedido> mostrarTodos() {
		TypedQuery<DetallePedido> q = em.createQuery("SELECT e FROM DetallePedido e", DetallePedido.class);
		return q.getResultList();
	}

	
	


}
