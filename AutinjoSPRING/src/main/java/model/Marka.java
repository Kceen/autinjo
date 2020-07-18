package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the marka database table.
 * 
 */
@Entity
@NamedQuery(name="Marka.findAll", query="SELECT m FROM Marka m")
public class Marka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMarka;

	private String naziv;

	public Marka() {
	}

	public int getIdMarka() {
		return this.idMarka;
	}

	public void setIdMarka(int idMarka) {
		this.idMarka = idMarka;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}