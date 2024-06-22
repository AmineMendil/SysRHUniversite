package systemmnguniversity;

import java.util.Date;

public class DataEtudiant {

    private Integer id;
    private String idEtud;
    private String email;
    private String nomUtil;
    private String mdp;
    private String nom;
    private String prenom;
    private Date dateNaiss;
    private Date dateInsc;
    private Date dateMod;
    private Date datesupp;
    private String sexe;
    private String image;
    private String cours;
    private String section;
    private String annee;
    private double paiment;
    private String st_paiment; //statut_paiment
    private String st; //statut

    public DataEtudiant(Integer id, String idEtud, String email, String nomUtil, String mdp, String nom, String prenom, Date dateNaiss, Date dateInsc, Date dateMod, Date datesupp,
            String sexe, String image, String cours, String section, String annee, double paiment, String st_paiment, String st) {
        this.id = id;
        this.idEtud = idEtud;
        this.email = email;
        this.nomUtil = nomUtil;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.dateInsc = dateInsc;
        this.dateMod = dateMod;
        this.datesupp = datesupp;
        this.sexe = sexe;
        this.image = image;
        this.cours = cours;
        this.section = section;
        this.annee = annee;
        this.paiment = paiment;
        this.st_paiment = st_paiment;
        this.st = st;
    }

    public DataEtudiant(Integer id, String idEtud, String email, String nomUtil, String mdp, String nom, String prenom, Date dateNaiss, Date dateInsc,
            Date dateMod, Date datesupp, String sexe, String cours, String section, String annee, double paiment,String st_paiment, String st) {
        this.id = id;
        this.idEtud = idEtud;
        this.email = email;
        this.nomUtil = nomUtil;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.dateInsc = dateInsc;
        this.dateMod = dateMod;
        this.datesupp = datesupp;
        this.sexe = sexe;
        this.cours = cours;
        this.section = section;
        this.annee = annee;
        this.paiment = paiment;
        this.st_paiment = st_paiment;
        this.st = st;
    }

    public DataEtudiant(Integer id, String idEtud, String nom, String prenom, Date dateMod
            , String image, String section, String annee, double paiment, String st_paiment) {
        this.id = id;
        this.idEtud = idEtud;
        this.nom = nom;
        this.prenom = prenom;
        this.dateMod = dateMod;
        this.image = image;
        this.section = section;
        this.annee = annee;
        this.paiment = paiment;
        this.st_paiment = st_paiment;
    }
    
    

    
    
    
 
    public Integer getId() {
        return id;
    }

    public String getIdEtud() {
        return idEtud;
    }

    public String getEmail() {
        return email;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public Date getDateInsc() {
        return dateInsc;
    }

    public Date getDateMod() {
        return dateMod;
    }

    public Date getDatesupp() {
        return datesupp;
    }

    public String getSexe() {
        return sexe;
    }

    public String getImage() {
        return image;
    }

    public String getCours() {
        return cours;
    }

    public String getSection() {
        return section;
    }

    public String getAnnee() {
        return annee;
    }

    public double getPaiment() {
        return paiment;
    }
    
    

    public String getSt_paiment() {
        return st_paiment;
    }

    public String getSt() {
        return st;
    }

}
