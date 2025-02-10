package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Entrada;
import entidades.Pas;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class PasFacadeImpl extends AbstractFacadeJPAImpl<Pas> {

	public PasFacadeImpl() {
		super(Pas.class);
	}
	
	public List<Pas>mostrarTodos(){
		TypedQuery<Pas> q = em.createQuery("SELECT p FROM Pas as p",Pas.class);
		return q.getResultList();
	}
	
	//3. Mostrar cuántas salas distintas existen, donde se proyectan películas de un género determinado.
	public List<Long>salasDistintintas(String genero){
		
		TypedQuery<Long> q2 = this.getEm().createQuery(
				"SELECT COUNT(PA.sala.codsala) FROM Pas PA "
				+ "WHERE PA.pelicula.genero = :genero",Long.class);
		
		q2.setParameter("genero", genero); // inserta parametro genero :genero
		
		return q2.getResultList();
	}
	
	
	//TODAS LAS PELICULAS PROYECTAS
	public List<Tuple>todasPelisProyectadas(){
		TypedQuery<Tuple> q3 = this.getEm().createQuery("SELECT P.pelicula.titulo  FROM Pas P ",Tuple.class);
		return q3.getResultList();
	}
	
	
	/* 4. Obtener la información de todos las salas de cine en las que se haya proyectado alguna película de
	género TERROR o COMEDIA y cuya fecha de producción haya sido posterior a 2008. El listado debe
	aparecer ordenado por número de asientos en orden descendente. */
	
	Date fechaJava = Date.valueOf("2008-01-01"); //creamos una fecha java
	
	public List<Tuple>consulta4(){
		TypedQuery<Tuple> q4 = this.getEm().createQuery(""
				+ "SELECT P.pelicula.titulo, (P.sala.numasiporfilas * P.sala.numfilas) FROM Pas P "
				+ "WHERE (P.pelicula.genero = 'TERROR' OR P.pelicula.genero = 'COMEDIA' ) "
				+ "AND P.fechaPase > :fecha "
				+ "ORDER BY (P.sala.numasiporfilas * P.sala.numfilas) ASC "
				+ "",Tuple.class);
		
		q4.setParameter("fecha", fechaJava); // inserta parametro fecha
		
		return q4.getResultList();
	}

	
	//5. Mostrar un listado con la información de las películas proyectadas en salas DOLBY.
	public List<Tuple>consulta5(){
		TypedQuery<Tuple> q5 = this.getEm().createQuery("SELECT P.pelicula.titulo FROM Pas P "
				+ "WHERE P.sala.tipoSonido = 'DOLBY'",Tuple.class);
		return q5.getResultList();
	}
	
	//6 listado de todas las películas que han sido proyectadas en más de 5 ocasiones
	public List<Tuple>consulta6(){
		TypedQuery<Tuple> q6 = this.getEm().createQuery(""
				+ "SELECT P.pelicula.titulo, COUNT(P.pelicula.codpelicula) FROM Pas P "
				+ "GROUP BY P.pelicula.codpelicula "
				+ "HAVING COUNT(P.pelicula.codpelicula) >= 5",Tuple.class);
		
		return q6.getResultList();
	}
	
	
	//9. A partir de un código de sala seleccionado, devolver el número de películas diferentes que se han
	//proyectado en esa sala.
	
	//1ero devuelveme las peliculas
	//2do cuentas y luego filtras con DISTINCT
	public List<Tuple>consulta9(int codSala){
		
		TypedQuery<Tuple> q7 = this.getEm().createQuery(""
				+ "SELECT COUNT(DISTINCT P.pelicula.titulo) FROM Pas P "
				+" WHERE P.sala.codsala = :codsala "
				+" ",Tuple.class);
		
		q7.setParameter("codsala", codSala);
		
		return q7.getResultList();
	}

	
	
	
	
	
	
}	











