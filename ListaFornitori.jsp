<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<%@ page import="data.FornitoreTO"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista Fornitori</title>
</head>
<body>
    <h1>Lista Fornitori</h1>
    <form>
    <table>
        <caption><h2>Lista dei fornitori</h2></caption>
        <tr>
            <th>Nome</th>
            <th>Descrizione</th>
            <th>Email</th>
            <th>Dettagli</th>
            <th>Seleziona</th>
        </tr>

        <c:forEach var="fornitore" items="${listaFornitori}">
            <tr>
                <td><c:out value="${fornitore.nome}" /></td>
                <td><c:out value="${fornitore.descrizione}" /></td>
                <td><c:out value="${fornitore.email}" /></td>
                <td>
                    <a href="dettagliofornitore?id=<c:out value='${fornitore.id}' />">Vedi</a>
                </td>
                <td>
                    <input id=<c:out value='${fornitore.id}' /> type="checkbox">
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Prosegui" />
    </form>
</body>
</html>