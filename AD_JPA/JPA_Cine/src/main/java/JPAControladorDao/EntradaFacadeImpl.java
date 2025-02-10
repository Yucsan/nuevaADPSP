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
	
	//2 MJ. Mostrar los campos título, codpelicula, , cantidad de pases y recaudación de todas las películas.  
		public List<Tuple> consulta2MJ() {
			TypedQuery<Tuple> consulta2mj = this.getEm()
					.createQuery("SELECT DISTINCT p.titulo, "
							+ "p.codpelicula, "
							+ "COUNT(Distinct ps.codpase) as numpases, "
							+ "SUM(e.pvp) as recaudacion "
							+ "FROM Pelicula p left join p.pases ps "
							+ "LEFT JOIN ps.entradas e "
							+ "GROUP BY p.titulo, p.codpelicula ORDER BY p.codpelicula ",Tuple.class);
			return consulta2mj.getResultList();

		}
	
	// investigar la diferencia entre estas 2
	
	

	public Long cuenta() {
		TypedQuery<Long> cuenta = em.createQuery(""
				+ "SELECT COUNT(e.pas.codpase) "
				+ "FROM Entrada as e", Long.class);
		return cuenta.getSingleResult();

	}

	// prueba Suma
	public List<Tuple> suma1() {
		TypedQuery<Tuple> suma = this.getEm()
				.createQuery("SELECT E.compardor, SUM(E.pvp) "
						+ "FROM Entrada E WHERE E.codpase = P.codpase "
						+ "GROUP BY p.tipoPase, P.pelicula.titulo ", Tuple.class);
		return suma.getResultList();
	}

	// 7 .7. Obtener un listado con la recaudación total
	// de las salas de cine agrupada por tipo de pase durante el
	// mes de junio de 2006 --- 06/2006 -para probar usamos 12/2016

	Date fecha1 = Date.valueOf("2016-12-01");
	Date fecha2 = Date.valueOf("2016-12-30");

	public List<Tuple> consulta7() {
		TypedQuery<Tuple> q7 = this.getEm().createQuery(
				"" + "SELECT E.pas.tipoPase, E.pas.sala.codsala ,SUM(E.pvp), E.pas.fechaPase FROM Entrada E " // aqui
						+ "WHERE E.pas.fechaPase > :fecha1 AND E.pas.fechaPase < :fecha2 "
						+ "GROUP BY E.pas.tipoPase, E.pas.sala.codsala, E.pas.fechaPase ",
				Tuple.class); // RECUERDA GROUP BY

		q7.setParameter("fecha1", fecha1);
		q7.setParameter("fecha2", fecha2);

		// falta filtrar
		return q7.getResultList();
	}

	// ----------------------------------- 1era prueba AFORO de sala numero de sillas por fila x numero de filas
	// ESTAS SON PRUEBAS QUE HICE PARA LLEGAR A LA CONSULTA 8
	// totales en las salas
	public List<Tuple> prueba() {
		TypedQuery<Tuple> prueba1 = this.getEm()
				.createQuery("" + "SELECT P.sala.numasiporfilas * P.sala.numfilas FROM Pas P ", Tuple.class);

		return prueba1.getResultList();
	}

	
	// prueba Cuenta número de codentrada - codpase agrupado por codpase
	public List<Tuple> numEntradas() {
		TypedQuery<Tuple> prueba2 = this.getEm().createQuery(
				"SELECT COUNT(E.codentrada), E.pas.codpase "
				+ "FROM Entrada E "
				+ "GROUP BY  E.pas.codpase",
				Tuple.class);

		return prueba2.getResultList();
	}

	// comprueba valores
	// Prueba 3 numero de entradas cuenta CodEntrada - aforo
	public List<Tuple> conPrueba3() {
		TypedQuery<Tuple> prueba3 = this.getEm()
				.createQuery( "SELECT COUNT(E.codentrada), (E.pas.sala.numasiporfilas* E.pas.sala.numfilas)/2 as aforo "
						+ "FROM Entrada E "
						+ "GROUP BY aforo", Tuple.class);

		return prueba3.getResultList();
	}

	// // Todos los datos Numero de Entradas, Total vendido y Aforo
	public List<Tuple> TotalVendido() {
		TypedQuery<Tuple> total = this.getEm().createQuery(""
				+ "SELECT  E.pas.codpase, COUNT(E.codentrada), SUM(E.pvp) as total , (E.pas.sala.numasiporfilas * E.pas.sala.numfilas) as aforo "
				+ "FROM Entrada E "
				+ "GROUP BY E.pas.codpase, aforo", Tuple.class);

		return total.getResultList();
	}
	
	// // Total vendido del codigo de pase 1
		public List<Tuple> total1() {
			TypedQuery<Tuple> total1 = this.getEm().createQuery(""
					+ "SELECT COUNT(E.codentrada) "
					+ "FROM Entrada E "
					+ "WHERE E.pas.codpase = 1 ", Tuple.class);

			return total1.getResultList();
		}

	// 8. Mostrar un listado con la información de todas las películas proyectadas
	// en salas de más de 100 asientos y con una venta de entradas de al menos el 50% 
    //del total del aforo de la sala.

	public List<Tuple> consulta8() {
		TypedQuery<Tuple> cons8 = this.getEm()
				.createQuery("SELECT  E.codentrada, E.pas.pelicula.titulo, (E.pas.sala.numasiporfilas * E.pas.sala.numfilas) "
						+ "FROM Entrada E "
						+ "WHERE (E.pas.sala.numasiporfilas * E.pas.sala.numfilas) > 50 "
						+ "AND ( SELECT COUNT(E.codentrada) FROM Entrada E WHERE E.pas.codpase = E.pas.codpase ) >= " //cuenta del total vendido de 1 pase
						+ " ( (E.pas.sala.numasiporfilas * E.pas.sala.numfilas)/2 )" // 50% aforo
						+ "", Tuple.class);


		return cons8.getResultList();
	}
	
	// 8.2 esta es una prueba para forzar resultados de la anerior 1/6 en ves de 50% y aforo mayor a 35
		public List<Tuple> consulta82() {
			TypedQuery<Tuple> cons82 = this.getEm()
					.createQuery("SELECT  E.codentrada, E.pas.pelicula.titulo, (E.pas.sala.numasiporfilas * E.pas.sala.numfilas) "
							+ "FROM Entrada E "
							+ "WHERE (E.pas.sala.numasiporfilas * E.pas.sala.numfilas) > 35 "
							+ "AND ( SELECT COUNT(E.codentrada) FROM Entrada E WHERE E.pas.codpase = E.pas.codpase ) >= " //cuenta del total vendido de 1 pase
							+ " ( (E.pas.sala.numasiporfilas * E.pas.sala.numfilas)/6 )" // 1/6 aforo
							+ "", Tuple.class);
			return cons82.getResultList();
		}

}
