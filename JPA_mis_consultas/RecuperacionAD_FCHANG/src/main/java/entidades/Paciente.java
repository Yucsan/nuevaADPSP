package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PACIENTES database table.
 * 
 */
@Entity
@Table(name="PACIENTES")
@NamedQueries({
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p"),

@NamedQuery(name=Paciente.CONS1, query="SELECT a.paciente "
		+ "FROM Analisi a "
		+ "WHERE a.valoracion = 'F' ")

})
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String CONS1="CONSULTA";

	@Id
	private int codpaciente;

	@Temporal(TemporalType.DATE)
	private Date fechanac;

	private String nombre;

	private BigDecimal peso;

	//bi-directional many-to-one association to Analisi
	@OneToMany(mappedBy="paciente")
	private List<Analisi> analisis;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="paciente")
	private List<Cita> citas;

	public Paciente() {
	}

	public int getCodpaciente() {
		return this.codpaciente;
	}

	public void setCodpaciente(int codpaciente) {
		this.codpaciente = codpaciente;
	}

	public Date getFechanac() {
		return this.fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public List<Analisi> getAnalisis() {
		return this.analisis;
	}

	public void setAnalisis(List<Analisi> analisis) {
		this.analisis = analisis;
	}

	public Analisi addAnalisi(Analisi analisi) {
		getAnalisis().add(analisi);
		analisi.setPaciente(this);

		return analisi;
	}

	public Analisi removeAnalisi(Analisi analisi) {
		getAnalisis().remove(analisi);
		analisi.setPaciente(null);

		return analisi;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setPaciente(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setPaciente(null);

		return cita;
	}

	@Override
	public String toString() {
		return "Paciente [codpaciente=" + codpaciente + ", fechanac=" + fechanac + ", nombre=" + nombre + ", peso="
				+ peso + "]";
	}
	

}