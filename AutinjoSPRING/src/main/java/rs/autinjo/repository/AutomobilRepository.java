package rs.autinjo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.Automobil;
import model.Korisnik;

public interface AutomobilRepository extends PagingAndSortingRepository<Automobil, Integer>, JpaRepository<Automobil, Integer> {

	List<Automobil> findByMarka(String marka);
	
	List<Automobil> findByMarka(String marka, Pageable p);
	
	List<Automobil> findByKorisnik(Korisnik korisnik);
	
	List<Automobil> findByMarkaAndCenaLessThanEqualAndGodisteGreaterThanEqual(String marka, int cenaDo, int godisteOd);
	
	List<Automobil> findByMarkaLikeAndModelLikeAndCenaGreaterThanAndCenaLessThanAndGodisteGreaterThanAndGodisteLessThanAndGorivoLikeAndStanjeLikeAndKaroserijaLikeAndZamenaLikeAndKilometrazaGreaterThanAndKilometrazaLessThanAndKubikazaGreaterThanAndKubikazaLessThanAndKsGreaterThanAndKsLessThanAndFiksnaCenaLike(String marka, String model, int cenaOd, int cenaDo, int godisteOd, int godisteDo, String gorivo, String stanje, String karoserija, String zamena, int kilometrazaOd, int kilometrazaDo, int kubikazaOd, int kubikazaDo, int ksOd, int ksDo, String fiksnaCena);
	
	
	// BEZ MARKE
	//List<Automobil> findByCenaLessThanEqualAndGodisteGreaterThanEqual(int cenaDo, int godisteOd);
	// BEZ GORIVA
	//List<Automobil> findByCenaLessThanEqualAndGodisteGreaterThanEqual(int cenaDo, int godisteOd);
		
	
	
	//@Query("SELECT a FROM Automobil a LIMIT ")
	//List<Automobil> find


}
