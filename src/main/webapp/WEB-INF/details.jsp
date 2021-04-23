<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Projet Bleu - Détails de l'employé ${keyEmploye.prenom} ${keyEmploye.nom}</title>
    <link href="./css/style.css" rel="stylesheet" media="all" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>
<div class="details">
    <h1>Information de l'employé :<br/><span>${keyEmploye.prenom} ${keyEmploye.nom}</span></h1>
<c:if test="${! empty keyMess}"><p style="color: red;font-weight: bold">${keyMess}</p></c:if>

<form action="controleur" method="post">
    <div class="input">
        <input type="hidden" name="id" value="${keyEmploye.id}">
        <div>
            <div class="inputBox"><label for="nom">Nom : </label><input autocomplete="off" value="${keyEmploye.nom}" id="nom" name="nom" style="text-transform: uppercase;"></div>
            <div class="inputBox"><label for="prenom">Prénom : </label><input autocomplete="off" value="${keyEmploye.prenom}" id="prenom" name="prenom"></div>
        </div>
        <div>
            <div><span>Numéro de téléphone</span></div>
            <div class="inputBox"><label for="teldom">Domicile : </label><input autocomplete="off" value="${keyEmploye.teldom}" name="teldom" id="teldom"></div>
            <div class="inputBox"><label for="telpor">Portable : </label><input autocomplete="off" value="${keyEmploye.telport}" name="telport" id="telpor"></div>
            <div class="inputBox"><label for="telpro">Professionnel : </label><input autocomplete="off" value="${keyEmploye.telpro}" name="telpro" id="telpro"></div>
        </div>
        <div>
            <div><span>Adresse postale</span></div>
            <div class="inputBox"><label for="adresse">Adresse : </label><input autocomplete="off" value="${keyEmploye.adresse}" name="adresse" id="adresse"></div>
            <div class="inputBox"><label for="cp">Code postal : </label><input autocomplete="off" value="${keyEmploye.codepostal}" name="codepostal" id="cp"></div>
            <div class="inputBox"><label for="ville">Ville : </label><input autocomplete="off" value="${keyEmploye.ville}" name="ville" id="ville"></div>
            <div class="inputBox"><label for="mail">E-mail : </label><input autocomplete="off" id="mail" name="email" value="${keyEmploye.email}"></div>
        </div>
        <div>
            <div class="inputBox">
                <input name="bouton" value="Retour" type="submit" />
                <input name="bouton" value="Modifier" type="submit" class="modifier" />
                <input type='submit' name="bouton" value="&#xf011;" class="disconnect" />
            </div>
        </div>
    </div>
</form>
</div>
</body>
</html>
