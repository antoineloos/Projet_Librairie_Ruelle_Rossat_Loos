/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dal.Article;
import dal.Auteur;

import dal.Redige;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Epulapp
 */
@Stateless
public class RedigeFacade extends AbstractFacade<Redige> {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RedigeFacade() {
        super(Redige.class);
    }

    public List<Redige> listeByAuteur(Auteur auteur) {
        
        try {
            Query requete = em.createNamedQuery("Redige.findByIdAuteur");
            requete.setParameter("idAuteur", auteur.getIdAuteur());
            List<Redige> tmp = requete.getResultList();
            return tmp;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
