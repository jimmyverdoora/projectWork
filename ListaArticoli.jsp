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
<h3>Fornitore ${fornitore.nome} - Listino ${listino.nome}</h3>
<p>${listino.descrizione}</p>
    <table>
        <tr>
            <th>Nome</th>
            <th>Tipo</th>
            <th>Prezzo</th>
            <th>Quantita disponibile</th>
            <th>Descrizione</th>
         </tr>
        <c:forEach var="articolo" items="${listaArticoli}">
            <tr>
                <td><c:out value="${articolo.nome}" /></td>
                <td><c:out value="${articolo.tipo}" /></td>
                <td><c:out value="${articolo.prezzo}" /></td>
                <td><c:out value="${articolo.quantita}" /></td>
                <td><c:out value="${articolo.descrizione}" /></td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>