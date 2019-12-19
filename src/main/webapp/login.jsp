<%@ include file="/includes/header.jsp" %>

<h1> Login </h1>

<form action="login" method="get">
	<div class="form-group">
		<label for="usuario"> Usuario </label>
		<input type="text"
			class="form-control"
			name="usuario" id="usuario"
			placeholder="admin"
		/>
	</div>
	<div class="form-group">
		<label for="password"> Contraseña </label>
		<input type="text"
			class="form-control"
			name="password" id="password"
			placeholder="123456"
		/>
	</div>
	<button type="submit" class="btn btn-outline-secondary btn-block"> Enviar </button>
</form>

<%@ include file="/includes/footer.jsp" %>