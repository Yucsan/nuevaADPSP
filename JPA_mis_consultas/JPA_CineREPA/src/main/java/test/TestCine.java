package test;

import java.util.List;

import JPAControladorDao.PasFacadeImpl;
import jakarta.persistence.Tuple;



public class TestCine {

	public static void main(String[] args) {

		
		PasFacadeImpl pf=new PasFacadeImpl();
		
		//1. Mostrar todos los géneros de los que nunca se haya proyectado una película en el multicine.
		System.out.println("");
		System.out.println("---- CONSULTA 1 ------");

		List<Tuple> todo = pf.consulta1();
		System.out.println(todo);
		
		//2. Mostrar los campos título, codpelicula, , cantidad de pases y recaudación de todas las películas.
		System.out.println("");
		System.out.println("---- CONSULTA 2 ------");
		List<Tuple> cons2 = pf.consulta2();
		System.out.println(cons2);
		
		
		//3. Mostrar cuántas salas distintas existen, donde se proyectan películas de un género determinado.
		System.out.println("");
		System.out.println("---- CONSULTA 3 ------");
		List<Tuple> cons3 = pf.consulta3("C.FICCION");
		System.out.println(cons3);
		
		
		/* 4. Obtener la información de todos las salas de cine en las que se haya proyectado alguna película de
		género TERROR o COMEDIA y cuya fecha de producción haya sido posterior a 2008. El listado debe
		aparecer ordenado por número de asientos en orden descendente.  */
		System.out.println("");
		System.out.println("---- CONSULTA 4 ------");
		List<Tuple> cons4 = pf.consulta4();
		System.out.println(cons4);
		

		//6. Obtener un listado de todas las películas que han sido proyectadas en más de 5 ocasiones.
		System.out.println("");
		System.out.println("---- CONSULTA 6 ------");
		List<Tuple> cons6 = pf.consulta6();
		System.out.println(cons6);
		
		//7. Obtener un listado con la recaudación total de las salas de cine agrupada por tipo de pase durante el
		//mes de junio de 2006.	
		System.out.println("");
		System.out.println("---- CONSULTA 7 ------");
		List<Tuple> cons7 = pf.consulta7();
		System.out.println(cons7);
		
		System.out.println("");
		System.out.println("---- CONSULTA 77 ------");
		List<Tuple> cons77 = pf.consulta77();
		System.out.println(cons77);
		
		/* 8. Mostrar un listado con la información de todas las películas proyectadas en salas de más de 100
		asientos y con una venta de entradas de al menos el 50% del total del aforo de la sala. */	
		System.out.println("");
		System.out.println("---- CONSULTA 8 ------");
		List<Tuple> cons8 = pf.consulta8();
		System.out.println(cons8);
		
		// 9. CONSULTA
		//A partir de un código de sala seleccionado, devolver el 
		//número de películas diferentes que se han proyectado en esa sala.
		System.out.println();
		System.out.println("---- CONSULTA 9 ----");

		List<Tuple> consulta9 = pf.consulta9(3);
		for (Tuple t : consulta9) {
				System.out.println("titulos: " + t.get(0) );
		}
		
		
;

	}

}
