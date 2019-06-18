<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listino</title>
</head>
<body>
<center>
</center>
<h1>Area Fornitori</h1>
<div align="center">
            <table>
                <caption>
                    <h2>
                        Listino ${listino.nome}
                    </h2>
                    <p>${listino.descrizione}</p>
                    <tr>
                        <th>Nome</th>
                        <th>Tipo</th>
                        <th>Prezzo</th>
                        <th>Descrizione</th>
                     </tr>
                    <c:forEach var="articolo" items="${listaArticoli}">
                        <tr>
                            <td><c:out value="${articolo.nome}" /></td>
                            <td><c:out value="${articolo.tipo}" /></td>
                            <td><c:out value="${articolo.prezzo}" /></td>
                            <td><c:out value="${articolo.descrizione}" /></td>
                        </tr>
                    </c:forEach>

                <form action="aggiungiarticolo" method="post">
                <input type="hidden" name="lid" value="${listino.id}">
                <tr>
                    <td><input id="nome" name="nome" type="text" /></td>
                    <td><input id="tipo" name="tipo" type="text" /></td>
                    <td><input id="prezzo" name="prezzo" type="text" /></td>
                    <td><input id="descrizione" name="descrizione" type="text" /></td>
                    <td><input name="Submit" type="submit" value="Crea" /></td>
                </tr>
                </form>
            </table>
</div>
</body>
</html>