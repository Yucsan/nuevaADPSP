package test;

import java.util.List;

import entidades.Libro;
import entidades.Socio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test1_Uso_del_EntityManager {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager = emfactory.createEntityManager(); // poner en dos lineas

		Libro l1 = new Libro("100", "autor1", "titulo1", (byte) 0);
		Libro l2 = new Libro("200", "autor2", "titulo2", (byte) 0);
		Libro l3 = new Libro("300", "autor3", "titulo3", (byte) 0);
		Libro l4 = new Libro("400", "autor4", "titulo4", (byte) 0);
		
		
		System.out.println("Llegamos...");
		
		emanager.getTransaction().begin();
		emanager.persist(l1);// crea un objeto a fila en bases de datos, "que hace el insert"
		l1.setTitulo("JPA e Hibernate");
		emanager.flush();// sirve para guardar si o si antes del commit realizar estos cambios 
		emanager.persist(l2);
		emanager.persist(l3);//sincroniza con la BD
		emanager.persist(l4);
		emanager.getTransaction().commit();
		
		// comprbamos si la entidad está gestionada todavia o no
		boolean gestionada = emanager.contains(l1);// contains si existe o no 
		System.out.println("L1 esta gestionada: " +gestionada);
		
		// compruebo crenado otra transscion si l1 sigue o no gestionada
		emanager.getTransaction().begin();
		l1.setTitulo("nuevo cambio");
		boolean gestionadaNueva = emanager.contains(l1);
		System.out.println("L1 esta gestionada en una nueva transaccion: " +gestionadaNueva);
		emanager.getTransaction().commit();
		
		// contesto de persistencia 
			// EL conjunto de los objetos entidad manejados por un EntityManager
			// se llama contexto de persistencia
		
		//3 buscar un libro
		//emanager.getTransaction().begin();
		Libro libroBuscado=emanager.find(Libro.class, "200");
		System.out.println(libroBuscado);
		
		libroBuscado.setTitulo("El arbol de la VIDA"); //cambia titulo
		libroBuscado=emanager.find(Libro.class, "200");
		System.out.println(libroBuscado);
		
		//4 consulta a la info de una tabla desde java a las entidades que estan asociadas
		TypedQuery<Libro>query=emanager.createQuery("Select e from Libro e ",Libro.class);
		List<Libro> list=query.getResultList();
		System.out.println(list);
		//emanager.getTransaction().commit();
		
		//5 otra cosa se esta haciendo una consulta sobre libroBuscado que ya esta persistido esto es para probar si da error//
		emanager.getTransaction().begin();
		emanager.persist(libroBuscado);
		emanager.persist(l2); //prueba
		libroBuscado.setTitulo("Hoy es viernes");
		emanager.getTransaction().commit();
		List<Libro> list2=query.getResultList();
		System.out.println(list2);
		
		//6 actualizar un libro: si la entidad esta persistida se actualiza sólo
		emanager.getTransaction().begin();
		libroBuscado.setAutor("Pepito");
		//emanager.merge(libroBuscado);
		emanager.getTransaction().commit();
		
		//7 vamos a separar un objeto entidad del contexto persistencia
		emanager.getTransaction().begin();
		emanager.detach(l4);
		
		//comprobamos
		l4.setAutor("Juanito");
		query = emanager.createQuery("Select e from Libro e",Libro.class);
		System.out.println("consulta "+query.getResultList());
		System.out.println("****** l4 está persistida  "+emanager.contains(l4));
		
		//voy actualizar el objeto de entidad con merge
		emanager.merge(l4); //va actualizar a autor de l4 de Juanito
		System.out.println("consulta despues del merge: "+query.getResultList());
		System.out.println("****l4 pasa a estado manage "+emanager.contains(l4));
		System.out.println("l4 sigue sin estar en el contexto de persistencia, "+"aunque haga una actualización con merge");
		
		
		//se recomienda cerrar
		emanager.close();
		emfactory.close();
		
		
		
		
	}

}
