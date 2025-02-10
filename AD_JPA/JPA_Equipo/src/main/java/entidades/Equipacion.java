package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the EQUIPACION database table.
 * 
 */
@Entity
@Table(name="EQUIPACION")
@NamedQuery(name="Equipacion.findAll", query="SELECT e FROM Equipacion e")
public class Equipacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquipacion;

	private String nombre;

	//bi-directional many-to-one association to Prestaequipa
	@OneToMany(mappedBy="equipacion")
	private List<Prestaequipa> prestaequipas;

	public Equipacion() {
	}

	public int getIdEquipacion() {
		return this.idEquipacion;
	}

	public void setIdEquipacion(int idEquipacion) {
		this.idEquipacion = idEquipacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Prestaequipa> getPrestaequipas() {
		return this.prestaequipas;
	}

	public void setPrestaequipas(List<Prestaequipa> prestaequipas) {
		this.prestaequipas = prestaequipas;
	}

	public Prestaequipa addPrestaequipa(Prestaequipa prestaequipa) {
		getPrestaequipas().add(prestaequipa);
		prestaequipa.setEquipacion(this);

		return prestaequipa;
	}

	public Prestaequipa removePrestaequipa(Prestaequipa prestaequipa) {
		getPrestaequipas().remove(prestaequipa);
		prestaequipa.setEquipacion(null);

		return prestaequipa;
	}

}