package rs.autinjo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Slika;

public interface SlikaRepository extends JpaRepository<Slika, Integer> {
	public List<Slika> findByAutomobil_idAutomobil(int Automobil_idAutomobil);
}
