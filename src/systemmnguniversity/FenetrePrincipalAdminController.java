/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmnguniversity;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author RSservices
 */
public class FenetrePrincipalAdminController implements Initializable {

    //Identifiant des composant graphique.
    @FXML
    private AnchorPane ajoutCours_window;

    @FXML
    private AnchorPane ajoutEns_window;

    @FXML
    private AnchorPane ajoutEtud_window;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_dInscEtud;

    @FXML
    private AnchorPane tabBord_window;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_dSuppEtud;

    @FXML
    private Button ajoutCour_btn;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_idEtud;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_dModEtud;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_paiEtud;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_stPaiEtud;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_dNassEtud;

    @FXML
    private Button ajoutEtudiant_btn;
    
    @FXML
    private Button deconct_btn;

    @FXML
    private Button ajoutEtud_deleteBtn;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_sexeEtud;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_prenomEtud;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_mdpEtud;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_nUtilEtud;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_stEtud;

    @FXML
    private Button ajoutEtud_addBtn;

    @FXML
    private Button salaire_btn;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_courEtud;

    @FXML
    private TableView<DataEtudiant> ajoutEtud_tableView;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_nomEtud;

    @FXML
    private Button ajoutEnseignant_btn;

    @FXML
    private Button tabBord_btn;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_anneeEtud;

    @FXML
    private Button ajoutEtud_UpdateBtn;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_emailEtud;

    @FXML
    private Label admin_nUtil;

    @FXML
    private Button ajoutFichier_btn;

    @FXML
    private TableColumn<DataEtudiant, String> ajoutEtud_col_sectionEtud;

    @FXML
    private Button paiment_btn;

    @FXML
    private Button ajoutEnsei_btnAj;

    @FXML
    private Button ajoutEnsei_btnMod;

    @FXML
    private TableView<EnseignantData> ajoutEnsei_tableView;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_anneeEx;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_departement;

    @FXML
    private TableColumn<EnseignantData, Date> ajoutEnsei_col_dtn;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_email;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_experience;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_idEns;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_nom;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_nomUtil;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_prenom;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_salaire;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_sexe;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_stSaliare;

    @FXML
    private TableColumn<EnseignantData, String> ajoutEnsei_col_status;

    @FXML
    private ComboBox<String> ajoutEnsei_comboSexe;

    @FXML
    private ComboBox<String> ajoutEnsei_comboStatus;

    @FXML
    private TextField ajoutEnsei_email;

    @FXML
    private TextField ajoutEnsei_experience;

    @FXML
    private TextField ajoutEnsei_idEns;

    @FXML
    private ComboBox<String> ajoutEnsei_comboAnneeExperience;

    @FXML
    private ComboBox<String> ajoutEnsei_idEns_comboDept;

    @FXML
    private DatePicker ajoutEnsei_idEns_dtn;

    @FXML
    private ImageView ajoutEnsei_imageView;

    @FXML
    private Button ajoutEnsei_imporBtn;

    @FXML
    private TextField ajoutEnsei_nom;

    @FXML
    private TextField ajoutEnsei_nomUtilis;

    @FXML
    private TextField ajoutEnsei_prenom;

    @FXML
    private TextField ajoutEnsei_salaire;

    @FXML
    private ComboBox<String> ajoutEnsei_st_comboSalaire;

    @FXML
    private Button ajoutEnsei_suppBtn;

    @FXML
    private Button ajoutCours__btn_supp;

    @FXML
    private Button ajoutCours__btn_vider;

    @FXML
    private TableColumn<CoursData, String> ajoutCours__col_cours;

    @FXML
    private TableColumn<CoursData, String> ajoutCours__col_dateInsert;

    @FXML
    private TableColumn<CoursData, String> ajoutCours__col_dept;

    @FXML
    private TableColumn<CoursData, String> ajoutCours__col_prix;

    @FXML
    private TableColumn<CoursData, String> ajoutCours__col_status;

    @FXML
    private TableView<CoursData> ajoutCours__tableview;

    @FXML
    private Button ajoutCours_btn_ajout;

    @FXML
    private Button ajoutCours_btn_modifier;

    @FXML
    private ComboBox<String> ajoutCours_combo_st;

    @FXML
    private TextField ajoutCours_cours;

    @FXML
    private TextField ajoutCours_dpt;

    @FXML
    private TextField ajoutCours_prix;

    @FXML
    private Button ajoutSuejt_btn_ajout;

    @FXML
    private Button ajoutSujet__btn_supp1;

    @FXML
    private TableColumn<SujetData, String> ajoutSujet__col_cours;

    @FXML
    private TableColumn<SujetData, String> ajoutSujet__col_id;

    @FXML
    private TableColumn<SujetData, String> ajoutSujet__col_insertion;

    @FXML
    private TableColumn<SujetData, String> ajoutSujet__col_status;

    @FXML
    private TableColumn<SujetData, String> ajoutSujet__col_sujet;

    @FXML
    private TableView<SujetData> ajoutSujet__tableview;

    @FXML
    private Button ajoutSujet_btn_modifier;

    @FXML
    private Button ajoutSujet_btn_vide;

    @FXML
    private ComboBox<String> ajoutSujet_combo_cours;

    @FXML
    private ComboBox<String> ajoutSujet_combo_st;

    @FXML
    private TextField ajoutSujet_id;

    @FXML
    private TextField ajoutSujet_sujet;

    @FXML
    private AnchorPane ajoutSujet_window;

    @FXML
    private TableColumn<String, DataEtudiant> paiment__col_section;

    @FXML
    private TextField paiment_annee;

    @FXML
    private AnchorPane paiment_window;

    @FXML
    private TableColumn<String, DataEtudiant> paiment_col_annee;

    @FXML
    private TableColumn<String, DataEtudiant> paiment_col_id;

    @FXML
    private TableColumn<String, DataEtudiant> paiment_col_nom;

    @FXML
    private TableColumn<String, DataEtudiant> paiment_col_paiment;

    @FXML
    private TableColumn<String, DataEtudiant> paiment_col_prenom;

    @FXML
    private TableColumn<String, DataEtudiant> paiment_col_stP;

    @FXML
    private ComboBox<String> paiment_comboStP;

    @FXML
    private TextField paiment_id;

    @FXML
    private ImageView paiment_imageView;

    @FXML
    private TextField paiment_nom;

    @FXML
    private Button paiment_paieBtn;

    @FXML
    private TextField paiment_paiment;

    @FXML
    private TextField paiment_prenom;

    @FXML
    private Button paiment_viderBtn;

    @FXML
    private TextField paiment_section;

    @FXML
    private TableView<DataEtudiant> paiment_tabView;

    @FXML
    private DatePicker salaire_datedebut;

    @FXML
    private DatePicker salaire_dateFin;

    @FXML
    private TextField salaire_IdEnseignat;

    @FXML
    private TextField salaire_nom;

    @FXML
    private TextField salaire_prenom;

    @FXML
    private ComboBox<String> salaire_status;

    @FXML
    private TextField salaire_coutparjour;

    @FXML
    private Button salaire_paieBtn;

    @FXML
    private Button salaire_viderBtn;

    @FXML
    private Label salaire_labTotalJour;

    @FXML
    private Label salaire_labSalaire;

    @FXML
    private TableView<EnseignantData> salaire_tabView;

    @FXML
    private TableColumn<EnseignantData, String> salaire_col_idEnseignant;

