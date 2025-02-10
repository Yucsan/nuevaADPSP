package entidades;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the PRESTAEQUIPA database table.
 * 
 */
@Embeddable
public class PrestaequipaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idEquipacion_FK;

	@Column(insertable=false, updatable=false)
	private int idJugador_FK;

	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	public PrestaequipaPK() {
	}
	public int getIdEquipacion_FK() {
		return this.idEquipacion_FK;
	}
	public void setIdEquipacion_FK(int idEquipacion_FK) {
		this.idEquipacion_FK = idEquipacion_FK;
	}
	public int getIdJugador_FK() {
		return this.idJugador_FK;
	}
	public void setIdJugador_FK(int idJugador_FK) {
		this.idJugador_FK = idJugador_FK;
	}
	public java.util.Date getFecha() {
		return this.fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrestaequipaPK)) {
			return false;
		}
		PrestaequipaPK castOther = (PrestaequipaPK)other;
		return 
			(this.idEquipacion_FK == castOther.idEquipacion_FK)
			&& (this.idJugador_FK == castOther.idJugador_FK)
			&& this.fecha.equals(castOther.fecha);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEquipacion_FK;
		hash = hash * prime + this.idJugador_FK;
		hash = hash * prime + this.fecha.hashCode();
		
		return hash;
	}
}