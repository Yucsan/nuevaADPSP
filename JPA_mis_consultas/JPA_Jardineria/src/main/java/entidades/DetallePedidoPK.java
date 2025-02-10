package entidades;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the detalle_pedido database table.
 * 
 */
@Embeddable
public class DetallePedidoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="codigo_pedido", insertable=false, updatable=false)
	private int codigoPedido;

	@Column(name="codigo_producto", insertable=false, updatable=false)
	private String codigoProducto;

	public DetallePedidoPK() {
	}
	public int getCodigoPedido() {
		return this.codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public String getCodigoProducto() {
		return this.codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallePedidoPK)) {
			return false;
		}
		DetallePedidoPK castOther = (DetallePedidoPK)other;
		return 
			(this.codigoPedido == castOther.codigoPedido)
			&& this.codigoProducto.equals(castOther.codigoProducto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codigoPedido;
		hash = hash * prime + this.codigoProducto.hashCode();
		
		return hash;
	}
}