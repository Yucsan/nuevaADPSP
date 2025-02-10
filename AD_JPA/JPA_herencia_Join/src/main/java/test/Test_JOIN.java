package test;

import java.util.List;


import entidades.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test_JOIN {
	public static void main(String[] args) {
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
			EntityManager emanager = emfactory.createEntityManager(); // poner en dos lineas
			
			emanager.getTransaction().begin();
			
			Empleado c1 = new Contratado("idEmp1", "Andres", "Gomez Perez", 1500f, "informatica");
			Empleado c2 = new Contratado("idEmp2", "Marío", "Sanchez Luz", 1700f, "comercial");
			
			Becario b1 = new Becario("idEmp3", "Ricardo", "Sanchez Merino", 30f, "Juana");
			Becario b2 = new Becario("idEmp4", "Ana", "Chang Suarez", 30f, "Roberto");
			
			
			 
			emanager.persist(c1);
			emanager.persist(c2);
			emanager.persist(b1);
			emanager.persist(b2);
			
			
			emanager.getTransaction().commit();
			
			emanager.close();
			emfactory.close();
		}catch(Exception e) {
			System.out.println("** Ha ocurrido un error al crear la BD **");
		}

		
		
		
		
	}

}
