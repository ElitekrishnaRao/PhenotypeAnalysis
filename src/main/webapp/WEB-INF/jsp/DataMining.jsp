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
  $(function () {
    $('#myList a:last-child').tab('show')
  })
</script>
<script>
$('a[data-toggle="list"]').on('shown.bs.tab', function (e) {
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
				class="nav-link nav-item" href="query">Database Querying</a> <a
				class="nav-link nav-item" href="stats">Descriptive Statistics &
				Visualizations</a> <a class="nav-link nav-item active" href="mine">Datamining
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