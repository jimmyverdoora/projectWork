<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Fornitore</title>
</head>
<body>
<center>
</center>
<h1>Area Fornitori</h1>
<div align="center">
            <table>
                <caption>
                    <h2>
                        I Tuoi Listini
                    </h2>
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
                                <input name="Submit" type="submit" value="Vedi">
                            </form>
                        </td>
                    </tr>
                </c:forEach>

                <form action="aggiungilistino" method="post">
                <tr>
                    <td><input id="nome" name="nome" type="text" /></td>
                    <td><input id="descrizione" name="descrizione" type="text" /></td>
                    <td><input name="Submit" type="submit" value="Crea" /></td>
                </tr>
                </form>
            </table>
            <h2>
                <a href="listaOrdini">Gestisci Ordini</a>
            </h2>
</div>
</body>
</html>