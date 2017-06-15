/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;

/**
 *
 * @author Epulapp
 */
public class Client {

    private static final long serialVersionUID = 1L;
   
    private Integer idClient;
    private String identiteClient;
    private String adresseClient;
    private Integer credits;
    private String loginClient;
    private String pwdClient;
    private Collection<Achete> acheteCollection;
    Categorie idCategorie;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, String loginClient, String pwdClient) {
        this.idClient = idClient;
        this.loginClient = loginClient;
        this.pwdClient = pwdClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getIdentiteClient() {
        return identiteClient;
    }

    public void setIdentiteClient(String identiteClient) {
        this.identiteClient = identiteClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getLoginClient() {
        return loginClient;
    }

    public void setLoginClient(String loginClient) {
        this.loginClient = loginClient;
    }

    public String getPwdClient() {
        return pwdClient;
    }

    public void setPwdClient(String pwdClient) {
        this.pwdClient = pwdClient;
    }

    public Collection<Achete> getAcheteCollection() {
        return acheteCollection;
    }

    public void setAcheteCollection(Collection<Achete> acheteCollection) {
        this.acheteCollection = acheteCollection;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
    }    
}
