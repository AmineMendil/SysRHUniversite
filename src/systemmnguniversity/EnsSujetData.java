/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmnguniversity;

import java.util.Date;


public class EnsSujetData {
    
    private int id; 
    private String code_sujet;
    private String sujet;
    private Date date_insert;
    private String status;

    public EnsSujetData(int id, String code_sujet, String sujet, Date date_insert, String status) {
        this.id = id;
        this.code_sujet = code_sujet;
        this.sujet = sujet;
        this.date_insert = date_insert;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCode_sujet() {
        return code_sujet;
    }

    public String getSujet() {
        return sujet;
    }

    public Date getDate_insert() {
        return date_insert;
    }

    public String getStatus() {
        return status;
    }
    
    
    
    
}
