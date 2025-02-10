package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table(name="PROYECTO", catalog ="ejercicio6", uniqueConstraints= {
		@UniqueConstraint(columnNames ="CODPROY")
})
public class Proyecto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CODPROY", unique = true, nullable = false)
	private Integer codProy;
	
	@Column(name="PNOMBRE")
	private String nombre;
	
	//3.5 BIDIRECCIONAL  Many to One Proyecto-Departamento
	
	@ManyToOne	
	@JoinColumn(name = "COD_DEPTO_FK")
	private Departamento departamento; 
	
	public Proyecto() {
		
	}
	

	public Proyecto(Integer codProy, String nombre) {
		this.codProy = codProy;
		this.nombre = nombre;
	}

	public Proyecto(Integer codProy, String nombre, Departamento departamento) {
		this.codProy = codProy;
		this.nombre = nombre;
		this.departamento = departamento;
	}
		
	//importante para las bidireccional	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Integer getCodProy() {
		return codProy;
	}

	public void setCodProy(Integer codProy) {
		this.codProy = codProy;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Proyecto [codProy=" + codProy + ", nombre=" + nombre + ", departamento=" + departamento.getDnombre() + "]";
	}

	
	
	
	

	
	

}
