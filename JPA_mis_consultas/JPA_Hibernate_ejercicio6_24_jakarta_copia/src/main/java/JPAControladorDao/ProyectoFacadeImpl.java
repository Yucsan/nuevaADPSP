package JPAControladorDao;

import java.util.List;

import entidades.Proyecto;
import jakarta.persistence.TypedQuery;

public class ProyectoFacadeImpl extends AbstractFacadeJPAImpl<Proyecto> implements ProyectoFacade {

	public ProyectoFacadeImpl() {
		super(Proyecto.class);
	}
	
	@Override
	public List<Proyecto> mostrarTodos(){
		TypedQuery<Proyecto> q = em.createQuery("SELECT p FROM Proyecto as p",Proyecto.class);
		return q.getResultList();
	}
	
	@Override
	public List<Proyecto> buscarProyectoDeDpto(String dep){
		
		TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto p WHERE p.departamento.codDept=:seleccionado"
				, Proyecto.class); //declaro consuta
		
		q.setParameter("seleccionado", dep); // asigno valor a la variable de la consulta con el parametro
		
		return q.getResultList(); // ejecuto la consulta
	}

	@Override
	public List<Proyecto> buscarProyectoDeDptoNombre(String nombre) {
		TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto p WHERE p.departamento.nombre=:seleccionado", Proyecto.class);
		q.setParameter("seleccionado", nombre);
		System.out.println(q.getResultList());
		return q.getResultList();
	}

	@Override
	public List<Proyecto> buscarProyectoDeDptoNombre2(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
