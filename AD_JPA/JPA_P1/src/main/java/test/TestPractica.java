package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import JPAControladorDao.*;
import entidades.*;

public class TestPractica {
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
			try {
				Date fechaN1 = sdf.parse("02/08/1981");
				Date fechaN2 = sdf.parse("15/03/1995");
				Date fechaex1 = sdf.parse("15/08/2023");
				Date fechaex2 = sdf.parse("03/04/2024");
				
				Grupo g1= new Grupo("codG1", "DAM2");
				Expediente ex1 = new Expediente("codEx1", fechaex1);
				Expediente ex2 = new Expediente("codEx2", fechaex2);
				Alumno alu1= new Alumno("codAlu1", "Fernando", "Chang", "Cam", fechaN1);
				Alumno alu2= new Alumno("codAlu2", "Ana", "Perez", "Urrutia", fechaN2);
				
				
				// Asignar el expediente correspondiente a cada alumno
				
	            alu1.setExpediente(ex1); 
	            alu2.setExpediente(ex2); 
	            
	            GrupoFacadeImpl gf=new GrupoFacadeImpl();
	            ExpedienteFacadeImpl ef=new ExpedienteFacadeImpl();
	            AlumnoFacadeImpl af=new AlumnoFacadeImpl();
				
				//orden
				gf.create(g1);
				ef.create(ex1);
				ef.create(ex2);
				af.create(alu1);
				af.create(alu2);
				
				g1.addAlumno(alu1);
				g1.addAlumno(alu2);
				
				gf.update(g1);
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
		
			
			
			
			
	
		
		
		
		
	}

}
