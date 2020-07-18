<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


		<!-- SIMPLE SEARCH FORM -->

		<div class="row">
			<form action="/autinjo/controllerTEST/search" class="filterForm p-3" style="width: 100%">
			  <div class="row align-items-center">
			  	<div class="col-lg col-sm-6">
			  		<div class="form-group">
					    <label for="marka">Marka</label>
					    <select class="form-control" onchange="getBrand()" id="marka" name="marka">
					      <option disabled="" selected="">Izaberi marku</option>
					      <c:forEach items="${allBrands}" var="brand">
					      	<option> ${brand.naziv} </option>
					      </c:forEach>
					    </select>
					 </div>
			  	</div>
			  	<div class="col-lg col-sm-6">
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
			  	<div class="col-lg col-sm-6">
			  		<div class="form-group">
			    		<label for="cenaDo">Cena do</label>
			   			<input type="number" class="form-control" id="cenaDo" min="0" step="10" name="cenaDo">
			  		</div>
			  	</div>
			  	<div class="col-lg col-sm-6">
			  		<div class="form-group">
			    		<label for="godisteOd">Godište od</label>
			   			<input type="number" class="form-control" id="godisteOd" min="1900" max="2020" name="godisteOd">
			  		</div>
			  	</div>
			  </div>


			  

			  <div class="row">
			  	<div class="col-lg text-center mb-3">
			  		<button type="submit" class="btn btn-primary btn-lg" id="searchButton">Traži</button>		
			  	</div>
			  </div>
			  
			  <div class="row">
			  	<div class="col-lg text-center">
			  		<a href="/autinjo/pages/homeDetailSearch.jsp" class="btn btn-outline-dark text-gray" role="button"> Detaljna pretraga </a>
			  	</div>
			  </div>
			  

			</form>
		</div>
