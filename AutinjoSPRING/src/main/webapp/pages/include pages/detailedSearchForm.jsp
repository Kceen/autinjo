<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


		<!-- SEARCH FORM -->

		<div class="row">
			<form action="/autinjo/controllerTEST/search" class="filterForm p-3" style="width: 100%">
				<div class="row align-items-center">
					<div class="col-lg-4 col-sm-6">
						<div class="form-group">
							<label for="marka">Marka</label>
							<select class="form-control" id="marka" name="marka">
								<option disabled="" selected="">Izaberi marku</option>
								<c:forEach items="${allBrands}" var="brand">
					      			<option> ${brand.naziv} </option>
					      		</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-lg-4 col-sm-6">
						<div class="form-group">
							<label for="model">Model</label>
							<select class="form-control" id="model" name="model">
								<option disabled="" selected="">Izaberi model</option>
								<option>A Klasa</option>
								<option>B Klasa</option>
								<option>C Klasa</option>
								<option>E Klasa</option>
								<option>S Klasa</option>
							</select>
						</div>
					</div>
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="cenaOd">Cena od</label>
							<input type="number" class="form-control" id="cenaOd" min="0" step="10" name="cenaOd">
						</div>
					</div>
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="cenaDo">Cena do</label>
							<input type="number" class="form-control" id="cenaDo" min="0" step="10" name="cenaDo">
						</div>
					</div>

				</div>


				<div class="row align-items-center">
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="godisteOd">Godište od</label>
							<input type="number" class="form-control" id="godisteOd" min="1900" max="2020" name="godisteOd">
						</div>
					</div>
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="godisteDo">Godište do</label>
							<input type="number" class="form-control" id="godisteDo" min="1900" max="2020" name="godisteDo">
						</div>
					</div>
					<div class="col-lg-4 col-sm-6">
						<div class="form-group">
							<label for="gorivo">Gorivo</label>
							<select class="form-control" id="gorivo" name="gorivo">
								<option disabled="" selected="">Izaberi gorivo</option>
								<option>Benzin</option>
								<option>Dizel</option>
								<option>Benzin + Gas(TNG)</option>
								<option>Metan CNG</option>
								<option>Električni pogon</option>
								<option>Hibridni pogon</option>
							</select>
						</div>
					</div>
					<div class="col-lg-4 col-sm-6">
						<div class="form-group">
							<label for="model">Stanje</label>
							<select class="form-control" id="stanje" name="stanje">
								<option disabled="" selected="">Izaberi stanje</option>
								<option>Novo vozilo</option>
								<option>Polovno vozilo</option>
							</select>
						</div>
					</div>
				</div>


				<div class="row align-items-center">

					<div class="col-lg-4 col-sm-6">
						<div class="form-group">
							<label for="karoserija">Karoserija</label>
							<select class="form-control" id="karoserija" name="karoserija">
								<option disabled="" selected="">Izaberi karoseriju</option>
								<option>Limuzina</option>
								<option>Hečbek</option>
								<option>Karavan</option>
								<option>Kupe</option>
								<option>Kabriolet/Roadster</option>
								<option>Monovolumen(Minivan)</option>
								<option>Džip/SUV</option>
								<option>Pickup</option>
							</select>
						</div>
					</div>
					<div class="col-lg-4 col-sm-6">
						<div class="form-group">
							<label for="karoserija">Zamena</label>
							<select class="form-control" id="zamena" name="zamena">
								<option disabled="" selected=""> Zamena </option>
								<option> DA </option>
								<option> NE </option>
							</select>
						</div>
					</div>
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="kilometrazaOd">Kilometraža od</label>
							<input type="number" class="form-control" id="kilometrazaOd" min="0" name="kilometrazaOd">
						</div>
					</div>
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="kilometrazaDo">Kilometraža do</label>
							<input type="number" class="form-control" id="kilometrazaDo" min="0" name="kilometrazaDo">
						</div>
					</div>
				</div>


				<div class="row align-items-center">
					
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="kubikazaOd">Kubikaža od</label>
							<input type="number" class="form-control" id="kubikazaOd" min="0" name="kubikazaOd">
						</div>
					</div>
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="kubikazaDo">Kubikaža do</label>
							<input type="number" class="form-control" id="kubikazaDo" min="0" name="kubikazaDo">
						</div>
					</div>
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="ksOd">Konjske snage od</label>
							<input type="number" class="form-control" id="ksOd" min="0" name="ksOd">
						</div>
					</div>
					<div class="col-lg-2 col-sm-6">
						<div class="form-group">
							<label for="ksDo">Konjske snage do</label>
							<input type="number" class="form-control" id="ksDo" min="0" name="ksDo">
						</div>
					</div>
					<div class="col-lg-4 col-sm-6">
						<div class="form-group">
							<label for="fiksnaCena"> Fiksna cena </label>
							<select class="form-control" id="fiksnaCena" name="fiksnaCena">
								<option disabled="" selected=""> Fiksna cena </option>
								<option> Cena je fiksna </option>
								<option> Cena nije fiksna </option>
							</select>
						</div>
					</div>

				</div>


				<div class="row">
					<div class="col-lg text-center">
						<button type="submit" class="btn btn-primary btn-lg" id="searchButton" >Traži</button>		
					</div>
				</div>

			</form>
		</div>	
