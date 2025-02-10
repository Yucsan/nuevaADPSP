package test;


import JPAControladorDao.TituloFacadeImpl;
import JPAControladorDao.AutorestituloFacadeImpl;
import JPAControladorDao.EditorialFacadeImpl;
import entidades.Autor;
import entidades.Titulo;
import jakarta.persistence.TypedQuery;

public class TestPruebaVelocidad {

	public static void main(String[] args) {
		TituloFacadeImpl tf=new TituloFacadeImpl();
		EditorialFacadeImpl ef=new EditorialFacadeImpl();
		AutorestituloFacadeImpl atf=new AutorestituloFacadeImpl();
	
		//Ejercicio 1
		System.out.println("** Ejercicio 1");
		
		TypedQuery<Titulo> query1 = tf.getEm().createNamedQuery(Titulo.LIBROS_BUSINESS_PSYCHOLOGY_AGOTADOS, Titulo.class);
		query1.setParameter("seleccionado1", "business").setParameter("seleccionado2", "psychology");
		System.out.println(query1.getResultList());
		
		System.out.println("Ejercicio 2");
		System.out.println( tf.consulta2());
		System.out.println( tf.consulta22());
		
		System.out.println(" ");
		
		/* 
		Mostrar el codigo, título, género y precio de los libros que hayan sido escritos al menos por
		un número de autores mayor que el que se le pasa por parámetro a la consulta. 
		Mostrar también el número de autores	*/
		System.out.println(atf.consulta3ok(1));
		
		System.out.println(atf.pruebaLEFTJOIN1());
		
		System.out.println("Prueba Left JOIN2");
		System.out.println(atf.pruebaLEFTJOIN2());
		
		System.out.println("Prueba Left JOIN3");
		System.out.println(atf.pruebaLEFTJOIN3());
		
		System.out.println("Prueba Left JOIN4");
		System.out.println(atf.pruebaLEFTJOIN4());

		
	
		System.out.println("--**");
		TypedQuery<Autor> estaticaAutores = tf.getEm().createNamedQuery(Autor.TDOAUTORES, Autor.class);
		System.out.println(estaticaAutores.getResultList());
	
		
		/*
		System.out.println("--");
		TypedQuery<Titulo> query2 = tf.getEm().createNamedQuery(Titulo.TDOLIBROS, Titulo.class);
		System.out.println(query2.getResultList());
	*/
	
	
	
	
	
	
	}
	

	

}
