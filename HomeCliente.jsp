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

<div class="myContainer" align="center">

<h1>Area Clienti</h1>

<h3>Ricerca Fornitori</h3>

<form class="mb-5" action="listafornitori" method="post">
  <div class="form-group">
    <input type="text" name="parolaChiave" class="form-control" id="exampleFormControlInput1" placeholder="Parola Chiave">
  </div>
  <div class="form-group">
    <select class="form-control" id="exampleFormControlSelect1" name="ruolo">
        <option value="fornitore">Ricerca per Fornitore</option>
        <option value="articolo">Ricerca per Articolo</option>
    </select>
  </div>
  <input class="btn btn-primary" type="submit" value="Cerca">
</form>

            <h3>
                <a class="btn btn-primary" href="listaordini">Gestisci Ordini</a>
            </h3>
</div>
</div>
</body>
</html>