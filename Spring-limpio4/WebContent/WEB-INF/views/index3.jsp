<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Index3</h1>
	
	<a href='<c:url value="/about"/>'>Acerca de</a><br/>	
	<a href='<c:url value="/admin"/>'>Admin</a><br/>
	<a href='<c:url value="/"/>'>Index</a><br/>
	<br/>
	Atributos del Model: <c:out value="${mensaje}" /><br/>
	Atributos en Session (resultado): <c:out value="${sessionScope.resultado}" /><br/>
	Atributos en Session (nombre): <c:out value="${sessionScope.nombre}" /><br/>

</body>
</html>