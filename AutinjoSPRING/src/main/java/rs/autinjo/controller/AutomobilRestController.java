package rs.autinjo.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import model.AuthResponse;
import model.Automobil;
import model.Korisnik;
import model.Marka;
import model.Slika;
import rs.autinjo.helpingClasses.FixAspectRatioTo16By9;
import rs.autinjo.repository.AutomobilRepository;
import rs.autinjo.repository.KorisnikRepository;
import rs.autinjo.repository.MarkaRepository;
import rs.autinjo.repository.SlikaRepository;

@RestController
@RequestMapping(value = "restAuto")
public class AutomobilRestController {
	
	@Autowired
	AutomobilRepository autoRepo;
	@Autowired
	KorisnikRepository korRepo;
	@Autowired
	MarkaRepository markaRepo;
	@Autowired
	SlikaRepository slikaRepo;
	
	Automobil justAddedAuto;
	Random random = new Random();
	
	// ODVRATNO URADJENO, POPRAVITI JEDNOG DANA
	
	// PRAVILA
	
	// /restAuto/get?id=200				VRATI AUTOMOBIL SA ID = 200
	// /restAuto/get?limit=50			VRATI 50 AUTOMOBILA
	// /restAuto/get?all				VRATI SVE AUTOMOBILE
	// /restAuto/get?page=2&limit=9		VRATI 9 AUTOMOBILA SA DRUGE STRANICE
	// /restAuto/get?brands				VRATI SVE MARKE
	
	
	@GetMapping(value = "get")
	public ResponseEntity<List<Automobil>> get(HttpServletRequest request) {
		if(request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			if(autoRepo.findById(id).isPresent()) {
				Automobil automobil = autoRepo.findById(id).get();
				List<Automobil> automobilL = new ArrayList<Automobil>();
				automobilL.add(automobil);
				return ResponseEntity.ok(automobilL);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		if(request.getParameter("limit") != null && !request.getParameter("limit").equals("") && request.getParameter("id") == null && request.getParameter("page") == null) {
			int limit = Integer.parseInt(request.getParameter("limit"));
			if(limit < autoRepo.count()) {
				Pageable pageable = PageRequest.of(0, (int) limit);
				Page<Automobil> automobili = autoRepo.findAll(pageable);
				List<Automobil> automobiliL = automobili.toList();
				return ResponseEntity.ok(automobiliL);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		if(request.getParameter("all") != null) {
			List<Automobil> automobili = autoRepo.findAll();
			return ResponseEntity.ok(automobili);
		}
		if(request.getParameter("page") != null && request.getParameter("limit") != null && !request.getParameter("limit").equals("")) {
			int pageNumber = Integer.parseInt(request.getParameter("page"));
			int carsPerPage = Integer.parseInt(request.getParameter("limit"));
			System.out.println("PAGE NUMBER = " + pageNumber);
			Pageable pageable = PageRequest.of(pageNumber, carsPerPage);
			Page<Automobil> allCarsPage = autoRepo.findAll(pageable);
			List<Automobil> allCars = allCarsPage.toList();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("isLastPage", allCarsPage.isLast() + "");
			
			return ResponseEntity.ok()
								 .headers(headers)
								 .body(allCars);
		}
		
		// ZA SAD HARDKODOVANE VREDNOSTI NAJMANJEG I NAJVECEG ID
		// JEDNOG LEPOG DANA POPRAVI
		
		if(request.getParameter("random") != null) {
			Automobil automobil = autoRepo.findById(new Random().nextInt(243) + 189).get();
			List<Automobil> automobilL = new ArrayList<Automobil>();
			automobilL.add(automobil);
			return ResponseEntity.ok(automobilL);
		}
		
		else {
			return ResponseEntity.notFound().build(); 
		}
	}
	
	@GetMapping(value = "getAllBrands")
	public ResponseEntity<List<String>> getAllBrands(HttpServletRequest request) {
		List<Marka> brandsModels = markaRepo.findAll();
		List<String> brandsStrings = new ArrayList<String>();
		
		for (Marka brandsModel : brandsModels) {
			brandsStrings.add(brandsModel.getNaziv());
		}
		
		return ResponseEntity.ok(brandsStrings);
	}
	
	@GetMapping(value = "getKorisnik")
	public ResponseEntity<List<Korisnik>> getKorisnik(HttpServletRequest request) {
		int idKorisnik = Integer.parseInt(request.getParameter("id"));
		Korisnik korisnik = korRepo.findById(idKorisnik).get();
		List<Korisnik> korisnikList = new ArrayList<Korisnik>();
		korisnikList.add(korisnik);
		
		return ResponseEntity.ok(korisnikList);
	}
	
	@GetMapping(value = "getAutosFromKorisnik")
	public ResponseEntity<List<Automobil>> getAutosFromKorisnik(HttpServletRequest request) {
		int idKorisnik = Integer.parseInt(request.getParameter("id"));
		Korisnik korisnik = korRepo.findById(idKorisnik).get();
		List<Automobil> autos = autoRepo.findByKorisnik(korisnik);
		
		return ResponseEntity.ok(autos);	
	}
		
	// OOOOOKEJ
	// ZNACI DAJ MI SVE KRITERIJUME I AKO NEKIH NEMA, STAVICE SE KAO DA SE ZELI SVE ZA TAJ KRITERIJUM
	// NA PRIMER - AKO NEMA ceneOd (TJ cenaOd=""), STAVICE cenaOd DA BUDE 0 DA BI DOBIO SVE
	@GetMapping(value = "searchSimple")
	public ResponseEntity<List<Automobil>> searchSimple(HttpServletRequest request) {
		List<Automobil> autos = new ArrayList<Automobil>();
		String marka = request.getParameter("marka");
		String model = request.getParameter("model");
		String cenaOd = request.getParameter("cenaOd");
		String cenaDo = request.getParameter("cenaDo");
		String godisteOd = request.getParameter("godisteOd");
		String godisteDo = request.getParameter("godisteDo");
		String gorivo = request.getParameter("gorivo");
		String stanje = request.getParameter("stanje");
		String karoserija = request.getParameter("karoserija");
		String zamena = request.getParameter("zamena");
		String kilometrazaOd = request.getParameter("kilometrazaOd");
		String kilometrazaDo = request.getParameter("kilometrazaDo");
		String kubikazaOd = request.getParameter("kubikazaOd");
		String kubikazaDo = request.getParameter("kubikazaDo");
		String ksOd = request.getParameter("ksOd");
		String ksDo = request.getParameter("ksDo");
		String fiksnaCena = request.getParameter("fiksnaCena");
		
		if(marka.equals("") || marka.equals("Sve")) {
			marka = "%";
		}
		if(model.equals("") || model.equals("null")) {
			model = "%";
		}
		// CENA -5 ZATO STO AKO JE CENA PO DOGOVORU, U BAZI PISE 0, A AKO JE CENA NA UPIT, U BAZI PISE -1
		if(cenaOd.equals("") || cenaOd.equals("null")) {
			cenaOd = "-5";
		}
		if(cenaDo.equals("") || cenaDo.equals("null")) {
			cenaDo = "1000000";
		}
		if(godisteOd.equals("") || godisteOd.equals("null")) {
			godisteOd = "0";
		}
		if(godisteDo.equals("") || godisteDo.equals("null")) {
			godisteDo = "1000000";
		}
		if(gorivo.equals("") || gorivo.equals("Sve")) {
			gorivo = "%";
		}
		if(stanje.equals("") || stanje.equals("Sve")) {
			stanje = "%";
		}
		if(karoserija.equals("") || karoserija.equals("Sve")) {
			karoserija = "%";
		}
		if(zamena.equals("") || zamena.equals("Sve")) {
			zamena = "%";
		}
		if(kilometrazaOd.equals("") || kilometrazaOd.equals("null")) {
			kilometrazaOd = "-5"; 
		}
		if(kilometrazaDo.equals("") || kilometrazaDo.equals("null")) {
			kilometrazaDo = "1000000";
		}
		if(kubikazaOd.equals("") || kubikazaOd.equals("null")) {
			kubikazaOd = "0";
		}
		if(kubikazaDo.equals("") || kubikazaDo.equals("null")) {
			kubikazaDo = "1000000";
		}
		if(ksOd.equals("") || ksOd.equals("null")) {
			ksOd = "0";
		}
		if(ksDo.equals("") || ksDo.equals("null")) {
			ksDo = "10000";
		}
		if(fiksnaCena.equals("") || fiksnaCena.equals("Sve")) {
			fiksnaCena = "%";
		}
		
		autos = autoRepo.findByMarkaLikeAndModelLikeAndCenaGreaterThanAndCenaLessThanAndGodisteGreaterThanAndGodisteLessThanAndGorivoLikeAndStanjeLikeAndKaroserijaLikeAndZamenaLikeAndKilometrazaGreaterThanAndKilometrazaLessThanAndKubikazaGreaterThanAndKubikazaLessThanAndKsGreaterThanAndKsLessThanAndFiksnaCenaLike(marka, model, Integer.parseInt(cenaOd), Integer.parseInt(cenaDo), Integer.parseInt(godisteOd), Integer.parseInt(godisteDo), gorivo, stanje, karoserija, zamena, Integer.parseInt(kilometrazaOd), Integer.parseInt(kilometrazaDo), Integer.parseInt(kubikazaOd), Integer.parseInt(kubikazaDo), Integer.parseInt(ksOd), Integer.parseInt(ksDo), fiksnaCena);
		return ResponseEntity.ok(autos);	
		
		}

	@GetMapping(value = "auth")
	public ResponseEntity<AuthResponse> authenticate(HttpServletRequest request) {
		System.out.println("AUTH SERVICE HAS BEEN CALLED");
		
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		//System.out.println("Username = " + new String(Base64.getDecoder().decode(username)));
		//System.out.println("Password = " + new String(Base64.getDecoder().decode(password)));
		System.out.println("Username = " + username);
		System.out.println("Password = " + password);
		
		AuthResponse failResponse = new AuthResponse(false, 0, 0);
		
		Korisnik user = korRepo.findByUsername(username);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				AuthResponse response = new AuthResponse(true, new Random().nextInt(Integer.MAX_VALUE), user.getIdKorisnik());
				return ResponseEntity.ok(response); 
			}
			else {
				return ResponseEntity.ok(failResponse); 
			}
		}
		else {
			return ResponseEntity.ok(failResponse); 
		}
		
	}

	@PostMapping(value = "addAuto")
	public void addAuto(@RequestBody Automobil autoToAdd) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("globalIdCounter.txt")));
		int globalIdCounter = Integer.parseInt(bufferedReader.readLine());
		bufferedReader.close();
		System.out.println("ID BEFORE = " + globalIdCounter);
		
