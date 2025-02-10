package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the EQUIPO database table.
 * 
 */
@Entity
@Table(name="EQUIPO")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idEquipo;

	private String nombre;

	//bi-directional many-to-one association to Jugador
	@OneToMany(mappedBy="equipo")
	private List<Jugador> jugadors;

	//bi-directional many-to-one association to Tecnico
	@OneToMany(mappedBy="equipo")
	private List<Tecnico> tecnicos;

	public Equipo() {
	}

	public String getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(String idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	public Jugador addJugador(Jugador jugador) {
		getJugadors().add(jugador);
		jugador.setEquipo(this);

		return jugador;
	}

	public Jugador removeJugador(Jugador jugador) {
		getJugadors().remove(jugador);
		jugador.setEquipo(null);

		return jugador;
	}

	public List<Tecnico> getTecnicos() {
		return this.tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public Tecnico addTecnico(Tecnico tecnico) {
		getTecnicos().add(tecnico);
		tecnico.setEquipo(this);

		return tecnico;
	}

	public Tecnico removeTecnico(Tecnico tecnico) {
		getTecnicos().remove(tecnico);
		tecnico.setEquipo(null);

		return tecnico;
	}

}