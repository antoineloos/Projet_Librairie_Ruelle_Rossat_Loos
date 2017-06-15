/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Epulapp
 */
public class Achete{

    private static final long serialVersionUID = 1L;
    protected AchetePK achetePK;
    private Date dateAchat;
    private Article article;
    private Client client;

    public Achete() {
    }

    public Achete(AchetePK achetePK) {
        this.achetePK = achetePK;
    }

    public Achete(int idClient, int idArticle, Date dateAchat) {
        this.achetePK = new AchetePK(idClient, idArticle);
        this.dateAchat = dateAchat;
    }

    public AchetePK getAchetePK() {
        return achetePK;
    }

    public void setAchetePK(AchetePK achetePK) {
        this.achetePK = achetePK;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.achetePK);
        hash = 29 * hash + Objects.hashCode(this.dateAchat);
        hash = 29 * hash + Objects.hashCode(this.article);
        hash = 29 * hash + Objects.hashCode(this.client);
        return hash;
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
        final Achete other = (Achete) obj;
        if (!Objects.equals(this.achetePK, other.achetePK)) {
            return false;
        }
        if (!Objects.equals(this.dateAchat, other.dateAchat)) {
            return false;
        }
        if (!Objects.equals(this.article, other.article)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        return true;
    }
    
    
    
}
