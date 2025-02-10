package JPAControladorDao;

import java.util.List;

import entidades.Alumno;
import jakarta.persistence.TypedQuery;

public class AlumnoFacadeImpl extends AbstractFacadeJPAImpl<Alumno> {

	public AlumnoFacadeImpl() {
		super(Alumno.class);
	}
	
	public List<Alumno> mostrarTodos(){
		TypedQuery<Alumno> q = em.createQuery("SELECT p FROM Libro as p",Alumno.class);
		return q.getResultList();
	}

}
