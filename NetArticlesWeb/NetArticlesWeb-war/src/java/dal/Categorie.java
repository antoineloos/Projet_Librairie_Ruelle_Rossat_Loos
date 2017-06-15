/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.Collection;

/**
 *
 * @author Epulapp
 */
public class Categorie{

    private static final long serialVersionUID = 1L;
    private Integer idCategorie;
    private String libcategorie;
    private Collection<Client> clientCollection;

    public Categorie() {
    }

    public Categorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibcategorie() {
        return libcategorie;
    }

    public void setLibcategorie(String libcategorie) {
        this.libcategorie = libcategorie;
    }

    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }    
}
