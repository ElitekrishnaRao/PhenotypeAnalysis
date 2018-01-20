<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Guest</title>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css" >
<link rel="stylesheet" type="text/css" href="../css/style.css" >
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
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
         <li class="active"><a href="Home.jsp">Home</a></li>
		 <li><a href="DatabaseQuerying.jsp">Database Querying</a></li>
		 <li><a href="DespStatsVisuals.jsp">Descriptive Statistics & Visualizations</a></li>
		 <li><a href="Datamining.jsp">Data Mining Tasks</a></li>
	 </ul>
	
</div>
</nav>

</body>
</html>