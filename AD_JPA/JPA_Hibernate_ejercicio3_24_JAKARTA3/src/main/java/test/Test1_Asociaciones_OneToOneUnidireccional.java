package test;

import java.util.List;

import entidades.Direccion;
import entidades.Empleado;
import entidades.PlazaParking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class Test1_Asociaciones_OneToOneUnidireccional {
	public static void main(String[] args) {
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
			EntityManager emanager = emfactory.createEntityManager(); // poner en dos lineas		
			
			Direccion d1=new Direccion("Las Acacias", "calle1", "Sevilla", "España", 41001l);
			Direccion d2=new Direccion("Las Trebloes", "calle2", "Malaga", "España", 41501l);
			PlazaParking p1 = new PlazaParking("p100",1,00);
			PlazaParking p2 = new PlazaParking("p200",2,01);
			Empleado e1=new Empleado("idEmple1", "Fernando_emple", "Chang Cam", d1, p1);
			Empleado e2=new Empleado("idEmple2", "Ana_emple", "Santos Chocano", d2, p2);
			
			emanager.getTransaction().begin();
				emanager.persist(d1);
				emanager.persist(p1);
				emanager.persist(e1);
			//en el objeto tengo que relacionar el parking con el empleado con un set.	
			p1.setEmpleado(e1);
			
			System.out.println("Empleado asignado a parking1" +"es(con un set): "+p1.getEmpleado());
			
				emanager.persist(d2);
				emanager.persist(p2);
				emanager.persist(e2);
			p2.setEmpleado(e2);
			
			
			emanager.getTransaction().commit();
			
			//consulta
			System.out.println(" ** Empleado en la BD **");
			TypedQuery<Empleado> query = emanager.createQuery("Select e from Empleado e",Empleado.class);
			
			//System.out.println(query.getResultList()); 
			
			List<Empleado> empleados = query.getResultList(); //para verlo mejor
			for(Empleado em: empleados) {
				System.out.println(em);
			}
			
			
			emanager.close();
			emfactory.close();
		}catch(Exception e) {
			System.out.println("** Ha ocurrido un error al crear la BD **");
			System.out.println(e);
		}

		
		
		
		
	}

}
