package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Entrada;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class EntradaFacadeImpl extends AbstractFacadeJPAImpl<Entrada> {

	public EntradaFacadeImpl() {
		super(Entrada.class);
	}

	public List<Entrada> mostrarTodos() {
		TypedQuery<Entrada> q = em.createQuery("SELECT e FROM Entrada as e", Entrada.class);
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
