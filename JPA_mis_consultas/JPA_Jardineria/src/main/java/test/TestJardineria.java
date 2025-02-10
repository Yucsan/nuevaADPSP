package test;


import java.util.List;

import JPAControladorDao.ClienteFacadeImpl;
import JPAControladorDao.DetallePedidoFacadeImpl;
import JPAControladorDao.EmpleadoFacadeImpl;
import JPAControladorDao.PagoFacadeImpl;
import JPAControladorDao.PedidoFacadeImpl;
import entidades.Pago;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class TestJardineria {

	public static void main(String[] args) {
		
		EmpleadoFacadeImpl ef=new EmpleadoFacadeImpl();
		PagoFacadeImpl pf = new PagoFacadeImpl();
		ClienteFacadeImpl cf=new ClienteFacadeImpl();
		PedidoFacadeImpl pedf = new PedidoFacadeImpl();
		
		System.out.println(ef.mostrarTodos());
		
		/* Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas. */
		//System.out.println( ef.ejer5Consulta1() );
		List<Tuple>Consulta1 = ef.ejer5Consulta1();
		/* for(Tuple t: Consulta1) 
			System.out.println("Cliente: "+t.get(0)+" Representante: "+t.get(1)); */
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("");
	
		/* 2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de
		  sus representantes de ventas. */
		//System.out.println(pf.ejer5Consulta2() );
		System.out.println("CONSULTA 2");
		List<Tuple>Consulta2 = pf.ejer5Consulta2();
		/* for(Tuple t: Consulta2) 
			System.out.println("Cliente: "+t.get(0)+" Representante: "+t.get(1)); */
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("");
		
		/* 3. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre
		   de sus representantes de ventas. */
		System.out.println("CONSULTA 3");
		System.out.println(pf.ejer5Consulta3() );
		List<Tuple>Consulta3 = pf.ejer5Consulta3();
		/* for(Tuple t: Consulta3) 
			System.out.println("Cliente: "+t.get(0)+" empleado: "+t.get(1)); */
		
		System.out.println(" Es lo mismo pero usando NOT IN "); 
		System.out.println("Consulta 3 Prueba ***** ");
		List<Tuple>Consulta3PRUEBA = pf.ejer5Consulta3PRUEBA();
		System.out.println(Consulta3PRUEBA);
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("");
		
		/* 4 .Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus
		   representantes junto con la ciudad de la oficina a la que pertenece el representante. */
		System.out.println("CONSULTA 4");
		System.out.println(pf.ejer5Consulta4());
		
		/* Saltamos el 5
		6. Lista la dirección de las oficinas que tengan clientes en Fuenlabrada */
		System.out.println("Saltamos el 5");
		System.out.println("CONSULTA 6");
		System.out.println( cf.consulta6CHAT("Fuenlabrada") );
		System.out.println();
		System.out.println( cf.consulta6chat2("Fuenlabrada") );
		
		/* 7. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la
		ciudad de la oficina a la que pertenece el representante.  */
		System.out.println("CONSULTA 7");
		System.out.println( cf.consulta7() );
		System.out.println();
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("");
		
		// 8 Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
		System.out.println("CONSULTA 8");
		System.out.println( ef.consulta8() );
		System.out.println();
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("");
		
		// 9. Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
		System.out.println("CONSULTA 9");
		System.out.println( pedf.consulta9() );
		System.out.println();
		
		
		/*  CONSULTAS RESUMEN
			4 ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.  */
		
		System.out.println(" 4 ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.");
		System.out.println( pedf.consResumen4() );
		System.out.println("");
		
		//  3. Cuál fue el pago medio en 2009?
		System.out.println(" 3. Cuál fue el pago medio en 2009? ");
		TypedQuery<Pago> consultaR3 = pf.getEm().createNamedQuery(Pago.TDOPAGOS, Pago.class);
		
		System.out.println(consultaR3.getResultList());
		System.out.println("");
		
		// Consulta Multitabla
		//7. Devuelve un listado de los productos que nunca han aparecido en un pedido
		System.out.println(" 7. Devuelve un listado de los productos que nunca han aparecido en un pedido ");
		List<Tuple> consM7 = pedf.consMultitabla7();
		System.out.println( pedf.consMultitabla7() );
		System.out.println( "Datos: "+consM7.size() );
		System.out.println("10");
		System.out.println( pedf.consMultitabla10() );
		
		//SUBSCONSULTAS
		//1. Devuelve el nombre del cliente con mayor límite de crédito.
		System.out.println("SUBSCONSULTAS");
		System.out.println("1. Devuelve el nombre del cliente con mayor límite de crédito.");
		System.out.println( cf.subs1() );
		
		//Consultas variadas
		/* 1. Devuelve el listado de clientes indicando el nombre del cliente y cuántos pedidos ha
		realizado. Tenga en cuenta que pueden existir clientes que no han realizado ningún
		pedido.  */
		
		System.out.println("1. Devuelve el listado de clientes indicando el nombre del cliente y cuántos pedidos ha\n"
				+ "		realizado. Tenga en cuenta que pueden existir clientes que no han realizado ningún\n"
				+ "		pedido..");
		System.out.println( cf.subVariadas() );
		
		
	
	}
	
	
	
	
	
	
	
	

}
