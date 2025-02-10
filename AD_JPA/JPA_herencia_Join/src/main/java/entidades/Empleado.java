package entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Empleado {

	@Id
	private String codEmpleado;
	private String nombre;
	private String apellidos;
	
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.PERSIST)
	private List < Contratado > contratados = new ArrayList < Contratado > ();
	
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.PERSIST)
	private List < Becario > becarios = new ArrayList < Becario > ();
	
	public Empleado(String codEmpleado, String nombre, String apellidos) {
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return String.format("Empleado [codEmpleado=%s, nombre=%s, apellidos=%s]", codEmpleado, nombre, apellidos);
	}

}
