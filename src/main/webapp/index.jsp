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

.libro .portada {
    width: 100%;
    height: auto;
    display: block;
}


</style>


<div class="row">
	<c:forEach items="${libros }" var="libro">
		<div class="col-12 col-md-4 libro mb-3">
			<img class="portada" src="${libro.imagen }" alt="" />
			<hr />
			<div>
			<p class="nombre"> ${libro.nombre }</p>
			<i class="far fa-heart"></i>
			<p class="autor">${libro.autor }</p>
			</div>
			<div class="precios">
				<span class="precio-descuento"> 11.99</span>
				<span class="precio-antiguo"> ${libro.precio }</span>
				<span class="descuento"> -${libro.descuento }%</span>
			</div>
		</div>
	</c:forEach>
</div>

${usuarioLogeado }

<%@ include file="/includes/footer.jsp" %>