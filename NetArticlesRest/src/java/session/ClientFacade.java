/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

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
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    public Client lireLogin(String login) throws Exception {
        try {
            Query requete = em.createNamedQuery("Client.findByLoginClient");
            requete.setParameter("loginClient", login);
            return ((Client) requete.getSingleResult());
        } catch (Exception e) {
            throw e;
        }
    }

    public Client lire(int id) throws Exception {
        try {
            return em.find(Client.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modifier(Client client) throws Exception {
        try {
            Client clientE = lire(client.getIdClient());
            clientE.setIdCategorie(client.getIdCategorie());
            clientE.setAdresseClient(client.getAdresseClient());
            clientE.setCredits(client.getCredits());
            clientE.setIdentiteClient(client.getIdentiteClient());
            clientE.setLoginClient(client.getLoginClient());
            clientE.setPwdClient(client.getPwdClient());
            em.merge(clientE);
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
            Client client = lire(id);
            em.remove(client);
        } catch (Exception e) {
            throw e;
        }
    }
}
