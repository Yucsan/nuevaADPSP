package JPAControladorDao;

import java.util.List;

import entidades.Libro;
import jakarta.persistence.TypedQuery;

public class LibroFacadeImpl extends AbstractFacadeJPAImpl<Libro> implements LibroFacade{

	public LibroFacadeImpl() {
		super(Libro.class);
	}

	@Override
	public List<Libro> mostrarTodos() {
		TypedQuery<Libro> q = em.createQuery("SELECT p FROM Libro as p",Libro.class);
		//return q.getResultList(); //esto era lo riginal
		
		// Formato personalizado al imprimir
		List<Libro> libros = q.getResultList();
		for(Libro l: libros) {
			System.out.println(l);
		}
	    return libros;
	   
	}
	
	
}
