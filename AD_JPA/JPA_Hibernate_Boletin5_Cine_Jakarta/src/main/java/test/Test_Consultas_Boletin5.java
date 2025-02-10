package test;
import java.util.List;

import JPAControladorDao.PeliculaFacadeImpl;
import JPAControladorDao.SalaFacadeImpl;
import entidades.Pelicula;
import entidades.Sala;
import jakarta.persistence.Tuple;


public class Test_Consultas_Boletin5 {
	
	
	
	public static void main(String[] args) {
		
		PeliculaFacadeImpl pf=new PeliculaFacadeImpl();
		SalaFacadeImpl sf=new SalaFacadeImpl();
		
		
		System.out.println("*******CONSULTA 1: PELICULAS NO MOSTRADAS**********");
		List<String>peliculasNoMostradas=pf.generosNoMostrados();
		System.out.println(peliculasNoMostradas);
		
		
		System.out.println("*******CONSULTA 2: PELICULAS CON CANT PASES Y RECAUDACION**********");
		List<Tuple>peliculasPasesRec=pf.pasesRecaudacionPeliculas();
		for(Tuple tupla: peliculasPasesRec) {
			System.out.println("-Titulo: "+tupla.get(0)+", codPeli: "+tupla.get(1)+", cantPases: "+tupla.get(2)+
					", Recaudacion: "+tupla.get(3));
		}
		
		System.out.println("*******CONSULTA 3: NUMERO DE SALAS QUE PROYECTAN UN GENERO**********");
		List<Long>salasGenero=sf.salasDetermGenero("C.FICCION");
		System.out.println(salasGenero);
		
		System.out.println("*******CONSULTA 4:SALAS DONDE LA PELI SEA COMEDIA O TERROR Y POSTERIOR A 2008**********");
		List<Tuple>salas=sf.salasComediaMasAnhos();
		for(Tuple tupla2:salas) {
			System.out.println("-Sala:{ Codigo: "+tupla2.get(0)+", Tipo Sonido: "+tupla2.get(1)+", "
					+ "Num filas: "+tupla2.get(2)+", Num asientos por fila: "+tupla2.get(3)+", Total de asientos: "+tupla2.get(4)+" }");
		}
		
		System.out.println("*******CONSULTA 5:PELICULAS DOLBY**********");
		List<Tuple>pelisDolby=pf.peliculasDolby();
		for(Tuple tupla5:pelisDolby) {
			System.out.println("-Pelicula:{ Codigo: "+tupla5.get(0)+", titulo: "+tupla5.get(1)+", Fecha Prod: "+tupla5.get(2)+", genero: "+tupla5.get(3)+"}");
		}
		
		System.out.println("*******CONSULTA 6:PELICULAS PROYECTADAS MAS DE 5 VECES**********");
		List<Tuple>pelis5ocasiones=pf.peliculasmas5ocasiones();
		for(Tuple tupla6:pelis5ocasiones) {
			System.out.println("-Pelicula:{ Codigo: "+tupla6.get(0)+", titulo: "+tupla6.get(1)+", Fecha Prod: "+tupla6.get(2)+", genero: "+tupla6.get(3)+""
					+ ", numero proyecc: "+tupla6.get(4)+"}");
		}
		
		System.out.println("*******CONSULTA 7:RECAUDACION TOTAL POR TIPO DE PASE**********");
		List<Tuple>recaudacion=sf.recaudacionTotal();
		for(Tuple tupla7:recaudacion) {
			System.out.println("-Tipo pase: "+tupla7.get(0)+", recaudacion total: "+tupla7.get(1));
		}
		
		System.out.println("*******CONSULTA 8: PELICULAS PROYECTADAS SALAS MAS DE 100 ASIENTOS Y VENTA ENTRADAS .....**********");
		/*List<Tuple>pelisap8=pf.peliculasAp8();
		for(Tuple tupla8:pelisap8) {
			System.out.println("-Pelicula:{ Codigo: "+tupla8.get(0)+", titulo: "+tupla8.get(1)+", Fecha Prod: "+tupla8.get(2)+", genero: "+tupla8.get(3)+"}");
		}*/
		
		
		
	
	}
	
	
}
