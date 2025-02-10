package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the PRESTAEQUIPA database table.
 * 
 */
@Entity
@Table(name="PRESTAEQUIPA")
@NamedQuery(name="Prestaequipa.findAll", query="SELECT p FROM Prestaequipa p")
public class Prestaequipa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrestaequipaPK id;

	//bi-directional many-to-one association to Equipacion
	@ManyToOne
	@JoinColumn(name="idEquipacion_FK")
	private Equipacion equipacion;

	//bi-directional many-to-one association to Jugador
	@ManyToOne
	@JoinColumn(name="idJugador_FK")
	private Jugador jugador;

	public Prestaequipa() {
	}
	
	public PrestaequipaPK getId() {
		return this.id;
	}

	public void setId(PrestaequipaPK id) {
		this.id = id;
	}

	public Equipacion getEquipacion() {
		return this.equipacion;
	}

	public void setEquipacion(Equipacion equipacion) {
		this.equipacion = equipacion;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	

}