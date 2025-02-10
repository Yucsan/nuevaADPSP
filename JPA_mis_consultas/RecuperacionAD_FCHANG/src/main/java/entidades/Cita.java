package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CITAS database table.
 * 
 */
@Entity
@Table(name="CITAS")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codcita;

	private BigDecimal coste;

	@Temporal(TemporalType.DATE)
	private Date fechacita;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="codmedico")
	private Medico medico;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="codpaciente")
	private Paciente paciente;

	public Cita() {
	}

	public int getCodcita() {
		return this.codcita;
	}

	public void setCodcita(int codcita) {
		this.codcita = codcita;
	}

	public BigDecimal getCoste() {
		return this.coste;
	}

	public void setCoste(BigDecimal coste) {
		this.coste = coste;
	}

	public Date getFechacita() {
		return this.fechacita;
	}

	public void setFechacita(Date fechacita) {
		this.fechacita = fechacita;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Cita [codcita=" + codcita + ", coste=" + coste + ", fechacita=" + fechacita + ", medico=" + medico
				+ ", paciente=" + paciente + "]";
	}
	
	
	

}