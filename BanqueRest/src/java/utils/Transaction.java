/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Epulapp
 */
public class Transaction {
    
    public Integer idCompte; 
    public Integer montantTransaction; 

    public Transaction() {
    }
    
    public Transaction(Integer idCompte, Integer montantTransaction) {
        this.idCompte = idCompte;
        this.montantTransaction = montantTransaction;
    }

    public Integer getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public Integer getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(Integer montantTransaction) {
        this.montantTransaction = montantTransaction;
    }
    
    
}
