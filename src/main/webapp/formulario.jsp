<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>

<h1> Añadir un nuevo libro </h1>

<c:if test="${not empty mensajes }">
	<div class="alert alert-warning alert-dismissible fade show">
	<h4 class="alert-heading"> No se ha podido añadir el libro</h4>
		<c:forEach items="${mensajes }" var="mensaje">
			<p> ${mensaje }</p>
		</c:forEach>
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    	<span aria-hidden="true">&times;</span>
	  	</button>
	</div>
</c:if>
<form action="libros" method="post">
	  <div class="form-group">
		    <label for="nombre">Nombre</label>
		    	<input type="text"
					name="nombre" id="nombre"
					value="${nombre }"
					class="form-control"
					placeholder="Los juegos del hambre"
				/>
		    <small id="nombreHelp" class="form-text text-muted">Debe tener de 2 a 100 caracteres</small>
	  </div>
	  <div class="form-group">
		    <label for="precio">Precio</label>
		    	<input type="text"
					name="precio" id="precio"
					value="${precio }"
					class="form-control"
					placeholder="2000,00"
				/>
		    <small id="precioHelp" class="form-text text-muted">Debe ser un número decimal mayor que 0.</small>
	  </div>
	  <div class="form-group">
		    <label for="descuento">Descuento</label>
		    	<input type="text"
					name="descuento" id="descuento"
					value="${descuento }"
					class="form-control"
					placeholder="49"
				/>
		    <small id="descuentoHelp" class="form-text text-muted">Debe ser un número positivo menor o igual a 100</small>
	  </div>


	<button type="submit" class="btn btn-primary btn-block"> Enviar</button>
</form>


<%@ include file="includes/footer.jsp" %>