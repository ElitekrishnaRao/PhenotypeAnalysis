$(function() {
		$('#myList a:last-child').tab('show');
		$('a[data-toggle="list"]').on('shown.bs.tab', function(e) {
			e.target // newly activated tab
			e.relatedTarget // previous active tab
		})
		$('.dropdown-item').click(function () {
			console.log("clicked");
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


