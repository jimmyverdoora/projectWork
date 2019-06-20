<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cliente</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>

<div class="myContainer2" align="center">

<h1>Area Clienti</h1>

<div class="container">
<div class="row">
<div class="col-6">
<h3>Nuovo Ordine</h3>
<form method="post" action="upload" enctype="multipart/form-data">

    <div class="my-3">
    <input class="btn btn-primary" type="file" name="uploadedxml">
    </div>
    <input class="btn btn-primary" type=submit value=Invia>
    <input class="btn btn-primary" type=reset value=Cancella></td>

</form>
</div>
<div class="col-6">
<h3 class="mb-3">I tuoi Ordini</h3>
<div class="card">
    <div class="table-responsive">
    <table class="table table-bordered table-striped mb-0">

        <tr>
            <th>Id Ordine</th>
            <th>Seleziona</th>
        </tr>

        <c:forEach var="ordine" items="${listaOrdini}">
            <tr>
                <td>Ordine numero <c:out value="${ordine.id}" /></td>
                <td>
                    <form action="ordine" method="post">
                        <input type="hidden" name="ordineId" value="${ordine.id}">
                        <input class="btn btn-primary" name="Submit" type="submit" value="Vedi">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</div>

</div>
</div>
</div>

</div>
</body>
</html>
