package test;


import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import JPAControladorDao.EntradaFacadeImpl;
import JPAControladorDao.PasFacadeImpl;
import JPAControladorDao.SalaFacadeImpl;
import entidades.Sala;
import entidades.Entrada;
import entidades.Pas;
import jakarta.persistence.Tuple;

public class TestCine {

	public static void main(String[] args) {
		EntradaFacadeImpl ef = new EntradaFacadeImpl();
		SalaFacadeImpl sf = new SalaFacadeImpl();
		PasFacadeImpl  pf = new PasFacadeImpl();
		
		System.out.println("");
		System.out.println("---- CONSULTA 1 ------");

		List<Entrada> todo = ef.mostrarTodos();
		System.out.println(todo);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechita = null;
		try {
			fechita = sdf.parse("01/01/2025");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Sala s1 = new Sala(25, 25, 10, "CHOLBY");
		//Sala s2 = new Sala(21, 18, 10, "HDX");
		
		Entrada en1 = new Entrada(19, "Comprador1", 3, 4, 7, 'S');
		
		Pas pa1 = new Pas(40, fechita, "Tardinal");
		Pas pa2 = new Pas(30, fechita, "Madrugada");
		
		System.out.println("Codsala: " + s1.getCodsala());
		
		/*
		sf.create(s1);
		System.out.println("sala");
		ef.create(en1);
		System.out.println("entrada");
		pf.create(pa1);
		pf.create(pa2);
		System.out.println("pase");
		
		pa1.setSala1(s1); // Asocia el pase a la sala s1
		pa2.setSala1(s1); // Asocia el pase a la 
		System.out.println("codigos sala");
		
		s1.addPases1(pa1);
		s1.addPases2(pa2);
		
		*/
		
		
		
		
		
		
		
		
/*
		System.out.println("");
		System.out.println("---- CONSULTA 2 ------");

		List<Tuple> cons2 = tf.Consulta2();
		System.out.println(cons2);
		 */

	}

}
