<%@ include file="includes/header.jsp" %>

<h1> Index.jsp </h1>

<a href="libros"> Cargar un texto</a>
<p>
Aqui deberia venir un libro:

${libro.id }
${libro.nombre }
${libro.precio }
${libro.descuento }
</p>

<p>
ID: ${id }
</p>
<p>
Nombre: ${nombre }
</p>


<%@ include 	file="includes/footer.jsp" %>