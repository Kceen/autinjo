<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<title>autinjo.rs</title>
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
		<%@include file="include pages/simpleSearchForm.jsp"%>

		<div class="row" id="mainCarsRow">
			<div class="row ml-0 mr-0">
				<c:forEach items="${allCars}" var="car">
					<div class="col-lg-4 text-center border-bottom pb-2">
						<a href="/autinjo/controllerTEST/singleCar?id=${car.idAutomobil}">
							<p class="lead" id="marka-model">${car.marka} ${car.model}</p> <img
							src="${car.thumbnailPath}" width="100%" class="carThumbnail">
							<c:if test="${car.cena > 0}">
								<span class="lead" id="price"> <fmt:formatNumber
										value="${car.cena}" type="number" /> €
								</span> -
							</c:if> <c:if test="${car.cena == 0}">
								<span class="lead" id="price"> Po dogovoru </span> -
							</c:if> <c:if test="${car.cena == -1}">
								<span class="lead" id="price"> Na upit </span> -
							</c:if> <span class="lead"> <fmt:formatNumber
									value="${car.kilometraza}" type="number" /> km
						</span> - <span class="lead"> ${car.gorivo} </span> - <span class="lead">
								${car.godiste} </span>
							<p class="lead" id="detailsLink">Detaljnije</p>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>


		<!--  PAGINATION -->

		<div class="row justify-content-center p-3" id="paginationRow">
			<ul class="pagination m-0">

				<c:if test="${pageNumber == 1}">
					<li class="page-item disabled"><span class="page-link">Prethodna</span>
					</li>
				</c:if>
				<c:if test="${pageNumber > 1}">
					<li class="page-item"><a class="page-link"
						href="/autinjo/controllerTEST/getAllTEST?page=${pageNumber - 1}">Prethodna</a>
					</li>
				</c:if>

				<li class="page-item active"><span class="page-link">
						${pageNumber} <span class="sr-only">(current)</span>
				</span></li>

				<c:if test="${isLastPage}">
					<li class="page-item disabled"><span class="page-link">Sledeća</span>
					</li>
				</c:if>
				<c:if test="${!isLastPage}">
					<li class="page-item"><a class="page-link"
						href="/autinjo/controllerTEST/getAllTEST?page=${pageNumber + 1}">Sledeća</a>
						
						<!-- PAMETNIJI NACIN ZA FUNKCIONALNOST STRANICA 
							 TJ RADICE KAD SE IDE STRANICA GORE ILI DOLE I NA HOME STRANICI I SEARCH
							 MEDJUTIM NE RADI ZATO STO UZIMAM CEO TRENUTNI URL I NA NJEGA DODAJEM PAGE=${PAGENUMBER}
							 A TO ZNACI DA CU DA DODAJEM page=3 NA page=2 NA page=1 ITD
							 PRIMER = http://localhost:8080/autinjo/controllerTEST/search?marka=Audi&cenaDo=&godisteOd=&page=1&page=2&page=3 -->
						<!-- href="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}&page=${pageNumber + 1}">Sledeća</a> -->
					</li>
				</c:if>
			</ul>
		</div>


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
	<!-- <script src="/autinjo/scripts/script.js" type="text/javascript"></script> -->

	<script>
		var audiModels = [ "1", "2", "3" ];
		var mbModels = [ "4", "5", "6" ];
		var newOption;

		var getBrand = function() {
			var allBrandsSelect = document.getElementById("marka");
			var allBrandsOptions = document.getElementById("marka").options;
			var selectedBrandIndex = allBrandsOptions.selectedIndex;
			var marka = allBrandsOptions[selectedBrandIndex].text;
			var Audi1 = "Audi";
			var sdsd = 5;
			
			console.log(eval("marka"));
			
			
			
			var allModelsSelect = document.getElementById("model");

			for (var i = allModelsSelect.length; i > 0; i--) {
				allModelsSelect.remove(i)
			}

			var Audi;
			var markaString = marka + "";
			for (var i = 0; i < eval("Audi1") ; i++) {
				newOption = document.createElement("option");
				newOption.text = audiModels[i];
				allModelsSelect.add(newOption);
			}

			if (marka == "Mercedes Benz") {
				for (var i = allModelsSelect.length; i > 0; i--) {
					allModelsSelect.remove(i)
				}

				for (var i = 0; i < mbModels.length; i++) {
					newOption = document.createElement("option");
					newOption.text = mbModels[i];
					allModelsSelect.add(newOption);
				}
			}

			console.log(marka);
		}
	</script>












</body>
</html>