package test;

import java.util.List;

import JPAControladorDao.LibroFacadeImpl;
import entidades.Libro;

public class TestFacade_en_consola {

	public static void main(String[] args) {
		
		Libro l1 = new Libro("100", "autor1", "titulo1", (byte) 0);
		Libro l2 = new Libro("200", "autor2", "titulo2", (byte) 0);
		Libro l3 = new Libro("300", "autor3", "titulo3", (byte) 0);
		Libro l4 = new Libro("400", "autor4", "titulo4", (byte) 0);
		
		LibroFacadeImpl lf = new LibroFacadeImpl();
		lf.create(l1);
		lf.create(l2);
		lf.create(l3);
		lf.create(l4);
		List<Libro> listalibros=lf.mostrarTodos();
		System.out.println(listalibros);
		
		l4.setAutor("Fernando");
		lf.remove(l3);
		
		List<Libro> listalibros2=lf.mostrarTodos();
		System.out.println(listalibros2);
		
		
		
		
		
		
		

	}

}
