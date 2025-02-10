package JPAControladorDao;


import java.util.List;
import entidades.Cliente;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class ClienteFacadeImpl extends AbstractFacadeJPAImpl<Cliente> {

	public ClienteFacadeImpl() {
		super(Cliente.class);
	}

	public List<Cliente> mostrarTodos() {
		TypedQuery<Cliente> q = em.createQuery("SELECT e FROM Cliente as e", Cliente.class);
		return q.getResultList();
	}
	
	// 6. Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
	//CON JOIN
	public List<Tuple> consulta6CHAT(String ciudad) {
	    TypedQuery<Tuple> q = em.createQuery(
	        "SELECT DISTINCT o.lineaDireccion1, o.lineaDireccion2, o.codigoPostal, o.ciudad, o.pais " +
	        "FROM Oficina o " +
	        "JOIN o.empleados e " +
	        "JOIN e.clientes c " +
	        "WHERE LOWER(c.lineaDireccion1) LIKE LOWER(CONCAT('%', :city, '%')) " +
	        "   OR LOWER(c.lineaDireccion2) LIKE LOWER(CONCAT('%', :city, '%')) " +
	        "   OR LOWER(c.ciudad) LIKE LOWER(CONCAT('%', :city, '%')) " +
	        "   OR LOWER(c.region) LIKE LOWER(CONCAT('%', :city, '%')) ",
	        Tuple.class
	    );
	    q.setParameter("city", ciudad);
	    return q.getResultList();
	}
	// SIN JOIN
	public List<Tuple> consulta6chat2(String ciudad) {
	    TypedQuery<Tuple> q = em.createQuery(
	        "SELECT DISTINCT c.empleado.oficina.lineaDireccion1, " +
	        "                c.empleado.oficina.lineaDireccion2, " +
	        "                c.empleado.oficina.codigoPostal, " +
	        "                c.empleado.oficina.ciudad, " +
	        "                c.empleado.oficina.pais " +
	        "FROM Cliente c " +
	        "WHERE LOWER(c.lineaDireccion1) LIKE LOWER(CONCAT('%', :city, '%')) " +
	        "   OR LOWER(c.lineaDireccion2) LIKE LOWER(CONCAT('%', :city, '%')) " +
	        "   OR LOWER(c.ciudad) LIKE LOWER(CONCAT('%', :city, '%')) " +
	        "   OR LOWER(c.region) LIKE LOWER(CONCAT('%', :city, '%')) ",
	        Tuple.class
	    );
	    q.setParameter("city", ciudad);
	    return q.getResultList();
	}
	
	/* 7. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la
		ciudad de la oficina a la que pertenece el representante.  */
	
	public List<Tuple> consulta7() {
	    TypedQuery<Tuple> q = em.createQuery(
	        "SELECT c.nombreCliente, c.empleado.nombre, c.empleado.oficina.ciudad "
	        + "FROM Cliente c "
	        + "ORDER BY c.nombreCliente, c.empleado.nombre, c.empleado.oficina.ciudad "
	        , Tuple.class
	    );
	    
	    return q.getResultList();
	}
	
	//SUBCONSULTAS
	//1. Devuelve el nombre del cliente con mayor límite de crédito.
	public List<Tuple> subs1() {
	    TypedQuery<Tuple> q = em.createQuery(
	        "SELECT c.nombreCliente, c.limiteCredito "
	        + "FROM Cliente c "
	        + "WHERE c.limiteCredito = (SELECT MAX(c1.limiteCredito) FROM Cliente c1) "
	        + "ORDER BY c.limiteCredito DESC "
	        
	        
	        , Tuple.class
	    );
	    
	    return q.getResultList();
	}
	
	/*Consultas variadas
	1. Devuelve el listado de clientes indicando el nombre del cliente y cuántos pedidos ha
	realizado. Tenga en cuenta que pueden existir clientes que no han realizado ningún
	pedido.  */
	
	public List<Tuple> subVariadas() {
	    TypedQuery<Tuple> q = em.createQuery(
	        "SELECT c.nombreCliente, SUM(p.codigoPedido) "
	        + "FROM Cliente c "
	        + "LEFT JOIN c.pedidos p "
	        + "GROUP BY c.nombreCliente "

	       	        
	        , Tuple.class
	    );
	    
	    return q.getResultList();
	}
	



	

}
