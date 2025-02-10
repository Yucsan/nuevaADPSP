package Ejercicio4_synchronized_versionMJ;

public class HiloTarea extends Thread{
	public static final String ANSI_BLUE = "\u001B[34m";
	private Mensaje mensaje;
	
	public HiloTarea(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	
	//el synchronized se  puede poner en el bloque que queramos lo que hace es que 
	//se bloquea hasta que termine de ejecutarse
	public void run(){
		for(int i = 0; i <= 10; i++) {
			synchronized (this.mensaje) {
				System.out.println(this.getName()+ " enterado del mensaje de "+this.mensaje.getMensaje());
				this.mensaje.setMensaje(this.getName()+": MSG"+i);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
