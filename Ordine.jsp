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

<%@include file="../nav.jsp" %>

<div class="myContainer2" align="center">

    <h1>Ordine numero ${idOrdine}</h1>
    <c:forEach var="fornitore" items="${listaFornitori}">
        <h3>Fornitore: ${fornitore.nome}</h3>
<div class="card mb-3">
    <div class="table-responsive">
    <table class="table table-bordered table-striped mb-0">

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

                    <c:if test = "${riga.stato.equals('OPEN')}">
                        <td class="open">OPEN</td>
                        <td></td>
                        <td></td>
                    </c:if>
                    <c:if test = "${riga.stato.equals('RIGETTATA')}">
                        <td class="rigettata">RIGETTATA</td>
                        <td></td>
                        <td></td>
                    </c:if>
                    <c:if test = "${riga.stato.equals('CONFERMATA')}">
                        <td class="confermata">CONFERMATA</td>
                        <td></td>
                        <td></td>
                    </c:if>
                    <c:if test = "${riga.stato.equals('MODIFICATA')}">
                        <td class="modificata">MODIFICATA</td>
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
        </div>
    </div>
    </c:forEach>

</div>

</body>
</html>