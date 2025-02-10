package JPAControladorDao;

import java.util.List;

import entidades.Pelicula;
import jakarta.persistence.TypedQuery;

public class PeliculaFacadeImpl extends AbstractFacadeJPAImpl<Pelicula> {

	public PeliculaFacadeImpl() {
		super(Pelicula.class);
	}
	
	public List<Pelicula> mostrarTodos(){
		TypedQuery<Pelicula> q = em.createQuery("SELECT p FROM Pelicula as p",Pelicula.class);
		return q.getResultList();
	}
	
	
	public List<String>generosNoMostrados(){
		TypedQuery<String> q= em.createQuery(
				"SELECT DISTINCT p.genero "
				+ "FROM Pelicula as p where p.genero not in " //selecciona todas las consultas que no esten en todos los generos (SubConsulta)
				+ "(SELECT DISTINCT peli.genero from Pas pas, Pelicula peli where peli.codpelicula = pas.pelicula.codpelicula)",String.class);
		return q.getResultList();
	}

}
