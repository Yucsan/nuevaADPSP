package test;

import java.util.List;

import JPAControladorDao.AutorestituloFacadeImpl;
import entidades.Autorestitulo;
import jakarta.persistence.Tuple;



public class TestBorrar {

	public static void main(String[] args) {
		AutorestituloFacadeImpl at=new AutorestituloFacadeImpl();
		
		
		System.out.println("");
		System.out.println("---- CONSULTA 1 ------");

		List<Autorestitulo> todo = at.mostrarTodos();
		System.out.println(todo);
		
/*
		System.out.println("");
		System.out.println("---- CONSULTA 2 ------");

		List<Tuple> cons2 = tf.Consulta2();
		System.out.println(cons2);
		 */

	}

}
