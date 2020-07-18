<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> autinjo.rs - Detaljna pretraga </title>
<link href="https://fonts.googleapis.com/css?family=Saira+Semi+Condensed&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/autinjo/css/newCSS.css">
</head>
<body>
	
	<div class="container shadow-lg">
		<%@include file="include pages/header.jsp"%>
		<%@include file="include pages/detailedSearchForm.jsp"%>
		
		<div class="row" id="mainCarsRow">
			<div class="row ml-0 mr-0">
				<c:forEach items="${allCars}" var="car">
					<div class="col-lg-4 text-center border-bottom pb-2">
						<a href="/autinjo/controllerTEST/singleCar?id=${car.idAutomobil}">
							<p class="lead" id="marka-model"> ${car.marka} ${car.model} </p>
							<img src="${car.thumbnailPath}" width="100%" class="carThumbnail">
							<span class="lead" id="price"> <fmt:formatNumber value="${car.cena}" type="number"/> € </span> -
							<span class="lead"> <fmt:formatNumber value="${car.kilometraza}" type="number"/> km </span> -
							<span class="lead"> ${car.gorivo} </span> -
							<span class="lead"> ${car.godiste} </span>
							<p class="lead" id="detailsLink"> Detaljnije </p>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	
		
		<%@include file="include pages/footer.jsp"%>
	</div>

	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>