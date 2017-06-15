/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Epulapp
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idArticle;
    private String titre;
    private String resume;
    private BigDecimal prix;
    private Date dateArticle;
    private String fichier;
    private Collection<Redige> redigeCollection;
    private Collection<Achete> acheteCollection;
    private Domaine idDomaine;

    public Article() {
      
    }

    public Article(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public Article(Integer idArticle, String fichier) {
        this.idArticle = idArticle;
        this.fichier = fichier;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Date getDateArticle() {
        return dateArticle;
    }

    public void setDateArticle(Date dateArticle) {
        this.dateArticle = dateArticle;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    
    public Collection<Redige> getRedigeCollection() {
        return redigeCollection;
    }

    public void setRedigeCollection(Collection<Redige> redigeCollection) {
        this.redigeCollection = redigeCollection;
    }

    public Collection<Achete> getAcheteCollection() {
        return acheteCollection;
    }

    public void setAcheteCollection(Collection<Achete> acheteCollection) {
        this.acheteCollection = acheteCollection;
    }

    public Domaine getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Domaine idDomaine) {
        this.idDomaine = idDomaine;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idArticle);
        hash = 23 * hash + Objects.hashCode(this.titre);
        hash = 23 * hash + Objects.hashCode(this.resume);
        hash = 23 * hash + Objects.hashCode(this.prix);
        hash = 23 * hash + Objects.hashCode(this.dateArticle);
        hash = 23 * hash + Objects.hashCode(this.fichier);
        hash = 23 * hash + Objects.hashCode(this.redigeCollection);
        hash = 23 * hash + Objects.hashCode(this.acheteCollection);
        hash = 23 * hash + Objects.hashCode(this.idDomaine);
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
        final Article other = (Article) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.resume, other.resume)) {
            return false;
        }
        if (!Objects.equals(this.fichier, other.fichier)) {
            return false;
        }
        if (!Objects.equals(this.idArticle, other.idArticle)) {
            return false;
        }
        if (!Objects.equals(this.prix, other.prix)) {
            return false;
        }
        if (!Objects.equals(this.dateArticle, other.dateArticle)) {
            return false;
        }
        if (!Objects.equals(this.redigeCollection, other.redigeCollection)) {
            return false;
        }
        if (!Objects.equals(this.acheteCollection, other.acheteCollection)) {
            return false;
        }
        if (!Objects.equals(this.idDomaine, other.idDomaine)) {
            return false;
        }
        return true;
    }



    
    
}
