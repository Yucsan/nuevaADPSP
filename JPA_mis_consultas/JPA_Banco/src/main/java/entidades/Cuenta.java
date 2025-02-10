package entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the CUENTA database table.
 * 
 */
@Entity
@Table(name="CUENTA")
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_CUENTA")
	private int codCuenta;

	@Column(name = "INTERES", columnDefinition = "DECIMAL(23,10)")
	private BigDecimal interes;

	@Column(name="SALDO")
	private BigDecimal saldo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="COD_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="COD_SUCURSAL")
	private Sucursal sucursal;

	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="cuenta")
	private List<Movimiento> movimientos;

	public Cuenta() {
	}
	
	

	public Cuenta(int codCuenta, BigDecimal interes, BigDecimal saldo) {
		super();
		this.codCuenta = codCuenta;
		this.interes = interes;
		this.saldo = saldo;

	}



	public int getCodCuenta() {
		return this.codCuenta;
	}

	public void setCodCuenta(int codCuenta) {
		this.codCuenta = codCuenta;
	}

	public BigDecimal getInteres() {
		return this.interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Movimiento addMovimiento(Movimiento movimiento) {
		getMovimientos().add(movimiento);
		movimiento.setCuenta(this);

		return movimiento;
	}

	public Movimiento removeMovimiento(Movimiento movimiento) {
		getMovimientos().remove(movimiento);
		movimiento.setCuenta(null);

		return movimiento;
	}

	@Override
	public String toString() {
		return "Cuenta [codCuenta=" + codCuenta + ", interes=" + interes + ", saldo=" + saldo + ", cliente=" + cliente
				+ ", sucursal=" + sucursal + "]";
	}
	
	
	
	
	
	
	
	

}