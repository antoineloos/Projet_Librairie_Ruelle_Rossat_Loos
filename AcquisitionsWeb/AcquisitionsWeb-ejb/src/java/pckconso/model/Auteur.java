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
public class Auteur{

    private static final long serialVersionUID = 1L;
    private Integer idAuteur;
    private String identiteAuteur;
    private String adresseAuteur;
    private String loginAuteur;
    private String pwdAuteur;
    private Collection<Redige> redigeCollection;
    private Collection<Droits> droitsCollection;

    public Auteur() {
    }

    public Auteur(Integer idAuteur) {
        this.idAuteur = idAuteur;
    }

    public Auteur(Integer idAuteur, String loginAuteur, String pwdAuteur) {
        this.idAuteur = idAuteur;
        this.loginAuteur = loginAuteur;
        this.pwdAuteur = pwdAuteur;
    }

    public Integer getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(Integer idAuteur) {
        this.idAuteur = idAuteur;
    }

    public String getIdentiteAuteur() {
        return identiteAuteur;
    }

    public void setIdentiteAuteur(String identiteAuteur) {
        this.identiteAuteur = identiteAuteur;
    }

    public String getAdresseAuteur() {
        return adresseAuteur;
    }

    public void setAdresseAuteur(String adresseAuteur) {
        this.adresseAuteur = adresseAuteur;
    }

    public String getLoginAuteur() {
        return loginAuteur;
    }

    public void setLoginAuteur(String loginAuteur) {
        this.loginAuteur = loginAuteur;
    }

    public String getPwdAuteur() {
        return pwdAuteur;
    }

    public void setPwdAuteur(String pwdAuteur) {
        this.pwdAuteur = pwdAuteur;
    }

    public Collection<Redige> getRedigeCollection() {
        return redigeCollection;
    }

    public void setRedigeCollection(Collection<Redige> redigeCollection) {
        this.redigeCollection = redigeCollection;
    }

    public Collection<Droits> getDroitsCollection() {
        return droitsCollection;
    }

    public void setDroitsCollection(Collection<Droits> droitsCollection) {
        this.droitsCollection = droitsCollection;
    }
}
