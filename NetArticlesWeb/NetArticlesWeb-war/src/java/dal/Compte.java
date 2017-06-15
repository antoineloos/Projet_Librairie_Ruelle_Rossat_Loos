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
public class Compte {
    
    private static final long serialVersionUID = 1L;
    protected Integer id_compte;
    public Integer solde;

    public Compte() {
    }

    public Compte(Integer id_compte) {
        this.id_compte = id_compte;
    }

    public Compte(Integer id_compte, Integer solde) {
        this.id_compte = id_compte;
        this.solde = solde;
    }

    public Integer getId_compte() {
        return id_compte;
    }

    public void setId_compte(Integer id_compte) {
        this.id_compte = id_compte;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }


    
    
}
