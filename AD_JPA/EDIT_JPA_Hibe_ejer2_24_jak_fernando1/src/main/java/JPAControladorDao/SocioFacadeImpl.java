package JPAControladorDao;

import java.util.List;

import entidades.Libro;
import entidades.Socio;
import jakarta.persistence.TypedQuery;

public class SocioFacadeImpl extends AbstractFacadeJPAImpl<Socio> implements SocioFacade {
									 
	public SocioFacadeImpl() {
		super(Socio.class);
	}
	
	@Override
	public List<Socio> mostrarTodos() {
		TypedQuery<Socio> q = em.createQuery("SELECT p FROM Socio as p",Socio.class);
		
		List<Socio> socios = q.getResultList();
		
		for(Socio l: socios) {
			System.out.println(l);
		}
	    return socios;
	}

}
