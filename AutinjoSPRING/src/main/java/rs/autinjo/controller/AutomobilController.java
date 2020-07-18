package rs.autinjo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Automobil;
import model.Korisnik;
import model.Marka;
import model.Modeli;
import model.Slika;
import rs.autinjo.repository.AutomobilRepository;
import rs.autinjo.repository.KorisnikRepository;
import rs.autinjo.repository.MarkaRepository;
import rs.autinjo.repository.ModeliRepository;
import rs.autinjo.repository.SlikaRepository;

@Controller
@RequestMapping(value = "controllerTEST")
public class AutomobilController {
	int pageNumber = 0;
	int carsPerPage = 27;

	@Autowired
	AutomobilRepository autoRepo;
	@Autowired
	SlikaRepository imageRepo;
	@Autowired
	MarkaRepository markaRepo;
	@Autowired
	KorisnikRepository korisnikRepo;
	@Autowired
	ModeliRepository modeliRepo;

	@GetMapping(value = "getAllTEST")
	public String getAllTest(HttpServletRequest request) {
		List<Modeli> sviModeli = modeliRepo.findAll();

		for (Modeli modeli : sviModeli) {
			String[] modeliNiz = modeli.getModeli().split(",");
			List<String> modeliLista = new ArrayList<String>();
			for (int i = 0; i < modeliNiz.length; i++) {

				modeliLista.add("\"" + modeliNiz[i] + "\"");

			}

			request.getSession().setAttribute(modeli.getMarka(), modeliLista);
		}

		if (request.getParameter("page") != null) {
			pageNumber = Integer.parseInt(request.getParameter("page"));
			pageNumber--;
		} else {
			pageNumber = 0;
		}
		// List<Automobil> allCars = autoRepo.findAll();
		List<Slika> allImages = imageRepo.findAll();
		List<String> imagesPathList = new ArrayList<String>();
		List<Slika> allImagesForOneCar = imageRepo.findByAutomobil_idAutomobil(1);
		List<Marka> allBrands = markaRepo.findAll();
		List<String> allBrandsJS = new ArrayList<String>();

		for (Marka brand : allBrands) {
			allBrandsJS.add("\"" + brand.getNaziv() + "\"");
		}

		Pageable pageable = PageRequest.of(pageNumber, carsPerPage);
		Page<Automobil> allCarsPage = autoRepo.findAll(pageable);
		System.out.println(allCarsPage.getNumber());
		List<Automobil> allCars = allCarsPage.toList();
		pageNumber++;

		for (Slika image : allImages) {
			imagesPathList.add(image.getPath());
		}

		request.getSession().setAttribute("allCars", allCars);
		request.getSession().setAttribute("allImages", imagesPathList);
		request.getSession().setAttribute("allImagesForOneCar", allImagesForOneCar);
		request.getSession().setAttribute("allBrands", allBrands);
		request.getSession().setAttribute("allBrandsJS", allBrandsJS);
		request.getSession().setAttribute("pageNumber", pageNumber);
		request.getSession().setAttribute("numberOfCarsOnPage", allCars.size());
		request.getSession().setAttribute("carsPerPage", carsPerPage);
		request.getSession().setAttribute("isLastPage", allCarsPage.isLast());

		return "pages/home";
	}

	@GetMapping(value = "singleCar")
	public String getSingleCar(HttpServletRequest request) {
		int idCar = Integer.parseInt(request.getParameter("id"));
		Automobil car = autoRepo.findById(idCar).get();
		List<Slika> images = imageRepo.findByAutomobil_idAutomobil(idCar);

		request.getSession().setAttribute("car", car);
		request.getSession().setAttribute("images", images);
		request.getSession().setAttribute("seller", car.getKorisnik());

		return "pages/singleCarView";
	}

	@GetMapping(value = "search")
	public String search(HttpServletRequest request) {
		String marka = request.getParameter("marka");
		int pageNumber;
		
		if(request.getParameter("page") != null) {
			pageNumber = Integer.parseInt(request.getParameter("page"));
			pageNumber--;
		}
		else {
			pageNumber = 0;
		}
		
		Pageable pageable = PageRequest.of(pageNumber, 9);
		List<Automobil> searchedCars = autoRepo.findByMarka(marka, pageable);

		pageNumber++;
		request.getSession().setAttribute("pageNumber", pageNumber);
		request.getSession().setAttribute("allCars", searchedCars);

		return "pages/home";
	}

	@GetMapping(value = "user")
	public String findUser(HttpServletRequest request) {
		int idUser = Integer.parseInt(request.getParameter("id"));
		Korisnik user = korisnikRepo.findById(idUser).get();

		List<Automobil> userCars = autoRepo.findByKorisnik(user);

		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("userCars", userCars);

		return "pages/user";

	}

}
