package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the programador database table.
 * 
 */
@Entity
@Table(name="programador")
@NamedQuery(name="Programador.findAll", query="SELECT p FROM Programador p")
public class Programador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codpro;

	private String ciudad;

	private int cp;

	private String direccion;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="programador")
	private List<Empresa> empresas;

	public Programador() {
	}

	public String getCodpro() {
		return this.codpro;
	}

	public void setCodpro(String codpro) {
		this.codpro = codpro;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCp() {
		return this.cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setProgramador(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setProgramador(null);

		return empresa;
	}

}