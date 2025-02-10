package ejer3Exam;

public class ejer3Main {

	public static void main(String[] args) {
		
		
		Hilo3 h1 = new Hilo3();
		h1.setName("H1");
		
		Hilo3 h2 = new Hilo3();
		h2.setName("H2");
		
		Hilo3 h3 = new Hilo3();
		h3.setName("H3");
		
		
		h1.start();
		h2.start();
		h3.start();

	}

}
