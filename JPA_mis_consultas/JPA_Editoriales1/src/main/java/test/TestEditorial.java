package test;

import java.util.List;

import JPAControladorDao.AutoresFacadeImpl;
import JPAControladorDao.EditorialFacadeImpl;
import JPAControladorDao.TituloFacadeImpl;

import entidades.Autorestitulo;
import entidades.Titulo;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class TestEditorial {

	public static void main(String[] args) {
		AutoresFacadeImpl af = new AutoresFacadeImpl();
		TituloFacadeImpl tf = new TituloFacadeImpl();

		EditorialFacadeImpl ef = new EditorialFacadeImpl();
			
		
		System.out.println("---- PRUEBA 1 ------");
		List<Autorestitulo> prueba = af.mostrarTodos();
		System.out.println(prueba);

		/* consulta 1
		Mostrar en un listado tdoso los libros de género business o psychology y cuyos ejemplares a la venta estén agotados.  
		El listado debe aparecer ordenado por título de libro */
		System.out.println("---- Consulta 1 ------");
		System.out.println("");
		List<Tuple> consulta1 = af.consulta1();
		System.out.println(consulta1);
		System.out.println("------------------------------");

		// consulta1 GALA
		System.out.println("EJEMPLO GALA");
		TypedQuery<Titulo> query1 = tf.getEm().createNamedQuery(Titulo.LIBROS_BUSINESS_PSYCHOLOGY_AGOTADOS,
				Titulo.class);
		query1.setParameter("seleccionado1", "business").setParameter("seleccionado2", "psychology");
		System.out.println(query1.getResultList());

		
		/* consulta 2 
		Mostrar el listado con toda la información de todas las editoriales de nuestra base de datos ( tanto si tienen 
		libros publicados como si no) junto con el número de libros que han publicado. El listado estrá ordenado jerárquicacemnte 
		por la ciudad de la editorial en ordén descendente y el nombre de le editorial en ascendente  */
		System.out.println("Mi consulta----------------------------22222");
		System.out.println("Probando consulta 2");
		System.out.println(ef.editorialLibrosVendidos());

		// consulta 2
		System.out.println("GALA2 consulta----------------------------33333");
		System.out.println("Probando gala2");
		System.out.println(ef.editorialLibrosVendidosG());
		
		
		/*Mostrar el código, título, género y precio de los libros que hayan sido escritos 
		  al menos por un número de autores mayor que el que se le pasa por parámetro a la consulta  
		  mostrar tambien el número de autores */
		
		System.out.println("*** Consulta 3 *** ");
		System.out.println( af.consulta3(1) );
		
		//pruebas consulta3
		System.out.println("*** Consulta 3 prueba con parametro String Titulo *** ");
		System.out.println( af.consulta3PRUEBA("titulo2") );
		
		
		

	}

}
