package ejer2Exam;

public class Eje2Main {

	public static void main(String[] args) {
		
		
		Tabla tabla=new Tabla();
		
		Hilo2 h1=new Hilo2(tabla); //inserte
		
		h1.setName("H1");
		h1.start();
		
		Hilo2 h2=new Hilo2(tabla); //inserte
		
		h2.setName("H2");
		h2.start();
		

	}

}
