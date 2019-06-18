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
</head>
<BODY>
<table border="0" cellspacing="1" cellpadding="0" width="300" align="center" bgcolor="#cccccc"><tbody>
<tr><form action="dologin" method="post">
    <td>
    <table border="0" cellspacing="1" cellpadding="3" width="100%" bgcolor="#ffffff"><tbody>
    <tr>
        <td colspan="3"><strong>Login</strong></td>
    </tr>
    <tr>
        <td width="78">Username</td>
        <td width="6">:</td>
        <td width="294"><input id="username" name="username" type="text" /></td>
    </tr>
    <tr>
        <td>Password</td>
        <td>:</td>
        <td><input id="password" name="password" type="password" /></td>
    </tr>
    <tr>
        <td>Chi sei</td>
        <td>:</td>
        <td><select name="ruolo">
            <option value="cliente">Cliente</option>
            <option value="fornitore">Fornitore</option>
            <option value="admin">Admin</option>
            </select>
    <tr>
        <td></td>
        <td></td>
        <td><input name="Submit" type="submit" value="Login" /></td>
    </tr>
    </tbody></table>
</td>
</form></tr>
</tbody></table>

<table border="0" cellspacing="1" cellpadding="0" width="300" align="center" bgcolor="#cccccc"><tbody>
<tr><form action="doregistration" method="post">
    <td>
    <table border="0" cellspacing="1" cellpadding="3" width="100%" bgcolor="#ffffff"><tbody>
    <tr>
        <td colspan="3"><strong>Registrazione</strong></td>
    </tr>
    <tr>
        <td width="78">Username</td>
        <td width="6">:</td>
        <td width="294"><input id="username" name="username" type="text" /></td>
    </tr>
    <tr>
        <td>Password</td>
        <td>:</td>
        <td><input id="password" name="password" type="password" /></td>
    </tr>
    <tr>
        <td>Nome</td>
        <td>:</td>
        <td><input id="nome" name="nome" type="text" /></td>
    </tr>
    <tr>
        <td>Descrizione</td>
        <td>:</td>
        <td><input id="descrizione" name="descrizione" type="text" /></td>
    </tr>
    <tr>
        <td>Email</td>
        <td>:</td>
        <td><input id="email" name="email" type="text" /></td>
    </tr>
    <tr>
        <td>Chi sei</td>
        <td>:</td>
        <td><select name="ruolo">
            <option value="cliente">Cliente</option>
            <option value="fornitore">Fornitore</option>
            <option value="admin">Admin</option>
            </select>
    <tr>
        <td></td>
        <td></td>
        <td><input name="Submit" type="submit" value="Registrati" /></td>
    </tr>
    </tbody></table>
</td>
</form></tr>
</tbody></table>
</BODY>
</html>
