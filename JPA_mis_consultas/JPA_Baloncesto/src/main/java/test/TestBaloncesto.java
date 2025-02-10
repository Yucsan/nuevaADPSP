package test;

import java.util.List;

import JPAControladorDao.PartidosJugadoresFacadeImpl;
import JPAControladorDao.TempEquipoJugadorFacadeImpl;
import entidades.PartidosJugadore;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class TestBaloncesto {


	public static void main(String[] args) {
		
		PartidosJugadoresFacadeImpl pjf = new PartidosJugadoresFacadeImpl();
		TempEquipoJugadorFacadeImpl tjf = new TempEquipoJugadorFacadeImpl();

		System.out.println("**********");
		System.out.println("*PRUEBA1");
		System.out.println("**********");

		List<PartidosJugadore> prueba1 = pjf.mostrarTodos();
		for( PartidosJugadore d: prueba1) {
			System.out.println(d);
		}
		
		System.out.println("**********");
		System.out.println("*CONSULTA 1");
		System.out.println("**********");
		System.out.println("Obtener un listado de los nombres de los equipos con los puntos a favor obtenidos en la temporada 2009-2010.");
		List<Tuple> consulta1 = pjf.consulta1();
		for (Tuple tupla : consulta1) {
			System.out.println(" Equipo: "+tupla.get(0)+" Puntos: "+tupla.get(1));
		}
		
		System.out.println("**********");
		System.out.println("*CONSULTA 2");
		System.out.println("**********");
		System.out.println("2 ¿En qué equipos jugó el Sr Rafael Martinez en la temporada 2009-2010? Mostrar nombre del equipo y el salario en miles de euros");
		List<Tuple> consulta2 = tjf.consulta2();
		for (Tuple tupla : consulta2) {
			System.out.println(" Equipo: "+tupla.get(0)+" salario: "+tupla.get(1)+"€");
		}
		
		//3) Nombres de los jugadores que han cambiado de equipo en esta temporada
		System.out.println("**********");
		System.out.println("*CONSULTA 3");
		System.out.println("**********");
		System.out.println("3) Nombres de los jugadores que han cambiado de equipo en esta temporada (2010_2011)");
		List<Tuple> consulta3 = tjf.consulta3();
		for (Tuple tupla : consulta3) {
			System.out.println(" Jugador: "+tupla.get(0)+" Equipo: "+tupla.get(1));
		}
		
		//cuenta Jugadores---------ESTA  es una subconsulta que use para desarrollar la 3
		//muestra el codigo del jugador y el numero de equipos por una Temporada Determinada
		System.out.println("**********");
		System.out.println("*subConsulta 1  de la 3");
		System.out.println("**********");
		System.out.println("Cuenta Jugador");
		List<Tuple> sub1 = tjf.sub1();
		for (Tuple tupla : sub1) {
			System.out.println(" cod Jugador: "+tupla.get(0)+" Nºde equipos: "+tupla.get(1));
		}
		
		
		// 4 Nombres de los jugadores que han cambiado de equipo en la misma temporada . 
		// Muestra el nombre del jugador, la temporada y el nº de veces que ha cambiado.

		//AFINANDO LA FINAL ES LA 42
		System.out.println("**********");
		System.out.println("*CONSULTA 4");
		System.out.println("**********");
		System.out.println("4) Nombres de los jugadores que han cambiado de equipo en la misma temporada ");
		System.out.println("   Muestra el nombre del jugador, la temporada y el nº de veces que ha cambiado ");
		List<Tuple> consulta4 = tjf.consulta42();
		for (Tuple tupla : consulta4) {
			System.out.println(" JUGADOR: "+tupla.get(0)+" TEMPORADA: "+tupla.get(1)+" Nº EQUIPOS: "+tupla.get(2));
		}
		
		// 5 Obener un listado de los jugadores que no han cambiado de equipo nunca.En el listado
		//   tiene que aparecer el código y nombre de dicho jugador.
		System.out.println("**********");
		System.out.println("*CONSULTA 5");
		System.out.println("**********");
		System.out.println("5) Obtener un listado de los jugadores que no han cambiado de equipo nunca.En el listado ");
		System.out.println("   tiene que aparecer el código y nombre de dicho jugador ");
		List<Tuple> consulta5 = tjf.consulta5();
		for (Tuple tupla : consulta5) {
			System.out.println(" Cod-Jugador: "+tupla.get(0)+" JUGADOR: "+tupla.get(1) );
		}
		
		
		// 5 Obener un listado de los jugadores que no han cambiado de equipo nunca.En
		// el listado
		// tiene que aparecer el código y nombre de dicho jugador.
		System.out.println("**********");
		System.out.println("*CONSULTA 6");
		System.out.println("**********");
		System.out.println("6) Obtener los códigos de los jugadores que jueguen en el equipo 'e1' donde su sueldo ");
		System.out.println( "maximo en cualquier temporada sea menor o igual que el menor sueldo de cualquier ");
		System.out.println("jugador de la temporada 't2'. ");

		List<Tuple> consulta6 = tjf.consulta6();
		for (Tuple tupla : consulta6) {
			System.out.println(" Cod-Jugador: " + tupla.get(0) + " SUELDO: " + tupla.get(1));
		}
		System.out.println("esta consulta no da resultados ... ");
		
		// SUB CONSULTA AUXILIAR 6 // TENCION USAMOS " getSingleResult() "
		//  atento a como devuelve el valor con ¡CASTING de Objeto al valor a devolver!
		System.out.println("**********");
		System.out.println("*SUB CONSULTA 6");
		System.out.println("**********");
		System.out.println("**** EXTRA SUB 6 ***** ");


		int sub6 = tjf.sub6();
		System.out.println("MAX: "+sub6);
		
		int sub7 = tjf.sub7();
		System.out.println("MIN: "+sub7);
		
		
		
		
		

		
		
		
		
	}

}
