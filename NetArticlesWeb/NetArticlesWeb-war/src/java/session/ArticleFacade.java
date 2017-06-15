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
import java.util.Objects;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.ConnectionFactory;
import javax.jms.MapMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
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
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            lArticles = clientNetArticlesRest.getArticles();
            return lArticles;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Article lire(int id) throws Exception {
        try {
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            return clientNetArticlesRest.getArticle(Article.class, id);
        } catch (Exception e) {
            throw e;
        }
    }
    
        public List<Article> listerByDomaine(Domaine domaine) throws Exception {
        try {
            ClientNetArticlesRest clientNetArticlesRest = new ClientNetArticlesRest();
            List<Article> response = clientNetArticlesRest.getArticlesByDomaine(domaine);
            return response;
        } catch (Exception e) {
            throw e;
        }
    }

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
    
     @Resource(mappedName = "FabriqueArticles")
    private ConnectionFactory fabriqueArticlesJMS;
    @Resource(mappedName = "jms/Articles")
    private Topic articles;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private TopicPublisher producteur = null;
    private MapMessage mapMessage = null;

    
    

    
    
    public void Emettre(Article art) {

        try {
            connection = (TopicConnection) fabriqueArticlesJMS.createConnection();
            session = connection.createTopicSession(false, 0);
            producteur = session.createPublisher(articles);
            mapMessage = session.createMapMessage();
            mapMessage.setString("id", art.getIdArticle().toString());
            
            mapMessage.setString("titre", art.getTitre());
            System.err.println("id : " + art.getIdArticle());
            System.err.println("Titre : " + art.getTitre());
            producteur.publish(mapMessage);

            producteur.close();
        } catch (Exception ex) {
            System.out.println("Erreur : " + ex.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
