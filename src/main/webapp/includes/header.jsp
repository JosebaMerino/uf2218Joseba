<% request.setCharacterEncoding("UTF-8"); %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!-- Tag lib imports -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!doctype html>
<html lang="es">
  <head>
    <!--meta charset="utf-8">  -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Joseba Merino">

    <base href="${pageContext.request.contextPath}/" />

    <title>UF-2218 - Joseba</title>

   <!-- Bootstrap core CSS -->
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

   <!-- nuestro css -->
   <link rel="stylesheet" href="css/custom.css">

   <fmt:setLocale value="es_ES"/>

  </head>
   <body>
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">LIBROS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
	   <a class="nav-link" href="formulario.jsp"> Añadir libro</a>
      </li>
      <li class="nav-item">
	   <a class="nav-link" href="libros"> Ver libros</a>
      </li>
  </div>
</nav>
   <nav>
   </nav>
    <main class="container">
   <c:if test="${not empty alerta }">
	   <div class="alert alert-${alerta.tipo } alert-dismissible fade show mt-2">
	   		<h4 class="alet-header">${alerta.titulo }</h4>
	   		<p> ${alerta.descripcion }</p>
		   	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    	<span aria-hidden="true">&times;</span>
		  	</button>
	   </div>
   </c:if>
