package com.jee.projetbleu.control;

// Import des classes du Package "model"
import com.jee.projetbleu.model.ActionDB;
import com.jee.projetbleu.model.Employe;
import com.jee.projetbleu.model.EmployesEntity;
import com.jee.projetbleu.model.Utilisateur;
import com.jee.projetbleu.model.UsersEntity;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import com.jee.projetbleu.utils.OperationMath;

import static com.jee.projetbleu.utils.Constantes.*;

@WebServlet(name = "Controleur", value = "/Controleur")
public class Controleur extends HttpServlet {
    // private static String loginUtilisateur;
    // private static String motDePasseUtilisateur;
    // private static Utilisateur utilisateurSaisiObjet;
    // private static String actionInputBouton;
    // private static HttpSession session;
    // private static int idEmploye;
    // private static ArrayList<UsersEntity> listeUsersEntity;
    // private static ArrayList<EmployesEntity> listeEmployeEntity;
    //private ActionDB actionDB;
    @Inject OperationMath operations;
    @Inject ActionDB actionDB;
    /***
     *
     * A chaque appel de page sans paramètre POST,
     * la méthode doGet est appelée et renvoi vers la page d'accueil si aucune session
     * sinon page bienvenue !
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        HttpSession session = request.getSession();

        if (session.getAttribute("keySessionUtilisateur")==null) {
            request.getRequestDispatcher(PAGE_INDEX).forward(request, response);
        } else {
            this.goToBienvenue(request, response);
        }
        } catch (IOException|ServletException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // MODE MANUELLE INJECTION (INSTANCIATION)
        //actionDB = new ActionDB();
        try {
            String actionInputBouton = request.getParameter("bouton");

            //if (actionInputBouton==null) {
            //    this.goToBienvenue(request, response);
            //}
                switch (actionInputBouton){

                case "Valider":
                   this.login(request,response);
                    break;
                case "Supprimer":
                    this.supprimer(request, response);
                    break;
                case "Details":
                    this.getDetails(request, response);
                    break;
                case "Retour":
                    this.goToBienvenue(request, response);
                    break;
                case "Modifier":
                    this.modifierEmploye(request,response);
                    break;
                default:
                    this.goToDisconnect(request,response);
            }
        } catch (IOException|ServletException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode qui récupère les valeurs saisies par l'utilisateur (POST) pour modifier un employé !
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void modifierEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Employe employeModif = new Employe();
            int idEmploye = Integer.parseInt(request.getParameter("id"));
            employeModif.setId(idEmploye);
            employeModif.setNom(request.getParameter("nom"));
            employeModif.setPrenom(request.getParameter("prenom"));
            employeModif.setTeldom(request.getParameter("teldom"));
            employeModif.setTelport(request.getParameter("telport"));
            employeModif.setTelpro(request.getParameter("telpro"));
            employeModif.setAdresse(request.getParameter("adresse"));
            employeModif.setCodepostal(request.getParameter("codepostal"));
            employeModif.setVille(request.getParameter("ville"));
            employeModif.setEmail(request.getParameter("email"));
            if (actionDB.updateEmploye(employeModif) == 1) {
                request.setAttribute("keyRequestMessage", MESSAGE_UPDATE_EMPLOYE);
            }
            this.goToDetails(request, response, idEmploye);
        } catch (IOException|ServletException e) {
            e.printStackTrace();
        }
    }
    
    private void getDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           if (request.getParameter("radios") != null) {
               int idEmploye = Integer.parseInt(request.getParameter("radios"));
               this.goToDetails(request, response, idEmploye);
           } else {
               request.setAttribute("keyRequestMessage", MESSAGE_SELECT_EMPLOYE);
               this.goToBienvenue(request, response);
           }
       } catch (IOException|ServletException e) {
           e.printStackTrace();
       }
    }
    
    private void goToDetails(HttpServletRequest request, HttpServletResponse response, int idEmploye) throws ServletException, IOException {
        try {
            EmployesEntity searchedEmploye = actionDB.getEmploye(idEmploye);
            if (searchedEmploye != null) {
                request.setAttribute("keyEmploye", searchedEmploye);
                request.getRequestDispatcher(PAGE_DETAILS).forward(request, response);
            }
        } catch (IOException|ServletException e) {
            e.printStackTrace();
        }
    }
    
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String loginUtilisateur = request.getParameter("chLogin");
            String motDePasseUtilisateur = request.getParameter("chMdp");
            Utilisateur utilisateurSaisiObjet = new Utilisateur();
            utilisateurSaisiObjet.setLogin(loginUtilisateur);
            utilisateurSaisiObjet.setMdp(motDePasseUtilisateur);

            ArrayList<UsersEntity> listeUsersEntity = new ArrayList<UsersEntity>();
            listeUsersEntity.addAll(actionDB.getListeUtilisateurs());

            for (UsersEntity utilisateur : listeUsersEntity) { // si user reconnu on charge la page bienvenue
                if (utilisateurSaisiObjet.getLogin().equals(utilisateur.getLogin()) && utilisateurSaisiObjet.getMdp().equals(utilisateur.getMdp())) {
                    session.setAttribute("keySessionUtilisateur", utilisateurSaisiObjet);
                    this.goToBienvenue(request,response);
                    break;
                } else {
                    request.setAttribute("keyErrMess", MESSAGE_ERREUR_LOGIN);
                    request.getRequestDispatcher(PAGE_INDEX).forward(request, response);
                }
            }
        } catch (IOException|ServletException e) {
            e.printStackTrace();
        }
    }
/**
 * on recupere l'id de l'employe à partir du radio bouton et on le supprime en base
 * on recharge à la fin la page de bienvenue
 * **/
    private void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getParameter("radios") != null) {
                int idEmploye = Integer.valueOf(request.getParameter("radios"));
                if (actionDB.deleteEmploye(idEmploye) == 1) {
                    request.setAttribute("keyRequestMessage", MESSAGE_DELETE_EMPLOYE);
                }

            }else{
                request.setAttribute("keyRequestMessage", MESSAGE_SELECT_EMPLOYE);
            }
            this.goToBienvenue(request, response);
        } catch (IOException|ServletException e) {
            e.printStackTrace();
        }
    }
/**
 * recupère la liste des employés, stocke dans keylistEmployes au niveau de la request et je redirige vers la page bienvenue
 **/
    private void goToBienvenue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        ArrayList<EmployesEntity> listeEmployeEntity = new ArrayList<EmployesEntity>();
        listeEmployeEntity.addAll(actionDB.getEmployes());
        request.setAttribute("keyListEmploye", listeEmployeEntity);

        request.getRequestDispatcher(PAGE_LISTE_EMPLOYES).forward(request, response);
        } catch (IOException|ServletException e) {
            e.printStackTrace();
        }
    }

    // appelé lors de l'arrêt du serveur applicatif
    public void goToDisconnect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("keyUser");
            request.getRequestDispatcher(PAGE_INDEX).forward(request, response);
        } catch (IOException|ServletException e) {
            e.printStackTrace();
        }
    }
}