    @FXML
    private TableColumn<EnseignantData, String> salaire_col_nom;

    @FXML
    private TableColumn<EnseignantData, String> salaire_col_prenom;

    @FXML
    private TableColumn<EnseignantData, String> salaire_col_coutparjour;

    @FXML
    private TableColumn<EnseignantData, String> salaire_col_dateinst;

    @FXML
    private TableColumn<EnseignantData, String> salaire_col_dateModif;

    @FXML
    private TableColumn<EnseignantData, String> salaire_col_status;

    @FXML
    private TableView<SalaireData> salaire_tabView2;

    @FXML
    private TableColumn<SalaireData, String> salaire_col_idEn2;

    @FXML
    private TableColumn<SalaireData, String> salaire_col_salaireP2;

    @FXML
    private TableColumn<SalaireData, String> salaire_col_dateP2;

    @FXML
    private AnchorPane salaire_window;

    @FXML
    private Label tabBord_labTEtud;

    @FXML
    private Label tabBord_labTEns;

    @FXML
    private Label tabBord_labTInsc;

    @FXML
    private Label tabBord_labTRevenu;

    @FXML
    private BubbleChart<?, ?> graphe_revenu;

    @FXML
    private AreaChart<?, ?> graphe_etudiant;

    @FXML
    private BarChart<?, ?> graphe_enseignant;

    //Outils de la base de données.
    Connection connexion;
    private PreparedStatement preparer;
    private ResultSet resultat;
    private Statement declaration;

    private Image image;
    
    //Pour la génération des alerte.
    private MessageAlerte alert = new MessageAlerte();

