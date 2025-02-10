package test;

import java.util.List;

import JPAControladorDao.EntradaFacadeImpl;
import entidades.Entrada;
import jakarta.persistence.Tuple;



public class TestCine {

	public static void main(String[] args) {
		EntradaFacadeImpl ef = new EntradaFacadeImpl();
		
		
		System.out.println("");
		System.out.println("---- CONSULTA 1 ------");
		List<Entrada> todo = ef.mostrarTodos();
		System.out.println(todo);
		
		
		/*
		List<Tuple> todo = ef.mostrarTodos();
		for (Tuple t : todo)
			System.out.println(t.get(0));
*/
		
		/*
		System.out.println("");
		System.out.println("---- CONSULTA 2 ------");

		List<Tuple> cons2 = tf.Consulta2();
		System.out.println(cons2);
		 */

	}

}
