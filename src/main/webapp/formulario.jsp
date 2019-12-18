<%@ include file="includes/header.jsp" %>

<h1> Formulario.jsp </h1>

<form action="libros" method="post">
	<label for="id"> Id:</label>
	<input type="text" name="id" id="id"/>
	<br />

	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" id="nombre"/>
	<br />

	<label for="precio">Precio:</label>
	<input type="text" name="precio" id="precio"/>
	<br />

	<label for="descuento">Descuento:</label>
	<input type="text" name="descuento" id="descuento"/>
	<br />

	<button type="submit"> Enviar</button>
</form>


<%@ include file="includes/footer.jsp" %>