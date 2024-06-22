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
public class CoursData {
    
    private Integer id;
    private String cours;
    private String departement;
    private double prix;
    private String statuts;
    private Date dateInsert;
    private Date dateMod;
    private Date dateSupp;

    public CoursData(Integer id, String cours, String departement, double prix,String statuts, Date dateInsert, Date dateMod, Date dateSupp) {
        this.id = id;
        this.cours = cours;
        this.departement = departement;
        this.prix = prix;
        this.statuts = statuts;
        this.dateInsert = dateInsert;
        this.dateMod = dateMod;
        this.dateSupp = dateSupp;
    }

    public Integer getId() {
        return id;
    }

    public String getCours() {
        return cours;
    }

    public String getDepartement() {
        return departement;
    }

    public double getPrix() {
        return prix;
    }

    public String getStatuts() {
        return statuts;
    }

    public Date getDateInsert() {
        return dateInsert;
    }

    public Date getDateMod() {
        return dateMod;
    }

    public Date getDateSupp() {
        return dateSupp;
    }
    
    
    
}
