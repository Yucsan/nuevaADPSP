package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

/**
 * The persistent class for the ANALISIS database table.
 * 
 */


@Entity
@Table(name="ANALISIS")
@NamedQuery(name="Analisi.findAll", query="SELECT a FROM Analisi a")


public class Analisi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int codanalisis;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String tipo;

	private char valoracion;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="codmedico")
	private Medico medico;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="codpaciente")
	private Paciente paciente;

	public Analisi() {
	}

	public int getCodanalisis() {
		return this.codanalisis;
	}

	public void setCodanalisis(int codanalisis) {
		this.codanalisis = codanalisis;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public char getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(char valoracion) {
		this.valoracion = valoracion;
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
		return "Analisi [codanalisis=" + codanalisis + ", fecha=" + fecha + ", tipo=" + tipo + ", valoracion="
				+ valoracion + ", medico=" + medico + ", paciente=" + paciente + "]";
	}
	
	

}