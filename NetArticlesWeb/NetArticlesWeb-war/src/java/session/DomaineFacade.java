/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import client.ClientNetArticlesRest;
import dal.Article;
import dal.Domaine;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
public class DomaineFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Domaine> lister() throws Exception {

        List<Domaine> lDomaines = new ArrayList<Domaine>();
        try {
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            lDomaines = clientNetArticlesRest.getDomaines();
            return lDomaines;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Domaine lire(int id) throws Exception {
        try {
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            return clientNetArticlesRest.getDomaine(Domaine.class, id);
        } catch (Exception e) {
            throw e;
        }
    }
}
