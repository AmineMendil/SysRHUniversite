/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmnguniversity;

import java.sql.Date;

/**
 *
 * @author RSservices
 */
public class SalaireData {
    
    private int id;
    private String id_salaire;
    private String nom;
    private String prenom;
    private int jour_tot;
    private double salaire_paie;
    private Date date_paie;

    public SalaireData(int id, String id_salaire, String nom, String prenom, int jour_tot, double salaire_paie, Date date_paie) {
        this.id = id;
        this.id_salaire = id_salaire;
        this.nom = nom;
        this.prenom = prenom;
        this.jour_tot = jour_tot;
        this.salaire_paie = salaire_paie;
        this.date_paie = date_paie;
    }

    public int getId() {
        return id;
    }

    public String getId_salaire() {
        return id_salaire;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getJour_tot() {
        return jour_tot;
    }

    public double getSalaire_paie() {
        return salaire_paie;
    }

    public Date getDate_paie() {
        return date_paie;
    }
    
    
    
    
}
