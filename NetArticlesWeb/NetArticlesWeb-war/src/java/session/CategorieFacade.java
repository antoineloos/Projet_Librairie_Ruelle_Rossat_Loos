/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import client.ClientNetArticlesRest;
import dal.Categorie;
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
public class CategorieFacade {

    private Categorie categorie;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Categorie> lister() throws Exception {

        List<Categorie> lCategories = new ArrayList<Categorie>();
        try {
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            lCategories = clientNetArticlesRest.getCategories();
            return lCategories;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Categorie lire(int id) throws Exception {
        try {
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            return clientNetArticlesRest.getCategorie(Categorie.class, id);
        } catch (Exception e) {
            throw e;
        }
    }
}
