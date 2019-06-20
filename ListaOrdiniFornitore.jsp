<%--
  Created by IntelliJ IDEA.
  User: Aula
  Date: 18/06/2019
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Fornitore</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>

<%@include file="../nav.jsp" %>

<div class="myContainer" align="center">

<h1>Area Fornitori</h1>

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

</body>
</html>
