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
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
	integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
	crossorigin="anonymous"></script>

<script>
	$(function() {
		$('#myList a:last-child').tab('show')
	})
</script>
<script>
	$('a[data-toggle="list"]').on('shown.bs.tab', function(e) {
		e.target // newly activated tab
		e.relatedTarget // previous active tab
	})
</script>
<style>
div#sidemabr1 button {
    font-size: 16px;
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
			<a class="nav-link nav-item" href="home">Home</a>
			<!--  <a class="nav-link nav-item dropdown-toggle active" data-toggle="dropdown" href="query">Database Querying</a> -->

			<div class="nav-item dropdown">
				<a class="nav-link dropdown-toggle active" href="query" id="dbquery"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Database
					Querying</a>
				<div class="dropdown-menu" aria-labelledby="dropdown5">
					<a class="dropdown-item" data-toggle="tab" href="plant">Plant
						Based</a> <a class="dropdown-item" data-toggle="tab" href="image">Image
						Based</a> <a class="dropdown-item" data-toggle="tab" href="adhoc">Adhoc</a>
				</div>
			</div>

			<a class="nav-link nav-item" href="stats">Descriptive Statistics
				& Visualizations</a> <a class="nav-link nav-item" href="mine">Data
				Mining Tasks</a>
		</nav>
	</div>


	<br>



	<div class="container">


		
				<div class="row">
					<div class="col-3">
						<!--  
						<div class="list-group" id="list-tab" role="tablist">
							<a class="list-group-item list-group-item-action active"
								id="list-plant-list" data-toggle="list" href="#list-plant"
								role="tab" aria-controls="plant">Plant Based</a> <a
								class="list-group-item list-group-item-action"
								id="list-image-list" data-toggle="list" href="#list-image"
								role="tab" aria-controls="image">Image Based</a> <a
								class="list-group-item list-group-item-action"
								id="list-adhoc-list" data-toggle="list" href="#list-adhoc"
								role="tab" aria-controls="adhoc">Adhoc</a>
						</div> 
						
						-->
						<div class="container">
						<h6>Search Here</h6>
						<div id="sidemabr1">
						<div class="btn-group dropright span9 btn-block no-padding">
							<button type="button" class="btn btn-primary btn-block dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Species</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">View plants list</a>
								<a class="dropdown-item" href="#">View treatments given</a>
							</div>
						</div>
						<div class="btn-group dropright span9 btn-block no-padding">
							<button type="button" class="btn btn-secondary btn-block dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Species & Plants</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">View phenotypic data</a> 
								<a class="dropdown-item" href="#">View genotypic data</a> 
							</div>
						</div>
						<div class="btn-group dropright span9 btn-block no-padding">
							<button type="button" class="btn btn-secondary btn-block dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Species & Treatment</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">View plants list</a> 
							</div>
						</div>
						</div>
						</div>
						<br>
						<div class="container">
							<h6>Select Here</h6>
							<form method="GET" class="px-2 py-2" action="DBQueryResults.jsp">
								<div class="form-group">
									<label for="inputsm">Species</label> <select name="species"
										class="form-control input-sm" id="inputsm">

										<c:forEach var="plant" items="${plantspeciesData}">
											<option value="${plant.species_Name}">${plant.species_Name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>Plants</label> <select multiple name="plants"
										class="form-control">
										<c:forEach var="plant" items="${plantData}">
											<option value="${plant.plant_Name}">${plant.plant_Name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group ">
									<label>Treatments</label> <select name="treatments"
										class="form-control">
										<c:forEach var="treatment" items="${treatmentData}">
											<option value="${treatment.treatment_Id}">${treatment.treatment_Id}
												- ${treatment.watering} , ${treatment.phosphorus}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>Phenotypes</label> <select multiple name="phenotypes"
										class="form-control">
										<option value="none">none</option>
									</select>
								</div>
								<div class="form-group">
									<label>Genotypes</label> <select name="genotypes"
										class="form-control">
										<c:forEach var="genotype" items="${genotypeData}">
											<option value="${genotype.genotype_Id}">${genotype.genotype_Id}
												- ${genotype.genotype}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>Views</label> <select name="views" class="form-control">
										<option value="none">none</option>
									</select>
								</div>

								<input type="submit" class="btn btn-primary"
									value="Clear Search" />
							</form>
						</div>

					</div>
					
					<div class="col-9">
					<p>
									Here you can perform dababase querying based on plants and
									obtain associated phenotypic, genotypic, treatments data. </p>
					</div>

					
				</div>
			
	</div>

	<script src="https://code.jquery.com/jquery-2.2.4.min.js"
		integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/dist/jquery-slim.min.js"></script>
	<script type="text/javascript" src="../js/dist/popper.min.js"></script>
	<script type="text/javascript" src="../js/dist/util.js"></script>
	<script type="text/javascript" src="../js/dist/tab.js"></script>
	<script type="text/javascript" src="../js/dist/dropdown.js"></script>


</body>
</html>