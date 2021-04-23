<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Projet Bleu</title>
    <link href="./css/style.css" rel="stylesheet" media="all" type="text/css">
</head>
<body>
<div class="login">
    <h1>Identifiez-vous</h1>
    <c:if test="${! empty keyErrMess}"><span style="color: red; font-size: 12px; ">${keyErrMess}</span></c:if>
    <c:remove var="keyErrMess" scope="session"/>
    <form name="frmDemo" method="post" action="controleur">
        <div class="input">
            <div class="inputBox"><label>Identifiant</label><input type="text" name="chLogin" placeholder="mail@google.fr" autocomplete="off" /></div>
            <div class="inputBox"><label>Mot de passe</label><input type="password" name="chMdp" placeholder="••••••••••" /></div>
            <div class="inputBox"><input type="submit" name="bouton" value="Valider" /></div>
        </div>
    </form>
</div>
</body>
</html>