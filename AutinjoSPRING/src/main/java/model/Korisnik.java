package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	
	private String brojTelefona;

	
	private String email;

	
	private String ime;

	
	private String lokacija; 

	
	private String password;

	private String username;

	//bi-directional many-to-one association to Automobil
	@OneToMany(mappedBy="korisnik")
	@JsonIgnore
	private List<Automobil> automobils;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="korisnik1")
	@JsonIgnore
	private List<Poruka> porukas1;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="korisnik2")
	@JsonIgnore
	private List<Poruka> porukas2;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getBrojTelefona() {
		return this.brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getLokacija() {
		return this.lokacija;
	}

	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Automobil> getAutomobils() {
		return this.automobils;
	}

	public void setAutomobils(List<Automobil> automobils) {
		this.automobils = automobils;
	}

	public Automobil addAutomobil(Automobil automobil) {
		getAutomobils().add(automobil);
		automobil.setKorisnik(this);

		return automobil;
	}

	public Automobil removeAutomobil(Automobil automobil) {
		getAutomobils().remove(automobil);
		automobil.setKorisnik(null);

		return automobil;
	}

	public List<Poruka> getPorukas1() {
		return this.porukas1;
	}

	public void setPorukas1(List<Poruka> porukas1) {
		this.porukas1 = porukas1;
	}

	public Poruka addPorukas1(Poruka porukas1) {
		getPorukas1().add(porukas1);
		porukas1.setKorisnik1(this);

		return porukas1;
	}

	public Poruka removePorukas1(Poruka porukas1) {
		getPorukas1().remove(porukas1);
		porukas1.setKorisnik1(null);

		return porukas1;
	}

	public List<Poruka> getPorukas2() {
		return this.porukas2;
	}

	public void setPorukas2(List<Poruka> porukas2) {
		this.porukas2 = porukas2;
	}

	public Poruka addPorukas2(Poruka porukas2) {
		getPorukas2().add(porukas2);
		porukas2.setKorisnik2(this);

		return porukas2;
	}

	public Poruka removePorukas2(Poruka porukas2) {
		getPorukas2().remove(porukas2);
		porukas2.setKorisnik2(null);

		return porukas2;
	}

	@Override
	public String toString() {
		return "Korisnik [idKorisnik=" + idKorisnik + ", brojTelefona=" + brojTelefona + ", email=" + email + ", ime="
				+ ime + ", lokacija=" + lokacija + ", password=" + password + ", username=" + username + ", automobils="
				+ automobils + ", porukas1=" + porukas1 + ", porukas2=" + porukas2 + "]";
	}
	
	

}