/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dal.Cles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Epulapp
 */
@Stateless
public class ClesFacade extends AbstractFacade<Cles> {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClesFacade() {
        super(Cles.class);
    }
    
}
