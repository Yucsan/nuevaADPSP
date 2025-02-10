package JPAControladorDao;


import java.util.List;
import entidades.Empleado;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class EmpleadoFacadeImpl extends AbstractFacadeJPAImpl<Empleado> {

	public EmpleadoFacadeImpl() {
		super(Empleado.class);
	}

	public List<Empleado> mostrarTodos() {
		TypedQuery<Empleado> q = em.createQuery("SELECT e FROM Empleado as e", Empleado.class);
		return q.getResultList();
	}
	
	
	//1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su
	//representante de ventas.
	
	public List<Tuple> ejer5Consulta1(){
		TypedQuery<Tuple> q = em.createQuery(""
				+ "SELECT c.nombreCliente, c.empleado.nombre "
				+ "FROM Cliente c "
				+ "", Tuple.class);
		return q.getResultList();
	}
	
	// 8Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
	public List<Tuple> consulta8() {
	    TypedQuery<Tuple> q = em.createQuery(
	        "SELECT e.nombre, e.empleado.nombre "
	        + "FROM Empleado e "
	        + "ORDER BY e.nombre, e.empleado.nombre ",
	        Tuple.class
	    );
	    
	    return q.getResultList();
	}

	

	

	

}
