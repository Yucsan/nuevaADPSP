package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="EXPEDIENTE" ,catalog="practica")
public class Expediente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="codExp", unique= true, nullable=false)
	private String codExp;
	
	@Column(name="fecha")
	private Date fechaExp;

	public Expediente() {
		
	}

	public Expediente(String codExp, Date fechaExp) {
		this.codExp = codExp;
		this.fechaExp = fechaExp;
	}
	
	
	//3.3 Asociacion bidireccional One to One sobre Empleado y PlazaParking
		//mappedBy plaza es un atributo de Empleado donde se indica la plaza
		
	@OneToOne (mappedBy="expediente", targetEntity=Alumno.class)
	@JoinColumn(name="ALUMNO_FK", unique=true, nullable=false, updatable=false)
	private Alumno alumno;

	public String getCodExp() {
		return codExp;
	}

	public void setCodExp(String codExp) {
		this.codExp = codExp;
	}

	public Date getFechaExp() {
		return fechaExp;
	}

	public void setFechaExp(Date fechaExp) {
		this.fechaExp = fechaExp;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
	
	
	

	
	
		
	
	
	
	
	
	
	
	

	

	
	
	

}

