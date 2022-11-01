<%@page import="java.io.File"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Gestion  produit</title>
</head>
<body>

<%@include file="header.jsp"%>

	<div class="conatiner col-md-10 col-md-offset-1 text-center mt-5 p-5">
			<div class="panel panel-default">
				<div class="panel-heading mt-5">cherche des produit</div>
					<div class="panel-body mt-5">
								<form action="chercher.com" method="get">
									<label>mot cle</label>
									<input type="text" name="motcle" value="" />
									<button type="submit" class="btn btn-primary">chercher</button>
								</form>				
						
					</div>
									
			</div> 
	</div>
	<table class="table table-striped">
	<tr>
	<th>ID</th>
	<th>DESIGNATION</th>
	<th>PRIX</th>
	<th>QUANTITE</th>
	<th>delete</th>
	<th>update</th>
	</tr>
	<c:forEach items="${model.produits}" var="p">
	<tr>
	<td>${p.id}</td>
	<td>${p.designation}</td>
	<td>${p.prix}</td>
	<td>${p.quantite}</td>
	<td><a onclick="return confirm('etes-vous sure supprimer le produit?')"href="delet.com?id=${p.id}">Delete</a></td>
	<td> <a href="update.com?id=${p.id}">update</a> </td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>