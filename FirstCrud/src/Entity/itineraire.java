/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author mhcab
 */
public class itineraire {
    int idUser;
    int idRes;
    String pointDepart;
    String pointDestination;
    int DureéEstime;

    public itineraire(int idUser, int idRes) {
        this.idUser = idUser;
        this.idRes = idRes;
    }

    public itineraire(int idUser, int idRes, String pointDepart, String pointDestination, int DureéEstime) {
        this.idUser = idUser;
        this.idRes = idRes;
        this.pointDepart = pointDepart;
        this.pointDestination = pointDestination;
        this.DureéEstime = DureéEstime;
    }

    public itineraire() {
    }

    public itineraire(String pointDepart, String pointDestination, int DureéEstime) {
        this.pointDepart = pointDepart;
        this.pointDestination = pointDestination;
        this.DureéEstime = DureéEstime;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    public String getPointDepart() {
        return pointDepart;
    }

    public void setPointDepart(String pointDepart) {
        this.pointDepart = pointDepart;
    }

    public String getPointDestination() {
        return pointDestination;
    }

    public void setPointDestination(String pointDestination) {
        this.pointDestination = pointDestination;
    }

    public int getDureéEstime() {
        return DureéEstime;
    }

    @Override
    public String toString() {
        return "itineraire{ pointDepart=" + pointDepart + ", pointDestination=" + pointDestination + ", Dure\u00e9Estime=" + DureéEstime + '}';
    }

    public void setDureéEstime(int DureéEstime) {
        this.DureéEstime = DureéEstime;
    }
    
}
