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
public class AchetePK{

    private int idClient;
    private int idArticle;

    public AchetePK() {
    }

    public AchetePK(int idClient, int idArticle) {
        this.idClient = idClient;
        this.idArticle = idArticle;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }
}
