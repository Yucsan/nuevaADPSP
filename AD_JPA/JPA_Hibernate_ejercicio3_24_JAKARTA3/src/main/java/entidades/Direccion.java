package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table(name="DIRECCION", catalog ="ejercicio3", uniqueConstraints= {
		@UniqueConstraint(columnNames ="IDDIRECCION")
})

public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="IDDIRECCION", unique= true, nullable=false)
	private String idDireccion;
	
	@Column(name="CALLE")
	private String calle;
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@Column(name="PAIS")
	private String pais;
	
	@Column(name="CODIGOPOSTAL")
	private Long codigoPostal;

	public Direccion() {
		
	}
	
	public Direccion(String idDireccion, String calle, String ciudad, String pais, Long codigoPostal) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
	}
	

	@Override
	public String toString() {
		return "Direccion idDireccion:" + idDireccion + ", calle:" + calle + ", ciudad:" + ciudad + ", pais:" + pais
				+ ", codigoPostal:" + codigoPostal;
	}


	
	
	
}
