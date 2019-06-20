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

<div class="myContainer2" align="center">

<h1>Area Fornitori</h1>

<h3>I tuoi Listini</h3>
<div class="card mb-5">
    <div class="table-responsive">
    <table class="table table-bordered table-striped mb-0">
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

                <form action="aggiungilistino" method="post">
                <tr>
                    <td><input id="nome" name="nome" type="text" /></td>
                    <td><input id="descrizione" name="descrizione" type="text" /></td>
                    <td><input class="btn btn-primary" name="Submit" type="submit" value="Crea" /></td>
                </tr>
                </form>
            </table>
         </div>
         </div>
            <h3>
                <a class="btn btn-primary" href="listaordini">Gestisci Ordini</a>
            </h3>
</div>
</body>
</html>