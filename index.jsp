<%--
  Created by IntelliJ IDEA.
  User: Aula
  Date: 14/06/2019
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<BODY>

<div class="myContainer" align="center">

<h1>Benvenuti nel nostro Sito!</h1>

<div class="row">
<div class="col-6">

<h3>Login</h3>

<form action="dologin" method="post">
  <div class="form-group">
    <input type="text" name="username" class="form-control" placeholder="Username">
  </div>
  <div class="form-group">
    <input type="password" name="password" class="form-control" placeholder="Password">
  </div>
  <div class="form-group">
    <select class="form-control" id="exampleFormControlSelect1" name="ruolo">
        <option value="cliente">Cliente</option>
        <option value="fornitore">Fornitore</option>
        <option value="admin">Admin</option>
    </select>
  </div>
  <input class="btn btn-primary" type="submit" value="Entra">
</form>

</div>
<div class="col-6">

<h3>Registrazione</h3>

<form action="doregistration" method="post">
  <div class="form-group">
    <input type="text" name="username" class="form-control" placeholder="Username">
  </div>
  <div class="form-group">
    <input type="password" name="password" class="form-control" placeholder="Password">
  </div>
  <div class="form-group">
    <input type="text" name="nome" class="form-control" placeholder="Nome della tua azienda">
  </div>
  <div class="form-group">
    <input type="text" name="descrizione" class="form-control" placeholder="Descrivi la tua azienda">
  </div>
  <div class="form-group">
    <input type="email" name="email" class="form-control" placeholder="esempio@ciao.it">
  </div>
  <div class="form-group">
    <select class="form-control" id="exampleFormControlSelect1" name="ruolo">
        <option value="cliente">Sono Cliente</option>
        <option value="fornitore">Sono un Fornitore</option>
        <option value="admin">Sono un Admin</option>
    </select>
  </div>
  <input class="btn btn-primary" type="submit" value="Registrati">
</form>
</div>
</div>
</div>

</BODY>
</html>
