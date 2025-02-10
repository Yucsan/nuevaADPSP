package entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="PLAZAPARKING" ,catalog="ejercicio6")
public class PlazaParking implements Serializable {

	// atributos //
	private static final long serialVersionUID = 1L;
	
	@Id // clave principal o primary key
	@Column(name="NUMPLAZA", unique= true, nullable=false)
	private String numPlaza;
	
	@Column(name="PLANTA")
	private int Planta;
	
	@Column(name="LUGAR")
	private int lugar;

	public PlazaParking() {
		
	}
	
	public PlazaParking(String numPlaza, int planta, int lugar) {
		super();
		this.numPlaza = numPlaza;
		this.Planta = planta;
		this.lugar = lugar;
	}
	

	public PlazaParking(String numPlaza, int planta, int lugar, Empleado empleado) {
		this.numPlaza = numPlaza;
		this.Planta = planta;
		this.lugar = lugar;
		this.empleado = empleado;
	}


	//3.3 Asociacion bidireccional One to One sobre Empleado y PlazaParking
	//mappedBy plaza es un atributo de Empleado donde se indica la plaza
	
	@OneToOne (mappedBy="plaza", targetEntity=Empleado.class)
	@JoinColumn(name="PLAZA_FK", unique=true, nullable=false, updatable=false)
	private Empleado empleado;

	public String getNumPlaza() {
		return numPlaza;
	}

	public void setNumPlaza(String numPlaza) {
		this.numPlaza = numPlaza;
	}

	public int getPlanta() {
		return Planta;
	}

	public void setPlanta(int planta) {
		Planta = planta;
	}

	public int getLugar() {
		return lugar;
	}

	public void setLugar(int lugar) {
		this.lugar = lugar;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "PlazaParking numPlaza: " + numPlaza + ", Planta: " + Planta + ", lugar: " + lugar;
	}//no pinta a empleado porque se pone en bule
	
	

	
	
		
	
	
	
	
	
	
	
	

	

	
	
	

}

