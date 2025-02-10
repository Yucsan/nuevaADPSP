package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "DEPARTAMENTO", catalog = "ejercicio6")

@NamedQueries({ 
	@NamedQuery(name = "Departamento.buscar", query = "SELECT d FROM Departamento d WHERE d.codDept = :cod"),
	@NamedQuery(name = "Departamento.orden", query = "SELECT d FROM Departamento d order by d.nombre desc") })

public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String BUSCAR_CODEPT = "Departamento.buscar";
	public static final String ORDENAR_DESC_NOMBRE = "Departamento.orden";

	@Id // clave principal o primary key
	@Column(name = "CODEDEPT", unique = true, nullable = false)
	private String codDept;

	@Column(name = "DNOMBRE")
	private String nombre;

	@Column(name = "PRESU")
	private Double presu;

	// UNIDIRECCIONAL Departamento-Empleado

	@OneToMany
	@JoinColumn(name = "COD_DEPTO_FK")
	private List<Empleado> empleados;

	// BIDIRECCIONAL ONE to Many Departamento-Proyecto

	@OneToMany(mappedBy = "departamento")
	private List<Proyecto> proyectos;

	public Departamento() {

	}

	public Departamento(String codDept, String nombre, Double presu) {
		this.codDept = codDept;
		this.nombre = nombre;
		this.presu = presu;
		this.empleados = new ArrayList<Empleado>();
		this.proyectos = new ArrayList<Proyecto>();
	}

	// EMPLEADO ----------------- añadir empleado, eliminar
	public void addEmpleado(Empleado p) {
		this.empleados.add(p);
	}

	public void removeEmpleado(Empleado p) {
		this.empleados.remove(p);
	}

	// get and sets List<Empleado>
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	// PROYECTO -----------------añadir proyecto, eliminar
	public void addProyecto(Proyecto p) {
		this.proyectos.add(p);
		p.setDepartamento(this);
	}

	public void removeProyecto(Proyecto p) {
		this.proyectos.remove(p);
		p.setDepartamento(null);
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	// --- Getters % Setters---

	public String getCodDept() {
		return codDept;
	}

	public void setCodDept(String codDept) {
		this.codDept = codDept;
	}

	public String getDnombre() {
		return nombre;
	}

	public void setDnombre(String dnombre) {
		this.nombre = dnombre;
	}

	public Double getPresu() {
		return presu;
	}

	public void setPresu(Double presu) {
		this.presu = presu;
	}

	@Override
	public String toString() {
		return "Departamento [codDept=" + codDept + ", dnombre=" + nombre + ", presu=" + presu + "]";
	}

}
