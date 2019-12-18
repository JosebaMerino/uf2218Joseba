<%@ include file="includes/header.jsp" %>

<h1> Formulario.jsp </h1>

<div>
	<c:forEach items="${mensajes }" var="mensaje">
		<p style="color:red"> ${mensaje }</p>
	</c:forEach>
</div>

<form action="libros" method="post">

	<label for="nombre">Nombre:</label>
	<input type="text"
		name="nombre" id="nombre"
		value="${nombre }"
	/>
	<br />

	<label for="precio">Precio:</label>
	<input type="text"
		name="precio" id="precio"
		value="${precio }"
	/>
	<br />

	<label for="descuento">Descuento:</label>
	<input type="text"
		name="descuento" id="descuento"
		value="${descuento }"
	/>
	<br />

	<button type="submit"> Enviar</button>
</form>


<%@ include file="includes/footer.jsp" %>