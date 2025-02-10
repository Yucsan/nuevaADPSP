package JPAControladorDao;


import java.util.List;
import entidades.Pago;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class PagoFacadeImpl extends AbstractFacadeJPAImpl<Pago> {

	public PagoFacadeImpl() {
		super(Pago.class);
	}

	public List<Pago> mostrarTodos() {
		TypedQuery<Pago> q = em.createQuery("SELECT e FROM Pago as e", Pago.class);
		return q.getResultList();
	}
	
	//2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de
	//sus representantes de ventas.
	public List<Tuple> ejer5Consulta2(){
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT p.cliente.nombreCliente, p.cliente.empleado.nombre  FROM Pago p "
				+ "", Tuple.class);
		return q.getResultList();
	}
	
	/* 3. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre
	de sus representantes de ventas. */
	
	// 3A
	public List<Tuple> ejer5Consulta3(){
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT c.nombreCliente, c.empleado.nombre "
				+ "FROM Cliente c "
				+ "LEFT JOIN c.pagos p "
				+ "WHERE p is NULL "
				+ "", Tuple.class);
		return q.getResultList();
	}
	// 3B opcion con NOT IN
	public List<Tuple> ejer5Consulta3PRUEBA(){
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT c.nombreCliente, c.empleado.nombre "
				+ "FROM Cliente c "
				+ "LEFT JOIN c.pagos p "
				+ "WHERE c.nombreCliente NOT IN "
				+ "( SELECT p.cliente.nombreCliente FROM Pago p )"
				+ "", Tuple.class);
		return q.getResultList();
	}
	
	/* 4. Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus
	   representantes junto con la ciudad de la oficina a la que pertenece el representante. */

	public List<Tuple> ejer5Consulta4(){
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT c.nombreCliente, c.empleado.nombre, c.empleado.oficina.ciudad "
				+ "FROM Cliente c "
				+ "LEFT JOIN c.pagos p "
			
				+ "", Tuple.class);
		return q.getResultList();
	}
	
	
	
	

}
