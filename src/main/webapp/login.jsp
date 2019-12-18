<%@ include file="/includes/header.jsp" %>

<h1> Login </h1>

<form action="login" method="get">
	<div class="form-group">
		<label for="email"> Correo electronico </label>
		<input type="text"
			class="form-control"
			name="email" id="email"
			placeholder="joseba@gmail.com"
		/>
	</div>
	<div class="form-group">
		<label for="password"> Contraseña </label>
		<input type="text"
			class="form-control"
			name="password" id="password"
		/>
	</div>
	<button type="submit" class="btn btn-outline-secondary btn-block"> Enviar </button>
</form>

<%@ include file="/includes/footer.jsp" %>