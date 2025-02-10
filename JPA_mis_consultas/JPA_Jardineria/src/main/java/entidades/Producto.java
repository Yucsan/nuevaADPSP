package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_producto")
	private String codigoProducto;

	@Column(name="cantidad_en_stock")
	private int cantidadEnStock;

	private String descripcion;

	private String dimensiones;

	private String nombre;

	@Column(name="precio_proveedor")
	private float precioProveedor;

	@Column(name="precio_venta")
	private float precioVenta;

	private String proveedor;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="producto")
	private List<DetallePedido> detallePedidos;

	//bi-directional many-to-one association to GamaProducto
	@ManyToOne
	@JoinColumn(name="gama")
	private GamaProducto gamaProducto;

	public Producto() {
	}

	public String getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidadEnStock() {
		return this.cantidadEnStock;
	}

	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDimensiones() {
		return this.dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioProveedor() {
		return this.precioProveedor;
	}

	public void setPrecioProveedor(float precioProveedor) {
		this.precioProveedor = precioProveedor;
	}

	public float getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setProducto(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setProducto(null);

		return detallePedido;
	}

	public GamaProducto getGamaProducto() {
		return this.gamaProducto;
	}

	public void setGamaProducto(GamaProducto gamaProducto) {
		this.gamaProducto = gamaProducto;
	}

	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", cantidadEnStock=" + cantidadEnStock + ", descripcion="
				+ descripcion + ", dimensiones=" + dimensiones + ", nombre=" + nombre + ", precioProveedor="
				+ precioProveedor + ", precioVenta=" + precioVenta + ", proveedor=" + proveedor + ", detallePedidos="
				+ detallePedidos + ", gamaProducto=" + gamaProducto + "]";
	}
	

}