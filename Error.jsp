<%@ page import="java.io.FileWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error</title>
</head>
<body>
	<center>
		<h1>Error</h1>
		<h5><%=exception.getMessage() %></h5>
		<jsp:scriptlet>
          exception.printStackTrace(new java.io.PrintWriter(out));
        </jsp:scriptlet>
		<c:forEach var="line" items="$(exception.getStackTrace())">
		   <p><c:out value="$(line.toString())" /></p>
        </c:forEach>
	</center>	
</body>
</html>