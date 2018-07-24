<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import="com.implementando.dao.DatabaseOperation" %>
    <%@ page import="com.implementando.bean.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>CRUD SEM FRAMEWORK</title>
</head>
<body>

<div class="container">
  <h2>Editando</h2>
  <form action="Main" method="post">
   <div class="form-group">
      <label for="id">Id:</label>
      <input type="text" class="form-control" style="width:200px;" id="id" value="<%=request.getParameter("id") %>" name="id">
    </div>
    <div class="form-group">
      <label for="email">Nome:</label>
      <input type="text" class="form-control" style="width:200px;" id="nome" value="<%=request.getParameter("nome") %>" name="nome">
    </div>
    <div class="form-group">
      <label for="idade">Idade:</label>
      <input type="text" class="form-control" style="width:200px;" id="idade" value="<%=request.getParameter("idade") %>" name="idade">
    </div>
    <input type="hidden" name="check" value="update"></input>
    <button type="submit" class="btn btn-default">Atualizar</button>
    
  </form>
   
    <% 
		String lastpage = "showdata.jsp";
	%> 
  <br>
   <button type="button" onClick="javascript:window.location='<%= lastpage %>';" class="btn btn-default">Voltar</button>
</div>
  
 
 
  

</body>
</html>