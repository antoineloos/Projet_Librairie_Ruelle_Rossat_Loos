/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dal.Achete;
import dal.Article;
import dal.Domaine;
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
public class ArticleFacade extends AbstractFacade<Article> {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

   
    public List<Article> listeByDomaine(Domaine idDomaine) throws Exception {
        try {
            Query requete = em.createNamedQuery("Article.findByDomaine");
            requete.setParameter("idDomaine", idDomaine);
            return (requete.getResultList());
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArticleFacade() {
        super(Article.class);
    }
    
}
