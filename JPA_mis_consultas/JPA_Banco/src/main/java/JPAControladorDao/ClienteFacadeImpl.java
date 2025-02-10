package JPAControladorDao;

import java.util.List;
import entidades.Cliente;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class ClienteFacadeImpl extends AbstractFacadeJPAImpl<Cliente> {

	public ClienteFacadeImpl() {
		super(Cliente.class);
	}

//	1 Mostrar el nombre, apellidos y dirección de aquellos clientes que tienen una cuenta
//	bancaria en la sucursal de la calle “Lepanto”. Este listado se debe completar con aquellos
//	clientes que viven en una avenida.
	
	public List<Tuple> ejer4Cons1() {
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT s.direccion, cli.nombre "
				+ "FROM Sucursal s "
				+ "LEFT JOIN s.cuentas c "
				+ "LEFT JOIN c.cliente cli "
				+ "WHERE s.direccion LIKE :direct "
				+ "UNION "
				+ "SELECT cli2.direccion, cli2.nombre "
				+ "FROM Cliente cli2 "
				+ "WHERE cli2.direccion LIKE :direct2 "
				, Tuple.class);
		
		q.setParameter("direct", "%Lepanto%");
		q.setParameter("direct2", "%Avda%");
		return q.getResultList();
	}
	
	//ClientesMov()
	public List<Tuple> ClientesMov() {
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT m.tipoMovimiento.codTipoMovimiento, m.fechaHora, m.cuenta.codCuenta, "
				+ "m.cuenta.cliente.codCliente  "
				+ "FROM Movimiento m "
				, Tuple.class);
		return q.getResultList();
	}
	

	
	
	
	


}
