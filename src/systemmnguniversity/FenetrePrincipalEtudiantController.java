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
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RSservices
 */
public class FenetrePrincipalEtudiantController implements Initializable {

    @FXML
    private Button etd_infoEtudBtn;

    @FXML
    private Button etd_decBtn;

    @FXML
    private Label etd_idEtud;

    @FXML
    private TableView<DataEtudiantEns> etd_tableView;

    @FXML
    private TableColumn<?, ?> etd_col_idEns;

    @FXML
    private TableColumn<?, ?> etd_col_nom;

    @FXML
    private TableColumn<?, ?> etd_col_genre;

    @FXML
    private TableColumn<?, ?> etd_col_AnnExp;

    @FXML
    private Circle etd_image;

    @FXML
    private Label etd_idEns;

    @FXML
    private Label etd_nom;

    @FXML
    private Label etd_gerne;

    @FXML
    private Label etd_date;

    /*(String id_enseignant, String nom, String prenom, 
    String email, String nomUtilisateur, String departement)*/
    //Outils de la base de données.
    Connection connexion;
    private PreparedStatement preparer;
    private ResultSet resultat;
    private Statement declaration;

    //Pour la génération des alerte.
    private MessageAlerte alert = new MessageAlerte();

    public ObservableList<DataEtudiantEns> teacherSetData() {

        ObservableList<DataEtudiantEns> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM enseignant_etudiant WHERE etud_idEtud = '"
                + etd_idEtud.getText() + "' AND dateSuppression IS NULL";
        connexion = DataBase.connectDB();

        try {

            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            DataEtudiantEns dsh;

            while (resultat.next()) {
//                DataStudentHandle(String teacherID, String studentID
//            , String name, String gender, Date dateInsert)

                dsh = new DataEtudiantEns(resultat.getString("ens_enseiID"),
                        resultat.getString("etud_idEtud"),
                        resultat.getString("nom_etudiant"),
                        resultat.getString("genre_etud"),
                        resultat.getDate("dateInsertion"));
                listData.add(dsh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
    
     private ObservableList<DataEtudiantEns> teacherListData;
    
  

    public void teacherDisplayData() {
        teacherListData = teacherSetData();

        etd_col_idEns.setCellValueFactory(new PropertyValueFactory<>("id_enseignant"));
        etd_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        etd_col_genre.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        etd_col_AnnExp.setCellValueFactory(new PropertyValueFactory<>("anneeExperience"));

        etd_tableView.setItems(teacherListData);
    }

    
    
      public void teacherSelectData() {
        DataEtudiantEns dsh = etd_tableView.getSelectionModel().getSelectedItem();
        int num = etd_tableView.getSelectionModel().getSelectedIndex();
        
        if ((num - 1) < -1) {
            return;
        }
        
        String sql = "SELECT * FROM enseignant WHERE id_enseignant = '"
                + dsh.getTeacherID()+ "'";
        
        connexion = DataBase.connectDB();
        
        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();
            
            if (resultat.next()) {
                
                etd_idEns.setText(resultat.getString("id_enseignant"));
                etd_nom.setText(resultat.getString("nom"));
                etd_gerne.setText(resultat.getString("genre"));
                etd_date.setText(resultat.getString("date_inscription"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
      
          public void studentIDDisplay() {
        
        String sql = "SELECT * FROM utilisateurs WHERE nom_utilisateur = '"
                + ListData.nom_etudiant + "'";
        
        connexion = DataBase.connectDB();
        
        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();
            
            if (resultat.next()) {
                etd_idEtud.setText(resultat.getString("id_etudiant"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
 
    
    
    
    public void logoutBtn() {

        try {
            if (alert.confirmeMessage("Are you sure you want to logout?")) {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

                etd_decBtn.getScene().getWindow().hide();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teacherDisplayData();
        studentIDDisplay();
    }

}
