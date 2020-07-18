package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the automobil database table.
 * 
 */
@Entity
@NamedQuery(name="Automobil.findAll", query="SELECT a FROM Automobil a")
public class Automobil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	// NE ZNAM ZASTO ALI KAD OVO NIJE ZAKOMENTARISANO, IZBACUJE GRESKU FAZON => Field 'idAutomobil' doesn't have a default value
	// I HOCE DA APDEJTUJE U BAZI SAMO AKO JE TAJ AUTOV ID VEC U BAZI, INACE BACA GORE POMENUTU GRESKU
	// KOLKO VIDIM, KAD JE ZAKOMENTARISANO, ONDA RADI
	// GLEDAM OVO POSLEDNJA DVA SATA I NIJE MI DOBRO, NMGU VISE
	// A I JA SVEJEDNO HOCU SAM DA PRAVIM ID-JEVE, poyyy
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idAutomobil;

	private int cena;

	@Temporal(TemporalType.TIMESTAMP)
	
	private Date datumPostavljanja;

	
	private String fiksnaCena;

	private int godiste;

	private String gorivo;
	
	
	private String karakteristike;

	
	private String karoserija;

	private int kilometraza;

	
	private int ks;

	
	private int kubikaza;

	private String marka;

	private String model;
	
	
	private String opis;

	
	private String oprema;

	
	private String sigurnost;

	
	private String stanje;

	
	private String stanjeLista;

	private String thumbnailPath;

	
	private String zamena;

	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// OK, RAZLOG ZASTO SE DESI INFINITE REKURZIJA OVDE JE ZATO STO ON PRIKAZE AUTO I PRIKAZE KORISNIKA CIJI JE TO AUTO, ALI U KORISNIKU 
	// IMA LISTA AUTOMOBILA GDE SE NALAZI BAS TAJ AUTO KOJI SE TRENUTNO PRIKAZUJE I ON TAKODJE IMA KORISNIKA KOJI TAKODJE IMA OPET NJEGA 
	// I TAKO ZAUVEK
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Slika
	@OneToMany(mappedBy="automobil")
	private List<Slika> slikas;

	public Automobil() {
	}

	public int getIdAutomobil() {
		return this.idAutomobil;
	}

	public void setIdAutomobil(int idAutomobil) {
		this.idAutomobil = idAutomobil;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Date getDatumPostavljanja() {
		return this.datumPostavljanja;
	}

	public void setDatumPostavljanja(Date datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
	}

	public String getFiksnaCena() {
		return this.fiksnaCena;
	}

	public void setFiksnaCena(String fiksnaCena) {
		this.fiksnaCena = fiksnaCena;
	}

	public int getGodiste() {
		return this.godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public String getGorivo() {
		return this.gorivo;
	}

	public void setGorivo(String gorivo) {
		this.gorivo = gorivo;
	}

	public String getKarakteristike() {
		return this.karakteristike;
	}

	public void setKarakteristike(String karakteristike) {
		this.karakteristike = karakteristike;
	}

	public String getKaroserija() {
		return this.karoserija;
	}

	public void setKaroserija(String karoserija) {
		this.karoserija = karoserija;
	}

	public int getKilometraza() {
		return this.kilometraza;
	}

	public void setKilometraza(int kilometraza) {
		this.kilometraza = kilometraza;
	}

	public int getKs() {
		return this.ks;
	}

	public void setKs(int ks) {
		this.ks = ks;
	}

	public int getKubikaza() {
		return this.kubikaza;
	}

	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getOprema() {
		return this.oprema;
	}

	public void setOprema(String oprema) {
		this.oprema = oprema;
	}

	public String getSigurnost() {
		return this.sigurnost;
	}

	public void setSigurnost(String sigurnost) {
		this.sigurnost = sigurnost;
	}

	public String getStanje() {
		return this.stanje;
	}

	public void setStanje(String stanje) {
		this.stanje = stanje;
	}

	public String getStanjeLista() {
		return this.stanjeLista;
	}

	public void setStanjeLista(String stanjeLista) {
		this.stanjeLista = stanjeLista;
	}

	public String getThumbnailPath() {
		return this.thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getZamena() {
		return this.zamena;
	}

	public void setZamena(String zamena) {
		this.zamena = zamena;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Slika> getSlikas() {
		return this.slikas;
	}

	public void setSlikas(List<Slika> slikas) {
		this.slikas = slikas;
	}

	public Slika addSlika(Slika slika) {
		getSlikas().add(slika);
		slika.setAutomobil(this);

		return slika;
	}

	public Slika removeSlika(Slika slika) {
		getSlikas().remove(slika);
		slika.setAutomobil(null);

		return slika;
	}

	@Override
	public String toString() {
		return "Automobil [idAutomobil=" + idAutomobil + ", cena=" + cena + ", datumPostavljanja=" + datumPostavljanja
				+ ", fiksnaCena=" + fiksnaCena + ", godiste=" + godiste + ", gorivo=" + gorivo + ", karakteristike="
				+ karakteristike + ", karoserija=" + karoserija + ", kilometraza=" + kilometraza + ", ks=" + ks
				+ ", kubikaza=" + kubikaza + ", marka=" + marka + ", model=" + model + ", opis=" + opis + ", oprema="
				+ oprema + ", sigurnost=" + sigurnost + ", stanje=" + stanje + ", stanjeLista=" + stanjeLista
				+ ", thumbnailPath=" + thumbnailPath + ", zamena=" + zamena + ", korisnik=" + korisnik + ", slikas="
				+ slikas + "]";
	}
	
	

}