package ejer2Exam;

public class Hilo2 extends Thread {
	
	public static final String CYAN = "\u001b[36m";
	public static final String MAG = "\u001B[35m";

	private Tabla tabla;

	public Hilo2(Tabla tabla) {
		this.tabla = tabla;
	}

	public void run() {
		char[] data = { 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'I', 'J', 'K' };
		int cuenta = 0;
		try {

			synchronized (this.tabla) {
				while (!tabla.isEstaLlena()) {
					if (this.getName().equals("H1")) {
						if (!this.tabla.isEstaLlena()) {
							tabla.anadirAtabla(data[cuenta]);
							cuenta++;
							System.out.println("agrega " + data[cuenta]);
						}

					} else if(this.getName().equals("H2")) {
						System.out.println("ENTRAAAAA");
						char busca = ' ';
						busca = tabla.leeDeTabla();
						System.out.println("lee Tabla: " + busca);
						// System.out.println("busco");
					}
				}
			}

			tabla.muestra();

			Thread.sleep((int) (Math.random() * 400));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if( this.getName().equals("H1") )
			System.out.println(CYAN+"FIN DE"+this.getName());
		else if ( this.getName().equals("H2") )
			System.out.println(MAG+"FIN DE"+this.getName());

	}
}
