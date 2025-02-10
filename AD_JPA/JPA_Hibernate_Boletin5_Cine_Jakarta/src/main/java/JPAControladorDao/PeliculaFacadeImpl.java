package JPAControladorDao;

import java.util.List;

import entidades.Pelicula;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class PeliculaFacadeImpl extends AbstractFacadeJPAImpl<Pelicula> implements PeliculaFacade {

	public PeliculaFacadeImpl() {
		super(Pelicula.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Pelicula>mostrarTodos(){
		TypedQuery <Pelicula> q=this.getEm().createQuery("SELECT p FROM PELICULAS AS p",Pelicula.class);
		return q.getResultList();
	}
	
	/**
	 * 
	 * Ejercicio1
	 */
	
	
	@Override
	public List<String>generosNoMostrados(){
		TypedQuery<String>q1=this.getEm().createQuery("SELECT DISTINCT p.genero FROM Pelicula p where p.genero not in( select distinct peli.genero from Pas pas, Pelicula peli where peli.codpelicula=pas.pelicula.codpelicula)",String.class);
		return q1.getResultList();
	}
	
	/**
	 * Ejercicio2
	 */
	
	@Override
	public List<Tuple>pasesRecaudacionPeliculas(){
		TypedQuery<Tuple>q2=this.getEm().createQuery("SELECT p.titulo,p.codpelicula,COUNT(pas.codpase),coalesce(SUM(en.pvp),0)"
				+ "FROM Pelicula p LEFT JOIN Pas pas ON p.codpelicula=pas.pelicula.codpelicula "
				+ "LEFT JOIN Entrada en ON pas.codpase=en.pas.codpase GROUP BY p.titulo,p.codpelicula",Tuple.class);
		return q2.getResultList();
		
	}

	@Override
	public List<Tuple> peliculasDolby() {
		// TODO Auto-generated method stub
		TypedQuery<Tuple>q5=this.getEm().createQuery("SELECT DISTINCT "
				+ " p.codpelicula,"
				+ " p.titulo,"
				+ " p.fechaProd,"
				+ " p.genero"
				+ " FROM "
				+ " Pelicula p "
				+ "JOIN "
				+ "Pas pas ON p.codpelicula = pas.pelicula.codpelicula "
				+ "JOIN "
				+ "Sala sa ON pas.sala.codsala = sa.codsala "
				+ "WHERE "
				+ "sa.tipoSonido = 'DOLBY'",Tuple.class);
		return q5.getResultList();
		
	}

	@Override
	public List<Tuple> peliculasmas5ocasiones() {
		// TODO Auto-generated method stub
		TypedQuery<Tuple>q6=this.getEm().createQuery("SELECT "
				+ "    p.codpelicula,"
				+ "    p.titulo,"
				+ "    p.fechaProd,"
				+ "    p.genero,"
				+ "    COUNT(pas.pelicula.codpelicula) as NumProyecciones "
				+ "FROM "
				+ "    Pelicula p "
				+ "JOIN "
				+ "    Pas pas ON p.codpelicula = pas.pelicula.codpelicula "
				+ "GROUP BY "
				+ "    p.codpelicula, p.titulo "
				+ "HAVING "
				+ "    COUNT(pas.pelicula.codpelicula) > 5",Tuple.class);
		return q6.getResultList();
	}
	
	@Override
	public List<Tuple> peliculasAp8() {
		// TODO Auto-generated method stub
		TypedQuery<Tuple>q8=this.getEm().createQuery("SELECT DISTINCT "
				+ "    p.codpelicula, "
				+ "    p.titulo, "
				+ "    p.fechaProd, "
				+ "    p.genero "
				+ "FROM "
				+ "    Pelicula p "
				+ "JOIN "
				+ "    Pas pas ON p.codpelicula = pas.pelicula.codpelicula "
				+ "JOIN "
				+ "    Sala sa ON pas.sala.codsala = sa.codsala "
				+ "JOIN "
				+ "    (SELECT "
				+ "         codpase, "
				+ "         COUNT(*) as TotalEntradasVendidas "
				+ "     FROM "
				+ "         Entrada "
				+ "     WHERE "
				+ "         vendido = 'S' "
				+ "     GROUP BY "
				+ "         codpase "
				+ "    ) as EntradasVendidas ON pas.codpase = EntradasVendidas.codpase "
				+ "WHERE "
				+ "    sa.numfilas * sa.numasiporfilas > 100 AND "
				+ "    EntradasVendidas.TotalEntradasVendidas >= 0.5 * (sa.numfilas * sa.numasiporfilas) ",Tuple.class);
		return q8.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
