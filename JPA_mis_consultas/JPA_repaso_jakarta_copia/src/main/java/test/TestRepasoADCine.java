package test;

import java.util.List;

import JPAControladorDao.EntradaFacadeImpl;
import JPAControladorDao.PasFacadeImpl;

import entidades.Entrada;
import entidades.Pas;
import entidades.Pelicula;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;

public class TestRepasoADCine {

	public static void main(String[] args) {
		PasFacadeImpl pf=new PasFacadeImpl();
		EntradaFacadeImpl ef=new EntradaFacadeImpl();
		
		/*
		List<Tuple> consulta1 = pf.mostrarTodos();
		for(Tuple p: consulta1) {
			System.out.println("tipoPase: "+p.get(0));
		}
		
		
		List<Entrada> TodasEntradas = ef.mostrarTodos();
		for(Entrada en : TodasEntradas) {
			System.out.println("* "+en);
		}*/
		
		
		// 1. Mostrar todos los géneros de los que nunca se haya proyectado una película en el multicine.
		System.out.println("---");
		System.out.println("-Consulta 1-");
		System.out.println(" ");
		List<Tuple> consultaR1 = pf.generosNoProyectados();
		for(Tuple p: consultaR1) {
			System.out.println("Genereos: "+p.get(0));
		}
		
		
		//prueba Consulta dinamica todas las Peliculas
		System.out.println("--- ");
		System.out.println("* Consulta estática que devuelva todos las Peliculas");
		System.out.println("--- ");
		Query query = ef.getEm().createNamedQuery(Pelicula.TODASPELAS);
		//System.out.println(query.getResultList());
		List<Pelicula> pelas = query.getResultList();
		for(Pelicula pe: pelas) {
			System.out.println(pe);
		}
		
		
		// 2. Mostrar los campos título, codpelicula, , cantidad de pases y recaudación de todas las películas.
		System.out.println("--- ");
		System.out.println("-Consulta 2-");
		System.out.println("---- ");
		List<Tuple> consultaR2 = pf.Consulta2();
		for(Tuple p: consultaR2) {
			System.out.println("Título: "+p.get(0)+" codPeli : "+p.get(1)+" Cantidad de Pases: "+p.get(2)+" Recaudación : "+p.get(3));
		}
		
		
		// EXTRA LEFT JOIN . Mostrar Tipos de Sonido, título, pelicula, cantidad de pases y recaudación de todas las películas.
		System.out.println("---");
		System.out.println("-Consulta Extra-");
		System.out.println("---");
		List<Tuple> consExtra2 = pf.ConsExtra2();
		for(Tuple p: consExtra2) {
			//System.out.println("tipoSonido: "+p.get(0)+" titulo : "+p.get(1));
			System.out.println("tipoSonido: "+p.get(0)+" titulo : "+p.get(1)+" Cantidad de Pases: "+p.get(2)+" Recaudación : "+p.get(3));
		}
		
		//3 Mostrar cuántas salas distintas existen, donde se proyectan películas de un género determinado.
		System.out.println("---");
		System.out.println("-Consulta 3-");
		System.out.println("---");
		List<Tuple> consulta3 = pf.Consulta3("COMEDIA");
		for(Tuple p: consulta3) {
			System.out.println("Nº de salas: "+p.get(0)+" del genereo Comedia ");
		}
		
		/* 4. Obtener la información de todos las salas de cine en las que se haya proyectado alguna película de
		género TERROR o COMEDIA y cuya fecha de producción haya sido posterior a 2008. El listado debe
		aparecer ordenado por número de asientos en orden descendente. */
		System.out.println("---");
		System.out.println("-Consulta 4-");
		System.out.println("---");
		List<Tuple> consulta4 = pf.Consulta4();
		for(Tuple p: consulta4) {
			System.out.println("codsala: "+p.get(0)+" butacas: "+p.get(1)+" Sonido: "+p.get(2));
		}
		
		 //5. Mostrar un listado con la información de las películas proyectadas en salas DOLBY.
		System.out.println("---");
		System.out.println("-Consulta 5-");
		System.out.println("---");
		List<Tuple> consulta5 = pf.Consulta5();
		for(Tuple p: consulta5) {
			System.out.println("codPelicula: "+p.get(0)+" fecha produccción: "+p.get(1)+" Genero: "+p.get(2)+" Título Película: "+p.get(3));
		}
		
		//6 Obtener un listado de todas las películas que han sido proyectadas en más de 5 ocasiones.
		System.out.println("---");
		System.out.println("-Consulta 6-");
		List<Tuple> consulta6 = pf.Consulta6();
		for(Tuple p: consulta6) {
			System.out.println("CUENTA: "+p.get(0)+" Título Película: "+p.get(1));
		}
		
		
		//7. Obtener un listado con la recaudación total de las salas de cine agrupada por tipo de pase durante el
		//mes de junio de 2006.
		System.out.println("---");
		System.out.println("-Consulta 7-**");
		System.out.println("---");
		List<Tuple> consulta7 = pf.Consulta7();
		for(Tuple p: consulta7) {
			System.out.println("Recaudación TOTAL: "+p.get(0)+"€ "+" TipoPase: "+p.get(1));
		}
		
		//8
		System.out.println("---");
		System.out.println("-Consulta 8-**");
		System.out.println("---");
		List<Tuple> consulta8 = pf.Consulta8();
		for(Tuple p: consulta8) {
			System.out.println("Pelicula: "+p.get(0)+" Butacas: "+p.get(1)+" Aforo vendido: "+p.get(2));
		}
		
		//8 MJ
		System.out.println("---");
		System.out.println("-Consulta 8-MJ");
		System.out.println("---");
		List<Pelicula> consulta82 = pf.Consulta8MJ();
		for(Pelicula p: consulta82) {
			System.out.println("Pelicula: "+p);
		}
		
		
		
		//8
		System.out.println("---");
		System.out.println("-Consulta 9-**");
		System.out.println("---");
		List<Tuple> consulta9 = pf.Consulta9(3);
		for(Tuple p: consulta9) {
				System.out.println("cuenta: "+p.get(0));
		}
		

		
		
		
	
	
	
	
	
	
	
	
	
	}
	

	

}
