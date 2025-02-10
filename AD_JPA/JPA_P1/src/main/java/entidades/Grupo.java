package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "GRUPO", catalog = "practica")
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // clave principal o primary key
	@Column(name = "CODGRUPO", unique = true, nullable = false)
	private String codGrupo;

	@Column(name = "DNOMBRE")
	private String nombreGrupo;


	//BIDIRECCIONAL ONE to Many Grupo-Alumnos
	@OneToMany(mappedBy = "grupo")
	private List<Alumno> alumnos;


	public Grupo() {

	}

	public Grupo(String codGrupo, String nombreGrupo) {
		this.codGrupo = codGrupo;
		this.nombreGrupo = nombreGrupo;
		this.alumnos = new ArrayList<Alumno>();
	}
	
	//agrega o borra alumno
	public void addAlumno(Alumno alu) {
		this.alumnos.add(alu);
		 alu.setGrupo(this); //SUPER IMPORTANTE
	}
	
	public void removeAlumno(Alumno alu) {
		this.alumnos.remove(alu);
	}
	

	public String getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public List<Alumno> getProyectos() {
		return alumnos;
	}


	
	
	
	
	
	


	
	
	
	
	
	

}
