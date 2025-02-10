package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import JPAControladorDao.AutorFacadeImpl;
import JPAControladorDao.AutorestituloFacadeImpl;
import JPAControladorDao.EditorialFacadeImpl;
import JPAControladorDao.TituloFacadeImpl;
import entidad.Autor;
import entidad.Autorestitulo;
import entidad.AutorestituloPK;
import entidad.Editorial;
import entidad.Titulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test_Consultas_JPQL {
	public static void main(String[]args) {
		
		AutorestituloFacadeImpl atf = new AutorestituloFacadeImpl();
		EditorialFacadeImpl ef = new EditorialFacadeImpl();
		TituloFacadeImpl tf = new TituloFacadeImpl();
		AutorFacadeImpl af = new AutorFacadeImpl();
		
		EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("Persistencia");
		
		EntityManager emanager=emFactory.createEntityManager();
		
		//Ejercicio 1
		System.out.println("***												***");
		System.out.println("** Ejercicio 1");
		System.out.println("****											****");
		
		TypedQuery<Titulo> query1 = tf.getEm().createNamedQuery(Titulo.LIBROS_BUSINESS_PSYCHOLOGY_AGOTADOS, Titulo.class);
		query1.setParameter("seleccionado1", "business").setParameter("seleccionado2", "psychology");
		System.out.println(query1.getResultList());
		
		//Ejercicio 2
		System.out.println("***												***");
		System.out.println("** Ejercicio 2");
		System.out.println("****											****");
		System.out.println(ef.editorialLibrosVendidos());
		
		//Ejercicio 3
		System.out.println("***												***");
		System.out.println("** Ejercicio 3");
		System.out.println("****											****");
		System.out.println(atf.librosEscritoPorAutores(1));
		
		//Ejercicio 4
		/*SimpleDateFormat sdf = null;
		Date fechaPubli = null;
		try {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			fechaPubli = sdf.parse("2016-01-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Titulo t1 = new Titulo("t6",10,fechaPubli,"novela",15.5,"jjjj",25,"titulo6",10);
		
		Autor a1 = new Autor("a4","autor4",41015,"direccion4","autor4","622587895");
		Autor a2 = new Autor("a5","autor5",41015,"direccion5","autor5","622545123");
		
		Editorial e1 = new Editorial(4,"sevilla","editorial4","españa");
		
		AutorestituloPK at1PK = new AutorestituloPK(a1.getCodautor(),t1.getCodtitulo());
		AutorestituloPK at2PK = new AutorestituloPK(a2.getCodautor(),t1.getCodtitulo());
		
		Autorestitulo at1 = new Autorestitulo(at1PK,3,10,a1,t1);
		Autorestitulo at2 = new Autorestitulo(at2PK,3,10,a2,t1);
		
		tf.create(t1);
		
		af.create(a1);
		af.create(a2);
		
		ef.create(e1);
		
		atf.create(at1);
		atf.create(at2);
		
		System.out.println("Persist hecho");
		
		t1.addAutorestitulo(at1);
		t1.addAutorestitulo(at2);
		t1.setEditorial(e1);
		
		ef.getEm().close();*/
	}
}
