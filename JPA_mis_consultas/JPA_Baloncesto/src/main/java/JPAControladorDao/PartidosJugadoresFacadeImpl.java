package JPAControladorDao;

import java.sql.Date;
import java.util.List;


import entidades.PartidosJugadore;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class PartidosJugadoresFacadeImpl extends AbstractFacadeJPAImpl<PartidosJugadore> {

	public PartidosJugadoresFacadeImpl() {
		super(PartidosJugadore.class);
	}

	public List<PartidosJugadore> mostrarTodos() {
		TypedQuery<PartidosJugadore> q = em.createQuery("SELECT P FROM PartidosJugadore as P", PartidosJugadore.class);
		return q.getResultList();
	}
	
	// 1 Obtener un listado de los nombres de los equipos con los puntos a favor obtenidos en la
	//temporada 2009-2010.
	
	public List<Tuple>consulta1(){
		TypedQuery<Tuple> q1 = this.getEm().createQuery(""
				+ "SELECT E.nombreEquipo, ( SELECT COALESCE(SUM(P1.puntosLocal), 0) "
				+ "FROM Partido P1 WHERE P1.equipo1.codEquipo = E.codEquipo "
				+ "AND P1.temporada.codTemp = :tempo ) + "
				+ "( SELECT COALESCE(SUM(P2.puntosVisitante), 0) "
				+ "FROM Partido P2 WHERE P2.equipo2.codEquipo = E.codEquipo "
				+ "AND P2.temporada.codTemp = :tempo )"
				+ "FROM Equipo E "
				+ "",Tuple.class);
		
		q1.setParameter("tempo", "t2"); 
		
		return q1.getResultList();
	}

	
	

	
	
	
	
	
	
	
	
	

	

}
