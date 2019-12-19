<%@ include file="/includes/header.jsp" %>



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
