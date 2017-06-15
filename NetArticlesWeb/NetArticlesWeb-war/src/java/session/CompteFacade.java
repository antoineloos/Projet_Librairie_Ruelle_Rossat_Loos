/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import client.ClientBanqueRest;
import client.ClientNetArticlesRest;
import dal.Compte;
import javax.ejb.*;
import javax.ws.rs.core.Response;
import utils.Transaction;

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
public class CompteFacade {

    private Compte compte;

    public Compte getCompte() {
        return this.compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Boolean debiterCompte(Transaction transaction) throws Exception {
        try {
            ClientBanqueRest clientBanqueRest = new ClientBanqueRest();
            Boolean bool = clientBanqueRest.debiterCompte(transaction);
            return bool;
        } catch (Exception e) {
            throw e;
        }
    }
    
   
}
