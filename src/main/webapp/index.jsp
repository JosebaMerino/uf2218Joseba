<%@ include file="/includes/header.jsp" %>
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

.flex-container {
	display: flex;
}

</style>


<div class="row">
<c:if test="${empty libros }">
	<h3> Actualente no se encuentran libros</h3>
</c:if>
	<c:forEach items="${libros }" var="libro">
		<div class="col-12 col-md-4 libro mb-3">
			<img class="portada" src="${libro.imagen }" alt="" />
			<hr />
			<div>
			<div class="flex-container">
				<p class="nombre"> ${libro.nombre }</p>
				<i class="far fa-heart"></i>
			</div>
			<p class="autor">${libro.autor }</p>
			</div>
			<div class="precios">
				<span class="precio-descuento"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${libro.calcularPrecioDescuento()}" /></span>
				<span class="precio-antiguo"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${libro.precio }" /></span>
				<span class="descuento"> -${libro.descuento }%</span>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/includes/footer.jsp" %>