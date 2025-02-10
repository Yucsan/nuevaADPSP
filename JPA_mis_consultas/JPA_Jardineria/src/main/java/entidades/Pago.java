package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@Table(name="pago")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String TDOPAGOS = "Pago.findAll"; 

	@EmbeddedId
	private PagoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	@Column(name="forma_pago")
	private String formaPago;

	private float total;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="codigo_cliente")
	private Cliente cliente;

	public Pago() {
	}

	public PagoPK getId() {
		return this.id;
	}

	public void setId(PagoPK id) {
		this.id = id;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", fechaPago=" + fechaPago + ", formaPago=" + formaPago + ", total=" + total
				+ ", cliente=" + cliente + "]";
	}
	

}