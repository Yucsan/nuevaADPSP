package entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contratado extends Empleado {
	private float salario;
	private String convenio;
	
	 @ManyToOne
	 @JoinColumn(name = "nombreExperto")
	 private Empleado empleado;
	
	public Contratado(String codEmpleado, String nombre, String apellidos, float salario, String convenio) {
		super(codEmpleado, nombre, apellidos);
		this.salario = salario;
		this.convenio = convenio;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	@Override
	public String toString() {
		return super.toString() +" Contratado salario=" + salario + ", convenio=" + convenio;
	}
	
	
	
	

}

