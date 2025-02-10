package test;

import java.util.List;

import JPAControladorDao.TempEquipoJugadorFacadeImpl;

import jakarta.persistence.Tuple;

public class TestCine {

	public static void main(String[] args) {
	
		TempEquipoJugadorFacadeImpl tejf = new TempEquipoJugadorFacadeImpl();

		// 1. Mostrar todos los géneros de los que nunca se haya proyectado una película
		// en el multicine.
		System.out.println("");
		System.out.println("---- CONSULTA 1 ------");
		System.out.println("----  ------");
		List<Tuple> mostrarTodos = tejf.mostrarTodos();
		for (Tuple tupla : mostrarTodos) {
			System.out.println("1 " + tupla.get(0));
		}

		
		
		
		
		
		
		
		
		
		
		

	}

}
