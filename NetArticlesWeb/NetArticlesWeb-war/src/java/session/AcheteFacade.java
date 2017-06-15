/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import client.ClientNetArticlesRest;
import dal.Achete;
import dal.Article;
import dal.Client;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.core.Response;

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
public class AcheteFacade {

    // Retourne la liste des achats du client
    public List<Achete> getAcheteByCustomer(int id) throws Exception {

        List<Achete> lAchetes = new ArrayList<Achete>();
        try {
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            lAchetes = clientNetArticlesRest.getAchete(id);
            return lAchetes;
        } catch (Exception e) {
            throw e;
        }
    }

    public Response ajouterAchat(Achete achete) throws Exception {
        try {
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            Response response = clientNetArticlesRest.ajouterAchat(achete);
            return response;
        } catch (Exception e) {
            throw e;
        }
    }

    public Response ajouter(Achete achete) throws Exception {
        try {
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            Response response = clientNetArticlesRest.ajouterAchete(achete);
            return response;
        } catch (Exception e) {
            throw e;
        }
    }

}
