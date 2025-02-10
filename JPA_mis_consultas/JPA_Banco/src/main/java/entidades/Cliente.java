package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the CLIENTE database table.
 * 
 */
@Entity
@Table(name="CLIENTE")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_CLIENTE")
	private String codCliente;

	@Column(name="APELLIDOS")
	private String apellidos;

	@Column(name="DIRECCION")
	private String direccion;

	@Column(name="NOMBRE")
	private String nombre;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="cliente")
	private List<Cuenta> cuentas;

	public Cliente() {
	}
	

	public Cliente(String codCliente, String apellidos, String direccion, String nombre) {
		super();
		this.codCliente = codCliente;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.nombre = nombre;
	}


	public String getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setCliente(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setCliente(null);

		return cuenta;
	}


	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", nombre=" + nombre + "]";
	}
	
	
	
	

}