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
<h3>Fornitore ${fornitore.nome}</h3>
<p>${fornitore.descrizione}</p>
    <table>

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
                        <input class="btn btn-primary" name="Submit" type="submit" value="Vedi">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </div>
</body>
</html>