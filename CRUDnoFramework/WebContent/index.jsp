<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import="com.implementando.dao.DatabaseOperation" %>
    <%@ page import="com.implementando.bean.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/homeCss.css">

<title>CRUD no Framework</title>
<script>
$(document).ready(function(){
    $("#insertButton").click(function(){
        $("#insertForm").show();
        $("#showRecord").hide();
        $("#delRecord").hide();
    });
    $("#showButton").click(function(){
    	  $("#insertForm").hide();
          $("#showRecord").show();
          $("#delRecord").hide();
    });
    $("#delBtn").click(function(){
    	  $("#insertForm").hide();
          $("#showRecord").hide();
          $("#delRecord").show();
    });
});
</script>
</head>
<body>
<h1>DATA BASE OPERATION</h1>
<input type="submit" value="Add Record"  id="insertButton">
<input type="submit" value="Show Record" id="showButton">
<input type="submit" value="Delete Record" id="delBtn">

<form id="insertForm" action="Main" method="post" class="insertForm">
<pre>
<input type="text" name="nome">

<input type="text" name="idade">

<input type="submit" value="insert">
</pre>
</form>

<p id="showRecord" class="showForm">
<% 
DatabaseOperation dao = new DatabaseOperation();
ArrayList<Usuario> al = new ArrayList<Usuario>();
al = dao.showData();

for(int i=0;i<al.size();i++){
	out.println(al.get(i).getId()+" ---- " +al.get(i).getNome()+ " ---- "+al.get(i).getIdade());
	%><br><%
}

%>
</p>

<form action="Main" id="delRecord" class="delForm" method="post">
<pre>
<input type="text" name="id">

<input type="submit" value="delete">
</pre>

</form>



</body>
</html>