package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import entidades.Entrada;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public interface EntradaFacade extends AbstractFacadeJPA<Entrada> {
	public List<Entrada>mostrarTodos();
	
	public List<Tuple> consulta2();
	
	public List<Integer> cuenta();
	
	public List<Tuple> suma1();

	public List<Tuple> consulta7(); 
	
	public List<Tuple> prueba();
	
	public List<Tuple> numEntradas();
	
	public List<Tuple> conPrueba3(); 
	
	public List<Tuple> TotalVendido();
	
	public List<Tuple> total1(); 

	public List<Tuple> consulta8(); 
	
	public List<Tuple> consulta82();
	
	
}
