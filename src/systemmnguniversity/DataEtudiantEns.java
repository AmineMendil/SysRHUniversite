/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmnguniversity;

import java.util.Date;



/**
 *
 * @author RSservices
 */
public class DataEtudiantEns {
    
    private int id;
    private String teacherID;
    private String etud_idEtud;
    private String nom_etud;
    private String prenom_etud;
    private String email_etud;
    private String genre_etud;
    private String cours_etud;
    private String semestre_etud;
    private Date dateInsertion;
    private Date datesuppression;
    private String status;

    public DataEtudiantEns(int id, String etud_idEtud, String nom_etud, String prenom_etud, String cours_etud, String semestre_etud, Date dateInsertion, Date datesuppression, String status) {
        this.id = id;
        this.etud_idEtud = etud_idEtud;
        this.nom_etud = nom_etud;
        this.prenom_etud = prenom_etud;
        this.cours_etud = cours_etud;
        this.semestre_etud = semestre_etud;
        this.dateInsertion = dateInsertion;
        this.datesuppression = datesuppression;
        this.status = status;
    }

    public DataEtudiantEns(String etud_idEtud, String nom_etud, String prenom_etud, String email_etud, String genre_etud, String cours_etud, String semestre_etud, Date dateInsertion, Date datesuppression, String status) {
        this.etud_idEtud = etud_idEtud;
        this.nom_etud = nom_etud;
        this.prenom_etud = prenom_etud;
        this.email_etud = email_etud;
        this.genre_etud = genre_etud;
        this.cours_etud = cours_etud;
        this.semestre_etud = semestre_etud;
        this.dateInsertion = dateInsertion;
        this.datesuppression = datesuppression;
        this.status = status;
    }
    

    
      public DataEtudiantEns(String teacherID, String etud_idEtud , String nom_etud, String genre_etud,  Date dateInsertion) {
        this.teacherID = teacherID;
        this.etud_idEtud = etud_idEtud;
        this.nom_etud = nom_etud;
        this.genre_etud = genre_etud;
        this.dateInsertion = dateInsertion;
    }

    public String getTeacherID() {
        return teacherID;
    }
    

    public String getEmail_etud() {
        return email_etud;
    }

    public String getGenre_etud() {
        return genre_etud;
    }

    
    
    

    public int getId() {
        return id;
    }

    public String getEtud_idEtud() {
        return etud_idEtud;
    }

    public String getNom_etud() {
        return nom_etud;
    }

    public String getPrenom_etud() {
        return prenom_etud;
    }

    public String getCours_etud() {
        return cours_etud;
    }

    public String getSemestre_etud() {
        return semestre_etud;
    }

    public Date getDateInsertion() {
        return dateInsertion;
    }

    public Date getDatesuppression() {
        return datesuppression;
    }

    public String getStatus() {
        return status;
    }
    
    
    
}
