<%@include file="Header.jsp"%>

<div class="container">
	<div class="header">
		<h3>Framework for Phenotypic Data Analysis</h3>
		<br>
	</div>
	<nav class="nav nav-pills">
			<a class="nav-link nav-item" href="home">Home</a>
			<a class="nav-link nav-item " href="query">Database Querying</a>
			<a class="nav-link nav-item active" href="stats">Descriptive Statistics
				& Visualizations</a> <a class="nav-link nav-item" href="mine">Data
				Mining Tasks</a>
		</nav>
</div>


<br>

	<div class="row">
		<br>
		<div class="container col-2">
			<h6>Select Here</h6>
			<form method="GET" class="px-2 py-2" action="DBQueryResults.jsp">
				<div class="form-group">
					<label for="inputsm">Species</label> <select
						onchange="myFunction();" name="species"
						class="form-control input-sm" id="speciesid">

						<c:forEach var="plant" items="${plantspeciesData}"
							varStatus="yourStatus">
							<option id="${yourStatus.index}" value="${plant.species_Name}"
								onclick='if (!document.getElementById("speciesid").onchange()) myFunction();'>${plant.species_Name}</option>
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

				<input type="submit" class="btn btn-primary" value="Clear Search" />
			</form>
		</div>



		<div class="container col-2">
			<h6>Search Here</h6>
			<div id="sidemabr1">
				<div class="btn-group dropright span9 btn-block no-padding">
					<button type="button"
						class="btn btn-primary btn-block dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Species, Plants, Phenotypes</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">View mean values</a> 
						<a class="dropdown-item" href="#">View median values</a>
						<a class="dropdown-item" href="#">View standard deviation values</a>
					</div>
				</div>
				<div class="btn-group dropright span9 btn-block no-padding">
					<button type="button"
						class="btn btn-secondary btn-block dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Species
						& Plants</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">View phenotypic data</a> <a
							class="dropdown-item" href="#">View genotypic data</a>
					</div>
				</div>
				<div class="btn-group dropright span9 btn-block no-padding">
					<button type="button"
						class="btn btn-secondary btn-block dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Species
						& Treatment</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">View plants list</a>
					</div>
				</div>
			</div>
		</div>

		<div class="container col-8">
			<p>Descriptive stats and visualizations</p>
			<p id="demo"></p>
		</div>
	</div>

<%@include file="Footer.jsp" %>