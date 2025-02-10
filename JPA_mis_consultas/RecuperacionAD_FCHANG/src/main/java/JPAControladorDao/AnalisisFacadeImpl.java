package JPAControladorDao;


import java.util.List;

import entidades.Analisi;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class AnalisisFacadeImpl extends AbstractFacadeJPAImpl<Analisi> {

	public AnalisisFacadeImpl() {
		super(Analisi.class);
	}

	public List<Analisi> mostrarTodos() {
		TypedQuery<Analisi> q = em.createQuery("SELECT a FROM Analisi as a", Analisi.class);
		return q.getResultList();
	}

	//cons 1
	
	public List<Tuple> consulta1() {
		TypedQuery<Tuple> consulta1 = this.getEm()
				.createQuery("SELECT a.paciente.nombre "
						+ "FROM Analisi a "
						+ "WHERE a.valoracion = 'F' "
						,Tuple.class);
		return consulta1.getResultList();

	}
	
	//consulta 4
	public List<Tuple> consulta4() {
		TypedQuery<Tuple> consulta4 = this.getEm()
				.createQuery("SELECT distinct a.paciente.nombre, COUNT(a.codanalisis) "
						+ "FROM Analisi a "
						+ "GROUP BY a.paciente.nombre "
						+ "HAVING COUNT(a.codanalisis) > 1 "
						,Tuple.class);
		return consulta4.getResultList();

	}  

	


	

}
