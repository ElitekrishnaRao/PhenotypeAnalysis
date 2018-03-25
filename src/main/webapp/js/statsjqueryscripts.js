$(function() {
		$('#myList a:last-child').tab('show');
		$('a[data-toggle="list"]').on('shown.bs.tab', function(e) {
			e.target // newly activated tab
			e.relatedTarget // previous active tab
		})
		$('.dropdown-item').click(function () {
			//console.log("clicked");
		window.location = $(this).attr('href');});
	});

//If a species Id is changed, then populate related plants and treatments in below drop downs
//function speciesChange(speciesId) {
//			var idx = speciesId.selectedIndex;
//			var which = speciesId.options[idx].value; 
//		    //document.getElementById("demo").innerHTML = "You selected" + which;
//		    $.get( "http://localhost:8080/PhenotypeAnalysis/web/plantsbyspecies/"+which, function( data ) {
//		    	var opts = $.parseJSON(data);
//                $('#plant-data').html('');
//                $.each(opts, function(i, d) {
//                    $('#plant-data').append('<option value="' + d.id + '">' + d.name + '</option>');
//                });
//                //Setting species Id in session
//                sessionStorage.setItem("speciesId", which);
//	    	});
//		    $.get( "http://localhost:8080/PhenotypeAnalysis/web/treatmentsbyspecies/"+which, function( data ) {
//		    	var opts = $.parseJSON(data);
//		    	$('#treatment-data').html('');
//		    	
//		        $.each(opts, function(i, d) {
//		        	 $('#treatment-data').append('<option value="' + d.id 
//								+ '">' + d.experimentType 
//								+ '-' + d.treatment 
//								+ '</option>');
//		        });
//			});
//		}

//function getSelectValues(select) {
//	  var result = [];
//	  var options = select && select.options;
//	  var opt;
//
//	  for (var i=0, iLen=options.length; i<iLen; i++) {
//	    opt = options[i];
//
//	    if (opt.selected) {
//	      //alert(opt);
//	      result.push(opt.value || opt.text);
//	    }
//	  }
//	  return result;
//	}

//Stats Functions
//Mean for phenotypes
function calphenomean(event) {
	var el = document.getElementsByTagName('select')[1];
	var plantIds =[];
	plantIds=getSelectValues(el);
	var speciesId=sessionStorage.getItem("speciesId");
	 $.get( "http://localhost:8080/PhenotypeAnalysis/web/phenmeansbyspplnts/"+speciesId+"/"+plantIds, function(data) {
			var opts = $.parseJSON(data);
			//console.log(opts);
			
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

//function phenotypesforgraphs(event) {
//	var speciesId=sessionStorage.getItem("speciesId");
//	//Specifying which select in JSP page selects multiple plants
//	var el = document.getElementsByTagName('select')[1];
//	var plantIds =[];
//	//Getting plants Id's of selected plants
//	plantIds=getSelectValues(el);
//	alert(speciesId);
//	$.get( "http://localhost:8080/PhenotypeAnalysis/web/phenotypesbyspplnts/"+speciesId+"/"+plantIds, function(data ) {
//		var opts = $.parseJSON(data);
//		$('#phenotypedatatable').dataTable({
//			data: opts,
//    		destroy: true,
//			"columns": [
//                { "data": "image.plant.id",
//                   title: "Plant ID"},
//                { "data": "image.view",
//                   title: "View"},
//                { "data": "image.date",
//                   title: "Date"},
//                { "data": "convexHullArea",
//                   title: "Convex Hull Area"}
//            ]  		 			
//		 });	
//	});
//	sessionStorage.setItem("plantIds", plantIds);
//}
