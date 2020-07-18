<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>autinjo.rs - ${car.marka} ${car.model} ${car.godiste}</title>
<link
	href="https://fonts.googleapis.com/css?family=Saira+Semi+Condensed&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/autinjo/css/newCSS.css">
</head>
<body>

	<div class="container shadow-lg">
		<%@include file="include pages/header.jsp"%>

		<div class="row align-items-center" id="firstContentRow">
			<div class="col-lg-10 p-0">
				<div id="carouselExampleControls" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100" src="${car.thumbnailPath}">
						</div>

						<c:forEach items="${images}" var="image">
							<div class="carousel-item">
								<img class="d-block w-100" src="${image.path}">
							</div>
						</c:forEach>

					</div>
					<a class="carousel-control-prev" href="#carouselExampleControls"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleControls"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>

			<div class="col-lg-2 mt-lg-0 mt-sm-3 mb-sm-3 text-center p-0">
				<c:if test="${car.cena > 0}">
					<h3 class="mainPriceText">
						<fmt:formatNumber value="${car.cena}" type="number" />
						€
					</h3>
				</c:if>
				<c:if test="${car.cena == 0}">
					<h3 class="mainPriceText">Po dogovoru</h3>
				</c:if>
				<c:if test="${car.cena == -1}">
					<h3 class="mainPriceText">Na upit</h3>
				</c:if>

				<p class="lead" style="background-color: #e8e8e8">${car.stanje}
				</p>
				<p class="lead">${car.marka}</p>
				<p class="lead" style="background-color: #e8e8e8">${car.model}</p>
				<p class="lead">${car.godiste} godište</p>
				<p class="lead" style="background-color: #e8e8e8">
					<fmt:formatNumber value="${car.kilometraza}" type="number" />
					km
				</p>
				<p class="lead">${car.karoserija}</p>
				<p class="lead" style="background-color: #e8e8e8">${car.gorivo}
				</p>
				<p class="lead">${car.kubikaza} cm3</p>
				<p class="lead" style="background-color: #e8e8e8">${car.ks} KS</p>
				<p class="lead">${car.fiksnaCena}</p>
				<p class="lead" style="background-color: #e8e8e8">
					Zamena:${car.zamena}</p>

			</div>
		</div>

		<div class="row border-left border-right border-bottom p-2">
			<div class="col-lg-6 text-lg-left col-sm-12 text-md-center">
				<p class="lead">
					Oglas dodat: <span class="font-weight-bold"> <fmt:formatDate
							value="${car.datumPostavljanja}" type="DATE" />
					</span>
				</p>
			</div>
			<div class="col-lg-6 text-lg-right col-sm-12 text-md-center">
				<p class="lead">
					Oglas dodao korisnik: <a
						href="/autinjo/controllerTEST/user?id=${seller.idKorisnik}"> <span
						class="font-weight-bold"> ${seller.username} </span>
					</a>
				</p>
			</div>
		</div>

		<c:if test="${!empty car.karakteristike}">
			<div class="row border-right border-left border-bottom pb-2 p-1">
				<div class="col-lg-12 text-center mb-2">
					<p class="naslovOsobineVozilaP">Karakteristike</p>
				</div>

				<c:forEach items="${car.karakteristike}" var="k">
					<div class="col-lg-3">
						<!-- SUBSTRINGUJE PRE : I TO ISPISUJE NORMALNO A POSLE : BOLDOVANO -->
						<p>
							${fn:substringBefore(k, ":")}:<span
								class="osobineVozilaPoljeSpan"> ${fn:substringAfter(k, ":")}
							</span>
						</p>
					</div>
				</c:forEach>

			</div>
		</c:if>

		<c:if test="${!empty car.sigurnost}">
			<div class="row border-right border-left border-bottom pb-2 p-1">
				<div class="col-lg-12 text-center mb-2">
					<p class="naslovOsobineVozilaP">Sigurnost</p>
				</div>

				<c:forEach items="${car.sigurnost}" var="s">
					<div class="col-lg-3">
						<p>${s}</p>
					</div>
				</c:forEach>

			</div>
		</c:if>

		<c:if test="${!empty car.oprema}">
			<div class="row border-right border-left border-bottom pb-2 p-1">
				<div class="col-lg-12 text-center mb-2">
					<p class="naslovOsobineVozilaP">Oprema</p>
				</div>

				<c:forEach items="${car.oprema}" var="o">
					<div class="col-lg-3">
						<p>${o}</p>
					</div>
				</c:forEach>

			</div>
		</c:if>

		<c:if test="${!empty car.stanjeLista}">
			<div class="row border-right border-left border-bottom pb-2 p-1">
				<div class="col-lg-12 text-center mb-2">
					<p class="naslovOsobineVozilaP">Stanje</p>
				</div>

				<c:forEach items="${car.stanjeLista}" var="sl">
					<div class="col-lg-3">
						<p>${sl}</p>
					</div>
				</c:forEach>

			</div>
		</c:if>

		<c:if test="${!empty car.opis}">
			<div class="row border-right border-left border-bottom pb-2 p-1">
				<div class="col-lg-12 text-center mb-2">
					<p class="naslovOsobineVozilaP">Opis</p>
				</div>

				<div class="col-lg-12 text-left mb-2">
					<c:forEach items="${car.opis}" var="opis">

						<span> ${opis} </span>

					</c:forEach>
				</div>
			</div>
		</c:if>

		<%@include file="include pages/footer.jsp"%>
	</div>


	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>