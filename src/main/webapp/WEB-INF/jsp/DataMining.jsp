<%@include file="Header.jsp"%>

<h2 style="color:white; background-color: #39ac39; ">PDA Framework</h2>
			<br>
	
<div class="container">
	
	<nav class="nav nav-pills nav-fill">
			<a class="nav-link nav-item" href="home">Home</a>
			<a class="nav-link nav-item " href="query">Database Querying</a>
			<a class="nav-link nav-item active" href="stats">Descriptive Statistics
				& Visualizations</a> <a class="nav-link nav-item" href="mine">Data
				Mining Tasks</a>
		</nav>
</div>
<br>


	<div id="graphdiv"></div>
<script type="text/javascript">


  g = new Dygraph(

    // containing div
    document.getElementById("graphdiv"),

    // CSV or path to a CSV file.
    "Date,Temperature\n" +
    "2008-05-07,75\n" +
    "2008-05-08,70\n" +
    "2008-05-09,80\n"

  );
</script>

<%@include file="Footer.jsp" %>