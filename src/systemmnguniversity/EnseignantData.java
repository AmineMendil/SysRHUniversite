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
public class EnseignantData {

    private Integer id;
    private String id_enseignant;
    private String nom;
    private String prenom;
    private String email;
    private String nomUtilisateur;
    private String sexe;
    private double salaire;
    private String statutsSalaire;
    private String departement;
    private String image;
    private Date dateNaiss;
    private String experience;
    private Date dateInsertion;
    private Date dateModification;
    private Date dateSuppression;
    private String status;
    private String anneeExperience;

    public EnseignantData(Integer id, String id_enseignant, String nom, String prenom, String email, String nomUtilisateur,
            String sexe, String anneeExperience, double salaire, String statutsSalaire, String departement, String image,
            Date dateNaiss, String experience, Date dateInsertion, Date dateModification, Date dateSuppression,
             String status) {
        this.id = id;
        this.id_enseignant = id_enseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.nomUtilisateur = nomUtilisateur;
        this.sexe = sexe;
        this.anneeExperience = anneeExperience;
        this.salaire = salaire;
        this.statutsSalaire = statutsSalaire;
        this.departement = departement;
        this.image = image;
        this.dateNaiss = dateNaiss;
        this.experience = experience;
        this.dateInsertion = dateInsertion;
        this.dateModification = dateModification;
        this.dateSuppression = dateSuppression;
        this.status = status;

    }

    public EnseignantData(Integer id, String id_enseignant, String nom, String prenom, double salaire,
            String statutsSalaire, Date dateInsertion, Date dateModification, String status) {
        this.id = id;
        this.id_enseignant = id_enseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.statutsSalaire = statutsSalaire;
        this.dateInsertion = dateInsertion;
        this.dateModification = dateModification;
        this.status = status;

    }

    public EnseignantData(Integer id, String id_enseignant, String nom, String sexe, Date dateInsertion, String anneeExperience) {
        this.id = id;
        this.id_enseignant = id_enseignant;
        this.nom = nom;
        this.sexe = sexe;
        this.dateInsertion = dateInsertion;
        this.anneeExperience = anneeExperience;
    }

    
//DataStudentHandle(String teacherID, String studentID
//            , String name, String gender, Date dateInsert)
 
   

    
    
   

    public Integer getId() {
        return id;
    }

    public String getId_enseignant() {
        return id_enseignant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getSexe() {
        return sexe;
    }

    public double getSalaire() {
        return salaire;
    }

    public String getStatutsSalaire() {
        return statutsSalaire;
    }

    public String getDepartement() {
        return departement;
    }

    public String getImage() {
        return image;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public String getExperience() {
        return experience;
    }

    public Date getDateInsertion() {
        return dateInsertion;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public String getStatus() {
        return status;
    }

    public String getAnneeExperience() {
        return anneeExperience;
    }

}