		justAddedAuto = autoToAdd;
		
		autoToAdd.setIdAutomobil(globalIdCounter);
		//autoToAdd.setKorisnik(korRepo.findById(1).get());
		autoRepo.save(autoToAdd);
		
		
		PrintWriter globalIdWriter = new PrintWriter(new FileOutputStream(new File("globalIdCounter.txt")), true);
		globalIdWriter.print(++globalIdCounter);
		globalIdWriter.flush(); 

		globalIdWriter.close();
		
	}
	
	@PostMapping(value = "register")
	public void addKorisnik(@RequestBody Korisnik korisnikToAdd) throws Exception {
		System.out.println(korisnikToAdd);
		
		korisnikToAdd.setBrojTelefona("0" + korisnikToAdd.getBrojTelefona());
		
		korRepo.save(korisnikToAdd);
		
	}
	
	@PostMapping(value = "uploadImage")
	public void uploadImage(@RequestParam("image") MultipartFile imageFile, HttpServletRequest request) throws Exception {		
		String folderName = justAddedAuto.getMarka() + "-" + justAddedAuto.getModel() + "-" + justAddedAuto.getGodiste() + "-" + justAddedAuto.getKilometraza();
		Path path = Paths.get(
				"C:\\Users\\Nikola\\Desktop\\Java Workspace\\Ostalo\\AutinjoSPRING\\src\\main\\webapp\\images\\" + folderName);
		Files.createDirectories(path);
		
		if(request.getHeader("thumbnail") != null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageFile.getBytes()));
			ImageIO.write(img, "png", new File(path + "\\thumbnail.png"));
			
			justAddedAuto.setThumbnailPath("/autinjo/images/" + folderName + "/thumbnail.png");
			autoRepo.save(justAddedAuto);

		}
		else {
			int randomImageInt = random.nextInt(1000000);
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageFile.getBytes()));
			ImageIO.write(img, "png", new File(path + "\\" + randomImageInt + ".png"));
			Slika slika = new Slika();
			slika.setPath("/autinjo/images/" + folderName + "/" + randomImageInt + ".png");
			slika.setAutomobil(justAddedAuto);
			slikaRepo.save(slika);
			
			
			autoRepo.save(justAddedAuto);
		}
		
		FixAspectRatioTo16By9.fixAspectRatioOneFolder(path.toString());
		
	}
	

}
