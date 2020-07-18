package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the modeli database table.
 * 
 */
@Entity
@NamedQuery(name="Modeli.findAll", query="SELECT m FROM Modeli m")
public class Modeli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idModeli;

	private String marka;

	private String modeli;

	public Modeli() {
	}

	public int getIdModeli() {
		return this.idModeli;
	}

	public void setIdModeli(int idModeli) {
		this.idModeli = idModeli;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModeli() {
		return this.modeli;
	}

	public void setModeli(String modeli) {
		this.modeli = modeli;
	}

}