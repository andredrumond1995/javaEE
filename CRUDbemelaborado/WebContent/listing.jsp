<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listing - Listagem de usu�rios</title>
</head>
<body>
	<center>
		<h1> Gerenciador de usu�rios</h1>
		<h2>
			<a href="/CRUDbemelaborado/novo">Adicionar novo usu�rio</a>
			&nbsp;&nbsp;&nbsp;
			<a href="/CRUDbemelaborado/listing">Listar usu�rios</a>
		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption><h2>Listagem de usu�rios</h2></caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Idade</th>
				<th>Ac�o</th>
			</tr>
			<c:forEach var="usuario" items="${showUsuarios}">
				<tr>
					<td><c:out value="${usuario.id}" /></td>
					<td><c:out value="${usuario.nome}" /></td>
					<td><c:out value="${usuario.idade}" /></td>
					
					<td>
						<a href="/CRUDbemelaborado/edit?id=<c:out value='${usuario.id}' />">Editar</a>
					 	&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/CRUDbemelaborado/delete?id=<c:out value='${usuario.id}' />">Deletar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>