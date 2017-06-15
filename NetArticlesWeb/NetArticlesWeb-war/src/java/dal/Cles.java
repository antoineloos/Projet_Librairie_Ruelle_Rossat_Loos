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
public class Cles{

    private static final long serialVersionUID = 1L;
    private String idCle;
    private Integer valCle;
    private String libCle;

    public Cles() {
    }

    public Cles(String idCle) {
        this.idCle = idCle;
    }

    public String getIdCle() {
        return idCle;
    }

    public void setIdCle(String idCle) {
        this.idCle = idCle;
    }

    public Integer getValCle() {
        return valCle;
    }

    public void setValCle(Integer valCle) {
        this.valCle = valCle;
    }

    public String getLibCle() {
        return libCle;
    }

    public void setLibCle(String libCle) {
        this.libCle = libCle;
    }
}
