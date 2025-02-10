package entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Becario")
public class Becario extends Empleado {
	private float salario;
	private String tutor;
	

	
	public Becario(String codEmpleado, String nombre, String apellidos, float salario, String tutor) {
		super(codEmpleado, nombre, apellidos);
		this.salario = salario;
		this.tutor = tutor;
	}

	

	public float getSalario() {
		return salario;
	}



	public void setSalario(float salario) {
		this.salario = salario;
	}



	public String getTutor() {
		return tutor;
	}



	public void setTutor(String tutor) {
		this.tutor = tutor;
	}



	@Override
	public String toString() {
		return super.toString() +" Becario salario=" + salario + ", tutor=" + tutor;
	}
	
	
	
	

}

