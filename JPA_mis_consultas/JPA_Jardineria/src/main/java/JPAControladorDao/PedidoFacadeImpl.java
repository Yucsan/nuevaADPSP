package JPAControladorDao;


import java.util.List;
import entidades.Pedido;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class PedidoFacadeImpl extends AbstractFacadeJPAImpl<Pedido> {

	public PedidoFacadeImpl() {
		super(Pedido.class);
	}
//9. Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
	public List<Tuple> consulta9() {
		TypedQuery<Tuple> q = em.createQuery("SELECT p.cliente.nombreCliente "
				+ "FROM Pedido p "
				+ "WHERE p.fechaEntrega > p.fechaEsperada "
				, Tuple.class);
		return q.getResultList();
	}
	
	//Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por
	//el número de pedidos.
	public List<Tuple> consResumen4() {
		TypedQuery<Tuple> q = em.createQuery("SELECT COUNT(p.codigoPedido) numPedidos, p.estado "
				+ "FROM Pedido p "
				+ "GROUP BY p.estado "
				+ "ORDER BY numPedidos DESC "
			
				, Tuple.class);
		return q.getResultList();
	}
	
	//7. Devuelve un listado de los productos que nunca han aparecido en un pedido
	public List<Tuple> consMultitabla7() {
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT pro.codigoProducto, pro.nombre "
				+ "FROM Producto pro "
				+ "LEFT JOIN pro.detallePedidos dt "
				+ "LEFT JOIN dt.pedido pe "
				+ "WHERE pe is NULL "
				
			
				, Tuple.class);
		return q.getResultList();
	}
	
	//10. Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
	public List<Tuple> consMultitabla10() {
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT c.codigoCliente, g.gama "
				+ "FROM Cliente c "
				+ "LEFT JOIN c.pedidos pe "
				+ "LEFT JOIN pe.detallePedidos dp "
				+ "LEFT JOIN dp.producto pro "
				+ "LEFT JOIN pro.gamaProducto g "
	
				, Tuple.class);
		return q.getResultList();
	}
	


}