    public void tabBordAffTEtud() {
        String sql = "SELECT COUNT(id) FROM etudiant WHERE date_suppression IS NULL";
        connexion = DataBase.connectDB();
        int tempTS = 0;
        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                tempTS = resultat.getInt("COUNT(id)");
            }
            tabBord_labTEtud.setText("" + tempTS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tabBordAffTEns() {
        String sql = "SELECT COUNT(id) FROM enseignant WHERE date_suppression IS NULL";
        connexion = DataBase.connectDB();
        int tempTT = 0;
        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                tempTT = resultat.getInt("COUNT(id)");
            }
            tabBord_labTEns.setText(String.valueOf(tempTT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tabBordTEtudInsc() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "SELECT COUNT(id) FROM etudiant WHERE date_suppression IS NULL AND date_inscription = '"
                + sqlDate + "'";
        connexion = DataBase.connectDB();
        int tempSRT = 0;
        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                tempSRT = resultat.getInt("COUNT(id)");

                tabBord_labTInsc.setText("" + tempSRT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tabBordAffRevenu() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "SELECT SUM(paiment) FROM etudiant WHERE stauts_paiment = 'Paie' AND date_suppression IS NULL";
        connexion = DataBase.connectDB();
        double tempTI = 0;
        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                tempTI = resultat.getDouble("SUM(paiment)");
            }
            tabBord_labTRevenu.setText("$" + tempTI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tabBordGrapheEtud() {

        graphe_etudiant.getData().clear();

        String sql = "SELECT date_inscription, COUNT(id) FROM etudiant WHERE date_suppression IS NULL GROUP BY TIMESTAMP(date_inscription) ASC LIMIT 9";

        connexion = DataBase.connectDB();

        try {
            XYChart.Series chart = new XYChart.Series<>();

            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            while (resultat.next()) {
                chart.getData().add(new XYChart.Data<>(resultat.getString(1), resultat.getInt(2)));
            }

            graphe_etudiant.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void tabBordGrapheEns() {

        graphe_enseignant.getData().clear();

        String sql = "SELECT date_inscription, COUNT(id) FROM enseignant WHERE date_suppression IS NULL GROUP BY TIMESTAMP(date_inscription) ASC LIMIT 5";

        connexion = DataBase.connectDB();

        try {
            XYChart.Series chart = new XYChart.Series<>();

            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            while (resultat.next()) {
                chart.getData().add(new XYChart.Data<>(resultat.getString(1), resultat.getInt(2)));
            }

            graphe_enseignant.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    

    public ObservableList<DataEtudiant> ajoutEtudaintGetdata() {

        ObservableList<DataEtudiant> listDonnee = FXCollections.observableArrayList();
        String selectData = "SELECT * FROM etudiant WHERE date_suppression IS NULL";

        connexion = DataBase.connectDB();

        DataEtudiant eData;

        try {

            preparer = connexion.prepareStatement(selectData);
            resultat = preparer.executeQuery();

            while (resultat.next()) {
                /*public DataEtudiant(Integer id, String idEtud, String email, String nomUtil, String mdp, String nom, String prenom, Date dateNaiss, Date dateInsc,
            Date dateMod, Date datesupp, String sexe, String cours, String section, String annee, double paiment,String st_paiment, String st)*/

                eData = new DataEtudiant(resultat.getInt("id"), resultat.getString("id_etudiant"), resultat.getString("email"),
                        resultat.getString("nom_utilisateur"), resultat.getString("mot_de_passe"), resultat.getString("nom"),
                        resultat.getString("prenom"), resultat.getDate("date_naissance"), resultat.getDate("date_inscription"),
                        resultat.getDate("date_modification"), resultat.getDate("date_suppression"), resultat.getString("genre"),
                        resultat.getString("cours"), resultat.getString("section"), resultat.getString("semestre"), resultat.getDouble("paiment"),
                        resultat.getString("stauts_paiment"), resultat.getString("stauts_compte"));
                listDonnee.add(eData);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDonnee;
    }

    private ObservableList<DataEtudiant> ajoutListDataEtud;

    public void ajoutDonneeAffEleve() {
        ajoutListDataEtud = ajoutEtudaintGetdata();

        ajoutEtud_col_idEtud.setCellValueFactory(new PropertyValueFactory<>("idEtud"));
        ajoutEtud_col_emailEtud.setCellValueFactory(new PropertyValueFactory<>("email"));
        ajoutEtud_col_nUtilEtud.setCellValueFactory(new PropertyValueFactory<>("nomUtil"));
        ajoutEtud_col_mdpEtud.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        ajoutEtud_col_nomEtud.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ajoutEtud_col_prenomEtud.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ajoutEtud_col_dNassEtud.setCellValueFactory(new PropertyValueFactory<>("dateNaiss"));
        ajoutEtud_col_sexeEtud.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        ajoutEtud_col_dInscEtud.setCellValueFactory(new PropertyValueFactory<>("dateInsc"));
        ajoutEtud_col_dModEtud.setCellValueFactory(new PropertyValueFactory<>("dateMod"));
        ajoutEtud_col_dSuppEtud.setCellValueFactory(new PropertyValueFactory<>("datesupp"));
        ajoutEtud_col_courEtud.setCellValueFactory(new PropertyValueFactory<>("cours"));
        ajoutEtud_col_sectionEtud.setCellValueFactory(new PropertyValueFactory<>("section"));
        ajoutEtud_col_anneeEtud.setCellValueFactory(new PropertyValueFactory<>("annee"));
        ajoutEtud_col_paiEtud.setCellValueFactory(new PropertyValueFactory<>("paiment"));
        ajoutEtud_col_stPaiEtud.setCellValueFactory(new PropertyValueFactory<>("st_paiment"));
        ajoutEtud_col_stEtud.setCellValueFactory(new PropertyValueFactory<>("st"));

        ajoutEtud_tableView.setItems(ajoutListDataEtud);
    }

    public void ajoutEtudiantAddBtn() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("AjoutEtudiant.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            ajoutDonneeAffEleve();
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void adminModifierBtn() {
        DataEtudiant eData = ajoutEtud_tableView.getSelectionModel().getSelectedItem();
        int num = ajoutEtud_tableView.getSelectionModel().getFocusedIndex();

        if (num == 0) {
            alert.messageErreur("Veuillez séléctionner l'item d'abord");
            return;
        } else {

            ListData.temp_idEtud = eData.getIdEtud();
            ListData.temp_emailEtud = eData.getEmail();
            ListData.temp_nomEtud = eData.getNom();
            ListData.temp_prenomEtud = eData.getPrenom();
            ListData.temp_dateNaissEtud = eData.getDateNaiss();
            ListData.temp_sexeEtud = eData.getSexe();
            ListData.temp_coursEtud = eData.getCours();
            ListData.temp_sectionEtud = eData.getSection();
            ListData.temp_anneeEtud = eData.getAnnee();
            ListData.temp_paimentEtud = eData.getPaiment();
            ListData.temp_stPaimEtud = eData.getSt_paiment();
            ListData.temp_stEtud = eData.getSt();
            ajoutDonneeAffEleve();

            try {

                Parent root = FXMLLoader.load(getClass().getResource("AjoutEtudiant.fxml"));
                Stage stage = new Stage();

                stage.setTitle("Modifier l'étudiant");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void adminSuppBtn() {

        DataEtudiant eData = ajoutEtud_tableView.getSelectionModel().getSelectedItem();

        int numero = ajoutEtud_tableView.getSelectionModel().getSelectedIndex();
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        if ((numero - 1) < -1) {
            alert.messageErreur("veuilez seléctionner un item d'abord");
            return;
        } else {
            if (alert.confirmeMessage("êtes vous sur de supprimer l'étudiant: " + eData.getIdEtud() + " ?")) {
                String suppData = "UPDATE etudiant SET 	date_suppression = ? WHERE id_etudiant = ?";

                connexion = DataBase.connectDB();

                try {
                    preparer = connexion.prepareStatement(suppData);
                    preparer.setString(1, String.valueOf(sqlDate));
                    preparer.setString(2, eData.getIdEtud());
                    preparer.executeUpdate();
                    alert.messageReussie("L'étudiant avec l'ID: " + eData.getIdEtud() + " est bien supprimer");

                } catch (Exception e) {
                }
            } else {
                alert.messageErreur("l'opération de suppression est annuler");

            }
        }
        ajoutDonneeAffEleve();

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ObservableList<EnseignantData> ajoutEnseignantGetData() {

        ObservableList<EnseignantData> listData = FXCollections.observableArrayList();
        String sqlSel = "SELECT * FROM enseignant WHERE date_suppression IS NULL";

        connexion = DataBase.connectDB();
        try {
            preparer = connexion.prepareStatement(sqlSel);
            resultat = preparer.executeQuery();

            EnseignantData tdata;

            while (resultat.next()) {
                /*(Integer id, String id_enseignant, String nom, String prenom, String email, String nomUtilisateur,
            String sexe, String salaire, String statutsSalaire, String departement, String image, 
            Date dateNaiss, String experience, Date dateInsertion, Date dateModification, Date dateSuppression
            ,String status, String anneeExperience)*/

                tdata = new EnseignantData(resultat.getInt("id"),
                        resultat.getString("id_enseignant"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                        resultat.getString("email"),
                        resultat.getString("nom_utilisateur"),
                        resultat.getString("genre"),
                        resultat.getString("annee_experience"),
                        resultat.getDouble("salaire"),
                        resultat.getString("status_salaire"),
                        resultat.getString("departement"),
                        resultat.getString("image"),
                        resultat.getDate("date_naissance"),
                        resultat.getString("experience"),
                        resultat.getDate("date_inscription"),
                        resultat.getDate("date_modification"),
                        resultat.getDate("date_suppression"),
                        resultat.getString("status_compte"));

                listData.add(tdata);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<EnseignantData> ajoutListData;

    public void ajoutEneignantAffData() {
        ajoutListData = ajoutEnseignantGetData();

        ajoutEnsei_col_idEns.setCellValueFactory(new PropertyValueFactory<>("id_enseignant"));
        ajoutEnsei_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ajoutEnsei_col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ajoutEnsei_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        ajoutEnsei_col_nomUtil.setCellValueFactory(new PropertyValueFactory<>("nomUtilisateur"));
        ajoutEnsei_col_sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        ajoutEnsei_col_anneeEx.setCellValueFactory(new PropertyValueFactory<>("anneeExperience"));
        ajoutEnsei_col_salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        ajoutEnsei_col_stSaliare.setCellValueFactory(new PropertyValueFactory<>("statutsSalaire"));
        ajoutEnsei_col_departement.setCellValueFactory(new PropertyValueFactory<>("departement"));
        ajoutEnsei_col_dtn.setCellValueFactory(new PropertyValueFactory<>("dateNaiss"));
        ajoutEnsei_col_experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        ajoutEnsei_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        ajoutEnsei_tableView.setItems(ajoutListData);

    }

    public void ajoutEnseiSelectItems() {
        EnseignantData tData = ajoutEnsei_tableView.getSelectionModel().getSelectedItem();

        int num = ajoutEnsei_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        ajoutEnsei_idEns.setText(tData.getId_enseignant());
        ajoutEnsei_nom.setText(tData.getNom());
        ajoutEnsei_prenom.setText(tData.getPrenom());
        ajoutEnsei_email.setText(tData.getEmail());
        ajoutEnsei_nomUtilis.setText(tData.getNomUtilisateur());
        ajoutEnsei_comboSexe.getSelectionModel().select(tData.getSexe());
        ajoutEnsei_comboAnneeExperience.getSelectionModel().select(tData.getAnneeExperience());
        ajoutEnsei_salaire.setText("" + tData.getSalaire());
        ajoutEnsei_st_comboSalaire.getSelectionModel().select(tData.getStatutsSalaire());
        ajoutEnsei_idEns_comboDept.getSelectionModel().select(tData.getDepartement());
        ajoutEnsei_idEns_dtn.setValue(LocalDate.parse(String.valueOf(tData.getDateNaiss())));
        ajoutEnsei_experience.setText(tData.getExperience());
        ajoutEnsei_comboStatus.getSelectionModel().select(tData.getStatus());

        ListData.source = tData.getImage();

        image = new Image("File: " + tData.getImage(), 105, 125, false, true);

        ajoutEnsei_imageView.setImage(image);

    }

    public void importBtnEnsei() {
        FileChooser ouvrir = new FileChooser();
        ouvrir.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image", "*.jpg", "*.jpeg", "*.png"));
        File file = ouvrir.showOpenDialog(ajoutEnsei_imporBtn.getScene().getWindow());

        if (file != null) {
            ListData.source = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 105, 125, false, true);
            ajoutEnsei_imageView.setImage(image);
            System.out.println(image);
        }
    }

    public void ajoutBtnEnsei() {

        if (ajoutEnsei_idEns.getText().isEmpty()
                || ajoutEnsei_nom.getText().isEmpty()
                || ajoutEnsei_prenom.getText().isEmpty()
                || ajoutEnsei_email.getText().isEmpty()
                || ajoutEnsei_nomUtilis.getText().isEmpty()
                || ajoutEnsei_comboSexe.getSelectionModel().getSelectedItem() == null
                || ajoutEnsei_comboAnneeExperience.getSelectionModel().getSelectedItem() == null 
                || ajoutEnsei_salaire.getText().isEmpty()
                || ajoutEnsei_st_comboSalaire.getSelectionModel().getSelectedItem() == null
                || ajoutEnsei_idEns_comboDept.getSelectionModel().getSelectedItem( )== null
                || ajoutEnsei_idEns_dtn.getValue() == null
                || ajoutEnsei_experience.getText().isEmpty()
                || ajoutEnsei_comboStatus.getSelectionModel().getSelectedItem() == null
                || ListData.source == null || "".equals(ListData.source)) {
            alert.messageErreur("Veuillez remplir les champs vide");
        } else {
            String donInsert = "INSERT INTO enseignant"
                    + "(id_enseignant, nom_utilisateur, email, nom, prenom, date_naissance, genre, image, date_inscription,"
                    + " departement, experience, annee_experience, salaire, status_salaire, status_compte)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            connexion = DataBase.connectDB();

            Date date = new Date();
            java.sql.Date sqldate = new java.sql.Date(date.getTime());

            String path = ListData.source;
            path.replace("\\", "\\\\");

            try {
                preparer = connexion.prepareStatement(donInsert);

                preparer.setString(1, ajoutEnsei_idEns.getText());
                preparer.setString(2, ajoutEnsei_nomUtilis.getText());
                preparer.setString(3, ajoutEnsei_email.getText());
                preparer.setString(4, ajoutEnsei_nom.getText());
                preparer.setString(5, ajoutEnsei_prenom.getText());
                preparer.setString(6, String.valueOf(ajoutEnsei_idEns_dtn.getValue()));
                preparer.setString(7, ajoutEnsei_comboSexe.getSelectionModel().getSelectedItem());
                preparer.setString(8, path);
                preparer.setString(9, String.valueOf(sqldate));
                preparer.setString(10, ajoutEnsei_idEns_comboDept.getSelectionModel().getSelectedItem());
                preparer.setString(11, ajoutEnsei_experience.getText());
                preparer.setString(12, ajoutEnsei_comboAnneeExperience.getSelectionModel().getSelectedItem());
                preparer.setString(13, ajoutEnsei_salaire.getText());
                preparer.setString(14, ajoutEnsei_st_comboSalaire.getSelectionModel().getSelectedItem());
                preparer.setString(15, ajoutEnsei_comboStatus.getSelectionModel().getSelectedItem());

                preparer.executeUpdate();

                Path transfer = Paths.get(path);
                Path copy = Paths.get("C:\\Users\\RSservices\\Documents\\NetBeansProjects\\SystemMngUniversity\\src\\RepertoireENS\\"
                        + ajoutEnsei_idEns.getText() + ".jpg");

                Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);
                alert.messageReussie("L'enseignant a été ajouté avec succès");

                ajoutEneignantAffData();
                viderEnseiChamps();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void ajoutEnsModifierBtn() {

        if (ajoutEnsei_idEns.getText().isEmpty()
                || ajoutEnsei_nom.getText().isEmpty()
                || ajoutEnsei_prenom.getText().isEmpty()
                || ajoutEnsei_email.getText().isEmpty()
                || ajoutEnsei_nomUtilis.getText().isEmpty()
                || ajoutEnsei_comboSexe.getSelectionModel().getSelectedItem() == null
                || ajoutEnsei_comboAnneeExperience.getSelectionModel().getSelectedItem() == null
                || ajoutEnsei_salaire.getText().isEmpty()
                || ajoutEnsei_st_comboSalaire.getSelectionModel().getSelectedItem() == null
                || ajoutEnsei_idEns_comboDept.getSelectionModel().getSelectedItem() == null
                || ajoutEnsei_idEns_dtn.getValue() == null
                || ajoutEnsei_experience.getText().isEmpty()
                || ajoutEnsei_comboStatus.getSelectionModel().getSelectedItem() == null
                || ListData.source == null || "".equals(ListData.source)) {
            alert.messageErreur("Veuillez remplir les champs vide");
        } else {
            if (alert.confirmeMessage("êtes vous sur de modifier l'enseignant ID: "
                    + ajoutEnsei_idEns.getText() + " ?")) {
                String path = ListData.source;
                path = path.replace("\\", "\\\\");

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String updateSql = "UPDATE enseignant SET nom = '"
                        + ajoutEnsei_nom.getText() + "', prenom = '"
                        + ajoutEnsei_prenom.getText() + "',nom_utilisateur = '"
                        + ajoutEnsei_nomUtilis.getText() + "', genre = '"
                        + ajoutEnsei_comboSexe.getSelectionModel().getSelectedItem() + "', annee_experience = '"
                        + ajoutEnsei_comboAnneeExperience.getSelectionModel().getSelectedItem() + "', salaire = '"
                        + ajoutEnsei_salaire.getText() + "', status_salaire = '"
                        + ajoutEnsei_st_comboSalaire.getSelectionModel().getSelectedItem() + "', departement = '"
                        + ajoutEnsei_idEns_comboDept.getSelectionModel().getSelectedItem() + "', image = '"
                        + path + "', date_naissance = '"
                        + ajoutEnsei_idEns_dtn.getValue() + "', experience = '"
                        + ajoutEnsei_experience.getText() + "', date_modification = '"
                        + sqlDate + "', status_compte = '" + ajoutEnsei_comboStatus.getSelectionModel().getSelectedItem() + "'"
                        + "WHERE id_enseignant = '"
                        + ajoutEnsei_idEns.getText() + "'";

                alert.messageReussie("Modification");

                connexion = DataBase.connectDB();

                try {
                    preparer = connexion.prepareStatement(updateSql);

                    System.out.println(preparer);
                    preparer.executeUpdate();

                    Path transfere = Paths.get(path);
                    Path copy = Paths.get("C:\\Users\\RSservices\\Documents\\NetBeansProjects\\SystemMngUniversity\\src\\RepertoireENS"
                            + ajoutEnsei_idEns + ".jpg");

                    Files.copy(transfere, copy, StandardCopyOption.REPLACE_EXISTING);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                alert.messageReussie("Annuler");
            }
        }
    }

    public void ajoutEnseiSuppBtn() {
        if (ajoutEnsei_idEns.getText().isEmpty()
                || ajoutEnsei_comboStatus.getSelectionModel().getSelectedItem() == null) {
            alert.messageErreur("Veuillez séléctionner un item d'abord");

        } else {
            if (alert.confirmeMessage("Es ce que vous êtes sur sur de supprimer l'enseignant ID: "
                    + ajoutEnsei_idEns.getText() + " ?")) {

                String deleteSql = "UPDATE enseignant SET date_suppression = ? WHERE id_enseignant = ?";

                connexion = DataBase.connectDB();

                Date date = new Date();
                java.sql.Date sqldate = new java.sql.Date(date.getTime());

                try {
                    preparer = connexion.prepareStatement(deleteSql);
                    preparer.setString(1, "" + sqldate);
                    preparer.setString(2, ajoutEnsei_idEns.getText());

                    preparer.executeUpdate();
                    alert.messageReussie("Suppression réussie !");

                    viderEnseiChamps();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.messageErreur("Annuler");
            }
        }
    }

    public void viderEnseiChamps() {
        affIdEnsei();
        ajoutEnsei_nom.clear();
        ajoutEnsei_prenom.clear();
        ajoutEnsei_email.clear();
        ajoutEnsei_nomUtilis.clear();
        ajoutEnsei_comboSexe.getSelectionModel().clearSelection();
        ajoutEnsei_comboAnneeExperience.getSelectionModel().clearSelection();
        ajoutEnsei_salaire.clear();
        ajoutEnsei_st_comboSalaire.getSelectionModel().clearSelection();
        ajoutEnsei_idEns_comboDept.getSelectionModel().clearSelection();
        ajoutEnsei_experience.clear();
        ajoutEnsei_comboStatus.getSelectionModel().clearSelection();
        ajoutEnsei_imageView.setImage(null);
    }

    public void ajoutEnseiSexe() {
        List<String> listS = new ArrayList<>();

        for (String data : ListData.sexe) {
            listS.add(data);
        }
        ObservableList listDonnee = FXCollections.observableArrayList(listS);
        ajoutEnsei_comboSexe.setItems(listDonnee);
        ajoutEnsei_imageView.setImage(image);

    }

    public void ajoutEnseiYexp() {
        List<String> listYE = new ArrayList<>();

        for (String data : ListData.YExperience) {
            listYE.add(data);
        }
        ObservableList listDonnee = FXCollections.observableArrayList(listYE);
        ajoutEnsei_comboAnneeExperience.setItems(listDonnee);

    }

    public void ajoutEnseiStSalaire() {
        List<String> listSS = new ArrayList<>();

        for (String data : ListData.statutSalaire) {
            listSS.add(data);
        }
        ObservableList listDonnee = FXCollections.observableArrayList(listSS);
        ajoutEnsei_st_comboSalaire.setItems(listDonnee);

    }

    public void ajoutEnseiDept() {
        /*List<String> listD = new ArrayList<>();

        for (String data : ListData.departement) {
            listD.add(data);
        }
        ObservableList listDonnee = FXCollections.observableArrayList(listD);
        ajoutEnsei_idEns_comboDept.setItems(listDonnee);*/

        String sql = "SELECT * FROM cours WHERE dateSuppression IS NULL";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            ObservableList listDonnee = FXCollections.observableArrayList();

            while (resultat.next()) {
                listDonnee.add(resultat.getString("departement"));
            }
            ajoutEnsei_idEns_comboDept.setItems(listDonnee);
        } catch (Exception e) {
        }

    }

    public void ajoutEnseiStatus() {
        List<String> listSt = new ArrayList<>();

        for (String data : ListData.statuts) {
            listSt.add(data);
        }
        ObservableList listDonnee = FXCollections.observableArrayList(listSt);
        ajoutEnsei_comboStatus.setItems(listDonnee);

    }

    private String EnseiID;

    public void genererIDEnsei() {
        String sql = "SELECT MAX(id) FROM enseignant";

        connexion = DataBase.connectDB();

        String temp_ensei = "ENS-";
        int temp_count = 0;

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                temp_count = resultat.getInt("MAX(id)");
            }

            if (temp_count == 0) {
                temp_count += 1;
                EnseiID = temp_ensei + temp_count;

            } else {
                EnseiID = temp_ensei + (temp_count + 1);
            }

        } catch (Exception e) {

        }
    }

    public void affIdEnsei() {
        genererIDEnsei();
        ajoutEnsei_idEns.setText(EnseiID);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ObservableList<CoursData> ajoutCoursGetData() {

        ObservableList<CoursData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM cours WHERE dateSuppression IS NULL";

        connexion = DataBase.connectDB();
        try {

            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();
            CoursData cData;

            while (resultat.next()) {
                /*(Integer id, String cours, String departement, String statuts, 
                    Date dateInsert, Date dateMod, Date dateSupp)*/

                cData = new CoursData(resultat.getInt("id"), resultat.getString("cours"), resultat.getString("departement"),
                        resultat.getDouble("prix"), resultat.getString("statuts"), resultat.getDate("dateInsertion"), resultat.getDate("dateModifiaction"),
                        resultat.getDate("dateSuppression"));

                listData.add(cData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<CoursData> ajoutCoursListdata;

    public void ajoutCoursAffData() {
        ajoutCoursListdata = ajoutCoursGetData();

        ajoutCours__col_cours.setCellValueFactory(new PropertyValueFactory<>("cours"));
        ajoutCours__col_dept.setCellValueFactory(new PropertyValueFactory<>("departement"));
        ajoutCours__col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        ajoutCours__col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));
        ajoutCours__col_status.setCellValueFactory(new PropertyValueFactory<>("statuts"));

        ajoutCours__tableview.setItems(ajoutCoursListdata);

    }

    public void ajoutCoursStatus() {
        List<String> listS = new ArrayList<>();

        for (String data : ListData.statusCours) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        ajoutCours_combo_st.setItems(listData);
    }

    private int courseID = 0;

    public void ajoutCoursselectitem() {

        CoursData cData = ajoutCours__tableview.getSelectionModel().getSelectedItem();
        int num = ajoutCours__tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        ajoutCours_cours.setText(cData.getCours());
        ajoutCours_dpt.setText(cData.getDepartement());
        ajoutCours_prix.setText("" + cData.getPrix());
        ajoutCours_combo_st.getSelectionModel().select(cData.getStatuts());

        courseID = cData.getId();
    }

    public void ajoutCoursBtn() {
        if (ajoutCours_cours.getText().isEmpty()
                || ajoutCours_dpt.getText().isEmpty()
                || ajoutCours_prix.getText().isEmpty()
                || ajoutCours_combo_st.getSelectionModel().getSelectedItem() == null) {
            alert.messageErreur("Veuillez remplir les champs vide");
        } else {

            connexion = DataBase.connectDB();

            String checkCourse = "SELECT * FROM cours WHERE cours = '"
                    + ajoutCours_cours.getText() + "' AND dateSuppression IS NULL";

            try {
                declaration = connexion.createStatement();
                resultat = declaration.executeQuery(checkCourse);

                if (resultat.next()) {
                    alert.messageErreur(ajoutCours_cours.getText() + " existe déja");
                } else {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    String insertData = "INSERT INTO cours (cours, departement, prix, statuts, dateInsertion) "
                            + "VALUES(?,?,?,?,?)";

                    preparer = connexion.prepareStatement(insertData);

                    preparer.setString(1, ajoutCours_cours.getText());
                    preparer.setString(2, ajoutCours_dpt.getText());
                    preparer.setString(3, ajoutCours_prix.getText());
                    preparer.setString(4, ajoutCours_combo_st.getSelectionModel().getSelectedItem());
                    preparer.setString(5, String.valueOf(sqlDate));

                    preparer.executeUpdate();

                    ajoutCoursAffData();

                    viderChampsCours();

                    alert.messageReussie("Le cours a été ajouter avec succès");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void modificationCoursBtn() {

        if (ajoutCours_cours.getText().isEmpty()
                || ajoutCours_dpt.getText().isEmpty()
                || ajoutCours_prix.getText().isEmpty()
                || ajoutCours_combo_st.getSelectionModel().getSelectedItem()== null) {
            alert.messageErreur("Veuillez remplir les champs vide");
        } else {
            if (alert.confirmeMessage("êtes vous sur de modifier ce cours ? "
                    + ajoutCours_cours.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String updateData = "UPDATE cours SET cours = '"
                        + ajoutCours_cours.getText() + "', departement = '"
                        + ajoutCours_dpt.getText() + "', prix ='" + ajoutCours_prix.getText()
                        + "' ,dateModifiaction = '" + sqlDate + "', statuts = '"
                        + ajoutCours_combo_st.getSelectionModel().getSelectedItem() + "' "
                        + "WHERE id = " + courseID;

                connexion = DataBase.connectDB();

                try {
                    preparer = connexion.prepareStatement(updateData);

                    System.out.println(preparer);
                    preparer.executeUpdate();

                    ajoutCoursAffData();

                    alert.messageReussie("Modification réussie !");

                    viderChampsCours();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.messageErreur("Cancelled");
            }
        }
    }

    public void suppCoursBtn() {
        if (courseID == 0) {
            alert.messageErreur("Please select item first");
        } else {
            if (alert.confirmeMessage("êtes vous sur de modifier ce cours ?  "
                    + ajoutCours_cours.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String deleteData = "UPDATE cours SET dateSuppression = ? WHERE id = ?";

                connexion = DataBase.connectDB();
                try {
                    preparer = connexion.prepareStatement(deleteData);
                    preparer.setString(1, String.valueOf(sqlDate));
                    preparer.setString(2, String.valueOf(courseID));

                    preparer.executeUpdate();

                    ajoutCoursAffData();

                    alert.messageReussie("Le cours a été supprimer avec succès!");

                    viderChampsCours();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void viderChampsCours() {
        ajoutCours_cours.clear();
        ajoutCours_dpt.clear();
        ajoutCours_prix.clear();
        ajoutCours_combo_st.getSelectionModel().clearSelection();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ObservableList<SujetData> ajoutSujetGetData() {

        ObservableList<SujetData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM sujet WHERE dateSuppression IS NULL";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            SujetData sData;
            /*(Integer id, String codeSujet, String sujet, String cours,
            String status, Date dateinsert, Date dateMod, Date dateSupp)*/
            while (resultat.next()) {
                sData = new SujetData(resultat.getInt("id"),
                        resultat.getString("codeSujet"),
                        resultat.getString("sujet"),
                        resultat.getString("cours"),
                        resultat.getString("status"),
                        resultat.getDate("dateInsertion"),
                        resultat.getDate("dateModification"),
                        resultat.getDate("dateSuppression"));

                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<SujetData> ajoutSujetListData;

    public void ajoutSujetAffData() {

        ajoutSujetListData = ajoutSujetGetData();

        ajoutSujet__col_id.setCellValueFactory(new PropertyValueFactory<>("codeSujet"));
        ajoutSujet__col_sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        ajoutSujet__col_cours.setCellValueFactory(new PropertyValueFactory<>("cours"));
        ajoutSujet__col_insertion.setCellValueFactory(new PropertyValueFactory<>("dateinsert"));
        ajoutSujet__col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        ajoutSujet__tableview.setItems(ajoutSujetListData);
    }

    private int subjectID = 0;

    public void ajoutSujetSelectitem() {

        SujetData sData = ajoutSujet__tableview.getSelectionModel().getSelectedItem();
        int num = ajoutSujet__tableview.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        ajoutSujet_id.setText(sData.getCodeSujet());
        ajoutSujet_sujet.setText(sData.getSujet());
        ajoutSujet_combo_cours.getSelectionModel().select(sData.getCours());
        ajoutSujet_combo_st.getSelectionModel().select(sData.getStatus());

        subjectID = sData.getId();
    }

    public void ajoutSujettBtn() {

        if (ajoutSujet_id.getText().isEmpty()
                || ajoutSujet_sujet.getText().isEmpty()
                || ajoutSujet_combo_cours.getSelectionModel().getSelectedItem()== null
                || ajoutSujet_combo_st.getSelectionModel().getSelectedItem()== null) {
            alert.messageErreur("Please fill all blank fields");
        } else {
            connexion = DataBase.connectDB();

            String checkSubject = "SELECT * FROM sujet WHERE codeSujet = '"
                    + ajoutSujet_id.getText() + "' AND 	dateSuppression IS NULL";
            try {
                declaration = connexion.createStatement();
                resultat = declaration.executeQuery(checkSubject);

                if (resultat.next()) {
                    alert.messageErreur(ajoutSujet_id.getText() + " is already exist");
                } else {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    System.out.println(sqlDate);

                    String insertData = "INSERT INTO sujet "
                            + "(codeSujet, sujet, cours, status, dateInsertion) "
                            + "VALUES(?,?,?,?,?)";

                    preparer = connexion.prepareStatement(insertData);
                    preparer.setString(1, ajoutSujet_id.getText());
                    preparer.setString(2, ajoutSujet_sujet.getText());
                    preparer.setString(3, ajoutSujet_combo_cours.getSelectionModel().getSelectedItem());
                    preparer.setString(4, ajoutSujet_combo_st.getSelectionModel().getSelectedItem());
                    preparer.setString(5, String.valueOf(sqlDate));

                    preparer.executeUpdate();

                    ajoutSujetAffData();

                    alert.messageReussie("Added Successfully!");

                    viderChampsSubject();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addSubjectDeleteBtn() {

        if (subjectID == 0) {
            alert.messageErreur("Veuilez saisir");
        } else {

            if (alert.confirmeMessage("êtes vous sur de supprimer le sujet: "
                    + ajoutSujet_id.getText() + " ?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String deleteData = "UPDATE sujet SET dateSuppression = ? WHERE id = ?";
                connexion = DataBase.connectDB();

                try {
                    preparer = connexion.prepareStatement(deleteData);
                    preparer.setString(1, String.valueOf(sqlDate));
                    preparer.setString(2, String.valueOf(subjectID));

                    preparer.executeUpdate();

                    ajoutSujetAffData();

                    alert.messageReussie("Deleted Successfully!");

                    viderChampsSubject();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void modifierSubjetBtn() {

        if (ajoutSujet_id.getText().isEmpty()
                || ajoutSujet_sujet.getText().isEmpty()
                || ajoutSujet_combo_cours.getSelectionModel().getSelectedItem()== null
                || ajoutSujet_combo_st.getSelectionModel().getSelectedItem()== null) {
            alert.messageErreur("Veuillez remplier les champs vide");
        } else {
            if (alert.confirmeMessage("êtes vous sur de modifier: "
                    + ajoutSujet_id.getText() + " ?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String updateData = "UPDATE sujet SET codeSujet = '"
                        + ajoutSujet_id.getText() + "', sujet = '"
                        + ajoutSujet_sujet.getText() + "', cours = '"
                        + ajoutSujet_combo_cours.getSelectionModel().getSelectedItem()
                        + "', dateModification = '"
                        + sqlDate + "', status = '"
                        + ajoutSujet_combo_st.getSelectionModel().getSelectedItem() + "' "
                        + "WHERE id = " + subjectID;

                connexion = DataBase.connectDB();

                try {
                    preparer = connexion.prepareStatement(updateData);
                    preparer.executeUpdate();

                    ajoutSujetAffData();

                    alert.messageReussie("Modification réussie !");

                    viderChampsSubject();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.messageErreur("Annuler");
            }
        }
    }

    public void ajoutSujetectCoursList() {

        String sql = "SELECT * FROM cours WHERE dateSuppression IS NULL";
        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (resultat.next()) {
                listData.add(resultat.getString("cours"));
            }

            ajoutSujet_combo_cours.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajoutSujetStatus() {
        List<String> listS = new ArrayList<>();

        for (String data : ListData.statusCours) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        ajoutSujet_combo_st.setItems(listData);
    }

    public void viderChampsSubject() {

        ajoutSujet_id.clear();
        ajoutSujet_sujet.clear();
        ajoutSujet_combo_cours.getSelectionModel().clearSelection();
        ajoutSujet_combo_st.getSelectionModel().clearSelection();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ObservableList<DataEtudiant> paimentGetData() {
        ObservableList<DataEtudiant> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM etudiant WHERE date_suppression IS NULL";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            DataEtudiant edata;

            while (resultat.next()) {

                /*(Integer id, String idEtud, String nom, String prenom,
                Date dateMod, String image String section, String annee, String paiment,String st_paiment)*/
                edata = new DataEtudiant(resultat.getInt("id"),
                        resultat.getString("id_etudiant"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                        resultat.getDate("date_modification"),
                        resultat.getString("image"),
                        resultat.getString("section"),
                        resultat.getString("semestre"),
                        resultat.getDouble("paiment"),
                        resultat.getString("stauts_paiment"));

                listData.add(edata);
            }
        } catch (Exception e) {
        }
        return listData;
    }

    private ObservableList<DataEtudiant> paimentListdata;

    public void paimentAffData() {
        paimentListdata = paimentGetData();

        paiment_col_id.setCellValueFactory(new PropertyValueFactory<>("idEtud"));
        paiment_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        paiment_col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        paiment__col_section.setCellValueFactory(new PropertyValueFactory<>("section"));
        paiment_col_annee.setCellValueFactory(new PropertyValueFactory<>("annee"));
        paiment_col_paiment.setCellValueFactory(new PropertyValueFactory<>("paiment"));
        paiment_col_stP.setCellValueFactory(new PropertyValueFactory<>("st_paiment"));

        paiment_tabView.setItems(paimentListdata);

    }

    public void paimentSelectItem() {
        DataEtudiant eData = paiment_tabView.getSelectionModel().getSelectedItem();
        int num = paiment_tabView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        paiment_id.setText(eData.getIdEtud());
        paiment_nom.setText(eData.getNom());
        paiment_prenom.setText(eData.getPrenom());
        paiment_section.setText(eData.getSection());
        paiment_annee.setText(eData.getAnnee());
        paiment_paiment.setText(String.valueOf(eData.getPaiment()));
        paiment_comboStP.getSelectionModel().select(eData.getSt_paiment());

        //ListData.source = eData.getImage();
        /*image = new Image("File :"+ListData.source, 100, 120, false, true);
        paiment_imageView.setImage(image);*/
    }

    public void paymentStList() {
        List<String> listPS = new ArrayList<>();

        for (String data : ListData.paiStatus) {
            listPS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listPS);
        paiment_comboStP.setItems(listData);
    }

    public void paymentModifierBtn() {
        if (paiment_id.getText().isEmpty()
                || paiment_paiment.getText().isEmpty()) {
            alert.messageErreur("Veuillez séléctionner l'item d'abord");
        } else {
            if (alert.confirmeMessage("êtes vous sur de supprimer l'étudiant:")) {
                String updateData = "UPDATE etudiant SET stauts_paiment = ? WHERE id_etudiant = ?";
                connexion = DataBase.connectDB();

                try {
                    preparer = connexion.prepareStatement(updateData);
                    preparer.setString(1, paiment_comboStP.getSelectionModel().getSelectedItem());
                    preparer.setString(2, paiment_id.getText());
                    preparer.executeUpdate();

                    paimentAffData();

                    alert.messageReussie("Modification réussie !");

                    paymentViderBtn();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void paymentViderBtn() {
        paiment_id.clear();
        paiment_nom.clear();
        paiment_prenom.clear();
        paiment_section.clear();
        paiment_annee.clear();
        paiment_paiment.clear();

        ListData.source = "";

        //paiment_imageView.setImage(null);
        paiment_comboStP.getSelectionModel().clearSelection();
    }

    public void paimentDesactiveChamps() {
        paiment_id.setDisable(true);
        paiment_nom.setDisable(true);
        paiment_prenom.setDisable(true);
        paiment_section.setDisable(true);
        paiment_annee.setDisable(true);
        paiment_paiment.setDisable(true);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ObservableList<EnseignantData> salaireGetData() {

        ObservableList<EnseignantData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM enseignant WHERE date_suppression IS NULL AND status_compte = 'Activer'";
        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            //System.out.println(preparer);
            resultat = preparer.executeQuery();

            EnseignantData tData;
            while (resultat.next()) {


                /*(Integer id, String id_enseignant, String nom, String prenom, String salaire,
            String statutsSalaire, Date dateInsertion, Date dateModification, String status)*/
                tData = new EnseignantData(resultat.getInt("id"),
                        resultat.getString("id_enseignant"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"), resultat.getDouble("salaire"),
                        resultat.getString("status_salaire"), resultat.getDate("date_inscription"),
                        resultat.getDate("date_modification"), resultat.getString("status_compte"));

                listData.add(tData);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<EnseignantData> salaireListData;

    public void salaryAffData() {
        salaireListData = salaireGetData();

        salaire_col_idEnseignant.setCellValueFactory(new PropertyValueFactory<>("id_enseignant"));
        salaire_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        salaire_col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        salaire_col_coutparjour.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        salaire_col_dateinst.setCellValueFactory(new PropertyValueFactory<>("dateInsertion"));
        salaire_col_dateModif.setCellValueFactory(new PropertyValueFactory<>("dateUpdate"));
        salaire_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        salaire_tabView.setItems(salaireListData);
    }

    public void salaireSelectItem() {

        EnseignantData tData = salaire_tabView.getSelectionModel().getSelectedItem();
        int num = salaire_tabView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        salaire_IdEnseignat.setText(tData.getId_enseignant());
        salaire_nom.setText(tData.getNom());
        salaire_prenom.setText(tData.getPrenom());
        salaire_coutparjour.setText("" + tData.getSalaire());
        salaire_datedebut.setValue(LocalDate.parse(String.valueOf(tData.getDateInsertion())));
        salaire_status.getSelectionModel().select(tData.getStatutsSalaire());

    }

    public void salaireDesactiverChamps() {
        salaire_IdEnseignat.setDisable(true);
        salaire_nom.setDisable(true);
        salaire_prenom.setDisable(true);
        salaire_coutparjour.setDisable(true);
    }

    public double salaireGetSalaireParJour() {

        double getSalary = 0;

        String sql = "SELECT * FROM enseignant WHERE id_enseignant = '"
                + salaire_IdEnseignat.getText() + "'";
        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                getSalary = resultat.getDouble("salaire");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getSalary;
    }

    public void salarySalaryStatusList() {

        List<String> listSS = new ArrayList<>();

        for (String data : ListData.paiStatus) {
            listSS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listSS);
        salaire_status.setItems(listData);

    }
    private long nbrJour;
    private double saliaireTotal;

    public double salaryGetSalaryPerDay() {

        double getSalaire = 0;

        String sql = "SELECT * FROM enseignant WHERE id_enseignant = '"
                + salaire_IdEnseignat.getText() + "'";
        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                getSalaire = resultat.getDouble("salaire");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getSalaire;
    }

    public void salaryCountDays() {
        if (salaire_datedebut.getValue() != null
                || salaire_dateFin.getValue() != null) {
            try {
                nbrJour = ChronoUnit.DAYS.between(salaire_datedebut.getValue(), salaire_dateFin.getValue());

                saliaireTotal = (salaryGetSalaryPerDay() * nbrJour);

                salaire_labTotalJour.setText("" + nbrJour);
                salaire_labSalaire.setText("DA " + saliaireTotal);

            } catch (Exception e) {
                alert.messageErreur("Invalide.");
            }
        }
    }

    public void salairePayBtn() {

        if (salaire_labTotalJour.getText().equals("*********")
                || salaire_labSalaire.getText().equals("*********")
                || salaire_IdEnseignat.getText().isEmpty()
                || nbrJour == 0
                || saliaireTotal == 0) {
            alert.messageErreur("veuillez selectionner un Item d'abord");
        } else {
            if (alert.confirmeMessage("Paie ?")) {
                String sql = "INSERT INTO salaire "
                        + "(id_enseignant, nom, prenom, jour_total, salaire_paie, date_paie)"
                        + " VALUES(?,?,?,?,?,?)";

                connexion = DataBase.connectDB();

                try {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    preparer = connexion.prepareStatement(sql);
                    preparer.setString(1, salaire_IdEnseignat.getText());
                    preparer.setString(2, salaire_nom.getText());
                    preparer.setString(3, salaire_coutparjour.getText());
                    preparer.setString(4, "" + nbrJour);
                    preparer.setString(5, "" + saliaireTotal);
                    preparer.setString(6, String.valueOf(sqlDate));

                    preparer.executeUpdate();

                    String updateData = "UPDATE enseignant SET status_salaire = ? WHERE id_enseignant = ?";

                    System.out.println(updateData);
                    preparer = connexion.prepareStatement(updateData);
                    preparer.setString(1, salaire_status.getSelectionModel().getSelectedItem());
                    preparer.setString(2, salaire_IdEnseignat.getText());

                    preparer.executeUpdate();

                    salaryAffData();
                    salaryDisplaydata();

                    alert.messageReussie("Paie avec succès!");

                    salaireClear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ObservableList<SalaireData> salarySPGetdata() {

        ObservableList<SalaireData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM salaire";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            SalaireData sData;

            while (resultat.next()) {
                /*(int id, String id_salaire, String nom, String prenom, int jour_tot, double salaire_paie, Date date_paie)*/
                sData = new SalaireData(resultat.getInt("id"),
                        resultat.getString("id_enseignant"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                        resultat.getInt("jour_total"),
                        resultat.getDouble("salaire_paie"),
                        resultat.getDate("date_paie"));

                listData.add(sData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<SalaireData> salarySPListData;

    public void salaryDisplaydata() {
        salarySPListData = salarySPGetdata();

        salaire_col_idEn2.setCellValueFactory(new PropertyValueFactory<>("id_salaire"));
        salaire_col_salaireP2.setCellValueFactory(new PropertyValueFactory<>("salaire_paie"));
        salaire_col_dateP2.setCellValueFactory(new PropertyValueFactory<>("date_paie"));

        salaire_tabView2.setItems(salarySPListData);
    }

    public void salaireClear() {
        salaire_IdEnseignat.clear();
        salaire_nom.clear();
        salaire_prenom.clear();
        salaire_coutparjour.clear();
        salaire_status.getSelectionModel().clearSelection();
        salaire_datedebut.setValue(null);
        salaire_dateFin.setValue(null);
        nbrJour = 0;
        saliaireTotal = 0;
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == tabBord_btn) {
            ajoutEtud_window.setVisible(false);
            tabBord_window.setVisible(true);
            ajoutEns_window.setVisible(false);
            ajoutCours_window.setVisible(false);
            ajoutSujet_window.setVisible(false);
            paiment_window.setVisible(false);
            salaire_window.setVisible(false);

            tabBordTEtudInsc();
            tabBordAffTEns();
            tabBordAffTEtud();
            tabBordAffRevenu();
            tabBordGrapheEtud();
            tabBordGrapheEns();

        } else if (event.getSource() == ajoutEtudiant_btn) {
            ajoutEtud_window.setVisible(true);
            tabBord_window.setVisible(false);
            ajoutEns_window.setVisible(false);
            ajoutCours_window.setVisible(false);
            ajoutSujet_window.setVisible(false);
            paiment_window.setVisible(false);
            salaire_window.setVisible(false);

            ajoutDonneeAffEleve();

        } else if (event.getSource() == ajoutEnseignant_btn) {
            ajoutEns_window.setVisible(true);
            tabBord_window.setVisible(false);
            ajoutEtud_window.setVisible(false);
            ajoutCours_window.setVisible(false);
            ajoutSujet_window.setVisible(false);
            paiment_window.setVisible(false);
            salaire_window.setVisible(false);

            ajoutEnseiSexe();
            ajoutEnseiYexp();
            ajoutEnseiStSalaire();
            ajoutEnseiStatus();
            ajoutEnseiDept();
            affIdEnsei();
            ajoutEneignantAffData();

        } else if (event.getSource() == ajoutCour_btn) {
            ajoutCours_window.setVisible(true);
            tabBord_window.setVisible(false);
            ajoutEns_window.setVisible(false);
            ajoutEtud_window.setVisible(false);
            ajoutSujet_window.setVisible(false);
            paiment_window.setVisible(false);
            salaire_window.setVisible(false);

            ajoutCoursAffData();
            ajoutCoursStatus();

        } else if (event.getSource() == ajoutFichier_btn) {
            ajoutSujet_window.setVisible(true);
            tabBord_window.setVisible(false);
            ajoutCours_window.setVisible(false);
            ajoutEns_window.setVisible(false);
            ajoutEtud_window.setVisible(false);
            paiment_window.setVisible(false);
            salaire_window.setVisible(false);

            ajoutSujetAffData();
            ajoutSujetStatus();
            ajoutSujetectCoursList();

        } else if (event.getSource() == paiment_btn) {
            paiment_window.setVisible(true);
            ajoutSujet_window.setVisible(false);
            tabBord_window.setVisible(false);
            ajoutCours_window.setVisible(false);
            ajoutEns_window.setVisible(false);
            ajoutEtud_window.setVisible(false);
            salaire_window.setVisible(false);

            paimentAffData();
            paymentStList();
            paimentDesactiveChamps();
        } else if (event.getSource() == salaire_btn) {

            paiment_window.setVisible(false);
            ajoutSujet_window.setVisible(false);
            tabBord_window.setVisible(false);
            ajoutCours_window.setVisible(false);
            ajoutEns_window.setVisible(false);
            ajoutEtud_window.setVisible(false);
            salaire_window.setVisible(true);
            salarySalaryStatusList();
            salaryAffData();
            salaireDesactiverChamps();
            salaryDisplaydata();

        }
    }
    
    public void displayGreet() {
        String username = ListData.nom_utilisateur;
        username = username.substring(0, 1).toUpperCase() + username.substring(1);

        admin_nUtil.setText(username);
    }
    
    public void logoutBtn() {
        try {
            if (alert.confirmeMessage("etes vous sur de se deconnecter")) {
                // TO SHOW THE LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.show();

                // TO HIDE YOUR MAIN FORM
                deconct_btn.getScene().getWindow().hide();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayGreet();
        tabBordTEtudInsc();
        tabBordAffTEns();
        tabBordAffTEtud();
        tabBordAffRevenu();
        tabBordGrapheEtud();
        tabBordGrapheEns();
    }

}
