/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dal.Achete;
import dal.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Epulapp
 */
@Stateless
public class AcheteFacade extends AbstractFacade<Achete> {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Achete> getAcheteByCustomer(int id) {
        return em.createNamedQuery("Achete.findByIdClient").setParameter("idClient", id).getResultList();

    }

    public void ajouterAchat(Achete achete) throws Exception {
        try {
            em.persist(achete);
        } catch (Exception e) {
            throw e;
        }
    }

    public AcheteFacade() {
        super(Achete.class);
    }

}
