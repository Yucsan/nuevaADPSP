package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_pedido")
	private int codigoPedido;

	private String comentarios;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrega")
	private Date fechaEntrega;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_esperada")
	private Date fechaEsperada;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pedido")
	private Date fechaPedido;

	//bi-directional many-to-one association to DetallePedido
	@OneToMany(mappedBy="pedido")
	private List<DetallePedido> detallePedidos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="codigo_cliente")
	private Cliente cliente;

	public Pedido() {
	}

	public int getCodigoPedido() {
		return this.codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaEsperada() {
		return this.fechaEsperada;
	}

	public void setFechaEsperada(Date fechaEsperada) {
		this.fechaEsperada = fechaEsperada;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public List<DetallePedido> getDetallePedidos() {
		return this.detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().add(detallePedido);
		detallePedido.setPedido(this);

		return detallePedido;
	}

	public DetallePedido removeDetallePedido(DetallePedido detallePedido) {
		getDetallePedidos().remove(detallePedido);
		detallePedido.setPedido(null);

		return detallePedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}