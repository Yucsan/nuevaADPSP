package test;

import java.util.List;

import entidades.*;
import entidades.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test5_Asociaciones_ManyToMany {
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager = emfactory.createEntityManager();
		
		emanager.getTransaction().begin();
		
		System.out.println("Select Tecnicos");
		
		TypedQuery<Tecnico>query1=emanager.createQuery("Select e from Tecnico e ",Tecnico.class);
		List<Tecnico> list=query1.getResultList();
		//System.out.println(list);
		for(Tecnico t: list) {
			System.out.println(t);
		}
		System.out.println("Select Jugadores");
		
		TypedQuery<Jugador>query2=emanager.createQuery("Select e from Jugador e ",Jugador.class);
		List<Jugador> listJ=query2.getResultList();
		//System.out.println(list);
		for(Jugador j: listJ) {
			System.out.println(j);
		}
		
		emanager.getTransaction().commit();
		
		//se recomienda cerrar
		emanager.close();
		emfactory.close();
			
		
			
			
			
			
			
			
	}

}
