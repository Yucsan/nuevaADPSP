package JPAControladorDao;

import java.util.List;

import entidad.Autorestitulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class AutorestituloFacadeImpl extends AbstractFacadeJPAImpl<Autorestitulo> implements AutorestituloFacade{

	public AutorestituloFacadeImpl() {
		super(Autorestitulo.class);
	}

	@Override
	public List<Autorestitulo> mostrarTodos() {
		TypedQuery<Autorestitulo> q = this.getEm().createQuery("SELECT p FROM Autorestitulo AS p",Autorestitulo.class);
		return q.getResultList();
	}
	
	//Ejercicio 3
	public List<Tuple> librosEscritoPorAutores(int autores){
		TypedQuery<Tuple> q = this.getEm().createQuery("SELECT at.titulo.codtitulo, at.titulo.titulo, at.titulo.genero, at.titulo.precio, COUNT(at.autor.codautor) as numAutores "
				+ "FROM Autorestitulo at "
				+ "GROUP BY at.titulo.codtitulo, at.titulo.titulo, at.titulo.genero, at.titulo.precio "
				+ "HAVING COUNT(at.autor.codautor) >:seleccionado ",Tuple.class);
		q.setParameter("seleccionado", autores);
		return q.getResultList();
	}
}
