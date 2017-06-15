/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author Epulapp
 */
public class Domaine{

    private static final long serialVersionUID = 1L;
    private Integer idDomaine;
    private String libdomaine;
    private Collection<Article> articleCollection;

    public Domaine() {
    }

    public Domaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    public Integer getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getLibdomaine() {
        return libdomaine;
    }

    public void setLibdomaine(String libdomaine) {
        this.libdomaine = libdomaine;
    }

    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idDomaine);
        hash = 89 * hash + Objects.hashCode(this.libdomaine);
        hash = 89 * hash + Objects.hashCode(this.articleCollection);
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
        final Domaine other = (Domaine) obj;
        if (!Objects.equals(this.libdomaine, other.libdomaine)) {
            return false;
        }
        if (!Objects.equals(this.idDomaine, other.idDomaine)) {
            return false;
        }
        if (!Objects.equals(this.articleCollection, other.articleCollection)) {
            return false;
        }
        return true;
    }
    
    
    
}
