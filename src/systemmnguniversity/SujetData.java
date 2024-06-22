/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmnguniversity;

import java.util.Date;
import javax.print.DocFlavor;

/**
 *
 * @author RSservices
 */
public class SujetData {
    
    private Integer id;
    private String codeSujet;
    private String sujet;
    private String cours;
    private String status;
    private Date dateinsert;
    private Date dateMod;
    private Date dateSupp;

    public SujetData(Integer id, String codeSujet, String sujet, String cours, String status, Date dateinsert, Date dateMod, Date dateSupp) {
        this.id = id;
        this.codeSujet = codeSujet;
        this.sujet = sujet;
        this.cours = cours;
        this.status = status;
        this.dateinsert = dateinsert;
        this.dateMod = dateMod;
        this.dateSupp = dateSupp;
    }

    public Integer getId() {
        return id;
    }

    public String getCodeSujet() {
        return codeSujet;
    }

    public String getSujet() {
        return sujet;
    }

    public String getCours() {
        return cours;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateinsert() {
        return dateinsert;
    }

    public Date getDateMod() {
        return dateMod;
    }

    public Date getDateSupp() {
        return dateSupp;
    }
    
    
    
}
