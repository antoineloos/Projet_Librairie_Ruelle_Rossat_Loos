/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import dal.Compte;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Epulapp
 */
@Stateless
public class CompteFacade extends AbstractFacade<Compte> {

    @PersistenceContext(unitName = "BanqueRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Liste des comptes
     *
     * @return : Collection de Comptes
     * @throws Exception
     */
    public List<Compte> lister() throws Exception {
        try {
            return (em.createNamedQuery("Compte.findAll").getResultList());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Lecture d'un compte sur son Id
     * @param id : id du compte à lire
     * @return : Compte
     * @throws Exception
     */
    public Compte lire(int id) throws Exception {
        try {
            return em.find(Compte.class, id);
        } catch (Exception e) {
            throw e;
        }
    }
    
        /**
     * Lecture d'un compte sur son Id
     * @param id : id du compte à lire
     * @return : Compte
     * @throws Exception
     */
    public boolean provisionCompte(Compte compte, Integer montant) throws Exception {
        try {
            Compte compteE = lire(compte.getIdCompte());
            if (compteE.getSolde() > montant) {
                compteE.setSolde(compteE.getSolde() - montant);
                modifier(compteE);
                return true;
            } else {
                return false; 
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Modification d'un compte
     * @param compte : Compet à modifier
     * @throws Exception 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
     public void modifier(Compte compte) throws Exception {
        try {
            Compte compteE = lire(compte.getIdCompte());
            compteE.setSolde(compte.getSolde());
            em.merge(compteE);
        } catch (Exception e) {
            throw e;
        }
    }
     
    

    public CompteFacade() {
        super(Compte.class);
    }

}
