package JPAControladorDao;


import java.sql.Date;
import java.util.List;


import entidades.Pas;
import entidades.Pelicula;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class PasFacadeImpl extends AbstractFacadeJPAImpl<Pas> {

	public PasFacadeImpl() {
		super(Pas.class);
	}
	
	public List<Tuple>mostrarTodos(){
		TypedQuery<Tuple> q = this.getEm().createQuery("SELECT p.tipoPase FROM Pas as p ",Tuple.class);
		return q.getResultList();
	}
	
	//1. Mostrar todos los géneros de los que nunca se haya proyectado una película en el multicine.
	public List<Tuple>generosNoProyectados(){
		// los genereos proyectados
		
		TypedQuery<Tuple> q = this.getEm().createQuery(""
				+ " SELECT DISTINCT P.genero FROM Pelicula as P "
				+ " WHERE P.genero NOT IN( "
				+ " SELECT PA.pelicula.genero FROM Pas PA )"
				+ "",Tuple.class);
	
		//TypedQuery<Tuple> q = this.getEm().createQuery("SELECT p.pelicula.genero FROM Pas as p ",Tuple.class);
	
		return q.getResultList();
	}
	
	//2. Mostrar los campos título, codpelicula, , cantidad de pases y recaudación de todas las películas.

		public List<Tuple>Consulta2(){
			// los genereos proyectados
			
			TypedQuery<Tuple> q = this.getEm().createQuery(""
					+ " SELECT P.titulo, P.codpelicula, "
					+ " COUNT(DISTINCT E.pas.codpase), "
					+ " SUM(E.pvp) "
					+ " FROM Pelicula P LEFT JOIN P.pases PS LEFT JOIN PS.entradas E "
					+ " GROUP BY P.titulo, P.codpelicula "
					+ "",Tuple.class);
	
			return q.getResultList();
		}
		
		//extra. Mostrar los tipos de salaSonido, cantidad de pases y recaudación de todas las películas.
	
		public List<Tuple>ConsExtra2(){
			// los genereos proyectados
			
			TypedQuery<Tuple> q = this.getEm().createQuery(""
					+ " SELECT S.tipoSonido, P.titulo, "
					+ " COUNT( DISTINCT PS.codpase), "
					+ " SUM(E.pvp) "
					+ " FROM Sala S LEFT JOIN S.pases PS LEFT JOIN PS.pelicula P LEFT JOIN PS.entradas E  "
					+ " GROUP BY S.tipoSonido, P.titulo "
					+ "",Tuple.class);
	
			return q.getResultList();
			
			
		}
		//3. Mostrar cuántas salas distintas existen, donde se proyectan películas de un género determinado.
		public List<Tuple> Consulta3(String genero) {
			
			TypedQuery<Tuple> q = this.getEm().createQuery(""
					+ " SELECT DISTINCT COUNT( P.sala.codsala ) "
					+ " FROM Pas P "
					+ " WHERE P.pelicula.genero = :generoPeli "
					+ "",Tuple.class);
			
			q.setParameter("generoPeli", genero);
			
			return q.getResultList();
			
		}
		
		/* 4. Obtener la información de todos las salas de cine en las que se haya proyectado alguna película de
		género TERROR o COMEDIA y cuya fecha de producción haya sido posterior a 2008. El listado debe
		aparecer ordenado por número de asientos en orden descendente. */
		public List<Tuple> Consulta4() {

			TypedQuery<Tuple> q = this.getEm().createQuery(""
					+ " SELECT DISTINCT P.sala.codsala, (P.sala.numasiporfilas * P.sala.numfilas) asientos , P.sala.tipoSonido  "
					+ " FROM Pas P "
					+ " WHERE P.pelicula.genero = :gen1 OR P.pelicula.genero = :gen2 "
					+ " AND P.fechaPase  > :fecha "
					+ " ORDER BY asientos DESC "
					+ "",Tuple.class);
			
			Date fechaJava = Date.valueOf("2008-01-01"); //creamos una fecha java
			q.setParameter("gen1", "TERROR");
			q.setParameter("gen2", "COMEDIA");
			q.setParameter("fecha", fechaJava);
			
			return q.getResultList();
		}

		//5. Mostrar un listado con la información de las películas proyectadas en salas DOLBY.
		public List<Tuple> Consulta5() {
		
			TypedQuery<Tuple> q = this.getEm().createQuery(""
					+ " SELECT DISTINCT P.pelicula.codpelicula, P.pelicula.fechaProd, P.pelicula.genero, P.pelicula.titulo "
					+ " FROM Pas P "
					+ " WHERE P.sala.tipoSonido = :sala "
					
					+ " ORDER BY P.pelicula.codpelicula "
					+ "",Tuple.class);
			
			
			q.setParameter("sala", "DOLBY");

			return q.getResultList();
		}
		
		//6. Obtener un listado de todas las películas que han sido proyectadas en más de 5 ocasiones.
		public List<Tuple> Consulta6() {

			TypedQuery<Tuple> q = this.getEm().createQuery(""
					+ " SELECT DISTINCT COUNT(P.pelicula.codpelicula), P.pelicula.titulo "
					+ " FROM Pas P "
					+ " GROUP BY P.pelicula.titulo "
					+ " HAVING COUNT(P.pelicula.codpelicula) >= :ocaciones "
					+ "",Tuple.class);
			
			q.setParameter("ocaciones", 5);

			return q.getResultList();
		}
		
		/*7. Obtener un listado con la recaudación total de las salas de cine agrupada por tipo de pase durante el
		mes de junio de 2006.*/
		public List<Tuple> Consulta7() {

			TypedQuery<Tuple> q = this.getEm().createQuery(""
					+ " SELECT SUM(E.pvp), E.pas.tipoPase "
					+ " FROM Entrada E "
					+ " WHERE E.pas.fechaPase > :fechaInicio OR E.pas.fechaPase < :fechaFin "
					+ " GROUP BY E.pas.tipoPase "
					+ "",Tuple.class);
			
			Date fechaInicio = Date.valueOf("2006-06-01"); 
			q.setParameter("fechaInicio", fechaInicio);
			
			Date fechaFin= Date.valueOf("2006-06-30"); 
			q.setParameter("fechaFin", fechaFin);
			
			return q.getResultList();
		}
		
		/*  8. Mostrar un listado con la información de todas las películas proyectadas en salas de más de 100
			asientos y con una venta de entradas de al menos el 50% del total del aforo de la sala.  */
		
			public List<Tuple> Consulta8() {

				TypedQuery<Tuple> q = this.getEm().createQuery(""
					+ " SELECT E.pas.pelicula.titulo, "
					+ " (E.pas.sala.numasiporfilas * E.pas.sala.numfilas), "
					+ "	COUNT(E.codentrada) "
					+ " FROM Entrada E "
					+ " WHERE (E.pas.sala.numasiporfilas * E.pas.sala.numfilas) > 35 "
					+ " GROUP BY E.pas.pelicula.titulo, E.pas.sala.numasiporfilas, E.pas.sala.numfilas "
					+ " HAVING COUNT(E.codentrada) >= (E.pas.sala.numasiporfilas * E.pas.sala.numfilas) / 2"
					+ "",Tuple.class);
		
				return q.getResultList();
			}
			
			
			
			
			/*  82. Mostrar un listado con la información de todas las películas proyectadas en salas de más de 100
			asientos y con una venta de entradas de al menos el 50% del total del aforo de la sala.  */
		
			public  List<Pelicula> Consulta8MJ() {

				TypedQuery<Pelicula> q = this.getEm().createQuery(""
					+ " SELECT P.pelicula FROM Pas P "
					+ " WHERE ((P.sala.numasiporfilas * P.sala.numfilas ) > 100 ) "
					+ " AND (SELECT SUM( E.codentrada) FROM Entrada E WHERE P.codpase = E.pas.codpase ) >= ("
					+ " P.sala.numasiporfilas * P.sala.numfilas )/2"
					+ "",Pelicula.class);
		
				return q.getResultList();
			}
			
			//83
			public List<Tuple> consulta8() {
				TypedQuery<Tuple> cons8 = this.getEm()
						.createQuery("SELECT  E.pas.pelicula.titulo, "
								+ "(E.pas.sala.numasiporfilas * E.pas.sala.numfilas), "
								+ " COUNT(E.codentrada) "
								+ "FROM Entrada E "
								+ "WHERE (E.pas.sala.numasiporfilas * E.pas.sala.numfilas) > 50 "
								+ "AND ( SELECT COUNT(E2.codentrada) FROM Entrada E2 WHERE E2.pas.codpase = E2.pas.codpase ) >= " //cuenta del total vendido de 1 pase
								+ " ( (E.pas.sala.numasiporfilas * E.pas.sala.numfilas)/2 ) "
								+ "GROUP BY E.pas.pelicula.titulo, E.pas.sala.numasiporfilas, E.pas.sala.numfilas "
								+ "", Tuple.class);

				return cons8.getResultList();
			}
			
			
			
		/*9. A partir de un código de sala seleccionado, devolver el número de películas diferentes que se han
		proyectado en esa sala.*/
			
			public List<Tuple> Consulta9(int codSala) {

				TypedQuery<Tuple> q = this.getEm().createQuery(""
					+ " SELECT COUNT (DISTINCT P.pelicula.codpelicula) "
					+ " FROM Pas P "
					+ " WHERE P.sala.codsala = :codigoSala "
					+ "",Tuple.class);
				
				q.setParameter("codigoSala", codSala);
		
				return q.getResultList();
			}
	
	
	
}	











