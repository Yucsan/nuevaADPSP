package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPO_MOVIMIENTO database table.
 * 
 */
@Entity
@Table(name="TIPO_MOVIMIENTO")
@NamedQuery(name="TipoMovimiento.findAll", query="SELECT t FROM TipoMovimiento t")
public class TipoMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_TIPO_MOVIMIENTO")
	private String codTipoMovimiento;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="SALIDA")
	private char salida;

	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="tipoMovimiento")
	private List<Movimiento> movimientos;

	public TipoMovimiento() {
	}

	public String getCodTipoMovimiento() {
		return this.codTipoMovimiento;
	}

	public void setCodTipoMovimiento(String codTipoMovimiento) {
		this.codTipoMovimiento = codTipoMovimiento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getSalida() {
		return this.salida;
	}

	public void setSalida(char salida) {
		this.salida = salida;
	}

	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Movimiento addMovimiento(Movimiento movimiento) {
		getMovimientos().add(movimiento);
		movimiento.setTipoMovimiento(this);

		return movimiento;
	}

	public Movimiento removeMovimiento(Movimiento movimiento) {
		getMovimientos().remove(movimiento);
		movimiento.setTipoMovimiento(null);

		return movimiento;
	}

	@Override
	public String toString() {
		return "TipoMovimiento [codTipoMovimiento=" + codTipoMovimiento + ", descripcion=" + descripcion + ", salida="
				+ salida + "]";
	}
	

}