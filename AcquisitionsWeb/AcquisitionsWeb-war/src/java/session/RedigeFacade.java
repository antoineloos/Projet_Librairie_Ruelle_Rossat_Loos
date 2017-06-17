/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import client.AcquisitionClient;
import dal.Article;
import dal.Auteur;
import dal.Redige;
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
public class RedigeFacade {

    public List<Redige> getArticlesByAuteur(Auteur auteur) throws Exception {

        List<Redige> lArticles = new ArrayList<Redige>();
        try {
            AcquisitionClient clientNetArticlesRest = new AcquisitionClient();
            lArticles = clientNetArticlesRest.getRedigeByAuteur(auteur);
            return lArticles;
        } catch (Exception e) {
            throw e;
        }
    }
}
