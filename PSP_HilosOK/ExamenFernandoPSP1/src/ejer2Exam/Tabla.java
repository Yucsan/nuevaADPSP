package ejer2Exam;

public class Tabla {
	private char[] tabla;
	private int siguiente;
	private boolean estaVacia;
	private boolean estaLlena;
	
	public Tabla() {
		this.tabla = new char[10];
		this.siguiente = 0;
		this.estaVacia = true;
		this.estaLlena = false;
	}
	
	public char leeDeTabla() {
		char encuentra = ' ';
		if(!estaVacia) {
			siguiente--;
			encuentra = tabla[siguiente];
		}else {
			System.out.println("inserta valores primero tabla vacia"); 
		}
		return encuentra;
	}
	
	public void anadirAtabla(char c) {
		
		if(!this.estaLlena) {
			this.tabla[siguiente]=c;
			siguiente++;
			this.estaVacia=false;
			if(siguiente == 9)
				this.estaLlena=true;
		}else {
			System.out.println("tabla llena!!");
		}
		
	}
	
	
	public boolean isEstaVacia() {
		return estaVacia;
	}

	public void setEstaVacia(boolean estaVacia) {
		this.estaVacia = estaVacia;
	}

	public boolean isEstaLlena() {
		return estaLlena;
	}

	public void setEstaLlena(boolean estaLlena) {
		this.estaLlena = estaLlena;
	}

	//solo para prueba
	public void muestra() {
		
		for(char c: this.tabla) {
			
			System.out.println(c);
		}
	}
	
	
	
}
