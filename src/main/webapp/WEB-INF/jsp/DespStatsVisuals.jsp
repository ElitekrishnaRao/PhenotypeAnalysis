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
			function getDateVsChaChart(dataArray) {
				//alert('hello');
				//alert(dateArrayLength);
				var r = "Date,View Angle 0,View Angle 72\n";
				for (var i = 0; i < dataArray.length; i++) {
					if (dataArray[i].image.view == 0) {
						r += dataArray[i].image.date;
						r += "," + dataArray[i].convexHullArea;
						for (var j = 0; j < dataArray.length; j++) {
							if ((dataArray[j].image.date == dataArray[i].image.date)
									&& (dataArray[j].image.view == 72)) {
								//alert(dataArray[i].date + " -- "
								//		+ dataArray[j].date + "--"
								//		+ dataArray[j].view)
								r += "," + dataArray[j].convexHullArea;
							}

						}
						r += "\n";
					}
				}
				console.log(r);
				return r;
			}
			// for a single/multiple plants - PPA in different views (clear if we use it for single plant - shown in multiple views)
			function getDateVsPpaChart(dataArray) {
				var r = "Date,View Angle 0,View Angle 72\n";
				for (var i = 0; i < dataArray.length; i++) {
					if (dataArray[i].image.view == 0) {
						r += dataArray[i].image.date;
						r += "," + dataArray[i].plantPixelArea;
						for (var j = 0; j < dataArray.length; j++) {
							if ((dataArray[j].image.date == dataArray[i].image.date)
									&& (dataArray[j].image.view == 72)) {
								r += "," + dataArray[j].plantPixelArea;
							}
						}
						r += "\n";
					}
				}
				console.log(r);
				return r;
			}
			// for a single/multiple plants - Ad in different views (clear if we use it for single plant - shown in multiple views)
			function getDateVsAdChart(dataArray) {
				var r = "Date,View Angle 0,View Angle 72\n";
				for (var i = 0; i < dataArray.length; i++) {
					if (dataArray[i].image.view == 0) {
						r += dataArray[i].image.date;
						r += "," + dataArray[i].arealDensity;
						for (var j = 0; j < dataArray.length; j++) {
							if ((dataArray[j].image.date == dataArray[i].image.date)
									&& (dataArray[j].image.view == 72)) {
								r += "," + dataArray[j].arealDensity;
							}
						}
						r += "\n";
					}
				}
				console.log(r);
				return r;
			}
			// for a single/multiple plants - Bbh in different views (clear if we use it for single plant - shown in multiple views)
			function getDateVsBbhChart(dataArray) {
				var r = "Date,View Angle 0,View Angle 72\n";
				for (var i = 0; i < dataArray.length; i++) {
					if (dataArray[i].image.view == 0) {
						r += dataArray[i].image.date;
						r += "," + dataArray[i].boundingBoxHt;
						for (var j = 0; j < dataArray.length; j++) {
							if ((dataArray[j].image.date == dataArray[i].image.date)
									&& (dataArray[j].image.view == 72)) {
								r += "," + dataArray[j].boundingBoxHt;
							}
						}
						r += "\n";
					}
				}
				console.log(r);
				return r;
			}
			// for a single/multiple plants - Ad in different views (clear if we use it for single plant - shown in multiple views)
			function getDateVsEcdChart(dataArray) {
				var r = "Date,View Angle 0,View Angle 72\n";
				for (var i = 0; i < dataArray.length; i++) {
					if (dataArray[i].image.view == 0) {
						r += dataArray[i].image.date;
						r += "," + dataArray[i].enclosingCircleDiameter;
						for (var j = 0; j < dataArray.length; j++) {
							if ((dataArray[j].image.date == dataArray[i].image.date)
									&& (dataArray[j].image.view == 72)) {
								r += "," + dataArray[j].enclosingCircleDiameter;
							}
						}
						r += "\n";
					}
				}
				console.log(r);
				return r;
			}
			// for a single/multiple plants - Ar in different views (clear if we use it for single plant - shown in multiple views)
			function getDateVsArChart(dataArray) {
				var r = "Date,View Angle 0,View Angle 72\n";
				for (var i = 0; i < dataArray.length; i++) {
					if (dataArray[i].image.view == 0) {
						r += dataArray[i].image.date;
						r += "," + dataArray[i].aspectRatio;
						for (var j = 0; j < dataArray.length; j++) {
							if ((dataArray[j].image.date == dataArray[i].image.date)
									&& (dataArray[j].image.view == 72)) {
								r += "," + dataArray[j].aspectRatio;
							}
						}
						r += "\n";
					}
				}
				console.log(r);
				return r;
			}

			function getDateVsChaChartSingViewMulPlants(dataArray, plantIds,
					viewVal) {
				//alert(plantIds+"---"+viewVal);
				//alert(plantIds.length);
				var r = "Date";
				for (var i = 0; i < plantIds.length; i++) {
					r += ", CHA of Plant ID " + plantIds[i];
				}
				r += "\n";
				alert(r);
				alert(viewVal);
				//for (var i = 0; i < plantIds.length; i++) {
				for (var j = 0; j < dataArray.length; j++) {
					if (dataArray[j].image.view == viewVal) {
						r += dataArray[j].image.date;
						for (var i = 0; i < plantIds.length; i++) {
							if (plantIds[i] == dataArray[j].image.plant.id) {
								r += "," + dataArray[j].convexHullArea;
							}
						}
					}
					r += "\n";
					alert(r);

					//r += "," + dataArray[j].convexHullArea;
				}

				//}
				console.log(r);
				return r;
			}

			function singleViewMultiplePlants(event) {
				var speciesId = sessionStorage.getItem("speciesId");
				//Specifying which select in JSP page selects multiple plants
				var el = document.getElementsByTagName('select')[1];
				var plantIds = [];
				//Getting plants Id's of selected plants
				plantIds = getSelectValues(el);
				var e = document.getElementById("viewSelected");
				var viewVal = e.options[e.selectedIndex].value;
				//alert(viewVal);
				$.get(
						"http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"
								+ speciesId + "/" + plantIds, function(data) {
							var opts = $.parseJSON(data);
							data1 = getDateVsChaChartSingViewMulPlants(opts,
									plantIds, viewVal);
							var g1 = new Dygraph(document
									.getElementById("graphdiv1"), data1, {
								title : 'Days Vs Convex Hull Area',
								stackedGraph : false,
								labelsDiv : document.getElementById("labels"),
								ylabel : "Convex Hull Area (Pixels)",
								xlabel : "Days",
								legend : 'always',
								showRangeSelector : true
							});
						});
			}

			function singlePlantMultipleViews(event) {
				var speciesId = sessionStorage.getItem("speciesId");
				//Specifying which select in JSP page selects multiple plants
				var el = document.getElementsByTagName('select')[1];
				var plantIds = [];
				//Getting plants Id's of selected plants
				plantIds = getSelectValues(el);
				//alert(speciesId);
				$.get(
						"http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"
								+ speciesId + "/" + plantIds, function(data) {
							var opts = $.parseJSON(data);
							data1 = getDateVsChaChart(opts);
							var g1 = new Dygraph(document
									.getElementById("graphdiv1"), data1, {
								title : 'Days Vs Convex Hull Area',
								stackedGraph : false,
								labelsDiv : document.getElementById("labels"),
								ylabel : "Convex Hull Area (Pixels)",
								xlabel : "Days",
								legend : 'always',
								showRangeSelector : true
							});
							//alert('hi');
						});
				$.get(
						"http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"
								+ speciesId + "/" + plantIds, function(data) {
							var opts = $.parseJSON(data);
							data1 = getDateVsPpaChart(opts);
							var g1 = new Dygraph(document
									.getElementById("graphdiv2"), data1, {
								title : 'Days Vs Plant Pixel Area',
								stackedGraph : false,
								labelsDiv : document.getElementById("labels"),
								ylabel : "Plant Pixel Area (Pixels)",
								xlabel : "Days",
								legend : 'always',
								showRangeSelector : true
							});
						});
				$.get(
						"http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"
								+ speciesId + "/" + plantIds, function(data) {
							var opts = $.parseJSON(data);
							data1 = getDateVsAdChart(opts);
							var g1 = new Dygraph(document
									.getElementById("graphdiv3"), data1, {
								title : 'Days Vs Areal Density',
								stackedGraph : false,
								labelsDiv : document.getElementById("labels"),
								ylabel : "Areal Density",
								xlabel : "Days",
								legend : 'always',
								showRangeSelector : true
							});
						});
				$.get(
						"http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"
								+ speciesId + "/" + plantIds, function(data) {
							var opts = $.parseJSON(data);
							data1 = getDateVsBbhChart(opts);
							var g1 = new Dygraph(document
									.getElementById("graphdiv4"), data1, {
								title : 'Days Vs Bounding Box Height',
								stackedGraph : false,
								labelsDiv : document.getElementById("labels"),
								ylabel : "Bounding Box Height",
								xlabel : "Days",
								legend : 'always',
								showRangeSelector : true
							});
						});
				$.get(
						"http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"
								+ speciesId + "/" + plantIds, function(data) {
							var opts = $.parseJSON(data);
							data1 = getDateVsEcdChart(opts);
							var g1 = new Dygraph(document
									.getElementById("graphdiv5"), data1, {
								title : 'Days Vs Enclosing Circle Diameter',
								stackedGraph : false,
								labelsDiv : document.getElementById("labels"),
								ylabel : "Enclosing Circle Diameter",
								xlabel : "Days",
								legend : 'always',
								showRangeSelector : true
							});
						});
				$.get(
						"http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"
								+ speciesId + "/" + plantIds, function(data) {
							var opts = $.parseJSON(data);
							data1 = getDateVsArChart(opts);
							var g1 = new Dygraph(document
									.getElementById("graphdiv6"), data1, {
								title : 'Days Vs Aspect Ratio',
								stackedGraph : false,
								labelsDiv : document.getElementById("labels"),
								ylabel : "Aspect Ratio",
								xlabel : "Days",
								legend : 'always',
								showRangeSelector : true
							});
						});
			}
		</script>
	</div>
</div>
<%@include file="Footer.jsp"%>