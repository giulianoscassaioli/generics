<%@page import="java.util.List"%>
<%@page import="entity.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Corso> corsi =(List<Corso>) request.getAttribute("lista") ;%> 


<h1>LISTA CORSI</h1>

<table border="1">
<tr><th>NOME CORSO</th><tr>

<%for(Corso c: corsi) { %>

<tr><td> <%=c.getNome() %></td></tr>

<%} %>


</table>
</body>
</html>