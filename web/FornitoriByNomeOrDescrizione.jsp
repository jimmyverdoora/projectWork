<%--
  Created by IntelliJ IDEA.
  User: Davide_Gabriele
  Date: 17/06/2019
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cerca Articolo</title>
</head>
<BODY>
<table border="0" cellspacing="1" cellpadding="0" width="300" align="center" bgcolor="#cccccc"><tbody>
<tr><form action="getFornitoriByNomeOrDescrizione" method="get">
    <td>
    <table border="0" cellspacing="1" cellpadding="3" width="100%" bgcolor="#ffffff"><tbody>
    <tr>
        <td colspan="3"><strong>Trova Fornitore</strong></td>
    </tr>
    <tr>
        <td width="78">Inserisci parola chiave</td>
        <td width="6">:</td>
        <td width="294"><input id="hint" name="hint" type="text" /></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td><input name="Cerca" type="submit" value="Cerca" /></td>
    </tr>
    </tbody></table>
</td>
</form></tr>
</tbody></table>
</BODY>
</html>