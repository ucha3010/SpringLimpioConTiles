<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de acceso</title>
</head>
<body>
	<h1>Formulario de acceso</h1>
	<br>
	<c:if test="${param.error != null }">
		<span style="color:red;">Error de credenciales</span>
	</c:if>
	<form name="f" action="j_spring_security_check" method="POST">
		<table>
			<tr>
				<td>Usuario</td>
				<td><input type='text' name='usuario' value='' /></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td><input type='password' name='clave' /></td>
			</tr>
			<tr>
				<td>Recordarme</td>
				<td><input name="spring_security_remember_me" type="checkbox" checked="checked" /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Acceder" /></td>
			</tr>
		</table>
	</form>
	<br><br><br>
	<a href='<c:url value="/"/>'>Index</a>

</body>
</html>