package test;

import java.util.List;

import JPAControladorDao.LibroFacadeImpl;
import JPAControladorDao.SocioFacadeImpl;
import entidades.Libro;
import entidades.Socio;

public class TestFacade_en_consola {

	public static void main(String[] args) {
		/*
		 * Libro l1 = new Libro("100", "autor1", "titulo1", (byte) 0); Libro l2 = new
		 * Libro("200", "autor2", "titulo2", (byte) 0); Libro l3 = new Libro("300",
		 * "autor3", "titulo3", (byte) 0); Libro l4 = new Libro("400", "autor4",
		 * "titulo4", (byte) 0);
		 * 
		 * LibroFacadeImpl lf = new LibroFacadeImpl(); lf.create(l1); lf.create(l2);
		 * lf.create(l3); lf.create(l4); List<Libro> listalibros=lf.mostrarTodos();
		 * //System.out.println(listalibros);
		 * 
		 * l4.setAutor("Fernando");
		 * 
		 * Libro LibroEncontrado = lf.find(l3.getIsbn());
		 * System.out.println("-----------ENCONTRADO **********************");
		 * System.out.println(LibroEncontrado);
		 * 
		 * //borro el Libro 3 lf.remove(l3); //vuelvo a mostrar tdos List<Libro>
		 * listalibros2=lf.mostrarTodos();
		 */
		// Socio(int idSocio, String nombre, String apellidos)
		Socio s1 = new Socio("100", "autor1", "ApellidoS1");
		Socio s2 = new Socio("200", "autor2", "ApellidoS2");
		Socio s3 = new Socio("300", "autor3", "ApellidoS3");
		Socio s4 = new Socio("400", "autor4", "ApellidoS4");

		SocioFacadeImpl sc = new SocioFacadeImpl();
		sc.create(s1);
		sc.create(s2);
		sc.create(s3);
		sc.create(s4);
		List<Socio> listasocios = sc.mostrarTodos();
		// System.out.println(listaSocios);

		// actualizar
		// Recuperar el socio que deseas actualizar (en este caso s4)
		
		Socio socioParaActualizar = sc.find(s4.getId_socio());
		if (socioParaActualizar != null) {
			// Hacer cambios en el objeto existente
			socioParaActualizar.setNombre("Fernando");
			socioParaActualizar.setApellidos("Perez");

			// Llamar al método update para guardar los cambios
			sc.update(socioParaActualizar);//actualizo en la bse de datos********
		} else {
			System.out.println("Socio no encontrado.");
		}

		Socio SocioEncontrado = sc.find(s3.getId_socio());
		System.out.println("-----------ENCONTRADO **********************");
		System.out.println(SocioEncontrado);

		// borro el Socio 3
		sc.remove(s3);
		// vuelvo a mostrar tdos
		listasocios = sc.mostrarTodos();

	}

}
