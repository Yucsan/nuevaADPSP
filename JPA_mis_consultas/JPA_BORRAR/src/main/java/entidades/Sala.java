package entidades;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the SALAS database table.
 * 
 */
@Entity
@Table(name="SALAS")
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codsala;

	private int numasiporfilas;

	private int numfilas;

	@Column(name="tipo_sonido")
	private String tipoSonido;

	//bi-directional many-to-one association to Pas
	@OneToMany(mappedBy="sala1")
	private List<Pas> pases1;

	//bi-directional many-to-one association to Pas
	@OneToMany(mappedBy="sala2")
	private List<Pas> pases2;

	public Sala() {
	}

	public int getCodsala() {
		return this.codsala;
	}

	public void setCodsala(int codsala) {
		this.codsala = codsala;
	}

	public int getNumasiporfilas() {
		return this.numasiporfilas;
	}

	public void setNumasiporfilas(int numasiporfilas) {
		this.numasiporfilas = numasiporfilas;
	}

	public int getNumfilas() {
		return this.numfilas;
	}

	public void setNumfilas(int numfilas) {
		this.numfilas = numfilas;
	}

	public String getTipoSonido() {
		return this.tipoSonido;
	}

	public void setTipoSonido(String tipoSonido) {
		this.tipoSonido = tipoSonido;
	}

	public List<Pas> getPases1() {
		return this.pases1;
	}

	public void setPases1(List<Pas> pases1) {
		this.pases1 = pases1;
	}

	public Pas addPases1(Pas pases1) {
		getPases1().add(pases1);
		pases1.setSala1(this);

		return pases1;
	}

	public Pas removePases1(Pas pases1) {
		getPases1().remove(pases1);
		pases1.setSala1(null);

		return pases1;
	}

	public List<Pas> getPases2() {
		return this.pases2;
	}

	public void setPases2(List<Pas> pases2) {
		this.pases2 = pases2;
	}

	public Pas addPases2(Pas pases2) {
		getPases2().add(pases2);
		pases2.setSala2(this);

		return pases2;
	}

	public Pas removePases2(Pas pases2) {
		getPases2().remove(pases2);
		pases2.setSala2(null);

		return pases2;
	}

}