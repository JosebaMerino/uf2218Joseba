<%@ include file="/includes/header.jsp" %>

<h1> Pantalla de bienvenida</h1>

<style>
.libro .precios .precio-antiguo {
	color: grey;
	text-decoration:line-through;
}

.libro .precios .precio-descuento {
	color: red;
	font-size: 125%;
}

.libro .precios .descuento {
	color: white;
	background-color: red;
	padding: 3px;
}

.libro .nombre {
	color: grey;
}
.libro .autor {
	font-weight: bold;
}


</style>


<div class="row">
	<% for(int i = 0; i < 3; i++){ %>
	<div class="col-12 col-md-4 libro mb-3">
		<img src="https://www.libreriacanaima.com/imagenes/9788491/978849107941.JPG" alt="" />
		<hr />
		<div>
		<p class="nombre"> Los futbolisimos un musical que llega unos cuantos años despues de lo que deberia llegar pero mira, por lo menos ha llegado</p>
		<i class="far fa-heart"></i>
		<p class="autor">ANONIMO</p>
		</div>
		<div class="precios">
			<span class="precio-descuento"> 11.99</span>
			<span class="precio-antiguo"> 22.11</span>
			<span class="descuento"> -5%</span>
		</div>

	</div>
<% } %>
</div>

${usuarioLogeado }

<%@ include file="/includes/footer.jsp" %>