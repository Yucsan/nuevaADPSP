package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the gama_producto database table.
 * 
 */
@Entity
@Table(name="gama_producto")
@NamedQuery(name="GamaProducto.findAll", query="SELECT g FROM GamaProducto g")
public class GamaProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gama;

	@Column(name="descripcion_html")
	private String descripcionHtml;

	@Column(name="descripcion_texto")
	private String descripcionTexto;

	private String imagen;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="gamaProducto")
	private List<Producto> productos;

	public GamaProducto() {
	}

	public String getGama() {
		return this.gama;
	}

	public void setGama(String gama) {
		this.gama = gama;
	}

	public String getDescripcionHtml() {
		return this.descripcionHtml;
	}

	public void setDescripcionHtml(String descripcionHtml) {
		this.descripcionHtml = descripcionHtml;
	}

	public String getDescripcionTexto() {
		return this.descripcionTexto;
	}

	public void setDescripcionTexto(String descripcionTexto) {
		this.descripcionTexto = descripcionTexto;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setGamaProducto(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setGamaProducto(null);

		return producto;
	}

}