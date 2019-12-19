<%@ include file="/includes/header.jsp" %>
<style>
.libro .precios .precio-antiguo {
  color: grey;
  text-decoration:line-through;
  margin-left: 5px;
}

.libro .precios .precio-descuento {
  color: #FF5E67;
  font-size: 125%;
}

.libro .precios .descuento {
  color: white;
  background-color: #FF5E67;
  padding: 3px;
  margin-left: 15px
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
        <c:if test="${libro.calcularPrecioDescuento() != libro.precio }">
        <span class="precio-descuento"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${libro.calcularPrecioDescuento()}" /></span>
        <span class="precio-antiguo"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${libro.precio }" /></span>
        <span class="descuento"> -${libro.descuento }%</span>
        </c:if>
        <c:if test="${empty libro.descuento || libro.descuento == 0}">
        <span class="precio-descuento"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${libro.precio }" /></span>

        </c:if>
      </div>
    </div>
  </c:forEach>
</div>

<%@ include file="/includes/footer.jsp" %>
