<%@include file="Header.jsp"%>

<h2 style="color: white; background-color: #000000;">
	<img src="../img/Logo4.PNG">
</h2>

<div class="container" style="color: black; background-color: #E8E8E8;">
	<nav class="nav nav-pills nav-fill">
		<a class="nav-link nav-item" href="home">Home</a> <a
			class="nav-link nav-item active" href="query" id="dbquery">Database
			Querying</a> <a class="nav-link nav-item" href="stats">Descriptive
			Statistics & Visualizations</a> <a class="nav-link nav-item"
			href="mining">Data Mining Tasks</a>
	</nav>
</div>
<br>

<div class="row">
	<br>
	<div class="container col-2"
		style="color: black; background-color: #DCDCDC;">
		<h6>Database Filters</h6>
		<form class="px-2 py-2" id="queryForm" >
			
			<label for="inputsm">Species</label> <select name="species"
				class="form-control input-sm" id="speciesid"
				onchange="speciesChange(this);">
				<option > -- Select Species -- </option>
				<c:forEach var="species" items="${plantspeciesData}"
					varStatus="yourStatus">
					<option id="${yourStatus.index}" value="${species.id}">${species.speciesName}</option>
				</c:forEach>
			</select> 
			
			
			<label>Plants</label> <select multiple name="plants" id="plant-data"
				class="form-control">
				<option > -- Plants -- </option>
			</select> 
			
			<label>Treatments</label> <select multiple name="treatments"
				id="treatment-data" class="form-control">
				<option > -- Treatments -- </option>
			</select> 
			
			<label>Phenotypes</label> <select multiple name="phenotypes"
				class="form-control" id="phenotype-selected">
				<!--  <option value="all">All</option> -->
				<option value="cha">Convex Hull Area</option>
				<option value="ppa">Plant Pixel Area</option>
				<option value="ad">Areal Density</option>
				<option value="bbh">Bounding Box Ht</option>
				<option value="ecd">Enclosing Circle Diameter</option>
				<option value="ar">Aspect Ratio</option>
			</select> <label>Genotypes</label> <select name="genotypes"
				class="form-control">
				<c:forEach var="genotype" items="${genotypeData}">
					<option value="${genotype.id}">${genotype.id}-
						${genotype.genotypeName}</option>
				</c:forEach>
			</select> <label>Viewing Angle</label> <select name="views" class="form-control">
				<option value="0">0</option>
				<option value="72">72</option>
				<option value="144">144</option>
				<option value="216">216</option>
				<option value="288">288</option>
			</select> <br> 
			<input type="button" onclick="clearForm()"
				class="btn btn-secondary" value="Clear Search" />
		</form>
	</div>

	<div class="container col-2">
		<h6>Database Querying Actions</h6>
		<br>


		<h6>Select..</h6>
		<div id="sidemabr1">


			<button type="button"
				class="btn btn-success btn-block dropdown-toggle"
				aria-haspopup="true" aria-expanded="false">Species</button>

			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="plantslistbyspecies()">View plants
				list</button>
			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="treatmentslistbyspecies()">View
				treatments given</button>



			<button type="button"
				class="btn btn-success btn-block dropdown-toggle"
				aria-haspopup="true" aria-expanded="false">Species & Plants</button>
			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" id="phenotype-data" onclick="phenotypesbyspplnts()">View
				phenotypes data</button>
			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="genotypesbyspplnts()">View genotypes
				data</button>
			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="imagesequence()">View image sequence</button>



			<button type="button"
				class="btn btn-success btn-block dropdown-toggle"
				aria-haspopup="true" aria-expanded="false">Species &
				Treatment</button>

			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="plantsbysptrtmnts()">View plants
				list</button>
			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" id="plant-phen-treat-data" onclick="phenotypesbyspplntstrmnts()">View
				phenotype, treatment data</button>	



			<!--   <div class="btn-group dropright span9 btn-block no-padding">
				<button type="button"
					class="btn btn-success btn-block dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Adhoc</button>
				<div class="dropdown-menu">
					<button class="btn btn-secondary right-button" type="button">View
						phenotypes list</button>
				</div>
			</div> -->
		</div>
	</div>

	<div class="container col-8 ScrollStyle" id="results-div">
		<p>Database Querying Results</p>
		<!-- <p id="demo"></p>   -->

		<table id="plantslisttable" class="table table-striped table-bordered"
			width="100%" cellspacing="0">
		</table>

		<table id="plantsbysptreatments"
			class="table table-striped table-bordered" width="100%"
			cellspacing="0">
		</table>

		<table id="phenotypedatatable"
			class="table table-striped table-bordered" width="100%"
			cellspacing="0">
		</table>
		
		<table id="imageseqtable"
			class="table table-striped table-bordered" width="100%"
			cellspacing="0">
		</table>

		<table id="treatmentdatatable"
			class="table table-striped table-bordered" width="100%"
			cellspacing="0">
		</table>

	</div>
</div>



<%@include file="Footer.jsp"%>