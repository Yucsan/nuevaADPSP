package JPAControladorDao;

import java.util.List;

import entidad.Titulo;
import jakarta.persistence.TypedQuery;

public class TituloFacadeImpl extends AbstractFacadeJPAImpl<Titulo> implements TituloFacade{

	public TituloFacadeImpl() {
		super(Titulo.class);
	}

	@Override
	public List<Titulo> mostrarTodos() {
		TypedQuery<Titulo> q = this.getEm().createQuery("SELECT p FROM Titulo AS p",Titulo.class);
		return q.getResultList();
	}
}
