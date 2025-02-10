package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the TECNICO database table.
 * 
 */
@Entity
@Table(name="TECNICO")
@NamedQuery(name="Tecnico.findAll", query="SELECT t FROM Tecnico t")
public class Tecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTecnico;

	private String apellidos;

	private String nombre;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="idEquipo_FK")
	private Equipo equipo;

	public Tecnico() {
	}

	public int getIdTecnico() {
		return this.idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return String.format("Tecnico idTecnico=%s, apellidos=%s, nombre=%s, equipo=%s", idTecnico, apellidos, nombre,
				equipo.getNombre());
	}

	
	

}