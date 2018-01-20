<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Querying</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" >
<link rel="stylesheet" type="text/css" href="../css/style.css" >
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
<h2>Phenotype Data Analysis</h2>
</div>
<nav class='navbar navbar-default'>
<!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
      <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
      </button>
     <!--  <a href="#" class="navbar-brand">Brand</a> -->
  </div>
  <!-- Collection of nav links and other content for toggling -->
  
<div id="navbarCollapse" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
         <li><a href="home">Home</a></li>
		 <li class="active"><a href="query">Database Querying</a></li>
		 <li><a href="DespStatsVisuals.jsp">Descriptive Statistics & Visualizations</a></li>
		 <li><a href="Datamining.jsp">Data Mining Tasks</a></li>
	 </ul>
	
</div>
</nav>




<form method="GET" class="lgnForm" action="DBQueryResults.jsp">


<div class="container">

<div class="row">
<div class="col">
<h2>Search Here</h2> <br>
<div class="form-group">
<label>Species</label>
<select name="species" class="form-control">
<option value="none">none</option>
</select>
</div>
<div class="form-group">
<label>Plants</label>
<select name="plants" class="form-control">
<option value="none">none</option>
</select>
</div>
<div class="form-group ">
<label>Treatments</label>
<select name="treatments" class="form-control">
<option value="none">none</option>
</select>
</div>
<div class="form-group">
<label>Phenotypes</label>
<select name="phenotypes" class="form-control">
<option value="none">none</option>
</select>
</div>
<div class="form-group">
<label>Genotypes</label>
<select name="genotypes" class="form-control">
<option value="none">none</option>
</select>
</div>
<div class="form-group">
<label>Views</label>
<select name="views" class="form-control">
<option value="none">none</option>
</select>
</div>

<input type="submit" class="btn btn-primary" value="Search" />
</div>

</div>
</div>
</form>
</body>
</html>