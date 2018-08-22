<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="contexto" value="${pageContext.request.contextPath}" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Load jQuery UI CSS  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" media="all" type="text/css" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css" />
<!-- Load jQuery JS -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- Load jQuery UI Main JS  -->
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery(".confirm").on("click", function(){
			return confirm("Seguro que desea eliminar?");
		});

		jQuery("#busqueda").autocomplete({
			source: "${contexto}/admin/json/search"
		});
		$('#ajaxSearch').click(function(event) {
			$.ajax({
				url: "${contexto}/admin/json/search",
				data: { term: $("#ajaxText").val()},
				success: function (data) {
					$('#ajaxResult').empty();
					$.each(data, function(index, element) {
						$('#ajaxResult').append(index, ':<b>' + element + '</b><br/>');
					});
				}
			});
		}); 
	});
</script>
</head>
<body>
	<fmt:setBundle basename="es.rural.util.messages"/>

	<h1><fmt:message key="admin.jsp" /></h1>
	<a href='<c:url value="/"/>'>Index</a><br/>
	<a href='<c:url value="/about"/>'>Acerca de</a><br/>
	<br/>
	Atributos del Model: <c:out value="${mensaje}" /><br/>
	Atributos en Session (resultado): <c:out value="${sessionScope.resultado}" /><br/>
	Atributos en Session (nombre): <c:out value="${sessionScope.nombre}" /><br/>
	<br/>
	<br/>
	<br/>

	<fmt:message key="buscar.administradores" /> <input type="text" id="busqueda"/>
	<br>
	<br>
	<fmt:message key="buscar.administradores.con.ajax" />
	<input type="text" id="ajaxText" />
	<input type="submit" id="ajaxSearch" value="<fmt:message key="buscar.asincronamente" />" />
	<div id="ajaxResult"></div>
	<br>
	<br>
	<sf:form method="post" action="${pageContext.request.contextPath}/admin/save" modelAttribute="admin">
		<input name="estado" type="text" />
		<c:if test="${admin.idAd ne 0}">
			<sf:input path="idAd" type="hidden"/>
			<sf:input path="fechaCreacion" type="hidden"/>
		</c:if>
		<table>
			<tr>
				<td>Nombre</td>
				<td><sf:input path="nombre" type="text"/></td>
			</tr>
			<tr>
				<td>Cargo</td>
				<td><sf:input path="cargo" type="text"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar cambios" /></td>
			</tr>			
		</table>
	</sf:form>
	<br/>
	Atributos en Model (resultado): <c:out value="${resultado}"></c:out>
	<br>
	<br>
	
	<c:forEach items="${admins}" var="admin">
		<c:out value="${admin}" /> <!-- con esto imprimo el m�todo toString -->
		<a href='<c:url value="/direccion/${admin.idAd}" />'>Direcciones</a>
		<a href='<c:url value="/admin/${admin.idAd}/update" />'>Actualizar</a>
		<a class="confirm" href='<c:url value="/admin/${admin.idAd}/delete" />'>Eliminar</a>
		<br>
	
	</c:forEach>

</body>
</html>