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

<div class="myContainer3" align="center">

<h1>Area Fornitori</h1>
<h3>Listino ${listino.nome}</h3>
<p>${listino.descrizione}</p>

<div class="card">
    <div class="table-responsive">
    <table class="table table-bordered table-striped mb-0">


                    <tr>
                        <th>Nome</th>
                        <th>Tipo</th>
                        <th>Prezzo</th>
                        <th>Disponibilita</th>
                        <th>Descrizione</th>
                        <th>Nuovo</th>
                     </tr>
                    <c:forEach var="articolo" items="${listaArticoli}">
                        <tr>
                            <td><c:out value="${articolo.nome}" /></td>
                            <td><c:out value="${articolo.tipo}" /></td>
                            <td><c:out value="${articolo.prezzo}" /></td>
                            <td><c:out value="${articolo.quantita}" /></td>
                            <td><c:out value="${articolo.descrizione}" /></td>
                            <td></td>
                        </tr>
                    </c:forEach>

                <form action="aggiungiarticolo" method="post">
                <input type="hidden" name="lid" value="${listino.id}">
                <tr>
                    <td><input id="nome" name="nome" type="text" /></td>
                    <td><input id="tipo" name="tipo" type="text" /></td>
                    <td><input id="prezzo" name="prezzo" type="text" /></td>
                    <td><input id="quantita" name="quantita" type="text" /></td>
                    <td><input id="descrizione" name="descrizione" type="text" /></td>
                    <td><input class="btn btn-primary" name="Submit" type="submit" value="Crea" /></td>
                </tr>
                </form>
            </table>
        </div>
    </div>
</div>
</body>
</html>