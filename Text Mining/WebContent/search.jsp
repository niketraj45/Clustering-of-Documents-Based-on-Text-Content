<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="com.impl.Constants"%>
<%@page import="com.impl.propertyImpl"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Clustering</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	

<div id="wrapper1">
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo"> <span class="icon icon-cogs"></span>
				<h1><a href="#">Clustering of Documents Based on Text Content
</a></h1>
				 </div>
			<div id="menu">
				<ul>
					<li class="current_page_item"><a href="index.jsp" accesskey="1" title="">Homepage</a></li>
					<li><a href="./Controller?task=getcluster" accesskey="2" title="">Search Data</a></li>
					
				</ul>
		</div>
		</div>
	</div>
	<div id="wrapper2">
		<div id="welcome" class="container"style="width:auto;" >
			<div class="title">
                            <h2>Welcome User</h2>
                            <h3>Search For Documents :-</h3>
			</div>
			
			<form action="Controller?task=search" method="post">
	<table>
	<tr><td>Please Select the type of domain to be searched:-</td><td>
	<select id="cluster" name = "cluster">
	<% String[] clusterNames = (String[])session.getAttribute("Clusters");
			for(String str:clusterNames){
				
			%>
	<option value="<%=str%>"><%=str %></option>
	<%} %>
	</select>
	</td>
	<td><input type="submit" value="Search"/></td>
	</tr>
	</table>
	</form>
		</div>
	</div>
	
</div>
</body>
</html>