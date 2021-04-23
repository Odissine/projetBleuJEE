package com.jee.projetbleu.model;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import static com.jee.projetbleu.utils.Constantes.*;

@javax.enterprise.context.RequestScoped
public class ActionDB {
    //@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    //@Inject EntityManager em;
    private final EntityManager em;
    //@Inject EntityManagerFactory entityManagerFactory;
    private final EntityManagerFactory entityManagerFactory;
    private int nombreDeleteEmploye;
    private int nombreUpdateEmploye;

    ArrayList<Utilisateur> listeUtilisateurs;
    Utilisateur utilisateur;
    
    /**
     * Instanciation de EntityManager pour pouvoir exécuter les requêtes en JPA (Java Persistence API)
     * Ref : META-INF/persistence.xml
     */
    public ActionDB() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = entityManagerFactory.createEntityManager();
    }
    
    /**
     * requête JPA qui récupére la liste des employes (de type EmployesEntity)
     * @return la liste des employés
     */
    public Collection<EmployesEntity> getEmployes(){
        Query queryGetAllEmployes = em.createQuery(QUERY_GET_ALL_EMPLOYES);
        return queryGetAllEmployes.getResultList();
    }
    
    /**
     * prend en entree l'id employe a supprimer, pour la suppression necessité de passer par une transaction
     * @param idEmploye
     * @return le nombre de lignes supprimées par la requête
     */
    public int deleteEmploye(int idEmploye) {
        if (null != em) {
            EntityTransaction deleteTransaction = em.getTransaction();
            deleteTransaction.begin();
            Query queryDeleteEmploye = em.createQuery(QUERY_DELETE_EMPLOYE).setParameter(1, idEmploye);
            nombreDeleteEmploye = queryDeleteEmploye.executeUpdate();
            deleteTransaction.commit();
        }
        return nombreDeleteEmploye;
    }
    /**
     * prend en entree l'id employe a supprimer, pour la suppression necessité de passer par une transaction
     * @param idEmploye
     * @return l'objet Employe de lignes supprimées par la requête
     */
    public EmployesEntity getEmploye(int idEmploye) {
        Query findById = em.createQuery(QUERY_GET_EMPLOYE_BY_ID);
        findById.setParameter("idEmp", idEmploye);
        EmployesEntity employeDetails = (EmployesEntity) findById.getSingleResult();
        return employeDetails;
    }

    public int updateEmploye(Employe employe) {
        if (null != em) {
            EntityTransaction updateTransaction = em.getTransaction();
            updateTransaction.begin();
            Query query = em.createQuery(QUERY_UPDATE_ALL_EMPLOYE);
            query.setParameter("id", employe.getId());
            query.setParameter("nom", employe.getNom());
            query.setParameter("prenom", employe.getPrenom());
            query.setParameter("telpro", employe.getTelpro());
            query.setParameter("teldom", employe.getTeldom());
            query.setParameter("telport", employe.getTelport());
            query.setParameter("adresse", employe.getAdresse());
            query.setParameter("ville", employe.getVille());
            query.setParameter("codepostal", employe.getCodepostal());
            query.setParameter("email", employe.getEmail());
            nombreUpdateEmploye = query.executeUpdate();
            updateTransaction.commit();
        }
        return nombreUpdateEmploye;
    }

    public Collection<UsersEntity> getListeUtilisateurs() {
        Query queryGetAllUsers=em.createQuery(QUERY_GET_ALL_USERS);
        return queryGetAllUsers.getResultList();
    }
}
