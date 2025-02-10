package test;

import JPAControladorDao.DepartamentoFacadeImpl;
import JPAControladorDao.DireccionFacadeImpl;
import JPAControladorDao.EmpleadoFacadeImpl;
import JPAControladorDao.PlazaParkingFacadeImpl;
import JPAControladorDao.ProyectoFacadeImpl;
import entidades.Departamento;
import entidades.Direccion;
import entidades.Empleado;
import entidades.PlazaParking;
import entidades.Proyecto;


public class Test2_Asociaciones_OneToManyUnidireccional {
	public static void main(String[] args) {
	
			Direccion d1=new Direccion("idDir1", "Treboles", "Sevilla", "España", 41001l);
			Direccion d2=new Direccion("idDir2", "Acacias", "Malaga", "España", 41501l);
			PlazaParking p1 = new PlazaParking("p100",1,00);
			PlazaParking p2 = new PlazaParking("p200",2,01);
			Empleado e1=new Empleado("idEmple1", "Fernando_emple", "Chang Cam", d1);
			Empleado e2=new Empleado("idEmple2", "Ana_emple", "Santos Chocano", d2);
			
			Departamento dep1 = new Departamento("depa1", "contabilidad", 10000.);
			
			Proyecto pro1=new Proyecto(1, "Proyecto1 JPA");
			
			Proyecto pro2=new Proyecto(2, "Proyecto2 React");
			
			PlazaParkingFacadeImpl  pf=new PlazaParkingFacadeImpl();
			DireccionFacadeImpl  df=new DireccionFacadeImpl(); 
			EmpleadoFacadeImpl ef=new EmpleadoFacadeImpl();
			DepartamentoFacadeImpl dpf=new DepartamentoFacadeImpl();
			ProyectoFacadeImpl pyf=new ProyectoFacadeImpl();
			
			//el orden es importante
			//creo direcciones
			df.create(d1);
			df.create(d2);
			
			//creo plazas
			pf.create(p1);
			pf.create(p2);
			
			//creo un empleado1
			e1.setPlaza(p1); //asigno plaza
			p1.setEmpleado(e1);//bidireccionalididad -------------- IMPORTANTE
			ef.create(e1); //persiste
			
			e2.setPlaza(p2);
			p2.setEmpleado(e2);
			ef.create(e2);
			
			//crea departaento
			dpf.create(dep1); //crea la lista vacia de empleados
			dep1.addEmpleado(e1); //asigna empleados1 y 2
			dep1.addEmpleado(e2);
			
			dpf.update(dep1);
			
			//creo proyecto
			pyf.create(pro1);
			pyf.create(pro2);
			
			dep1.addProyecto(pro1);
			dep1.addProyecto(pro2);
			
			dpf.update(dep1);
			
			dep1.toString();
			pro1.toString();
			System.out.println(pro1);
		
			
			
			
			
			
			
			
			
			
		
			
			
			
			
	
		
		
		
		
	}

}
