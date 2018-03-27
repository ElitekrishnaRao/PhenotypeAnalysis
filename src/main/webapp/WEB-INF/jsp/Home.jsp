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
script type ="text/javascript" src ="../js/jqueryscripts.js "> </script>
	<link rel ="stylesheet" src ="../css/Custom.css "> <style>
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
		<p> The plants' phenotypic knowledge discovery is
			necessary for plant scientists, researchers and practitioners to make
			better decisions based on one's research requirements such as
			improving crop yields, deciding whether the treatment provided to the
			plant species is efficient or not, etc. With the rise of greenhouse
			facilities, numerous plant species are being grown year-round with
			varied environmental conditions. The images of these plants are
			captured for a sequence of days, in multiple views and angles using
			diverse imaging modalities. These images are used to compute various
			component based or holistic phenotypes using 2D or 3D image
			processing techniques. This project is motivated by the need to
			organize such high dimensional phenome data and explore various
			strategies to analyze, visualize and mine. In this project, we
			developed a data model by identifying principal entities related to
			the plants and implemented a prototype of integrated framework
			PhenomeD<sup>2</sup>. </p>
			
			<p> PhenomeD<sup>2</sup> is the integration of database querying,
			descriptive statistics, visualizations and data mining components. In
			this prototype, a few use cases are implemented in each of these
			components and other actions are listed that can be implemented in
			future. Our implementation integrates Weka, a data mining open source
			tool and Dygraphs, a Java script charting library for visualizing
			time series data that provides scope to include complex
			functionalities to the framework in future. We analysed the scope for
			expanding data model and include genome sequences for implementing
			QTL/GWAS mappings to relate the genotypes and phenotypes in future.</p>
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
		style="color: white; background-color: #000000;  bottom: 0; width: 100%; height: 30px;">
		 University Of Nebraska Lincoln - Plant Vision Initiative</div>


</body>
</html>