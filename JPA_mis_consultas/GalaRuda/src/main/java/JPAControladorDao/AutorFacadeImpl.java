package JPAControladorDao;

import java.util.List;

import entidad.Autor;
import jakarta.persistence.TypedQuery;

public class AutorFacadeImpl extends AbstractFacadeJPAImpl<Autor> implements AutorFacade{

	public AutorFacadeImpl() {
		super(Autor.class);
	}

	@Override
	public List<Autor> mostrarTodos() {
		TypedQuery<Autor> q = this.getEm().createQuery("SELECT p FROM Autor AS p",Autor.class);
		return q.getResultList();
	}
}
