package com.esprit.rhmanager.demandeconge.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class DemandeConge implements Serializable {
    private static final long serialVersionUID = 6 ;

    @Id
    @GeneratedValue
    private int idConge ;
    private String userName ;
    private String poste ;
    private int duree ;
    private Boolean etat ;


    public DemandeConge(){

    }
    public DemandeConge(String userName) {
        super();
        this.userName = userName;
    }

    public int getIdConge() {
        return idConge;
    }


    public void setIdConge(int idConge) {
        this.idConge = idConge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
}
