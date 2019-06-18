<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Articoli Listino</title>
</head>
<body>
    <table>
        <h1>Fornitore ${fornitore.nome} - Listino ${listino.nome}</h1>
        <p>${listino.descrizione}</p>
        <tr>
            <th>Nome</th>
            <th>Tipo</th>
            <th>Prezzo</th>
            <th>Descrizione</th>
         </tr>
        <c:forEach var="articolo" items="${listaArticoli}">
            <tr>
                <td><c:out value="${articolo.nome}" /></td>
                <td><c:out value="${articolo.tipo}" /></td>
                <td><c:out value="${articolo.prezzo}" /></td>
                <td><c:out value="${articolo.descrizione}" /></td>
            </tr>
        </c:forEach>
</body>
</html>