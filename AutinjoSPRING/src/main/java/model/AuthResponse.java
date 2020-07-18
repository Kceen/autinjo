package model;

public class AuthResponse {

	public AuthResponse(boolean success, int token, int idKorisnik) {
		this.success = success;
		this.token = token;
		this.idKorisnik = idKorisnik;
	}
	
	boolean success;
	int token;
	int idKorisnik;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public int getIdKorisnik() {
		return idKorisnik;
	}
	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}
	
	
	
}
