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

//Stats Functions
//Mean for phenotypes
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
