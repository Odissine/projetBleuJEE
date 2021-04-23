package com.jee.projetbleu.utils;

public class Constantes {
    public static final String MESSAGE_ERREUR_LOGIN = "Echec de la connexion ! <br/>Vérifiez votre login et/ou votre mot de passe.";
    public static final String MESSAGE_DELETE_EMPLOYE = "Employé supprimé !";
    public static final String MESSAGE_SELECT_EMPLOYE = "Veuillez selectionner un employé";
    public static final String MESSAGE_UPDATE_EMPLOYE = "Employé(e) mis à jour !";
    public static final String QUERY_UPDATE_ALL_EMPLOYE = "UPDATE EmployesEntity e "
        + "SET e.nom = :nom ,"
        + "e.prenom = :prenom,"
        + "e.telpro = :telpro,"
        + "e.teldom = :teldom,"
        + "e.telport = :telport,"
        + "e.adresse = :adresse,"
        + "e.ville = :ville,"
        + "e.codepostal = :codepostal,"
        + "e.email = :email"
        + "  WHERE e.id = :id ";
    public static final String QUERY_GET_EMPLOYE_BY_ID = "SELECT e FROM EmployesEntity e WHERE e.id = :idEmp";
    public static final String QUERY_DELETE_EMPLOYE = "DELETE FROM EmployesEntity e WHERE e.id=?1";
    public static final String QUERY_GET_ALL_EMPLOYES = "select e from EmployesEntity e";
    public static final String QUERY_GET_ALL_USERS = "select u from UsersEntity u";
    public static final String PERSISTENCE_UNIT_NAME = "default";
    public static final String PAGE_INDEX = "WEB-INF/index.jsp" ;
    public static final String PAGE_DETAILS = "/WEB-INF/details.jsp";
    public static final String PAGE_LISTE_EMPLOYES = "WEB-INF/bienvenue.jsp";
}