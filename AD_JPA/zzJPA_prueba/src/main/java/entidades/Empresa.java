package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="empresa")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codempre;

	private String cif;

	private String titulo;

	//bi-directional many-to-one association to Programador
	@ManyToOne
	@JoinColumn(name="codpro_FK")
	private Programador programador;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="codproye_FK")
	private Proyecto proyecto;

	public Empresa() {
	}

	public String getCodempre() {
		return this.codempre;
	}

	public void setCodempre(String codempre) {
		this.codempre = codempre;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Programador getProgramador() {
		return this.programador;
	}

	public void setProgramador(Programador programador) {
		this.programador = programador;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}