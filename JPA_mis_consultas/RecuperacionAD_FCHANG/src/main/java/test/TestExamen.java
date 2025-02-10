package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import JPAControladorDao.AnalisisFacadeImpl;
import JPAControladorDao.CitaFacadeImpl;
import entidades.Analisi;
import entidades.Medico;
import entidades.Paciente;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;



public class TestExamen {

	public static void main(String[] args) {
		AnalisisFacadeImpl anf = new AnalisisFacadeImpl();
		CitaFacadeImpl  cf = new CitaFacadeImpl();
		//cons1
	
		System.out.println("");
		System.out.println("---- CONSULTA 1 -dinamica-----");
		List<Analisi> todo = anf.mostrarTodos();
		System.out.println(todo);
	
		System.out.println("---- CONSULTA 1 ESTATICA------");
		TypedQuery<Paciente> query1 = anf.getEm().createNamedQuery(Paciente.CONS1, Paciente.class);
		System.out.println(query1.getResultList());
		
		
		//2 codigo cita, fecha cita, nombre medico, nombre paciente / ordenado por nom Medico ASC y 
		System.out.println("");
		System.out.println("---- CONSULTA 2 ------");
		List<Tuple> cons2 = cf.consulta2();
		System.out.println(cons2);
		
		//3 cod medico, nombre medico, num citas
		System.out.println("");
		System.out.println("---- CONSULTA 3 ------");
		List<Tuple> cons3 = cf.consulta3();
		System.out.println(cons3);
		
		// 4 pacientes con mas de 1 analisis
		System.out.println("");
		System.out.println("---- CONSULTA 4 ------");
		List<Tuple> cons4 = anf.consulta4();
		System.out.println(cons4);
		
		// 5 coste medio de cada cita, cod medico, nombre, fechaIngreso, 
		//ordenada por antiguedad del medico, 
		System.out.println("");
		System.out.println("---- CONSULTA 5 ------");
		List<Tuple> cons5 = cf.consulta5();
		for(Tuple t: cons5) {
			System.out.println("codMedico: "+t.get(0)+" nombre: "+t.get(1)+" "
					+ " fechaIngresp: "+t.get(2)+" COSTE MEDIO: "+t.get(3) );
		}
		//System.out.println(cons5);
		
		
		// 6 numero y coste total de las citas clasificado por  especialidad medica, 
		System.out.println("");
		System.out.println("---- CONSULTA 6 ------");
		List<Tuple> cons6 = cf.consulta6();
		System.out.println(cons6);
		
		
		// 7 numero y coste total de las citas clasificado por  especialidad medica, 
		System.out.println("");
		System.out.println("---- CONSULTA 7 ------");
		List<Tuple> cons7 = cf.consulta7("GENERAL");
		System.out.println(cons7);
		
		//PARA LA 7 ESTATICA
		Date fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try { fecha = sdf.parse("12-12-2014"); } catch (ParseException e) { e.printStackTrace(); }
		
		System.out.println("---- CONSULTA 7 ESTATICA------");
		TypedQuery<Medico> query2 = anf.getEm().createNamedQuery(Medico.CONS7, Medico.class);
		System.out.println(query2.getResultList());

	}

}
