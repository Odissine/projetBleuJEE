<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Projet Bleu - Bienvenue</title>
    <link href="./css/style.css" rel="stylesheet" media="all" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>
    <div class="liste">
        <h1>Liste des employés</h1>
            <c:if test="${! empty keyMess}"><span class="error">${keyMess}</span></c:if>
            <c:remove var="keyMess" scope="session"/>
        <form action="controleur" method="post">
            <div class="employes">
                <div class="divTable darkTable">
                    <div class="divTableHeading">
                        <div class="divTableRow">
                            <div class="divTableHead">ID</div>
                            <div class="divTableHead" style="text-transform: uppercase;">NOM</div>
                            <div class="divTableHead">PRENOM</div>
                            <!--
                            <div class="divTableHead">TEL DOM</div>
                            <div class="divTableHead">TEL PORT</div>
                            <div class="divTableHead">TEL PRO</div>
                            <div class="divTableHead">ADRESSE</div>
                            <div class="divTableHead">CP</div>
                            -->
                            <div class="divTableHead">VILLE</div>
                            <div class="divTableHead">EMAIL</div>
                        </div>
                    </div>
                    <div class="divTableBody">
                        <c:forEach items= "${keyListEmploye}" var="e">
                        <div class="divTableRow">
                            <div class="divTableCell"><label class="radio"><input type="radio" name='radios' value=${e.id} /><i class="fa fa-circle" aria-hidden="true"></i></label></div>
                            <div class="divTableCell">${e.nom}</div>
                            <div class="divTableCell">${e.prenom}</div>
                            <!--
                            <div class="divTableCell">${e.teldom}</div>
                            <div class="divTableCell">${e.telport}</div>
                            <div class="divTableCell">${e.telpro}</div>
                            <div class="divTableCell">${e.adresse}</div>
                            <div class="divTableCell">${e.codepostal}</div>
                            -->
                            <div class="divTableCell">${e.ville}</div>
                            <div class="divTableCell">${e.email}</div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="input">
                    <div class="inputBox">
                        <input type='submit' name="bouton" value="Details"/>
                        <input type='submit' name="bouton" value="Supprimer" class="supprimer"/>
                        <label class="disconnect"><input type='submit' name="bouton" value="&#xf011;" class="disconnect" /></label>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
