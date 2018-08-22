<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<h2>header</h2>

<sec:authorize access="!isAuthenticated()">
	Sesión no iniciada
</sec:authorize>

<sec:authorize access="isRememberMe()">
	Sesión iniciada como: 
	<sec:authentication property="principal" var="principal"/>
	<c:set var="username" value="${principal.username}" />
	<c:out value="${username}"></c:out>
	<br/>
	<a href="<c:url value='/logout'/>">Cerrar sesión</a>
</sec:authorize>

<sec:authorize access="isFullyAuthenticated()">
	Sesión iniciada como: 
	<sec:authentication property="principal" var="principal"/>
	<c:set var="username" value="${principal}" />
	<c:out value="${username}"></c:out>
	<br/>
	<a href="<c:url value='/logout'/>">Cerrar sesión</a>
</sec:authorize>

<br/><br/>
<a href='<c:url value="/usuario"/>'>Usuarios</a><br/>
<a href='<c:url value="/"/>'>Index</a><br/>