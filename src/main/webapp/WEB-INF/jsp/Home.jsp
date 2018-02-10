<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plant based database Querying</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
		integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
		crossorigin="anonymous"></script>
		
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<style>
		
<script type="text/javascript" src="../js/jqueryscripts.js"></script>
<link rel="stylesheet" src="../css/Custom.css">

<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 100%;
}
</style>

</head>
<body>

	<div class="container">
		<div class="header">
			<h3>Framework for Phenotypic Data Analysis</h3>
			<br>
		</div>
		<nav class="nav nav-pills">
			<a class="nav-link nav-item active" href="home">Home</a> 
			<a class="nav-link nav-item" href="query">Database Querying</a> 
			<a class="nav-link nav-item" href="stats">Descriptive Statistics & Visualizations</a> 
			<a class="nav-link nav-item" href="mine">Data Mining Tasks</a>
		</nav>
		<br>
		<p>Genotype and Phenotype are basic terms of biology that are
			related to each other. Genotype is a gene or set of genes which are
			responsible for genetic characteristics of organisms, usually
			inherited from parents. Phenotypes are observable characteristics of
			organisms such as physical or behavioural characteristics which
			results from interaction between genotypes and environment.</p>
		<br>

		<div class="row">
			<div class="col-4">
				<p>Below are the components for analysis on plant phenotype
					data:
				</li> <br>
				<ol>
					<li>Database Querying</li>
					<li>Descriptive Statistics and Visualizations</li>
					<li>Data Mining Tasks</li>
				</ol>
				</p>
			</div>

			<div class="col-8">
				<div id="demo" class="carousel slide" data-ride="carousel">

					<!-- Indicators -->
					<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1"></li>
						<li data-target="#demo" data-slide-to="2"></li>
					</ul>

					<!-- The slideshow -->
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="../img/PlantImage5.jpg" alt="Plant1" width="1100"
								height="500">
						</div>
						<div class="carousel-item">
							<img src="../img/PlantImage3.jpg" alt="Plant2" width="1100"
								height="500">
						</div>
						<div class="carousel-item">
							<img src="../img/PlantImage4.jpg" alt="Plant3" width="1100"
								height="500">
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="carousel-control-prev" href="#demo" data-slide="prev">
						<span class="carousel-control-prev-icon"></span>
					</a> <a class="carousel-control-next" href="#demo" data-slide="next">
						<span class="carousel-control-next-icon"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<!-- 	<script type="text/javascript" src="../js/dist/jquery-slim.min.js"></script>  -->
	<script type="text/javascript" src="../js/dist/popper.min.js"></script>
	<script type="text/javascript" src="../js/dist/util.js"></script>
	<script type="text/javascript" src="../js/dist/tab.js"></script>
	<script type="text/javascript" src="../js/dist/dropdown.js"></script>

</body>
</html>