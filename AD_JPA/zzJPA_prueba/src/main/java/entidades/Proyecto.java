package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@Table(name="proyecto")
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codproye;

	private String nombre;

	private String pais;

	private String tecnologia;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="proyecto")
	private List<Empresa> empresas;

	public Proyecto() {
	}

	public int getCodproye() {
		return this.codproye;
	}

	public void setCodproye(int codproye) {
		this.codproye = codproye;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTecnologia() {
		return this.tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setProyecto(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setProyecto(null);

		return empresa;
	}

}