package test;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import JPAControladorDao.ClienteFacadeImpl;
import JPAControladorDao.CuentaFacadeImpl;
import JPAControladorDao.SucursalFacadeImpl;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Sucursal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;

public class TestBanco {

	public static void main(String[] args) {
		
		EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager=emFactory.createEntityManager();
		
		CuentaFacadeImpl cf=new CuentaFacadeImpl();
		SucursalFacadeImpl sf=new SucursalFacadeImpl();
		ClienteFacadeImpl clif = new ClienteFacadeImpl();

		
		/* BANCO
		1. Mostrar el saldo medio de todas las cuentas de la entidad bancaria con dos decimales y
		la suma de los saldos de todas las cuentas bancarias. */
		
		List<Tuple>Consulta1 = cf.cons1();
		System.out.println(Consulta1);
		
		/* 3. Mostrar la suma de los saldos y el saldo medio de las cuentas bancarias por cada código
		de sucursal. */
		System.out.println("Consulta 3");
		List<Tuple>Consulta3 = cf.cons3();
		System.out.println(Consulta3);
		
		/* 7. Mostrar el saldo medio y el interés medio de las cuentas a las que se le aplique un interés
		mayor del 10%, de las sucursales 1 y 2.*/
		System.out.println("");
		System.out.println("Consulta 7");
		List<Tuple>Consulta7 = cf.cons7();
		System.out.println(Consulta7);
		
		//Inserta
		Cliente cli = new Cliente( "KOrio2", "Perez Cam", "c/Estrella", "Sara");
		Sucursal sucu = emanager.find(Sucursal.class, 2) ;
	
		BigDecimal interes = BigDecimal.valueOf(0.6789).setScale(4, RoundingMode.HALF_UP);
		BigDecimal saldo = BigDecimal.valueOf(888.5).setScale(2, RoundingMode.HALF_UP);
		Cuenta cue1 = new Cuenta(61119, interes, saldo);
	
		clif.create(cli);//clientes creado	 
		cf.create(cue1); // cuenta creada
		cue1.setSucursal(sucu);

		//calle lepanto
		List<Tuple>Ejer4Cons1 = clif.ejer4Cons1();
		System.out.println(Ejer4Cons1);
				
		//cliente y todos sus movimientos
		List<Tuple>clientesMov = clif.ClientesMov();
		//System.out.println(clientesMov);
		for(Tuple t: clientesMov)
			System.out.println(t);
		
		
	
		

	
	}

}
