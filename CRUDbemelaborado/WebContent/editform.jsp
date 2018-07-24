<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar livro</title>
</head>
<body>
	<center>
		<h1> Gerenciador de usuários</h1>
		<h2>
			<a href="/CRUDbemelaborado/novo">Adicionar novo usuário</a>
			&nbsp;&nbsp;&nbsp;
			<a href="/CRUDbemelaborado/listing">Listar usuários</a>
		</h2>
	</center>
	<div align="center">
		
			<form action="update" method="post">
		
		
		<table border="1" cellpadding="5">
			<caption>
				<h2>	
						Editar usuário
				</h2>
			</caption>
					<input type="hidden" name="id" value="<c:out value='${usuario.id}' />" />
				
			 <tr>
			 <tr>
                <th>Nome: </th>
                <td>
                    <input type="text" name="nome" style="width:200px;"
                            value="<c:out value='${usuario.nome}' />"
                    />
                </td>
            </tr>
                <th>Idade: </th>
                <td>
                    <input type="text" name="idade" style="width:200px;"
                            value="<c:out value='${usuario.idade}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update" />
                </td>
            </tr>
			
			</table>
		</form>
	</div>
</body>
</html>