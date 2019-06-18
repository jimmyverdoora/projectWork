<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listini Fornitore</title>
</head>
<body>
    <table>
        <h1>Fornitore ${fornitore.nome}</h1>
        <p>${fornitore.descrizione}</p>
        <tr>
            <th>Nome</th>
            <th>Descrizione</th>
            <th>Dettagli</th>
         </tr>
        <c:forEach var="listino" items="${listaListini}">
            <tr>
                <td><c:out value="${listino.nome}" /></td>
                <td><c:out value="${listino.descrizione}" /></td>
                <td>
                    <form action="listaarticoli" method="post">
                        <input type="hidden" name="lid" value="${listino.id}">
                        <input name="Submit" type="submit" value="Vedi">
                    </form>
                </td>
            </tr>
        </c:forEach>
</body>
</html>