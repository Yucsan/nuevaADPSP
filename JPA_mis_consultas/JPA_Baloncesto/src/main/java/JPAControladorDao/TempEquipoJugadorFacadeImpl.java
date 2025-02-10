package JPAControladorDao;

import java.util.List;


import entidades.PartidosJugadore;
import entidades.TempEquipoJugador;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class TempEquipoJugadorFacadeImpl extends AbstractFacadeJPAImpl<TempEquipoJugador> {

	public TempEquipoJugadorFacadeImpl() {
		super(TempEquipoJugador.class);
	}


	// 2 ¿En qué equipos jugó el Sr Rafael Martinez en la temporada 2009-2010? Mostrar el
	//    nombre del equipo y el salario en miles de euros
	public List<Tuple>consulta2(){
		TypedQuery<Tuple> q2 = this.getEm().createQuery(""
				+ "SELECT T.equipo.nombreEquipo, T.salario " 
				+ "FROM TempEquipoJugador T "
				+ "WHERE T.jugadore.nombreJugador = :name "
				+ "AND T.temporada.codTemp = :tempo"
				+ "",Tuple.class);
		
		q2.setParameter("name", "Rafa Martinez"); 
		q2.setParameter("tempo", "t2"); 
		
		return q2.getResultList();
	}
	
	
	////3) Nombres de los jugadores que han cambiado de equipo en esta temporada
	public List<Tuple>consulta3(){
		TypedQuery<Tuple> q3 = this.getEm().createQuery(""
				+ "SELECT T.jugadore.nombreJugador,  T.equipo.nombreEquipo " 
				+ "FROM TempEquipoJugador T "
				+ "WHERE T.temporada.nombre = :tempo "
				
				+ "AND ( SELECT COUNT(T2.equipo.nombreEquipo) " 
				+ "FROM TempEquipoJugador T2 "
				+ "WHERE T2.temporada.nombre = :tempo "
				+ "AND T2.jugadore.codJugador = T.jugadore.codJugador ) > 1 "
				+ "ORDER BY T.jugadore.nombreJugador "
				
				+ "",Tuple.class);
		
		q3.setParameter("tempo", "2009_2010"); 
		 
		
		return q3.getResultList();
	}

	//SUB CONSULTA CUENTA CANTIDAD DE EQUIPOS DE 1 JUGADOR POR TEMPORADA DETERMINADA 
	public List<Tuple> sub1() {
		
		TypedQuery<Tuple> qs1 = this.getEm().createQuery(""
				+ "SELECT T.jugadore.codJugador, COUNT(T.equipo.nombreEquipo) " 
				+ "FROM TempEquipoJugador T "
				+ "WHERE T.temporada.nombre = :tempo "
				+ "AND T.jugadore.codJugador = :codPlayer "
				+ "GROUP BY T.jugadore.codJugador "
				+ "",Tuple.class);
		
		qs1.setParameter("tempo", "2009_2010"); 
		qs1.setParameter("codPlayer", "j5"); //cod jugador 
		 
		
		return qs1.getResultList();
	}

	// 4 Nombres de los jugadores que han cambiado de equipo en la misma temporada . 
			// Muestra el nombre del jugador, la temporada y el nº de veces que ha cambiado.
	public List<Tuple> consulta42() {
		
		TypedQuery<Tuple> q42 = this.getEm().createQuery(""
				+ "SELECT T.jugadore.nombreJugador, T.temporada.nombre ,COUNT(T.equipo.nombreEquipo) " 
				+ "FROM TempEquipoJugador T "
				+ "WHERE T.temporada.nombre = :tempo "
				+ "GROUP BY T.jugadore.nombreJugador, T.temporada.nombre "
				+ "HAVING COUNT(T.equipo.nombreEquipo) > 1"
				+ "ORDER BY T.jugadore.nombreJugador "
				+ "",Tuple.class);
		
		q42.setParameter("tempo", "2009_2010"); 
		 
		
		return q42.getResultList();
}
	
	
	//5) Obener un listado de los jugadores que no han cambiado de equipo nunca.En el listado
	//   tiene que aparecer el código y nombre de dicho jugador.
	public List<Tuple> consulta5() {
		
		TypedQuery<Tuple> q5 = this.getEm().createQuery(""
				+ "SELECT T.jugadore.codJugador, T.jugadore.nombreJugador " 
				+ "FROM TempEquipoJugador T "
				+ "GROUP BY T.jugadore.codJugador, T.jugadore.nombreJugador "
				+ "HAVING COUNT(T.equipo.nombreEquipo) = 1"
				+ "ORDER BY T.jugadore.nombreJugador "
				+ "",Tuple.class);
		
		//q5.setParameter("tempo", "2009_2010"); 
		 
		
		return q5.getResultList();
}


	public List<Tuple> consulta6() {
		TypedQuery<Tuple> q6 = this.getEm().createQuery(""
				+ "SELECT T.jugadore.codJugador, T.salario " 
				+ "FROM TempEquipoJugador T "
				+ "WHERE  T.equipo.codEquipo = :cEquipo "
				+ "AND ( SELECT MAX(T.salario) FROM TempEquipoJugador T ) <= " //MAX sueldo en cualquier tempo <=  
				+ "( SELECT MIN(T.salario) FROM TempEquipoJugador T "          // que MIN sueldo cualquier jugadorde Temporada 't2'  
				+ "	WHERE  T.temporada.codTemp = :codigoTemporada ) "
				
				+ "ORDER BY T.jugadore.codJugador "
				+ "",Tuple.class);
		
		q6.setParameter("cEquipo", "e1"); 
		q6.setParameter("codigoTemporada", "t2");  
		
		return q6.getResultList();
	}

	
	//SUB CONSULTA 6 ATENCION A LA SINTAXIS que devuelve 1 solo valor
	
	//MAXIMO
	public Integer sub6() {
		Query s6 = em.createQuery(""
				+ "SELECT MAX(T.salario) FROM TempEquipoJugador T ");
		 
		Object result = s6.getSingleResult();
		return (Integer)result;
	}
	
	//MINIMO
	public Integer sub7() {
		Query s7 = em.createQuery(""
				+ "SELECT MIN(T.salario) FROM TempEquipoJugador T "
				+ "WHERE  T.temporada.codTemp = :codigoTemporada ");
		
		s7.setParameter("codigoTemporada", "t2"); 
		 
		Object result = s7.getSingleResult();
		return (Integer)result;
	}


}
