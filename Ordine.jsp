<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ordine</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>

<div class="myContainer" align="center">

    <h1>Ordine numero ${idOrdine}</h1>
    <c:forEach var="fornitore" items="${listaFornitori}">
        <h3>Fornitore: ${fornitore.nome}</h3>
        <table class="mb-3">
            <tr>
                <th>Nome</th>
                <th>Quantita</th>
                <th>Prezzo unitario</th>
                <th>Stato</th>
                <th>Conferma</th>
                <th>Rigetta</th>
            </tr>
            <c:forEach var="riga" items="${mappaFornitori.get(fornitore.id)}">
                <tr>
                    <td><c:out value="${mappaArticoli.get(riga.articolo_id)}" /></td>
                    <td><c:out value="${riga.quantita}" /></td>
                    <td><c:out value="${riga.prezzoUnitario}" /></td>
                    <td><c:out value="${riga.stato}" /></td>

                    <c:if test = "${riga.stato.equals('MODIFICATA')}">
                        <td><form action="conferma" method="post">
                            <input type="hidden" name="rid" value="${riga.id}">
                            <input class="btn btn-primary" name="Submit" type="submit" value="Conferma">
                        </form></td>
                        <td><form action="rigetta" method="post">
                            <input type="hidden" name="rid" value="${riga.id}">
                            <input class="btn btn-primary" name="Submit" type="submit" value="Rigetta">
                        </form></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:forEach>

</div>

</body>
</html>