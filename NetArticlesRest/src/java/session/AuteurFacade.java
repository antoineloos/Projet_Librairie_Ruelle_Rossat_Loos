/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dal.Auteur;
import dal.Client;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Epulapp
 */
@Stateless
public class AuteurFacade extends AbstractFacade<Auteur> {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Auteur lireLogin(String login) throws Exception {
        try {
            Query requete = em.createNamedQuery("Auteur.findByLoginAuteur");
            requete.setParameter("loginAuteur", login);
            return ((Auteur) requete.getSingleResult());
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Auteur lire(int id) throws Exception {
        try {
            return em.find(Auteur.class, id);
        } catch (Exception e) {
            throw e;
        }
    }
    
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modifier(Auteur auteur) throws Exception {
        try {
            Auteur auteurE = lire(auteur.getIdAuteur());
            auteurE.setDroitsCollection(auteur.getDroitsCollection());
            auteurE.setAdresseAuteur(auteur.getAdresseAuteur());
            auteurE.setRedigeCollection(auteur.getRedigeCollection());
            auteurE.setIdentiteAuteur(auteur.getIdentiteAuteur());
            auteurE.setLoginAuteur(auteur.getLoginAuteur());
            auteurE.setPwdAuteur(auteur.getPwdAuteur());
            em.merge(auteurE);
        } catch (Exception e) {
            throw e;
        }
    }

    public void ajouter(Client client) throws Exception {
        try {
            em.persist(client);
        } catch (Exception e) {
            throw e;
        }
    }

    public void supprimer(int id) throws Exception {
        try {
            Auteur auteur = lire(id);
            em.remove(auteur);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public AuteurFacade() {
        super(Auteur.class);
    }
    
}
