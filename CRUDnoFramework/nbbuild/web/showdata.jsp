<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import="com.implementando.dao.DatabaseOperation" %>
    <%@ page import="com.implementando.bean.Usuario" %>
    <%//@include file="insertdata.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript"> 

function doSubmit() 
{ 
window.transfer("insertdata.jsp","_self"); 
} 
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Show data</title>
</head>
<body>
<div class="container">
  <h2>Dados do banco</h2>
           
  <table class="table table-hover">
    <thead>
      <tr>
        <th>id</th>
        <th>Nome</th>
        <th>Idade</th>
        <th>Ação</th>
      </tr>
    </thead>
    
    
<% 
DatabaseOperation dao = new DatabaseOperation();
ArrayList<Usuario> al = new ArrayList<Usuario>();
al = dao.showData();

for(int i=0;i<al.size();i++){

	%>
	<tbody>
    <tr>
    
	<td><% out.println(al.get(i).getId()); %></td>
    <td id="nome"><% out.println(al.get(i).getNome()); %></td>
    <td id="idade" ><% out.println(al.get(i).getIdade()); %></td>
    
    <td>
        <a href="edit.jsp?id=<% out.println(al.get(i).getId()); %>&nome=<% out.println(al.get(i).getNome()); %>&idade=<% out.println(al.get(i).getIdade()); %>">Update</a>
        
        <form action="Main" method="post">
        	<input type="hidden" name="id" value="<% out.println(al.get(i).getId()); %>"></input>
        	<input type="hidden" name="check" value="delete"></input>
        	<button type="submit" class="btn btn-primary">Deletar</button>
        </form>
    </tr>
      
      
    </tbody>
    <% } %>

<% 
	String insertdata = "insertdata.jsp"; 
%>    
  </table>
  <button type="button" onClick="javascript:window.location='<%= insertdata %>';" class="btn btn-primary">Adicionar usuário</button>
  <br>
  <br>
  <button type="button" onclick="" class="btn btn-primary">Voltar</button></td>
</div>
</body>
</html>