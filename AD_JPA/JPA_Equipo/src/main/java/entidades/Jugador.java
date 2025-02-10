package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the JUGADOR database table.
 * 
 */
@Entity
@Table(name="JUGADOR")
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idJugador;

	private String apellidos;

	private String nombre;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="idEquipo_FK")
	private Equipo equipo;

	//bi-directional many-to-one association to Prestaequipa
	@OneToMany(mappedBy="jugador")
	private List<Prestaequipa> prestaequipas;

	public Jugador() {
	}

	public int getIdJugador() {
		return this.idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
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

	public List<Prestaequipa> getPrestaequipas() {
		return this.prestaequipas;
	}

	public void setPrestaequipas(List<Prestaequipa> prestaequipas) {
		this.prestaequipas = prestaequipas;
	}

	public Prestaequipa addPrestaequipa(Prestaequipa prestaequipa) {
		getPrestaequipas().add(prestaequipa);
		prestaequipa.setJugador(this);

		return prestaequipa;
	}

	public Prestaequipa removePrestaequipa(Prestaequipa prestaequipa) {
		getPrestaequipas().remove(prestaequipa);
		prestaequipa.setJugador(null);

		return prestaequipa;
	}

	@Override
	public String toString() {
		return String.format("Jugador idJugador=%s, apellidos=%s, nombre=%s, equipo=%s, prestaequipas=%s", idJugador,
				apellidos, nombre, equipo.getNombre(), prestaequipas);
	}
	
	

}