<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista Fornitori</title>
</head>
<body>
    <h1>Lista Fornitori</h1>
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
                    <form action="dettagliofornitore" method="post">
                        <input type="hidden" name="fid" value="${fornitore.id}">
                        <input name="Submit" type="submit" value="Vedi">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>