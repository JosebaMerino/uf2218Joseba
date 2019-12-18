<%@ include file="includes/header.jsp" %>

<h1> Index.jsp </h1>
<a href="formulario.jsp"> Añadir un nuevo libro</a>
<c:if test="${empty libros }">
	<p>Ningún libro almacenado hasta el momento, puedes agregar uno desde <a href="formulario.jsp">aquí</a></p>
</c:if>
<c:if test="${not empty libros}">
	<table class="table table-striped table-bordered">
		<thead>
			<th>ID</th>
			<th>NOMBRE</th>
			<th>PRECIO</th>
			<th>DESCUENTO</th>
		</thead>
		<tfoot>
			<th>ID</th>
			<th>NOMBRE</th>
			<th>PRECIO</th>
			<th>DESCUENTO</th>
		</tfoot>
		<tbody>
	<c:forEach items="${libros }" var="libro">
	<tr>
		<td>
			${libro.id }
		</td>
		<td>
			${libro.nombre }
		</td>
		<td>
			<!--

			 ${libro.precio }
			 -->
			 <fmt:formatNumber type="currency" maxFractionDigits="2" value="${libro.precio }" />
		</td>
		<td>
			${libro.descuento}
		</td>
	</tr>
	</c:forEach>
	</tbody>

	</table>
</c:if>

<%@ include 	file="includes/footer.jsp" %>