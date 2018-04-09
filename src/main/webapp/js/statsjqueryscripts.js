$(function() {
		$('#myList a:last-child').tab('show');
		$('a[data-toggle="list"]').on('shown.bs.tab', function(e) {
			e.target // newly activated tab
			e.relatedTarget // previous active tab
		})
		$('.dropdown-item').click(function () {
			// console.log("clicked");
		window.location = $(this).attr('href');});
	});

// Stats Functions
// Mean for phenotypes
function calphenomean(event) {
	var el = document.getElementsByTagName('select')[1];
	var plantIds =[];
	plantIds=getSelectValues(el);
	var speciesId=sessionStorage.getItem("speciesId");
	if(!isValid(speciesId,plantIds)){
		alert("Both Species and plants should be selected in filter menu to generate data");
		return;
	}
	showOnlyActiveTable("phenmeantable");
	 $.get( "http://localhost:8080/PhenotypeAnalysis/web/phenmeansbyspplnts/"+speciesId+"/"+plantIds, function(data) {
			var opts = $.parseJSON(data);
			// console.log(opts);
			
			$('#phenmeantable').dataTable({
				"data": opts,
				destroy: true,
				dom: 'Bfrtip',
	            buttons: [
	                'copy', 'csv', 'excel', 'pdf', 'print'
	            ]
			 });
			$('#phenmeantable').removeClass("hidden");
	});
}

function invokeClassification(classifierName){
	 $.get( "http://localhost:8080/PhenotypeAnalysis/weka/wekaTest/"+classifierName, function(response) {
		 $('#results-div').html(response);
	});
}

function getDateVsChaChart(dataArray) {
	// alert('hello');
	// alert(dateArrayLength);
	var r = "Date,View Angle 0,View Angle 72\n";
	for (var i = 0; i < dataArray.length; i++) {
		if (dataArray[i].image.view == 0) {
			r += dataArray[i].image.date;
			r += "," + dataArray[i].convexHullArea;
			for (var j = 0; j < dataArray.length; j++) {
				if ((dataArray[j].image.date == dataArray[i].image.date)
						&& (dataArray[j].image.view == 72)) {
					// alert(dataArray[i].date + " -- "
					// + dataArray[j].date + "--"
					// + dataArray[j].view)
					r += "," + dataArray[j].convexHullArea;
				}

			}
			r += "\n";
		}
	}
	console.log(r);
	return r;
}
// for a single/multiple plants - PPA in different views (clear if we use it for
// single plant - shown in multiple views)
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
// for a single/multiple plants - Ad in different views (clear if we use it for
// single plant - shown in multiple views)
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
// for a single/multiple plants - Bbh in different views (clear if we use it for
// single plant - shown in multiple views)
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
// for a single/multiple plants - Ad in different views (clear if we use it for
// single plant - shown in multiple views)
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
// for a single/multiple plants - Ar in different views (clear if we use it for
// single plant - shown in multiple views)
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
	// alert(plantIds+"---"+viewVal);
	// alert(plantIds.length);
// var r = "Date";
// for (var i = 0; i < plantIds.length; i++) {
// r += ", CHA of Plant ID " + plantIds[i];
// }
// r += "\n";
	
	let array = [];
	
	let plantNames = [];
	
	plantNames.push("Dates");
	
	plantIds.forEach(val => {
		plantNames.push("CHA of "+val);
	})
	
	for (var j = 0; j < dataArray.length; j++) {
		let tempArray = [];
		if (dataArray[j].image.view == viewVal) {
			let date = dataArray[j].image.date;
			if(array[date] === undefined) {
				array[date] = new Array();
			}
			for (var i = 0; i < plantIds.length; i++) {
				if (plantIds[i] == dataArray[j].image.plant.id) {
// r += "," + dataArray[j].convexHullArea;
					array[date].push(dataArray[j].convexHullArea);
				}
			}
		}
	}
	
	let mainData = [];
	for (var key in array) {
	    let temp = [];
	    // console.log(new Date(key));
	    temp.push(new Date(key));
	    array[key].forEach(val => {
	    	temp.push(val);
	    })
	    mainData.push(temp);
	}
	//console.log(plantNames);
	return {
		data: mainData,
		labels: plantNames
	}
}

function singleViewMultiplePlants(event) {
	var speciesId = sessionStorage.getItem("speciesId");
	// Specifying which select in JSP page selects multiple plants
	var el = document.getElementsByTagName('select')[1];
	var plantIds = [];
	// Getting plants Id's of selected plants
	plantIds = getSelectValues(el);
	var e = document.getElementById("viewSelected");
	var viewVal = e.options[e.selectedIndex].value;
	// alert(viewVal);
	$.get(
			"http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"
					+ speciesId + "/" + plantIds, function(data) {
				var opts = $.parseJSON(data);
				data1 = getDateVsChaChartSingViewMulPlants(opts,
						plantIds, viewVal);
				var g1 = new Dygraph(document
						.getElementById("graphdiv1"), data1.data, {
					title : 'Days Vs Convex Hull Area',
					stackedGraph : false,
					labelsDiv : document.getElementById("labels"),
					ylabel : "Convex Hull Area (Pixels)",
					xlabel : "Days",
					legend : 'always',
					showRangeSelector : true,
					labels: data1.labels,
			          connectSeparatedPoints: true,
			          drawPoints: true
				});
			});
}

function singlePlantMultipleViews(event) {
	var speciesId = sessionStorage.getItem("speciesId");
	// Specifying which select in JSP page selects multiple plants
	var el = document.getElementsByTagName('select')[1];
	var plantIds = [];
	// Getting plants Id's of selected plants
	plantIds = getSelectValues(el);
	
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