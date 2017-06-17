/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import client.AcquisitionClient;
import dal.Auteur;

import javax.ws.rs.core.Response;
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
public class AuteurFacade {
    private Auteur auteur;

    public Auteur getAuteur() {
        return this.auteur;
    }

    public void setClient(Auteur auteur) {
        this.auteur = auteur;
    }

       /**
     * Lecture de l'utilisateur sur son login Note : le login est unique
     * (contrainte de bd)
     *
     * @param login login de l'utilisateur à lire
     * @return un objet Client
     * @throws Exception
     */
    public Auteur lireLogin(String login) throws Exception {
        try {
            AcquisitionClient NetArticlesRest = new AcquisitionClient();
            
            return NetArticlesRest.getConnexionAuteur(Auteur.class, login);
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Vérifie qu'un Client voulant s'authentifier a bien fournit le bon
     * login et le bon mot de passe
     *
     * @param login Login de l'Client
     * @param pwd Mot de passe de l'Client
     * @return True : si tout OK, False sinon
     * @throws Exception
     */
    public boolean connecter(String login, String pwd) throws Exception {
        boolean retour = false;
        try {
            this.auteur = lireLogin(login);
            if (pwd.equals(auteur.getPwdAuteur())) {
                retour = true;
            }
            return retour;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public Response modifier(Auteur auteur) throws Exception {
        try {
            AcquisitionClient NetArticlesRest = new AcquisitionClient();
            Response response = NetArticlesRest.modifierAuteur(auteur);
            return response;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Response ajouter(Auteur auteur) throws Exception {
        try {
            AcquisitionClient NetArticlesRest = new AcquisitionClient();
            Response response = NetArticlesRest.ajouterAuteur(auteur);
            return response;
        } catch (Exception e) {
            throw e;
        }
    }
    
   
    
    public Auteur lire(int id) throws Exception {
        try {
            AcquisitionClient NetArticlesRest = new AcquisitionClient();
            return NetArticlesRest.getAuteur(Auteur.class, id);
        } catch (Exception e) {
            throw e;
        }
    }
}
