/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.Date;

/**
 *
 * @author Epulapp
 */
public class DroitsPK{

    private int idAuteur;
    private Date dateTrimestre;

    public DroitsPK() {
    }

    public DroitsPK(int idAuteur, Date dateTrimestre) {
        this.idAuteur = idAuteur;
        this.dateTrimestre = dateTrimestre;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public Date getDateTrimestre() {
        return dateTrimestre;
    }

    public void setDateTrimestre(Date dateTrimestre) {
        this.dateTrimestre = dateTrimestre;
    }

}
