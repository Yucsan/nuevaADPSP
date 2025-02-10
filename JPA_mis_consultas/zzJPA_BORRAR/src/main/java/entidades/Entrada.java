package entidades;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the ENTRADAS database table.
 * 
 */
@Entity
@Table(name="ENTRADAS")
@NamedQuery(name="Entrada.findAll", query="SELECT e FROM Entrada e")
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codentrada;

	private String comprador;

	private int numenfila;

	private int numfila;

	private int pvp;

	private char vendido;

	//bi-directional many-to-one association to Pas
	@ManyToOne
	@JoinColumn(name="codpase", insertable=false, updatable=false)
	private Pas pas1;

	//bi-directional many-to-one association to Pas
	@ManyToOne
	@JoinColumn(name="codpase", insertable=false, updatable=false)
	private Pas pas2;

	public Entrada() {
	}
	

	public Entrada(int codentrada, String comprador, int numenfila, int numfila, int pvp, char vendido) {
		super();
		this.codentrada = codentrada;
		this.comprador = comprador;
		this.numenfila = numenfila;
		this.numfila = numfila;
		this.pvp = pvp;
		this.vendido = vendido;
	}




	public int getCodentrada() {
		return this.codentrada;
	}

	public void setCodentrada(int codentrada) {
		this.codentrada = codentrada;
	}

	public String getComprador() {
		return this.comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public int getNumenfila() {
		return this.numenfila;
	}

	public void setNumenfila(int numenfila) {
		this.numenfila = numenfila;
	}

	public int getNumfila() {
		return this.numfila;
	}

	public void setNumfila(int numfila) {
		this.numfila = numfila;
	}

	public int getPvp() {
		return this.pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	}

	public char getVendido() {
		return this.vendido;
	}

	public void setVendido(char vendido) {
		this.vendido = vendido;
	}

	public Pas getPas1() {
		return this.pas1;
	}

	public void setPas1(Pas pas1) {
		this.pas1 = pas1;
	}

	public Pas getPas2() {
		return this.pas2;
	}

	public void setPas2(Pas pas2) {
		this.pas2 = pas2;
	}

	@Override
	public String toString() {
		return "Entrada [codentrada=" + codentrada + ", comprador=" + comprador + ", numenfila=" + numenfila
				+ ", numfila=" + numfila + ", pvp=" + pvp + ", vendido=" + vendido + "]";
	}
	
	
	
	

}