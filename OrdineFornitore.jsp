<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ordine</title>
</head>
<body>

    <h1>Ordine N ${idOrdine}</h1>
        <table>
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
                            <td><c:out value="${riga.stato}" /></td>
                            <td><input name="Submit" type="submit" value="Conferma"></td>
                        </form>
                    </c:if>
                    <c:if test = "${riga.stato.equals('RIGETTATA')}">
                        <form action="modifica" method="post">
                            <input type="hidden" name="rid" value="${riga.id}">
                            <td><input type="text" name="quantita" value="${riga.quantita}"></td>
                            <td><input type="text" name="prezzo" value="${riga.prezzoUnitario}"></td>
                            <td><c:out value="${riga.stato}" /></td>
                            <td><input name="Submit" type="submit" value="Conferma"></td>
                        </form>
                    </c:if>
                    <c:if test =  "${riga.stato.equals('CONFERMATA')}">
                        <td><c:out value="${riga.quantita}" /></td>
                        <td><c:out value="${riga.prezzoUnitario}" /></td>
                        <td><c:out value="${riga.stato}" /></td>
                    </c:if>
                    <c:if test =  "${riga.stato.equals('MODIFICATA')}">
                        <td><c:out value="${riga.quantita}" /></td>
                        <td><c:out value="${riga.prezzoUnitario}" /></td>
                        <td><c:out value="${riga.stato}" /></td>
                    </c:if>

                </tr>
            </c:forEach>
        </table>

</body>
</html>