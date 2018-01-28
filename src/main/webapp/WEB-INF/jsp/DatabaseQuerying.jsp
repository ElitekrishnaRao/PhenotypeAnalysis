<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Querying</title>
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

</head>
<body>



	<div class="container">
		<div class="header">
			<h3>Framework for Phenotypic Data Analysis</h3>
			<br>
		</div>
		<nav class="nav nav-pills">
			<a class="nav-link nav-item" href="home">Home</a> <a
				class="nav-link nav-item active" href="query">Database Querying</a>
			<a class="nav-link nav-item" href="stats">Descriptive Statistics
				& Visualizations</a> <a class="nav-link nav-item" href="mine">Datamining
				Tasks</a>
			<!-- <div class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="dropdown5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
		          <div class="dropdown-menu" aria-labelledby="dropdown5">
		            <a class="dropdown-item" data-toggle="tab" href="#fat5">@fat</a>
		            <a class="dropdown-item" data-toggle="tab" href="#mdo5">@mdo</a>
		          </div> -->

		</nav>
	</div>


	<br>



	<div class="container">


		<div class="row">
			<div class="col-9">
				<div class="row">
					<div class="col-4">
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
					</div>
					<div class="col-8">
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="list-plant"
								role="tabpanel" aria-labelledby="list-plant-list">
								<p>
									Here you can perform dababase querying based on plants and
									obtain associated phenotypic, genotypic, treatments data. <br>
									<br> <b>Select a species </b><br>
									<button type="button" class="btn btn-primary btn-sm">View
										list of plants</button>
									<br>
									<button type="button" class="btn btn-primary btn-sm">View
										different treatments given for plants</button>
									<br> <br> <b></>Select species and plants </b><br>
									<button type="button" class="btn btn-primary btn-sm">View
										phenotypic data</button>
									<br>
									<button type="button" class="btn btn-primary btn-sm">View
										genotypic data</button>
									<br>
									<button type="button" class="btn btn-primary btn-sm">View
										list of plants</button>
									<br> <br> <b></>Select species and treatment </b><br>
									<button type="button" class="btn btn-primary btn-sm">View
										all plants with this treatment</button>
									<br> <br>

								</p>
							</div>
							<div class="tab-pane fade" id="list-image" role="tabpanel"
								aria-labelledby="list-image-list">
								<p>
									Here you can perform dababase querying based on images like
									viewing sequence of images of particular plant life cycle,
									viewing image of a plant for a particular day to view the
									growth of plant, etc.<br> <br> <b>Select a
										species and plant </b><br>
									<button type="button" class="btn btn-primary btn-sm">View
										image sequence</button>
									<br>

								</p>
							</div>

							<div class="tab-pane fade" id="list-adhoc" role="tabpanel"
								aria-labelledby="list-adhoc-list">
								<p>
									Here you can perform adhoc dababase queries based on analysis
									being performed. For instance <br> <br>
									<button type="button" class="btn btn-primary btn-sm">View
										list of all phenotypes</button>
									<br>
								</p>
							</div>
							<div class="tab-pane fade" id="list-settings" role="tabpanel"
								aria-labelledby="list-settings-list">...</div>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="col-3" >

				<h4>Search Here</h4>
				<br>
				<form method="GET" class="lgnForm" action="DBQueryResults.jsp">
					<div class="form-group">
						<label>Species</label> <select name="species" class="form-control">
							
							<c:forEach var="plant" items="${plantspeciesData}">
								<option value="${plant.species_Name}">${plant.species_Name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Plants</label> <select name="plants" class="form-control">
							<c:forEach var="plant" items="${plantData}">
								<option value="${plant.plant_Name}">${plant.plant_Name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group ">
						<label>Treatments</label> <select name="treatments" class="form-control">
							<c:forEach var="treatment" items="${treatmentData}">
								<option value="${treatment.treatment_Id}">${treatment.treatment_Id} - ${treatment.watering} , ${treatment.phosphorus}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Phenotypes</label> <select name="phenotypes"
							class="form-control">
							<option value="none">none</option>
						</select>
					</div>
					<div class="form-group">
						<label>Genotypes</label> <select name="genotypes"
							class="form-control">
							<option value="none">none</option>
						</select>
					</div>
					<div class="form-group">
						<label>Views</label> <select name="views" class="form-control">
							<option value="none">none</option>
						</select>
					</div>

					<input type="submit" class="btn btn-primary" value="Clear Search" />
				</form>
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