<%@ include file="includes/header.jsp" %>

<h1> Index.jsp </h1>

<a href="libros"> Cargar un texto</a>
<p>
Aqui deberian venir uvarios libros: <br />

<c:forEach items="${libros }" var="libro">
------------------------------- <br />
${libro.id } <br />
${libro.nombre } <br />
${libro.precio } <br />
${libro.descuento } <br />
------------------------------- <br />
</c:forEach>
</p>

<p>
ID: ${id }
</p>
<p>
Nombre: ${nombre }
</p>


<%@ include 	file="includes/footer.jsp" %>