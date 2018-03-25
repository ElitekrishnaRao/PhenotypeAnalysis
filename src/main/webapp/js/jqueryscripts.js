$(function() {
		$('#myList a:last-child').tab('show');
		$('a[data-toggle="list"]').on('shown.bs.tab', function(e) {
			e.target // newly activated tab
			e.relatedTarget // previous active tab
		})
		$('.dropdown-item').click(function () {
		//	console.log("clicked");
		window.location = $(this).attr('href');});
	});
$(document).ready(function() {
    $('#example').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
} );

function clearForm(){
	$("#queryForm").get(0).reset();
}

//If a species Id is changed, then populate related plants and treatments in below drop downs
function speciesChange(speciesId) {
			var idx = speciesId.selectedIndex;
			var which = speciesId.options[idx].value; 
		    //document.getElementById("demo").innerHTML = "You selected" + which;
		    $.get( "http://localhost:8080/PhenotypeAnalysis/web/plantsbyspecies/"+which, function( data ) {
		    	var opts = $.parseJSON(data);
                $('#plant-data').html('');
                $.each(opts, function(i, d) {
                    $('#plant-data').append('<option value="' + d.id + '">' + d.name + '</option>');
                });
                //Setting species Id in session
                sessionStorage.setItem("speciesId", which);
	    	});
		    $.get( "http://localhost:8080/PhenotypeAnalysis/web/treatmentsbyspecies/"+which, function( data ) {
		    	var opts = $.parseJSON(data);
		    	$('#treatment-data').html('');
		        $.each(opts, function(i, d) {
		        	 $('#treatment-data').append('<option value="' + d.id + '">' + d.experimentType + '-' + d.treatment + '</option>');
		        });
			});
		}	

// To get list of plants with selected species Id
function plantslistbyspecies(event) {
	var speciesId=sessionStorage.getItem("speciesId");
	//alert(speciesId);
	$.get( "http://localhost:8080/PhenotypeAnalysis/web/plantsbyspecies/"+speciesId, function( data ) {
    	var opts = $.parseJSON(data);
    	$('#plantslisttable').dataTable({
    		data: opts,
    		//$('#results-div div').empty();
    		destroy: true,
    		dom: 'Bfrtip',
            buttons: [
                'copy', 'csv', 'excel', 'pdf', 'print'
            ],
    		"columns": [
                { "data": "id",
                   title: "Plant ID"},
                { "data": "name",
                	title: "Plant Name"}
            ]
    	});
	});
}
//Plants list by species and treatments selected
function plantsbysptrtmnts(event) {
	var speciesId=sessionStorage.getItem("speciesId");
	//Specifying which select in JSP page selects multiple plants
	var el = document.getElementsByTagName('select')[2];
	var treatmentIds =[];
	//Getting plants Id's of selected plants
	treatmentIds=getSelectValues(el);
	//alert(speciesId+" "+treatmentIds);
	
	$.get( "http://localhost:8080/PhenotypeAnalysis/web/plantsbysptrtmnts/"+speciesId+"/"+treatmentIds, function(data ) {
		var opts = $.parseJSON(data);
		//consol.log(opts);
		//$('#results-div div').empty(); 
		
		$('#plantsbysptreatments').dataTable({
    		data: opts,
    		destroy: true,
    		dom: 'Bfrtip',
            buttons: [
                'copy', 'csv', 'excel', 'pdf', 'print'
            ],
    		"columns": [
                { "data": "id",
                   title: "Plant ID"},
                { "data": "name",
                	title: "Plant Name"},
                { "data": "treatmentId",
                   	title: "Treatment ID"} 	
            ]
    	});
	});
}


// To get list of treatments with selected species Id
function treatmentslistbyspecies(event) {
	var speciesId=sessionStorage.getItem("speciesId");
	$.get( "http://localhost:8080/PhenotypeAnalysis/web/treatmentsbyspecies/"+speciesId, function( data ) {
    	var opts = $.parseJSON(data);
    	$('#treatmentdatatable').dataTable({
    		data: opts,
    		destroy: true,
    		dom: 'Bfrtip',
            buttons: [
                'copy', 'csv', 'excel', 'pdf', 'print'
            ],
    		"columns": [
                { "data": "id",
                   title: "Treatment ID"},
                { "data": "environmentType",
                	title: "Environment Type"},
                { "data": "experimentType",
                    title: "Experiment Type"},
                { "data": "treatment",
                	title: "Treatment"}
            ]
    	});
	});
}

//To get phenotypes data for selected species Id, and plants (single/multiple)
function phenotypesbyspplnts(event) {
	var speciesId=sessionStorage.getItem("speciesId");
	//Specifying which select in JSP page selects multiple plants
	var el = document.getElementsByTagName('select')[1];
	var plantIds =[];
	//Getting plants Id's of selected plants
	plantIds=getSelectValues(el);
	//alert(plantIds);
	$.get( "http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"+speciesId+"/"+plantIds, function(data ) {
		var opts = $.parseJSON(data);
		//console.log(opts);
		
		//$('#results-div div').empty();
		$('#phenotypedatatable').dataTable({
			data: opts,
    		destroy: true,
    		dom: 'Bfrtip',
            buttons: [
                'copy', 'csv', 'excel', 'pdf', 'print'
            ],
			"columns": [
                { "data": "image.plant.id",
                   title: "Plant ID"},
                { "data": "image.view",
                   title: "View"},
                { "data": "image.date",
                   title: "Date"},
                { "data": "convexHullArea",
                   title: "Convex Hull Area",
                   "render": function(data, type, row){ 
                	   return Math.round(data*100)/100;
                   }
                },  
                { "data": "plantPixelArea",
                   title: "Plant Pixel Area"},
                { "data": "arealDensity",
                   title: "Areal Density",
                   "render": function(data, type, row){ 
                	   return Math.round(data*100)/100;
                   }
                },
                { "data": "boundingBoxHt",
                   title: "Bounding Box Height"},
                { "data": "enclosingCircleDiameter",
                   title: "Enclosing Circle Diameter"},
                { "data": "aspectRatio",
                   title: "Aspect Ratio"}  
            ]  		 			
		 });
		
	});
	sessionStorage.setItem("plantIds", plantIds);
}

