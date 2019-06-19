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

        <c:forEach var="ordine" items="${listaOrdini}">
            <form action="ordine" method="post">
                <input type="hidden" name="ordineId" value="${ordine.id}">
                <input class="btn btn-primary mb-2" name="Submit" type="submit" value="Ordine numero ${ordine.id}">
            </form>

        </c:forEach>

    </table>

</div>
</div>
</div>

</div>
</body>
</html>
