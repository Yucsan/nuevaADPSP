package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the detalle_pedido database table.
 * 
 */
@Entity
@Table(name="detalle_pedido")
@NamedQuery(name="DetallePedido.findAll", query="SELECT d FROM DetallePedido d")
public class DetallePedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallePedidoPK id;

	private int cantidad;

	@Column(name="numero_linea")
	private int numeroLinea;

	@Column(name="precio_unidad")
	private float precioUnidad;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="codigo_pedido")
	private Pedido pedido;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="codigo_producto")
	private Producto producto;

	public DetallePedido() {
	}

	public DetallePedidoPK getId() {
		return this.id;
	}

	public void setId(DetallePedidoPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getNumeroLinea() {
		return this.numeroLinea;
	}

	public void setNumeroLinea(int numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public float getPrecioUnidad() {
		return this.precioUnidad;
	}

	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}