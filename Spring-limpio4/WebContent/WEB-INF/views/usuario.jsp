<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js">
</script>
<script>
	jQuery(document).ready(function(){
		jQuery(".confirm").on("click", function(){
			return confirm("Seguro que desea eliminar?");
		});
	});
	$(document).ready(function() {
		$("input[type=password]").val('');
	});
</script>
</head>
<body>

	<h1>usuario.jsp</h1>
	<a href='<c:url value="/"/>'>Index</a><br/>
	<br/>
	<br/>
	<sf:form method="post" action="${pageContext.request.contextPath}/usuario/save" modelAttribute="usuario">
		<c:if test="${usuario.idUsr ne 0}">
			<sf:input path="idUsr" type="hidden"/>
			<sf:input path="fechaCreacion" type="hidden"/>
			<sf:input path="habilitado" type="hidden"/>
		</c:if>
		<table>
			<tr>
				<td>Usuario</td>
				<td>
					<sf:input path="usuario" type="text"/>
					<sf:errors path="usuario" cssStyle="color:red" />
				</td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td>
					<sf:input path="clave" type="password" value=""/>
					<sf:errors path="clave" cssStyle="color:red" />
					<c:if test="${usuario.idUsr ne 0}"><span style="color:green;">Si no desea cambiar la contraseña deje este recuadro en blanco</span></c:if>
				</td>
			</tr>
			<tr>
				<td>Permisos</td>
				<td>
					<sf:input path="permiso" type="text"/>
					<sf:errors path="permiso" cssStyle="color:red" />					
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar cambios" /></td>
			</tr>			
		</table>
	</sf:form>
	<br>
	<c:out value="${sessionScope.resultadoError}"></c:out>
	<br>
	<br>
	
	<c:forEach items="${usuarios}" var="usuario">
		<c:out value="${usuario}" /> <!-- con esto imprimo el método toString -->
		<a href='<c:url value="/usuario/${usuario.idUsr}/update" />'>Actualizar</a>
		<a class="confirm" href='<c:url value="/usuario/${usuario.idUsr}/delete" />'>Eliminar</a>
		<br>
	
	</c:forEach>

</body>
</html>