function phenotypesbyspplntstrmnts(event) {
	var speciesId=sessionStorage.getItem("speciesId");
	
	//Specifying which select in JSP page selects multiple plants
	var el = document.getElementsByTagName('select')[1];
	var plantIds =[];
	//Getting plants Id's of selected plants
	plantIds=getSelectValues(el);
	//alert(plantIds);
	
//	var elt = document.getElementsByTagName('select')[2];
//	var treatmentIds =[];
//	treatmentIds=getSelectValues(elt);
//	alert(treatmentIds);
	
	var selectedPhen = document.getElementById("phenotype-selected");
	var phenChosen = selectedPhen.options[selectedPhen.selectedIndex].value;
	var phenotype =[];
	//alert(phenChosen);
	
	$.get( "http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"+speciesId+"/"+plantIds, function(data ) {
		var opts = $.parseJSON(data);
		//console.log(opts);
		
		if (phenChosen=="cha" ) {
			phenotype="convexHullArea";
			alert(phenotype);
		} 
		else if (phenChosen=="ppa") {
			phenotype="plantPixelArea";
		} 
		else if (phenChosen=="ad") {
			phenotype="arealDensity";
		}
		else if (phenChosen=="bbh") {
			phenotype="boundingBoxHt";
		} 
		else if (phenChosen=="ecd") {
			phenotype="enclosingCircleDiameter";
		} 
		else if (phenChosen=="ar") {
			phenotype="aspectRatio";
		} 
		else{
			alert("Phenotype not specified");
		}
		
		$('#phenotypedatatable').dataTable({
			data: opts,
    		destroy: true,
    		dom: 'Bfrtip',
            buttons: [
                'copy', 'csv', 'excel', 'pdf', 'print'
            ],
			"columns": [
                { "data": "image.plant.id",
                   title: "Plant ID"},
                { "data": "image.view",
                   title: "View"},
                { "data": "image.date",
                   title: "Date"},
                { "data": phenotype,
                   title: phenotype},
                { "data": "image.plant.treatmentId",
                   title: "Treatment Id"} 
            ]  		 			
		 });
		
		//$('#results-div div').empty();
//		$('#phenotypedatatable').dataTable({
//			data: opts,
//    		destroy: true,
//    		dom: 'Bfrtip',
//            buttons: [
//                'copy', 'csv', 'excel', 'pdf', 'print'
//            ],
//			"columns": [
//                { "data": "image.plant.id",
//                   title: "Plant ID"},
//                { "data": "image.view",
//                   title: "View"},
//                { "data": "image.date",
//                   title: "Date"},
//                { "data": "convexHullArea",
//                   title: "Convex Hull Area"},  
//                { "data": "plantPixelArea",
//                   title: "Plant Pixel Area"},
//                { "data": "arealDensity",
//                   title: "Areal Density"},
//                { "data": "boundingBoxHt",
//                   title: "Bounding Box Height"},
//                { "data": "enclosingCircleDiameter",
//                   title: "Enclosing Circle Diameter"},
//                { "data": "aspectRatio",
//                   title: "Aspect Ratio"}  
//            ]  		 			
//		 });
		
	});
	//sessionStorage.setItem("plantIds", plantIds);
}



function getSelectValues(select) {
	  var result = [];
	  var options = select && select.options;
	  var opt;

	  for (var i=0, iLen=options.length; i<iLen; i++) {
	    opt = options[i];

	    if (opt.selected) {
	     // alert(opt);
	      result.push(opt.value || opt.text);
	    }
	  }
	  return result;
	}

//Image sequence for selected list of plants
function imagesequence(event) {
	//var plantsIds=sessionStorage.getItem("plantIds");
	var el = document.getElementsByTagName('select')[1];
	var plantsIds =[];
	//Getting plants Id's of selected plants
	plantsIds=getSelectValues(el);
	//alert(plantsIds);
	var speciesId=sessionStorage.getItem("speciesId");
	alert(plantsIds);
	 $.get( "http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"+speciesId+"/"+plantsIds, function(data ) {
			var opts = $.parseJSON(data);
			//console.log(opts);
			$('#phenotypedatatable').dataTable({
				data: opts,
	    		destroy: true,
	    		
				"columns": [
	                { "data": "image.plant.id",
	                   title: "Plant ID"},
	                { "data": "image.view",
	                   title: "View"},
	                { "data": "image.date",
	                   title: "Date"},
	                { "data": "image.filePath",
	                   title: "Image",
	                   "render": function(data, type, row){ 
	                	   return "<a href='..\\"+data+"' target='_blank' ><img src='..\\"+data+"' width='200px' /></a>";
	                	   	
	                   }  
	                 }
	            ]  		 			
			 });
		});
	
}



