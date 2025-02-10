package JPAControladorDao;


import java.util.List;
import entidades.Editorial;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class EditorialFacadeImpl extends AbstractFacadeJPAImpl<Editorial> {

	public EditorialFacadeImpl() {
		super(Editorial.class);
	}
	
	public List<Editorial>mostrarTodos(){
		TypedQuery<Editorial> q = this.getEm().createQuery("SELECT t FROM Editorial t ",Editorial.class);
		return q.getResultList();
	}
	
	/*
	public List<Tuple>consulta2(){
		TypedQuery<Tuple> q = this.getEm().createQuery(""
				+ "SELECT e, t.titulo FROM Editorial e LEFT JOIN e.titulos t "
				,Tuple.class);
		return q.getResultList();
	}
	*/
	


	
	
	
	
	
	
}	











