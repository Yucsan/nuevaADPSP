package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Autorestitulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class AutorestituloFacadeImpl extends AbstractFacadeJPAImpl<Autorestitulo> {

	public AutorestituloFacadeImpl() {
		super(Autorestitulo.class);
	}

	public List<Autorestitulo> mostrarTodos() {
		TypedQuery<Autorestitulo> q = em.createQuery("SELECT a FROM Autorestitulo a", Autorestitulo.class);
		return q.getResultList();
	}

	//2. Mostrar los campos título, codpelicula, , cantidad de pases y recaudación de todas las películas.
	/*
	public List<Tuple> consulta2() {
		TypedQuery<Tuple> consulta2 = this.getEm()
				.createQuery("SELECT DISTINCT P.titulo, "
						+ "P.codpelicula, "
						+ "COUNT( DISTINCT E.pas.codpase), "
						+ "SUM(E.pvp) "
						+ "FROM Pelicula P LEFT JOIN P.pases PS LEFT JOIN PS.entradas E "
						+ "GROUP BY P.titulo, P.codpelicula ORDER BY P.codpelicula ",Tuple.class);
		return consulta2.getResultList();

	}  */

	

}
