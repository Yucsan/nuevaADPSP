package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.TempEquipoJugador;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class TempEquipoJugadorFacadeImpl extends AbstractFacadeJPAImpl<TempEquipoJugador> {

	public TempEquipoJugadorFacadeImpl() {
		super(TempEquipoJugador.class);
	}

	public List<Tuple> mostrarTodos() {
		TypedQuery<Tuple> q = em.createQuery("SELECT t FROM TempEquipoJugador as t", Tuple.class);
		return q.getResultList();
	}

	//2. Mostrar los campos título, codpelicula, , cantidad de pases y recaudación de todas las películas.
	public List<Tuple> consulta2() {
		TypedQuery<Tuple> consulta2 = this.getEm()
				.createQuery("SELECT E.pas.pelicula.titulo, "
						+ "E.pas.pelicula.codpelicula, "
						+ "COUNT(E.pas.codpase), "
						+ "SUM(E.pvp) "
						+ "FROM Entrada E "
						+ "GROUP BY E.pas.codpase, E.pas.pelicula.codpelicula ",Tuple.class);
		return consulta2.getResultList();

	}
	

}
