<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Fornitori</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>

<div class="myContainer" align="center">

<h1>Area Clienti</h1>

<h3>Ricerca Fornitori</h3>

    <table>
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
                        <input class="btn btn-primary" name="Submit" type="submit" value="Vedi">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>