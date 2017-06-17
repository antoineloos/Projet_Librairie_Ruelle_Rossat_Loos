/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import client.AcquisitionClient;
import dal.Article;
import dal.Domaine;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
/**
 *
 * @author Epulapp
 */
public class ArticleFacade {
     // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private Article article;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Article> lister() throws Exception {

        List<Article> lArticles = new ArrayList<Article>();
        try {
            AcquisitionClient clientNetArticlesRest = new AcquisitionClient();
            lArticles = clientNetArticlesRest.getArticles();
            return lArticles;
        } catch (Exception e) {
            throw e;
        }
    }
    
//    public Article lire(int id) throws Exception {
//        try {
//            AcquisitionClient clientNetArticlesRest = new AcquisitionClient();
//            return clientNetArticlesRest.getArticle(Article.class, id);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    
//        public List<Article> listerByDomaine(Domaine domaine) throws Exception {
//        try {
//            AcquisitionClient clientNetArticlesRest = new AcquisitionClient();
//            List<Article> response = clientNetArticlesRest.getArticlesByDomaine(domaine);
//            return response;
//        } catch (Exception e) {
//            throw e;
//        }
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArticleFacade other = (ArticleFacade) obj;
        if (!Objects.equals(this.article, other.article)) {
            return false;
        }
        return true;
    }
    
}
