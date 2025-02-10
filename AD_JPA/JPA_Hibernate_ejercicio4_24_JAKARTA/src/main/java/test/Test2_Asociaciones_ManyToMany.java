package test;


import entidades.Libro;
import entidades.Socio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test2_Asociaciones_ManyToMany {
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager = emfactory.createEntityManager(); // poner en dos lineas

		Libro l1 = new Libro("100", "Julio Ramon Ribeiro", "titulo1", (byte) 0);
		Libro l2 = new Libro("200", "Jose Santos", "titulo2", (byte) 0);
		Libro l3 = new Libro("300", "Mario Vargas Llosa", "titulo3", (byte) 0);
		Libro l4 = new Libro("400", "autor4", "titulo4", (byte) 0);
		
		Socio s1=new Socio(1, "Rus", "Luis");
		Socio s2=new Socio(2, "Gomez", "Luisa");
		
		emanager.getTransaction().begin();
		emanager.persist(l1);
		emanager.persist(l2);
		emanager.persist(l3);
		emanager.persist(l4);
		emanager.persist(s1);
		emanager.persist(s2);
		emanager.getTransaction().commit();
		
		
		emanager.getTransaction().begin();
		//un socio que alquila un libro
		l2.addSocio(s1);
		l3.addSocio(s1);
		l1.addSocio(s1);
		
		emanager.getTransaction().commit();
		
		
		//se recomienda cerrar
		emanager.close();
		emfactory.close();
			
	}

}
