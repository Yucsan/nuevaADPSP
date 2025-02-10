package JPAControladorDao;

import java.util.List;

import entidades.Pelicula;
import jakarta.persistence.Tuple;

public interface PeliculaFacade extends AbstractFacadeJPA<Pelicula> {
	
	public List<Pelicula>mostrarTodos();
	public List<String>generosNoMostrados();
	public List<Tuple>pasesRecaudacionPeliculas();
	public List<Tuple>peliculasDolby();
	public List<Tuple>peliculasmas5ocasiones();
	public List<Tuple>peliculasAp8();

}
