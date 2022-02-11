<%@page import="java.util.List"%>
<%@page import="entity.Studente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Studente> studenti =(List<Studente>) request.getAttribute("lista") ;%> 


<h1>LISTA CORSI</h1>

<table border="1">
<tr><th>NOME CORSO</th><tr>

<%for(Studente s: studenti) { %>

<tr><td> <%=s.getNome() %></td></tr>

<%} %>


</table>

</body>
</html>