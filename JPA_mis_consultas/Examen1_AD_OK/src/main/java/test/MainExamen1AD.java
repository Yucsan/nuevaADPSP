package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import JPAControladorDao.AutorFacadeImpl;
import JPAControladorDao.AutorestituloFacadeImpl;
import JPAControladorDao.EditorialFacadeImpl;
import JPAControladorDao.TituloFacadeImpl;
import entidades.Autor;
import entidades.Autorestitulo;
import entidades.AutorestituloPK;
import entidades.Editorial;
import entidades.Titulo;
import jakarta.persistence.Tuple;

public class MainExamen1AD {

	public static void main(String[] args) {

		TituloFacadeImpl tf = new TituloFacadeImpl();
		AutorestituloFacadeImpl af = new AutorestituloFacadeImpl();
		AutorFacadeImpl autf = new AutorFacadeImpl();
		EditorialFacadeImpl ef= new EditorialFacadeImpl();
		

		/*
		 * Mostrar en un listado todos los libros de género business o psychology y
		 * cuyos ejemplares a la venta estén agotados. El listado debe aparecer ordenado
		 * por título de libro
		 */
		System.out.println("");
		System.out.println("---- CONSULTA 1 ------");

		List<Tuple> todo = tf.Consulta1();
		for (Tuple t : todo)
			System.out.println(t.get(0));

		/*
		 * Mostrar el listado con toda la información de todas las editoriales de
		 * nuestra base de datos(tanto si tienen libros publicados como si no) junto con
		 * el número de libros que han publicado. El listado estrá ordenado
		 * jerárquicamente por la ciudad de la editorial en orden descendente y el
		 * nombre de la editorial en ascendente
		 */
		System.out.println("");
		System.out.println("---- CONSULTA 2 ------");

		List<Tuple> cons2 = tf.Consulta2();
		System.out.println(cons2);

		/*
		 * Mostrar el código, titulo, género y precio de los libros que hayan sido
		 * escritos al menos por un número de autores mayor que el que se pasa por
		 * parámetro a la consulta Mostrar también el número de autores
		 */
		System.out.println("");
		System.out.println("---- CONSULTA 3 ------");

		List<Tuple> cons3 = af.Consulta3(1);
		System.out.println(cons3);

		// insertar en la base de datos: Un título nuevo con dos autores y asociados a
		// una editorial
		
		//************* RECUERDA GENERAR LOS CONSTRUCTORES DE LAS ENTIDADES QUE VAS A CREAR **************
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		// creamos titulo
		
		try {
			Date fechaP = sdf.parse("15-10-1975");
			
			Titulo t1 = new Titulo("t10", 12.00, fechaP, "ComediaNegra", 7.8, "El examen2", 200.0,
					"Las LLaves Primarias", 100.0);

			// creamos 2 autores
			Autor a1 = new Autor("a19", "Lobitos2", 41008, "La campiña1234", "Korra Largo", "98765412");
			Autor a2 = new Autor("a20", "Tumbes2", 41008, "hdkgwqkfdjbq", "Miranda Morrison", "325777");

			//creamos esitorial
			Editorial edi1 = new Editorial(7, "Manila2", "Las Sofi", "Ayacucho");
			
			//AutorestituloPK							// ATENTO A1 T1
			AutorestituloPK autPK1 = new AutorestituloPK( a1.getCodautor(), t1.getCodtitulo() );
														// ATENTO A2 T1
			AutorestituloPK autPK2 = new AutorestituloPK( a2.getCodautor(), t1.getCodtitulo() ); 
			
			Autorestitulo autt1=new Autorestitulo(autPK1, 5, 1, a1, t1);
			Autorestitulo autt2=new Autorestitulo(autPK2, 5, 2, a2, t1);
			
			tf.create(t1);
			System.out.println("t ok");
			
			autf.create(a1);
			autf.create(a2);
			System.out.println("autores ok");
			
			ef.create(edi1);
			System.out.println("editorial ok");
			
			af.create(autt1);
			af.create(autt2);
			System.out.println("Se crean autorestitulo");
	
			t1.addAutorestitulo(autt1);
			t1.addAutorestitulo(autt2);
			t1.setEditorial(edi1);
			System.out.println("Se vincula todo");

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
