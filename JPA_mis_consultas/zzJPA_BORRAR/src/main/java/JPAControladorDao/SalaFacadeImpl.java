package JPAControladorDao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entidades.Pas;
import entidades.Sala;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class SalaFacadeImpl extends AbstractFacadeJPAImpl<Sala> {

	public SalaFacadeImpl() {
		super(Sala.class);
	}

	public List<Sala> mostrarTodos() {
		TypedQuery<Sala> q = em.createQuery("SELECT s FROM Sala s", Sala.class);
		return q.getResultList();
	}
	
	
	
	

	

}
