<%--
  Created by IntelliJ IDEA.
  User: Aula
  Date: 18/06/2019
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

    <table>
        <h1>I Tuoi Ordini</h1>
        <tr>
            <th>Id Ordine</th>
            <th>Seleziona</th>
        </tr>

        <c:forEach var="ordine" items="${listaOrdini}">
            <tr>
                <td><c:out value="${ordine.id}" /></td>
                <td>
                    <form action="ordine" method="post">
                        <input type="hidden" name="ordineId" value="${ordine.id}">
                        <input name="Submit" type="submit" value="Vedi">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
