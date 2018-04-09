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
<
script type ="text /javascript" src ="../js /jqueryscripts.js "> </script>
	<link rel ="stylesheet " src ="../css /Custom.css "> <style>
	/* Make the image fully responsive */ .carousel-inner img {
	width: 100%;
	height: 100%;
}
</style>

</head>
<body background="../img/4.jpg">


	<h2 style="color: white; background-color: #000000;">
		<img src="../img/Logo4.PNG">
	</h2>



	<div class="container" style="color: black; background-color: #d1e0e0;">
		<nav class="nav nav-pills nav-fill">
			<a class="nav-link nav-item active" href="home">Home</a> <a
				class="nav-link nav-item" href="query">Database Querying</a> <a
				class="nav-link nav-item" href="stats">Descriptive Statistics &
				Visualizations</a> <a class="nav-link nav-item" href="mining">Data
				Mining Tasks</a>
		</nav>
	</div>
	<div class="container" style="color: black; background-color: white;">


		<br>
		<p> Knowledge discovery from plant phenotype information along
			with the genotype data is important for plant scientists, researchers
			and practitioners. It can lead to better understanding of
			physiological processes in plants at different stages of growth,
			under different treatments of nutrients and stress. In the long run,
			it can lead to development of crops that are tailored to different
			environments in order to maximize the yield. With the advent of
			high-throughput phenotyping systems, many experiments with diverse
			plant species under different growth conditions are being conducted
			to study phenotypes. These plants are imaged at multiple time points
			from multiple viewpoints and in different modalities. Researchers are
			computing a variety of phenotypes (holistic, component; static,
			dynamic; 2D, 3D) from these images. Currently, there is no mechanism
			to discover interesting patterns from diverse experiments since there
			is no unified framework to store the information from them. This
			project is motivated by the need to organize such high dimensional
			phenomic data and explore various strategies to analyze, visualize
			and mining the data. </p>
			
			<p>In this project, we have proposed an integrated framework called Data model and Data analytics on Phenomic
			data and developed a prototype, PhenomeD². The framework includes a
			data model that is used to store all the phenomic (and related)
			information in a relational database. The frontend of PhenomeD²
			supports: (a) database querying (b) computation of descriptive
			statistics and visualizations and (c) data mining. These modules
			provide mechanisms to explore and analyze patterns in the phenomic
			data. PhenomeD² integrates Weka, a widely used software for data
			mining. To support visualization of temporal patterns in phenomic
			data, PhenomeD² uses Dygraphs, a JavaScript-based charting library.
			The framework supports inclusion of genome sequences and integrating
			tools to enable QTL/GWAS mappings.
		</p>
		<br>

		<div class="row">
			<div class="col-6">
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

			<div class="col-6">
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
							<img src="../img/PlantImage5.jpg" alt="Plant1" width="700"
								height="300">
						</div>
						<div class="carousel-item">
							<img src="../img/PlantImage3.jpg" alt="Plant2" width="700"
								height="300">
						</div>
						<div class="carousel-item">
							<img src="../img/PlantImage4.jpg" alt="Plant3" width="700"
								height="300">
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




	<div id="footer"
		style="color: white; background-color: #000000; bottom: 0; width: 100%; height: 30px;">
		University Of Nebraska Lincoln - Plant Vision Initiative</div>


</body>
</html>