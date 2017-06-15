/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

/**
 *
 * @author Epulapp
 */

public class RedigePK{

    private int idArticle;
    private int idAuteur;

    public RedigePK() {
    }

    public RedigePK(int idArticle, int idAuteur) {
        this.idArticle = idArticle;
        this.idAuteur = idAuteur;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }
}
