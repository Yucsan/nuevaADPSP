package test;

import java.util.List;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test0_Asociaciones_OneToOneUnidireccional {
	public static void main(String[] args) {
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
			EntityManager emanager = emfactory.createEntityManager(); // poner en dos lineas			
			emanager.close();
			emfactory.close();
		}catch(Exception e) {
			System.out.println("** Ha ocurrido un error al crear la BD **");
		}

		
		
		
		
	}

}
