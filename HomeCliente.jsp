<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cliente</title>
</head>
<body>
<center>
</center>
<h1>Benvenuto cliente</h1>
<div align="center">
    <form action="listafornitori" method="post">
            <table>
                <caption>
                    <h2>
                        Ricerca Fornitore
                    </h2>
                </caption>
                <tr>
                    <td>Parola chiave</td>
                    <td>:</td>
                    <td><input id="parolaChiave" type="text" name="parolaChiave"/></td>
                </tr>
                <tr>
                    <td>Cerca per</td>
                    <td>:</td>
                    <td><select name="ruolo">
                        <option value="fornitore">Fornitore</option>
                        <option value="articolo">Articolo</option>
                        </select></td>
                <tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input name="Submit" type="submit" value="Cerca" /></td>
                </tr>
            </table>
        </form>
            <h2>&nbsp;&nbsp;&nbsp;
                <a href="listaOrdini">Gestisci Ordini</a>
            </h2>
</div>
</body>
</html>