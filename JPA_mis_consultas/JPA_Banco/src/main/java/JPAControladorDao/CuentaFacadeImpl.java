package JPAControladorDao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import entidades.Cuenta;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class CuentaFacadeImpl extends AbstractFacadeJPAImpl<Cuenta> {

	public CuentaFacadeImpl() {
		super(Cuenta.class);
	}

	public List<Cuenta> mostrarTodos() {
		TypedQuery<Cuenta> q = em.createQuery("SELECT e FROM Cuenta as e", Cuenta.class);
		return q.getResultList();
	}
	
//	1. Mostrar el saldo medio de todas las cuentas de la entidad bancaria con dos decimales y
//		la suma de los saldos de todas las cuentas bancarias. 
	public List<Tuple> cons1() {
		TypedQuery<Tuple> consulta1 = this.getEm()
				.createQuery("SELECT ROUND(AVG(c.saldo),2), SUM(c.saldo) FROM Cuenta c "
					,Tuple.class);
		return consulta1.getResultList();
	}
	
	/* 3. Mostrar la suma de los saldos y el saldo medio de las cuentas bancarias por cada código
	de sucursal. */
	public List<Tuple> cons3() {
		TypedQuery<Tuple> consulta3 = this.getEm()
				.createQuery("SELECT SUM(c.saldo), AVG(c.saldo) "
						+ "FROM Cuenta c "
						+ "GROUP BY c.sucursal.codSucursal "
					,Tuple.class);
		return consulta3.getResultList();
	}
	
	/* 7. Mostrar el saldo medio y el interés medio de las cuentas a las que se le aplique un interés
	mayor del 10%, de las sucursales 1 y 2.*/
	public List<Tuple> cons7() {
		TypedQuery<Tuple> consulta7 = this.getEm()
				.createQuery(" SELECT AVG(c.saldo), AVG(c.interes) "
						+ "FROM Cuenta c "
						+ "WHERE c.sucursal.codSucursal IN (1, 2) "
						+ "AND c.interes > :interes "
					,Tuple.class);
		consulta7.setParameter("interes", new BigDecimal("0.1")); 
		return consulta7.getResultList();

	}
	

	
	
	
	


}
