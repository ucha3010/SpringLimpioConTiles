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
</script>
</head>
<body>

	<h1>direccion.jsp</h1>
	<a href='<c:url value="/"/>'>Index</a><br/>
	<a href='<c:url value="/about"/>'>Acerca de</a><br/>
	<a href='<c:url value="/admin"/>'>Admin</a><br/>
	<br/>

	<sf:form method="post" action="${pageContext.request.contextPath}/direccion/save" modelAttribute="direccion">
<!-- 		<input name="estado" type="text" /> -->
		<c:if test="${direccion.idDir ne 0}">
			<sf:input path="idDir" type="hidden"/>
		</c:if>		
		<br>
		<table>
			<tr>
				<td></td>
				<td><c:out value="${admin.nombre }" /></td>
			</tr>
			<tr>
				<td>Calle</td>
				<td><sf:input path="calle" type="text"/></td>
			</tr>
			<tr>
				<td>Código Postal</td>
				<td><sf:input path="cp" type="text"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar cambios" /></td>
			</tr>			
		</table>
	</sf:form>
<!-- 	<br/> -->
<%-- 	Atributos en Model (resultado): <c:out value="${resultado}"></c:out> --%>
<!-- 	<br> -->
<!-- 	<br> -->
	
	<c:forEach items="${direcciones}" var="dire">
		<c:out value="${dire}" />
		<a href='<c:url value="/direccion/${dire.idDir}/update" />'>Actualizar</a>
		<a class="confirm" href='<c:url value="/direccion/${dire.idDir}/delete" />'>Eliminar</a>
		<br>
	
	</c:forEach>

</body>
</html>