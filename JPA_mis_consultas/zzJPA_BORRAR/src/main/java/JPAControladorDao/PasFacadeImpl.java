package JPAControladorDao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entidades.Pas;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class PasFacadeImpl extends AbstractFacadeJPAImpl<Pas> {

	public PasFacadeImpl() {
		super(Pas.class);
	}

	public List<Pas> mostrarTodos() {
		TypedQuery<Pas> q = em.createQuery("SELECT e FROM Pas as e", Pas.class);
		return q.getResultList();
	}
	
	// 1. Mostrar todos los géneros de los que nunca se haya proyectado una película en el multicine.

	public List<Tuple> consulta1() {
		TypedQuery<Tuple> q = this.getEm()
				.createQuery(" SELECT p.genero "
						+ "FROM Pelicula p "
						+ "LEFT JOIN p.pases pa "
						+ "WHERE pa is NULL "
						,Tuple.class);
		return q.getResultList();

	}
	
	//2. Mostrar los campos título, codpelicula, cantidad de pases y recaudación de todas las películas.
	public List<Tuple> consulta2() {
		TypedQuery<Tuple> q = this.getEm()
				.createQuery(" SELECT e.pas.pelicula.titulo, e.pas.pelicula.codpelicula, e.pas.codpase, SUM(e.pvp) "
						+ "FROM Entrada e "
						+ "GROUP BY e.pas.pelicula.titulo, e.pas.pelicula.codpelicula, e.pas.codpase "
						,Tuple.class);
		return q.getResultList();
	}
	
	//3. Mostrar cuántas salas distintas existen, donde se proyectan películas de un género determinado.
	public List<Tuple> consulta3(String genero) {
		TypedQuery<Tuple> q = this.getEm()
				.createQuery(" SELECT DISTINCT p.pelicula.genero, p.sala.tipoSonido "
						+ "FROM Pas p "
						+ "WHERE p.pelicula.genero = :gen "
						,Tuple.class);
		q.setParameter("gen", genero);
		return q.getResultList();
	}
	
	/* 4. Obtener la información de todos las salas de cine en las que se haya proyectado alguna película de
	género TERROR o COMEDIA y cuya fecha de producción haya sido posterior a 2008. El listado debe
	aparecer ordenado por número de asientos en orden descendente.  */
	public List<Tuple> consulta4() {
		
		Date fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try { fecha = sdf.parse("01-01-2008"); } catch (ParseException e) { e.printStackTrace(); }
		
		TypedQuery<Tuple> q = this.getEm()
				.createQuery(" SELECT p.sala "
						+ "FROM Pas p "
						+ "WHERE ( p.pelicula.genero = :gen1 OR p.pelicula.genero = :gen2 ) "
						+ "AND p.fechaPase > :fechita "
						+ "ORDER BY (p.sala.numasiporfilas * p.sala.numfilas) DESC "
					
						,Tuple.class);
		
		q.setParameter("gen1", "TERROR");
		q.setParameter("gen2", "COMEDIA");
		q.setParameter("fechita", fecha);
		
		return q.getResultList();
	}
	
	//6. Obtener un listado de todas las películas que han sido proyectadas en más de 5 ocasiones.
	
		public List<Tuple> consulta6() {	
		TypedQuery<Tuple> q = this.getEm()
				.createQuery(" SELECT DISTINCT COUNT(p.fechaPase), p.pelicula.titulo "
						+ "FROM Pas p "
						+ "GROUP BY p.pelicula.titulo "
						+ "HAVING COUNT(p.fechaPase) >= 5 "
					
						,Tuple.class);

		return q.getResultList();
	}
		
	//7. Obtener un listado con la recaudación total de las salas de cine agrupada por tipo de pase durante el
		//mes de junio de 2006.	
	
		public List<Tuple> consulta7() {	
			
			Date fecha1 = null, fecha2 = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try { 
				fecha1 = sdf.parse("01-06-2006");
				fecha1 = sdf.parse("30-06-2006");
			} catch (ParseException e) { e.printStackTrace(); }
			
			TypedQuery<Tuple> q = this.getEm()
					.createQuery(" SELECT SUM(e.pvp), e.pas.tipoPase "
							+ "FROM Entrada e "
							+ "WHERE e.vendido = 'S' "
							+ "AND e.pas.fechaPase BETWEEN :fechita1 AND :fechita2 "
							+ "GROUP BY e.pas.tipoPase "
							,Tuple.class);
			q.setParameter("fechita1", fecha1);
			q.setParameter("fechita2", fecha2);
			
			return q.getResultList();
		}
		
	// LO MISMO PERO CON e.pas.fechaPase >= :fechita1 AND e.pas.fechaPase <= :fechita2	
	public List<Tuple> consulta77() {	
			
			Date fecha1 = null, fecha2 = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try { 
				fecha1 = sdf.parse("01-06-2006");
				fecha1 = sdf.parse("30-06-2006");
			} catch (ParseException e) { e.printStackTrace(); }
			
			TypedQuery<Tuple> q = this.getEm()
					.createQuery(" SELECT SUM(e.pvp), e.pas.tipoPase "
							+ "FROM Entrada e "
							+ "WHERE e.vendido = 'S' "
							+ "AND (e.pas.fechaPase >= :fechita1 AND e.pas.fechaPase <= :fechita2) "
							+ "GROUP BY e.pas.tipoPase "
							,Tuple.class);
			q.setParameter("fechita1", fecha1);
			q.setParameter("fechita2", fecha2);
			
			return q.getResultList();
		}
	
	/* 8. Mostrar un listado con la información de todas las películas proyectadas en salas de más de 100
		asientos y con una venta de entradas de al menos el 50% del total del aforo de la sala. */
	
	public List<Tuple> consulta8() {		
		TypedQuery<Tuple> q = this.getEm()
				.createQuery(" SELECT p.pelicula FROM Pas p "
						+ "WHERE ((p.sala.numasiporfilas * p.sala.numfilas) > 100 ) and "
						+ "(SELECT SUM(ent.codentrada) FROM Entrada ent "
						+ "WHERE p.codpase = ent.pas.codpase) >= (p.sala.numasiporfilas * p.sala.numfilas)*50/100  "
						
						,Tuple.class);
		
		return q.getResultList();
	}
	
	
	
	//9. A partir de un código de sala seleccionado, devolver el número de películas diferentes que se han
	//proyectado en esa sala.
	
	public List<Tuple>consulta9(int codSala){
		
		TypedQuery<Tuple> q7 = this.getEm().createQuery(""
				+ "SELECT COUNT(DISTINCT P.pelicula.titulo) FROM Pas P "
				+" WHERE P.sala.codsala = :codsala "
				+" ",Tuple.class);
		
		q7.setParameter("codsala", codSala);
		
		return q7.getResultList();
	}

	
	
	
	
	

	

}
