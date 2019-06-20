<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Fornitore</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>

<div class="container" align="center">

<h1>Area Fornitori</h1>

    <h3>Ordine numero ${idOrdine}</h3>
       <div class="card">
           <div class="table-responsive">
           <table class="table table-bordered table-striped mb-0">

            <tr>
                <th>Nome</th>
                <th>Quantita</th>
                <th>Prezzo unitario</th>
                <th>Stato</th>
                <th>Modifica</th>
            </tr>
            <c:forEach var="riga" items="${listaRighe}">
                <tr>
                    <td><c:out value="${mappaArticoli.get(riga.articolo_id)}" /></td>
                    <c:if test = "${riga.stato.equals('OPEN')}">
                        <form action="modifica" method="post">
                            <input type="hidden" name="rid" value="${riga.id}">
                            <td><input type="text" name="quantita" value="${riga.quantita}"></td>
                            <td><input type="text" name="prezzo" value="${riga.prezzoUnitario}"></td>
                            <td class="open">OPEN</td>
                            <td><input class="btn btn-primary" name="Submit" type="submit" value="Conferma"></td>
                        </form>
                    </c:if>
                    <c:if test = "${riga.stato.equals('RIGETTATA')}">
                        <form action="modifica" method="post">
                            <input type="hidden" name="rid" value="${riga.id}">
                            <td><input type="text" name="quantita" value="${riga.quantita}"></td>
                            <td><input type="text" name="prezzo" value="${riga.prezzoUnitario}"></td>
                            <td class="rigettata">RIGETTATA</td>
                            <td><input class="btn btn-primary" name="Submit" type="submit" value="Conferma"></td>
                        </form>
                    </c:if>
                    <c:if test =  "${riga.stato.equals('CONFERMATA')}">
                        <td><c:out value="${riga.quantita}" /></td>
                        <td><c:out value="${riga.prezzoUnitario}" /></td>
                        <td class="confermata">CONFERMATA</td>
                        <td></td>
                    </c:if>
                    <c:if test =  "${riga.stato.equals('MODIFICATA')}">
                        <td><c:out value="${riga.quantita}" /></td>
                        <td><c:out value="${riga.prezzoUnitario}" /></td>
                        <td class="modificata">MODIFICATA</td>
                        <td></td>
                    </c:if>

                </tr>
            </c:forEach>
        </table>
        </div>
    </div>
    </div>

</body>
</html>