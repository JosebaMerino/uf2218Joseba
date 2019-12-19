<%@ include file="/includes/header.jsp" %>

<h1> Listado de libros </h1>
<c:if test="${empty libros }">
	<p>Ning�n libro almacenado hasta el momento, puedes agregar uno desde <a href="privado/libros/formulario.jsp">aqu�</a></p>
</c:if>

<c:if test="${not empty libros}">
<a href="privado/libros/formulario.jsp"> A�adir un nuevo libro</a>
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
			 <fmt:formatNumber type="currency" maxFractionDigits="2" value="${libro.precio }" />
			 <a href="privado/libros?accion=formulario&id=${libro.id }"> Ver</a>
		</td>
		<td>
			${libro.descuento}
		</td>
	</tr>
	</c:forEach>
	</tbody>

	</table>
</c:if>

<%@ include 	file="/includes/footer.jsp" %>