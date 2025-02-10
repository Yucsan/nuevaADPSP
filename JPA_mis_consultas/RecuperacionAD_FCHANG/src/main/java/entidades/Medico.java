package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MEDICOS database table.
 * 
 */
@Entity
@Table(name="MEDICOS")
@NamedQueries({
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m"),

// esta no la se hacer en estatica
@NamedQuery(name=Medico.CONS7, query="SELECT m FROM Medico m"),

})
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String CONS7="CONSULTA7";
	@Id
	private int codmedico;

	private String especialidad;

	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	private String nombre;

	private BigDecimal salario;

	//bi-directional many-to-one association to Analisi
	@OneToMany(mappedBy="medico")
	private List<Analisi> analisis;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="medico")
	private List<Cita> citas;

	public Medico() {
	}

	public int getCodmedico() {
		return this.codmedico;
	}

	public void setCodmedico(int codmedico) {
		this.codmedico = codmedico;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<Analisi> getAnalisis() {
		return this.analisis;
	}

	public void setAnalisis(List<Analisi> analisis) {
		this.analisis = analisis;
	}

	public Analisi addAnalisi(Analisi analisi) {
		getAnalisis().add(analisi);
		analisi.setMedico(this);

		return analisi;
	}

	public Analisi removeAnalisi(Analisi analisi) {
		getAnalisis().remove(analisi);
		analisi.setMedico(null);

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
		cita.setMedico(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setMedico(null);

		return cita;
	}

	@Override
	public String toString() {
		return "Medico [codmedico=" + codmedico + ", especialidad=" + especialidad + ", fechaingreso=" + fechaingreso
				+ ", nombre=" + nombre + ", salario=" + salario + "]";
	}
	
	
	
	

}