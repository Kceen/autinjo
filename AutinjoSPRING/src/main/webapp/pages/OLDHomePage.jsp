<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/autinjo/css/oldCSS.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title> Autinjo </title>
</head>

<body>
	<div class="mainContentContainer">
		
		<h1 class="mainTitle"> POLOVNI AUTOMOBILI LOL </h1>

		<div class="mainSearchForm">
			<form>
				Marka
				<select name="marka">
					<option> Audi </option>
					<option> BMW </option>
					<option> Mercedes </option>
					<option> Volkswagen </option>
				</select>
				Model
				<select name="model">
					<option> Model1 </option>
					<option> Model2 </option>
					<option> Model3 </option>
					<option> Model4 </option>
				</select>
				Cena do <input type="text" name="cenaDo" maxlength="9" size="7">
				Godiste od
				<select name="godisteOd">
					<option> 2000 </option>
					<option> 2001 </option>
					<option> 2002 </option>
					<option> 2003 </option>
				</select>
				<br>
				<input type="submit" name="" class="searchSubmitButton" value="Trazi">
			</form>	
		</div>
		
		<div class="carsContainer"> 

			<c:forEach items="${allCars}" var="car">
				<div class="mainCarContainer"> 
					<h3 class="carTitle"> ${car.marka} ${car.model} </h3>
					<p class="price"> ${car.cena} € </p>
					<img src="${car.thumbnailPath}" class="carThumbnail">
					
					<div class="leftInfoColumn">
						<p class="infoColumnPClass">Godiste: <span class="infoColumnSpanClass"> ${car.godiste} </span> </p> 
						<p class="infoColumnPClass">Kilometraza:<span class="infoColumnSpanClass"> ${car.kilometraza} </span> </p> 
						<p class="infoColumnPClass">Gorivo: <span class="infoColumnSpanClass"> ${car.gorivo} </span> </p>
			
					</div>
					<div class="rightInfoColumn">
						<p class="infoColumnPClass">Kubikaza: <span class="infoColumnSpanClass"> ${car.kubikaza} </span> </p> 
						<p class="infoColumnPClass">KS:<span class="infoColumnSpanClass"> ${car.ks} </span> </p> 
						<p class="infoColumnPClass">Stanje: <span class="infoColumnSpanClass"> ${car.stanje} </span> </p>
					</div>
			
					<p class="detailsLinkContainer"> <a class="detailsLink" href="/autinjo/controllerTEST/singleCar?idCar=${car.idAutomobil}">  Detalji... </a> </p>
				</div>
			</c:forEach>
			

			
		</div>

	</div>
</body>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</html>









<c:forEach items="${allCars}" var="car">
		<h2> ${car.marka} ${car.model} ${car.cena} € </h2>
		<img src="${car.thumbnailPath}" width="50%">
		<h3> Gorivo = ${car.gorivo} </h3>
		<h3> Snaga motora = ${car.ks} </h3>
		<h3> Kubikaza = ${car.kubikaza} </h3>
		<h3> Zamena = ${car.zamena} </h3>
		<h3> Kilometraza = ${car.kilometraza} </h3>
		<h3> Fiksna cena = ${car.fiksnaCena} </h3>
		<h3> Stanje = ${car.stanje} </h3>
		<h3> Karoserija = ${car.karoserija} </h3>
		<h3> Godiste = ${car.godiste} </h3>
		<h3> Karakteristike </h3> <br>
		<p> ${car.karakteristike} </p>
		<h3> Sigurnost </h3> <br>
		<p> ${car.sigurnost} </p>
		<h3> Oprema </h3> <br>
		<p> ${car.oprema} </p>
		<h3> Stanje </h3> <br>
		<p> ${car.stanjeLista} </p>
		<h3> Opis </h3> <br>
		<p> ${car.opis} </p>
	</c:forEach>
	