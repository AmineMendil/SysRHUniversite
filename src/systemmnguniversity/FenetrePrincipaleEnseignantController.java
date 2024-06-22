/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmnguniversity;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FenetrePrincipaleEnseignantController implements Initializable {

    @FXML
    private Button ens_deconct_btn;

    @FXML
    private Button btn_ajoutEtud_window;

    @FXML
    private Button btn_ajoutSujet_window;

    @FXML
    private Label ens_lab_idENS;

    @FXML
    private Label nom_fenetre;

    @FXML
    private AnchorPane ens_ajoutEtud_window;

    @FXML
    private ComboBox<String> ens_combo_idEtud;

    @FXML
    private ComboBox<String> ens_combo_cours;

    @FXML
    private ComboBox<String> ens_combo_annee;

    @FXML
    private TableView<DataEtudiantEns> ajout_etudiant_tabView;

    @FXML
    private Label ens_lab_nom;

    @FXML
    private Label ens_lab_prenom;

    @FXML
    private Label ens_lab_email;

    @FXML
    private Label ens_lab_genre;

    @FXML
    private Label ens_lab_semestre;

    @FXML
    private Label ens_lab_annee;

    @FXML
    private Button ens_btn_ajout;

    @FXML
    private Button ens_btn_vider;

    @FXML
    private Button ens_btn_supprimer;

    @FXML
    private Label ens_lab_cours;

    @FXML
    private TableColumn<DataEtudiantEns, String> ens_col_idEtud;

    @FXML
    private TableColumn<DataEtudiantEns, String> ens_col_nom;

    @FXML
    private TableColumn<DataEtudiantEns, String> ens_col_prenom;

    @FXML
    private TableColumn<DataEtudiantEns, String> ens_col_semestre;

    @FXML
    private TableColumn<DataEtudiantEns, String> ens_col_cours;

    @FXML
    private TableColumn<DataEtudiantEns, String> ens_col_dateInsertion;

    @FXML
    private AnchorPane ens_ajoutSujet_window;

    @FXML
    private ComboBox<String> ens_combo_codeSujet;

    @FXML
    private ComboBox<String> ens_combo_sujet;

    @FXML
    private ComboBox<String> ens_combo_statusSuj;

    @FXML
    private Button ens_btn_Ajoutsujet;

    @FXML
    private Button ens_btn_vidersujet;

    @FXML
    private Button ens_btn_suppsujet;

    @FXML
    private TableColumn<EnsSujetData, String> ens_col_codeSujet;

    @FXML
    private TableColumn<EnsSujetData, String> ens_col_Sujet;

    @FXML
    private TableColumn<EnsSujetData, String> ens_col_status;

    @FXML
    private TableColumn<EnsSujetData, String> ens_col_SUJDateInsert;

    @FXML
    private TableView<EnsSujetData> ajou_sujet_tabView;

    @FXML
    private Label greet_name;

    //Outils de la base de données.
    Connection connexion;
    private PreparedStatement preparer;
    private ResultSet resultat;
    private Statement declaration;

    private MessageAlerte alerte = new MessageAlerte();

    public void addStudentsAddBtn() {

        if (ens_combo_idEtud.getSelectionModel().getSelectedItem() == null
                || ens_combo_annee.getSelectionModel().getSelectedItem() == null
                || ens_combo_cours.getSelectionModel().getSelectedItem() == null) {
            alerte.messageErreur("veuillez remplir les champs vides");
        } else {

            String insertData = "INSERT INTO enseignant_etudiant "
                    + "( etud_idEtud, nom_etudiant, prenom_etudiant, email_etud,genre_etud"
                    + ", semestre_etudiant, cours_etudiant"
                    + ", dateInsertion, status) VALUES(?,?,?,?,?,?,?,?,?)";
            connexion = DataBase.connectDB();

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            try {
                preparer = connexion.prepareStatement(insertData);
                preparer.setString(1, ens_combo_idEtud.getSelectionModel().getSelectedItem());
                preparer.setString(2, ens_lab_nom.getText());
                preparer.setString(3, ens_lab_prenom.getText());
                preparer.setString(4, ens_lab_email.getText());
                preparer.setString(5, ens_lab_genre.getText());
                preparer.setString(6, ens_lab_semestre.getText());
                preparer.setString(7, ens_lab_cours.getText());
                preparer.setString(8, String.valueOf(sqlDate));
                preparer.setString(9, "Active");

                preparer.executeUpdate();

                addStudentDisplayData();

                alerte.messageReussie("Ajouté avec succès!");

                addStudentClearBtn();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addStudentsRemoveBtn() {

        if (ens_combo_cours.getSelectionModel().getSelectedItem() == null
                || ens_combo_annee.getSelectionModel().getSelectedItem() == null
                || ens_combo_idEtud.getSelectionModel().getSelectedItem() == null) {
            alerte.messageErreur("veuillez remplir les champs vides");
        } else {
            if (alerte.confirmeMessage("êtes vous sur de supprimer l'etudiant ID: "
                    + ens_combo_idEtud.getSelectionModel().getSelectedItem())) {
                String insertData = "UPDATE enseignant_etudiant SET dateSuppression = ?, status = ? "
                        + "WHERE etud_idEtud = ?";
                connexion = DataBase.connectDB();

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                try {
                    preparer = connexion.prepareStatement(insertData);
                    preparer.setString(1, String.valueOf(sqlDate));
                    preparer.setString(2, "Inactive");
                    preparer.setString(3, ens_combo_idEtud.getSelectionModel().getSelectedItem());

                    preparer.executeUpdate();

                    addStudentDisplayData();

                    alerte.messageReussie("Supprission avec succès!!");

                    addStudentClearBtn();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alerte.messageErreur("Cancelled.");
            }

        }
    }

    public void addStudentClearBtn() {
        ens_combo_idEtud.getSelectionModel().clearSelection();
        ens_combo_cours.getSelectionModel().clearSelection();
        ens_combo_annee.getSelectionModel().clearSelection();

        ens_lab_nom.setText("********");
        ens_lab_prenom.setText("********");
        ens_lab_email.setText("********");
        ens_lab_genre.setText("********");
        ens_lab_semestre.setText("********");
        ens_lab_cours.setText("********");
    }

    public ObservableList<DataEtudiantEns> addStudentListData() {

        ObservableList<DataEtudiantEns> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM enseignant_etudiant WHERE dateSuppression IS NULL AND status = 'Active'";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);

            resultat = preparer.executeQuery();

            DataEtudiantEns dshData;

            while (resultat.next()) {
                /*(String etud_idEtud, String nom_etud, String prenom_etud, String email_etud, String genre_etud, String cours_etud, String semestre_etud, Date dateInsertion, Date datesuppression, String status)*/
                dshData = new DataEtudiantEns(resultat.getString("etud_idEtud"),
                        resultat.getString("nom_etudiant"),
                        resultat.getString("prenom_etudiant"),
                        resultat.getString("email_etud"),
                        resultat.getString("genre_etud"),
                        resultat.getString("cours_etudiant"),
                        resultat.getString("semestre_etudiant"),
                        resultat.getDate("dateInsertion"),
                        resultat.getDate("dateSuppression"),
                        resultat.getString("status"));

                listData.add(dshData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<DataEtudiantEns> addStudentGetData;

    public void addStudentDisplayData() {
        addStudentGetData = addStudentListData();

        ens_col_idEtud.setCellValueFactory(new PropertyValueFactory<>("etud_idEtud"));
        ens_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_etud"));
        ens_col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_etud"));
        ens_col_semestre.setCellValueFactory(new PropertyValueFactory<>("semestre_etud"));
        ens_col_cours.setCellValueFactory(new PropertyValueFactory<>("cours_etud"));
        ens_col_dateInsertion.setCellValueFactory(new PropertyValueFactory<>("dateInsertion"));

        ajout_etudiant_tabView.setItems(addStudentGetData);

    }

    public void addStudentSelectitem() {
        DataEtudiantEns dshData = ajout_etudiant_tabView.getSelectionModel().getSelectedItem();
        int num = ajout_etudiant_tabView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        ens_combo_cours.getSelectionModel().select(dshData.getCours_etud());
        ens_combo_annee.getSelectionModel().select(dshData.getSemestre_etud());
        ens_combo_idEtud.getSelectionModel().select(dshData.getEtud_idEtud());

        ens_lab_nom.setText(dshData.getNom_etud());
        ens_lab_prenom.setText(dshData.getPrenom_etud());
        ens_lab_email.setText(dshData.getEmail_etud());
        ens_lab_genre.setText(dshData.getGenre_etud());
        ens_lab_semestre.setText(dshData.getSemestre_etud());
        ens_lab_cours.setText(dshData.getCours_etud());

    }

    public void addStudentCourseList() {

        String sql = "SELECT * FROM cours WHERE dateSuppression IS NULL";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (resultat.next()) {
                listData.add(resultat.getString("cours"));
            }

            ens_combo_cours.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<EnsSujetData> subjectHandleGetData() {

        ObservableList<EnsSujetData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM enseignant_sujet";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            EnsSujetData dshData;

            while (resultat.next()) {

                dshData = new EnsSujetData(resultat.getInt("id"),
                        resultat.getString("code_sujet"),
                        resultat.getString("sujet"),
                        resultat.getDate("date_insertion"), resultat.getString("status"));

                listData.add(dshData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void subjectHandleSubjectCodeList() {
        String sql = "SELECT * FROM sujet WHERE dateSuppression IS NULL";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (resultat.next()) {
                listData.add(resultat.getString("codeSujet"));
            }

            ens_combo_codeSujet.setItems(listData);

            subjectHandleSubjectList();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ObservableList<EnsSujetData> subjectHandleListData;

    public void subjectHandleDisplayData() {
        subjectHandleListData = subjectHandleGetData();

        ens_col_codeSujet.setCellValueFactory(new PropertyValueFactory<>("code_sujet"));
        ens_col_Sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        ens_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        ens_col_SUJDateInsert.setCellValueFactory(new PropertyValueFactory<>("date_insert"));

        ajou_sujet_tabView.setItems(subjectHandleListData);
    }

    public void subjectHandleSelectItem() {

        EnsSujetData dshData = ajou_sujet_tabView.getSelectionModel().getSelectedItem();
        int num = ajou_sujet_tabView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        ens_combo_codeSujet.getSelectionModel().select(dshData.getCode_sujet());
        ens_combo_sujet.getSelectionModel().select(dshData.getStatus());
        ens_combo_statusSuj.getSelectionModel().select(dshData.getStatus());

    }

    public void subjectHandleSubjectList() {
        String sql = "SELECT * FROM sujet WHERE dateSuppression IS NULL AND "
                + "codeSujet = '"
                + ens_combo_codeSujet.getSelectionModel().getSelectedItem() + "'";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (resultat.next()) {
                listData.add(resultat.getString("sujet"));
            }

            ens_combo_sujet.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudentsYearList() {

        List<String> listY = new ArrayList<>();

        for (String data : ListData.annee) {
            listY.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listY);
        ens_combo_annee.setItems(listData);

        addStudentsStudentNumber();

    }

    public void addStudentsStudentNumber() {

        String sql = "SELECT * FROM etudiant WHERE cours = '"
                + ens_combo_cours.getSelectionModel().getSelectedItem() + "' AND semestre = '"
                + ens_combo_annee.getSelectionModel().getSelectedItem() + "' AND date_suppression IS NULL";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (resultat.next()) {
                listData.add(resultat.getString("id_etudiant"));
            }

            ens_combo_idEtud.setItems(listData);

            addStudentsDisplayFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudentsDisplayFields() {

        String sql = "SELECT * FROM etudiant WHERE id_etudiant = '"
                + ens_combo_idEtud.getSelectionModel().getSelectedItem() + "'";

        connexion = DataBase.connectDB();

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                ens_lab_nom.setText(resultat.getString("nom"));
                ens_lab_prenom.setText(resultat.getString("prenom"));
                ens_lab_email.setText(resultat.getString("email"));
                ens_lab_genre.setText(resultat.getString("genre"));
                ens_lab_semestre.setText(resultat.getString("semestre"));
                ens_lab_cours.setText(resultat.getString("cours"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void subjectHandleAddBtn() {

        if (ens_combo_codeSujet.getSelectionModel().getSelectedItem() == null
                || ens_combo_sujet.getSelectionModel().getSelectedItem() == null
                || ens_combo_statusSuj.getSelectionModel().getSelectedItem() == null) {

            alerte.messageErreur("Veuillez remplir les champs vides");
        } else {
            String insertData = "INSERT INTO enseignant_sujet (code_sujet, sujet, date_insertion, status) "
                    + "VALUES(?,?,?,?)";
            connexion = DataBase.connectDB();

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            try {
                preparer = connexion.prepareStatement(insertData);
                preparer.setString(1, ens_combo_codeSujet.getSelectionModel().getSelectedItem());
                preparer.setString(2, ens_combo_sujet.getSelectionModel().getSelectedItem());
                preparer.setString(3, String.valueOf(sqlDate));
                preparer.setString(4, ens_combo_statusSuj.getSelectionModel().getSelectedItem());

                preparer.executeUpdate();

                subjectHandleDisplayData();

                alerte.messageReussie("Ajouter avec succès!");

                subjectHandleClearBtn();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void subjectHandleRemoveBtn() {

        if (ens_combo_codeSujet.getSelectionModel().getSelectedItem() == null
                || ens_combo_sujet.getSelectionModel().getSelectedItem() == null
                || ens_combo_statusSuj.getSelectionModel().getSelectedItem() == null) {
            alerte.messageErreur("Veuillez remplir les champs vides");
        } else {

            if (alerte.confirmeMessage("etes vous sur de supprimer le sujet: "
                    + ens_combo_codeSujet.getSelectionModel().getSelectedItem() + "?")) {
                String deleteData = "DELETE FROM enseignant_sujet WHERE code_sujet = '"
                        + ens_combo_codeSujet.getSelectionModel().getSelectedItem() + "'";
                connexion = DataBase.connectDB();

                try {
                    preparer = connexion.prepareStatement(deleteData);

                    preparer.executeUpdate();

                    subjectHandleDisplayData();

                    alerte.messageReussie("Supprimer avec succès!");

                    subjectHandleClearBtn();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alerte.messageErreur("annuler");
            }

        }
    }

    public void subjectHandleClearBtn() {
        ens_combo_codeSujet.getSelectionModel().clearSelection();
        ens_combo_sujet.getSelectionModel().clearSelection();
        ens_combo_statusSuj.getSelectionModel().clearSelection();
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == btn_ajoutEtud_window) {
            ens_ajoutEtud_window.setVisible(true);
            ens_ajoutSujet_window.setVisible(false);

            addStudentCourseList();
            addStudentsYearList();
            addStudentDisplayData();

            nom_fenetre.setText("Ajout etudiant | fenetre");
        } else if (event.getSource() == btn_ajoutSujet_window) {
            ens_ajoutEtud_window.setVisible(false);
            ens_ajoutSujet_window.setVisible(true);

            subjectHandleStatusList();
            subjectHandleSubjectCodeList();
            subjectHandleSubjectCodeList();
            nom_fenetre.setText("Ajout sujet | fenetre");

        }

    }

    public void subjectHandleStatusList() {

        List<String> listS = new ArrayList<>();

        for (String data : ListData.statusCours) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        ens_combo_statusSuj.setItems(listData);

    }

    public void logoutBtn() {
        try {
            if (alerte.confirmeMessage("etes vous sur de se deconnecter")) {
                // TO SHOW THE LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.show();

                // TO HIDE YOUR MAIN FORM
                ens_deconct_btn.getScene().getWindow().hide();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ////
        addStudentCourseList();
        addStudentsYearList();

        addStudentDisplayData();

        

        ///
        //    subjectHandleStatusList();
        //  subjectHandleSubjectCodeList();
        //subjectHandleSubjectCodeList();
    }

}
