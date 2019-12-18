<%@ include file="includes/header.jsp" %>

<h1> Formulario.jsp </h1>

<form action="libros" method="post">
	<input type="text" name="id" />
	<input type="text" name="nombre" />

	<button type="submit"> Enviar</button>
</form>


<%@ include file="includes/footer.jsp" %>