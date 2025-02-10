package test;

import java.util.List;

import JPAControladorDao.EntradaFacadeImpl;
import JPAControladorDao.PasFacadeImpl;
import JPAControladorDao.PeliculaFacadeImpl;
import JPAControladorDao.SalaFacadeImpl;
import entidades.Entrada;
import jakarta.persistence.Tuple;

public class TestCine {

	public static void main(String[] args) {
		PasFacadeImpl paf = new PasFacadeImpl();
		PeliculaFacadeImpl pf = new PeliculaFacadeImpl();
		SalaFacadeImpl sf = new SalaFacadeImpl();
		EntradaFacadeImpl ef = new EntradaFacadeImpl();

		// 1. Mostrar todos los géneros de los que nunca se haya proyectado una película
		// en el multicine.
		System.out.println("");
		System.out.println("---- CONSULTA 1 ------");
		System.out.println("---- Mostrar todos los géneros de los que nunca se haya proyectado una película ------");
		List<String> generosNo = pf.generosNoMostrados();
		System.out.println(generosNo);

		// 2. Mostrar los campos título, codpelicula, cantidad de pases y recaudación
		// todas las películas.
		System.out.println("");
		System.out.println("---- CONSULTA 2 ------");
		System.out.println("---- Mostrar los campos título, codpelicula, cantidad de pases y recaudación de todas las películas ------");
		List<Tuple> consulta2 = ef.consulta2();
		for (Tuple tupla : consulta2) {
			System.out.println("Título Peli: " + tupla.get(0) + " codPelicula: " + tupla.get(1) + " Nº pases: "
					+ tupla.get(2)+"  recaudacion: "+ tupla.get(3)+"€");
		}
		
		// 2. MJ
				// todas las películas.
				System.out.println("");
				System.out.println("---- CONSULTA 2MJ ------");
				System.out.println("---- Mostrar los campos título, codpelicula, cantidad de pases y recaudación de todas las películas ------");
				List<Tuple> consulta2MJ = ef.consulta2MJ();
				for (Tuple tupla : consulta2) {
					System.out.println("Título Peli: " + tupla.get(0) + " codPelicula: " + tupla.get(1) + " Nº pases: "
							+ tupla.get(2)+"  recaudacion: "+ tupla.get(3)+"€");
				}
		

		// MIS PRUEBAS
		// cuenta cantidad de pases
		System.out.println();
		System.out.println("esta es una prueba");
		Long cuentas = ef.cuenta();
		System.out.println("numero de pases: " + cuentas);

		// 3. Mostrar cuántas salas distintas existen, donde se proyectan películas de
		// un género determinado.
		System.out.println("");
		System.out.println("---- CONSULTA 3 ------");
		System.out.println("---- Mostrar cuántas salas distintas existen, donde se proyectan películas de un género determinado ------");
		long consulta3 = paf.salasDistintintas("BELICO");
		
			System.out.println("del genero Belico son: "+consulta3);
		

		/*4. Obtener la información de todos las salas de cine en las que se haya
		proyectado alguna película de género TERROR o COMEDIA y cuya fecha de
		producción haya sido posterior a 2008. El listado debe aparecer ordenado por
		número de asientos en orden descendente. */

		System.out.println();
		System.out.println("Obtener la información de todos las salas de cine en las que se haya proyectado alguna película de\n"
				+ "género TERROR o COMEDIA y cuya fecha de producción haya sido posterior a 2008. El listado debe\n"
				+ "aparecer ordenado por número de asientos en orden descendente.");
		System.out.println("---- CONSULTA 4 ------");
		List<Tuple> consulta4 = paf.consulta4();
		for (Tuple l : consulta4) {
			System.out.println("Titulo: "+l.get(0)+" Aforo: "+l.get(1));
		}

		// 5. Mostrar un listado con la información de las películas proyectadas en
		// salas DOLBY.
		System.out.println();
		System.out.println(
				"---- CONSULTA 5 ------ listado con la información de las películas proyectadas en salas DOLBY.");
		List<Tuple> consulta5 = paf.consulta5();
		for (Tuple l : consulta5) {
			System.out.println("Titulo: "+l.get(0));
		}

		// 6. Obtener un listado de todas las películas que han sido proyectadas en más
		// de 5 ocasiones.
		System.out.println();
		System.out.println(
				"---- CONSULTA 6 ------ listado de todas las películas que han sido proyectadas en más de 5 ocasiones.");

		List<Tuple> consulta6 = paf.consulta6();
		for (Tuple l : consulta6) {
			System.out.println("Titulo: " + l.get(0) + " Proyecciones: " + l.get(1));
		}

		// 7 .7. Obtener un listado con la recaudación total de las salas de cine
		// agrupada por tipo de pase durante el
		// mes de junio de 2006 --- 06/2006 -para probar usamos 12/2016
		System.out.println();
		System.out.println("---- CONSULTA 7 ------ Obtener un listado con la recaudación total de las salas de cine "
				+ "agrupada por tipo de pase durante el\n" + "	//mes de junio de 2016 .");

		List<Tuple> consulta7 = ef.consulta7();
		for (Tuple l : consulta7) {
			System.out.println("1. Tipo Pase: " + l.get(0) + "2. codSala: " + l.get(1) + " Recaudación: " + l.get(2)
					+ " FechaPase: " + l.get(3));
		}

		// ----------------------------------------------Pruebita

		System.out.println();
		System.out.println("---- PRUEBA1 ----");
		List<Tuple> prue = ef.prueba();
		for (Tuple l : prue) {
			System.out.println("aforo sala: " + l.get(0));
		}

		// CUENTA LAS ENTRADAS AGRUPADAS POR PASE
		System.out.println();
		System.out.println("---- PRUEBA2 ---- NUM ENTRADAS AGRUPADAS POR PASE");
		List<Tuple> prue2 = ef.numEntradas();
		for (Tuple l : prue2) {
			System.out.println("cod Entrada: " + l.get(0) + " " + "cod Pas: " + l.get(1));
		}

		// CUENTA LAS ENTRADAS AGRUPADAS POR PASE
		System.out.println();
		System.out.println("---- PRUEBA3 ---- datos");
		List<Tuple> prue3 = ef.conPrueba3();
		for (Tuple l : prue3) {
			System.out.println("Nº entradas: " + l.get(0) + " " + "aforo: " + l.get(1));
		}
		
		// Todos los datos Numero de Entradas, Total vendido y Aforo
		System.out.println();
		System.out.println("---- TODOS LOS datos");
		List<Tuple> PruebaTotalVendido = ef.TotalVendido();
		for (Tuple l : PruebaTotalVendido) {
			System.out.println("1)codPase " +l.get(0)+" 2)NumEntradas " +l.get(1)+" 2)Total Vendido: "+l.get(2)+" 3)Aforo: "+l.get(3));
		}

		
		System.out.println();
		System.out.println("---- Total vendido del codigo de pase 1");
		List<Tuple> to = ef.total1();
		for (Tuple l : to) {
			System.out.println("TOTAL1 " +l.get(0));
		}

		
		// 8. Mostrar un listado con la información de todas las películas 
		//proyectadas en salas de más de 100 asientos y 
		//con una venta de entradas de al menos el 50% del total del aforo de la sala.
		System.out.println();
		System.out.println("---- CONSULTA 8 ----todas las películas proyectadas en salas de más de 50");
		System.out.println("---- ---------- ----con una venta de entradas de al menos el 50% del total del aforo de la sala");
		List<Tuple> consulta8 = ef.consulta8();
		for (Tuple l : consulta8) {
			System.out.println("codEntrada: " + l.get(0) + " " + "titulo: " + l.get(1)+" Aforo: " + l.get(2));
		}
		
		// 8.2. prueba
		//proyectadas en salas de más de 100 asientos y 
		//con una venta de entradas de al menos el 1/6 del total del aforo de la sala.
		System.out.println();
		System.out.println("---- CONSULTA 8.2 ----todas las películas proyectadas en salas de más de 35");
		System.out.println("---- ---------- ----con una venta de entradas de al menos 1/6 del total del aforo de la sala");
		List<Tuple> consulta82 = ef.consulta82();
		for (Tuple l : consulta82) {
				System.out.println("codEntrada: " + l.get(0) + " " + "titulo: " + l.get(1)+" Aforo: " + l.get(2));
		}
		
		
		// 9. CONSULTA
		//A partir de un código de sala seleccionado, devolver el 
		//número de películas diferentes que se han proyectado en esa sala.
		System.out.println();
		System.out.println("---- CONSULTA 9 ----A partir de un código de sala seleccionado, "
				+ "devolver el número de películas diferentes que se han"
				+ "proyectado en esa sala");
		
		List<Tuple> consulta9 = paf.consulta9(3);
		for (Tuple l : consulta9) {
				System.out.println("titulos: " + l.get(0) );
		}
		
		
		
		
		
		
		
		
		
		

	}

}
