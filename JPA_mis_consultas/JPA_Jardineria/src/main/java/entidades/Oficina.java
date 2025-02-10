package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the oficina database table.
 * 
 */
@Entity
@Table(name="oficina")
@NamedQuery(name="Oficina.findAll", query="SELECT o FROM Oficina o")
public class Oficina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_oficina")
	private String codigoOficina;

	private String ciudad;

	@Column(name="codigo_postal")
	private String codigoPostal;

	@Column(name="linea_direccion1")
	private String lineaDireccion1;

	@Column(name="linea_direccion2")
	private String lineaDireccion2;

	private String pais;

	private String region;

	private String telefono;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="oficina")
	private List<Empleado> empleados;

	public Oficina() {
	}

	public String getCodigoOficina() {
		return this.codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLineaDireccion1() {
		return this.lineaDireccion1;
	}

	public void setLineaDireccion1(String lineaDireccion1) {
		this.lineaDireccion1 = lineaDireccion1;
	}

	public String getLineaDireccion2() {
		return this.lineaDireccion2;
	}

	public void setLineaDireccion2(String lineaDireccion2) {
		this.lineaDireccion2 = lineaDireccion2;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setOficina(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setOficina(null);

		return empleado;
	}

}