		<%@include file="header.jsp" %>
		
		<div class="text-center mx-5">
		<div class="input-group mb-3 w-25 p-3 form-group">
		
		<form action="save.com" method="POST">
		
				<input type="hidden" name="id"  value="${produit.id }"  class="form-control" >
		
			<p></p>
			
			<label class="control-label">
				designation :
			</label>
			
				<input type="text" name="designation" class="form-control" value="${produit.designation}">
		
			<p></p>
			<label class="control-label">
				Prix :
			</label>
			<input type="text" name="prix" class="form-control" value="${produit.prix}">
			<p></p>
			<label class="control-label">
				Quantite :
			</label>
			
			<input type="text" name="quantite" class="form-control" value="${produit.quantite}">
			<br>
			<br>
			<br>
			<button type="submit" class="btn btn-primary">update data</button>
		
		</form>
			
		</div>
		</div>
		</body>
		</html>