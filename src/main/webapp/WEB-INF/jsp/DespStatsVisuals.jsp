<%@include file="Header.jsp"%>

<h2 style="color: white; background-color: #000000;">
	<img src="../img/Logo4.PNG">
</h2>


<div class="container" style="color: black; background-color: #E8E8E8;">
	<nav class="nav nav-pills nav-fill">
		<a class="nav-link nav-item" href="home">Home</a> <a
			class="nav-link nav-item " href="query">Database Querying</a> <a
			class="nav-link nav-item active" href="stats">Descriptive
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
		<form method="GET" class="px-2 py-2" action="/query">

			<label for="inputsm">Species</label> <select name="species"
				class="form-control input-sm" id="speciesid"
				onchange="speciesChange(this);">
				<option>-- Select Species --</option>
				<c:forEach var="species" items="${plantspeciesData}"
					varStatus="yourStatus">
					<option id="${yourStatus.index}" value="${species.id}">${species.speciesName}</option>
				</c:forEach>
			</select> <label>Plants</label> <select multiple name="plants" id="plant-data"
				class="form-control">
				<option>-- Plants --</option>
			</select> <label>Treatments</label> <select multiple name="treatments"
				id="treatment-data" class="form-control">
				<option>-- Treatments --</option>
			</select> <label>Phenotypes</label> <select multiple name="phenotypes"
				class="form-control">
				<!-- <option value="all">All</option> -->
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
			</select> <label>Viewing Angle</label> <select name="views"
				class="form-control" id="viewSelected">
				<option value="0">0</option>
				<option value="72">72</option>
				<option value="144">144</option>
				<option value="216">216</option>
				<option value="288">288</option>
			</select> <br> <input type="submit" class="btn btn-secondary"
				value="Clear Search" />
		</form>
	</div>



	<div class="container col-2">

		<div id="sidemabr1">
			<h6>Descriptive Statistics</h6>
			<br>


			<h6>Select..</h6>
			<button type="button"
				class="btn btn-success btn-block dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Species,
				Plants & Phenotypes</button>

			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="calphenomean()">View mean values</button>
			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="calphenmedian()">View median values</button>
			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="calphenstdev()">View standard
				deviation values</button>
			<p></p>
			<h6>Visualizations</h6>
			<br>
			<h6>Select..</h6>
			<button type="button"
				class="btn btn-success btn-block dropdown-toggle"
				aria-haspopup="true" aria-expanded="false">Plants & Viewing
				angles</button>

			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="singlePlantMultipleViews()">Single
				Plant, Multiple View Angles</button>
			<button class="btn btn-secondary span9 btn-block no-padding"
				type="button" onclick="singleViewMultiplePlants()">Multiple
				Plants, Single View Angle</button>


			<!-- 	<div class="btn-group dropright span9 btn-block no-padding">
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
				</div>     -->
		</div>
	</div>

	<div class="container col-8 ScrollStyle" id="results-div">
		<p>Descriptive statistics/visualizations Results</p>
		<p id="demo"></p>

		<table id="phenmeantable"
			class="table table-striped table-bordered hidden" width="100%"
			cellspacing="0">
			<thead>
				<tr>
					<th>Plant ID</th>
					<th>View Angle</th>
					<th>CHA Mean</th>
					<th>PPA Mean</th>
					<th>AD Mean</th>
					<th>BBH Mean</th>
					<th>ECD Mean</th>
					<th>AR Mean</th>
				</tr>
			</thead>
		</table>
		<div id="labels"></div>
		<br>
		<div id="graphdiv1"></div>
		<div id="graphdiv2"></div>


		<div id="graphdiv3"></div>
		<div id="graphdiv4"></div>


		<div id="graphdiv5"></div>
		<div id="graphdiv6"></div>

		<script type="text/javascript">
			// for a single/multiple plants - CHA in different views (clear if we use it for single plant - shown in multiple views)
			
		</script>
	</div>
</div>
<%@include file="Footer.jsp"%>