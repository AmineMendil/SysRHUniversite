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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author RSservices
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField admin_nom;

    @FXML
    private TextField admin_prenom;

    @FXML
    private TextField ens_prenom;

    @FXML
    private TextField ens_nom;

    @FXML
    private TextField ens_dtn;

    @FXML
    private TextField etd_nom;

    @FXML
    private TextField etd_prenom;

    @FXML
    private TextField etd_dtn;

    @FXML
    private PasswordField ens_cmdp;

    @FXML
    private TextField ens_mail;

    @FXML
    private Button etd_btn;

    @FXML
    private Button login_btn;

    @FXML
    private Button ens_btn;

    @FXML
    private TextField login_nUtil;

    @FXML
    private ComboBox<String> login_combo;

    @FXML
    private PasswordField etd_cmdp;

    @FXML
    private AnchorPane admin_window;

    @FXML
    private PasswordField admin_cmdp;

    @FXML
    private Hyperlink etd_signin;

    @FXML
    private TextField etd_mail;

    @FXML
    private PasswordField admin_mdp;

    @FXML
    private AnchorPane ens_window;

    @FXML
    private TextField admin_nutil;

    @FXML
    private PasswordField login_mdp;

    @FXML
    private TextField etd_nUtil;

    @FXML
    private PasswordField ens_mdp;

    @FXML
    private AnchorPane login_window;

    @FXML
    private Hyperlink admin_signin;

    @FXML
    private AnchorPane etd_window;

    @FXML
    private PasswordField etd_mdp;

    @FXML
    private Hyperlink ens_signin;

    @FXML
    private TextField ens_nUtil;

    @FXML
    private Button admin_btn;

    Connection connexion;
    private PreparedStatement preparer;
    private ResultSet resultat;
    private Statement declaration;
    private MessageAlerte alerte = new MessageAlerte();

    public void connexionCompte() throws SQLException {

        //Vérification si les cahmps sont vide ==> génération d'erreur
        if (login_nUtil.getText().isEmpty() || login_mdp.getText().isEmpty()) {
            alerte.messageErreur("Veuillez remplir les champs vides");
        } else {
            String data = "SELECT * FROM utilisateurs WHERE nom_utilisateur = ? AND mot_de_passe = ?";

            //Effectuer une connexion à la base de donnée.
            connexion = DataBase.connectDB();

            String role = "";

            try {
                preparer = connexion.prepareStatement(data);
                preparer.setString(1, login_nUtil.getText());
                preparer.setString(2, login_mdp.getText());

                resultat = preparer.executeQuery();

                if (resultat.next()) {
                    role = resultat.getString("role");
                    //System.out.println(role);
                    Thread.sleep(1000);

                    if (role.equals("Admin")) {
                        ListData.nom_utilisateur = login_nUtil.getText();
                        //Faire un lien entre la denêtre de connexion et de la fenêtre principal de l'admin.
                        Parent root = FXMLLoader.load(getClass().getResource("FenetrePrincipalAdmin.fxml"));

                        Stage stage = new Stage();
                        stage.setTitle("Système de gestion d'université | Portail admin");
                        stage.setScene(new Scene(root));

                        stage.show();

                        //Pour cacher la fenêtre de connexion.
                        login_btn.getScene().getWindow().hide();

                    } else if (role.equals("Etudiant")) {
                        
                         String tempEtudiantID = resultat.getString("id_etudiant");

                        String checkData = "SELECT * FROM  etudiant WHERE id_etudiant = '"
                                + tempEtudiantID + "'";

                        declaration = connexion.createStatement();
                        resultat = declaration.executeQuery(checkData);

                        if (resultat.next()) {
                            if (resultat.getString("stauts_compte").equals("Approuve")) {
                                alerte.messageErreur("besoin que votre comptes soit approuvé par l'admin!");
                            } else if (resultat.getString("stauts_compte").equals("Desactiver")) {
                                alerte.messageErreur(" votre comptes est désactiver!");
                            } else {
                                ListData.nom_etudiant = login_nUtil.getText();
                                //Faire un lien entre la denêtre de connexion et de la fenêtre principal de l'admin.
                                Parent root = FXMLLoader.load(getClass().getResource("FenetrePrincipalEtudiant.fxml"));

                                Stage stage = new Stage();
                                stage.setTitle("Système de gestion d'université | Portail Etudiant");
                                stage.setScene(new Scene(root));

                                stage.show();

                                //Pour cacher la fenêtre de connexion.
                                login_btn.getScene().getWindow().hide();
                            }
                        }
                        
                        
                        

                    } else if (role.equals("Enseignant")) {

                        String tempTeacherID = resultat.getString("id_enseignant");

                        String checkData = "SELECT * FROM enseignant WHERE id_enseignant = '"
                                + tempTeacherID + "'";

                        declaration = connexion.createStatement();
                        resultat = declaration.executeQuery(checkData);

                        if (resultat.next()) {
                            if (resultat.getString("status_compte").equals("Approuve")) {
                                alerte.messageErreur("besoin que votre comptes soit approuvé par l'admin!");
                            } else if (resultat.getString("status_compte").equals("Desactiver")) {
                                alerte.messageErreur(" votre comptes est désactiver!");
                            } else {
                                ListData.nom_enseignant = login_nUtil.getText();
                                //Faire un lien entre la denêtre de connexion et de la fenêtre principal de l'admin.
                                Parent root = FXMLLoader.load(getClass().getResource("FenetrePrincipaleEnseignant.fxml"));

                                Stage stage = new Stage();
                                stage.setTitle("Système de gestion d'université | Portail Enseignant");
                                stage.setScene(new Scene(root));

                                stage.show();

                                //Pour cacher la fenêtre de connexion.
                                login_btn.getScene().getWindow().hide();
                            }
                        }

                    }

                } else {
                    //en cas l'utilisateur se trompe en saisissant son nom d'utilisateur/mots de passe
                    alerte.messageErreur("Nom utilisateur/Mot de passe incorrect");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inscriptionAdmin() {

        //Vérification si les cahmps sont vide ==> génération d'erreur
        if (admin_nutil.getText().isEmpty() || admin_mdp.getText().isEmpty() || admin_cmdp.getText().isEmpty()
                || admin_nom.getText().isEmpty() || admin_prenom.getText().isEmpty()) {
            alerte.messageErreur("Veuillez remplir les champs vides");
        } else {
            //Création d'un lien à la base de donnée.
            connexion = DataBase.connectDB();

            //Récupération de données de l'utilisateur.
            String dataSelctionner = "SELECT * FROM utilisateurs WHERE nom_utilisateur = '"
                    + admin_nutil.getText() + "'";

            try {
                //création d'un objet qui va servir à l'éxecution des requêtes SQL.
                declaration = connexion.createStatement();
                resultat = declaration.executeQuery(dataSelctionner);

                //Afficahge d'un message d'erreur si l'utilisateur existe déjà.
                if (resultat.next()) {
                    alerte.messageErreur(admin_nutil.getText() + " existe déjà !");

                    //Vérification si les deux champs ds mots de passe sont égeaux. 
                } else if (!admin_mdp.getText().equals(admin_cmdp.getText())) {
                    alerte.messageErreur("Veuillez saisir à nouveau MOT DE PASSE");
                } else if (admin_mdp.getText().length() < 6) {
                    alerte.messageErreur("Mot de passe invalide au moins 6 caractère");
                } else {

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    //Insertion des données dans la base de donnée
                    String dataInserer = "INSERT INTO utilisateurs (nom, prenom, nom_utilisateur, mot_de_passe, date_inscription, role)"
                            + "VALUES(? ,? ,? ,? ,? ,?)";

                    preparer = connexion.prepareStatement(dataInserer);
                    preparer.setString(1, admin_nom.getText());
                    preparer.setString(2, admin_prenom.getText());
                    preparer.setString(3, admin_nutil.getText());
                    preparer.setString(4, admin_mdp.getText());
                    preparer.setString(5, String.valueOf(sqlDate));
                    preparer.setString(6, "Admin");

                    //Exécution de la requête SQL.
                    preparer.executeUpdate();

                    //Vider les champs après l'inscription
                    admin_nom.clear();
                    admin_prenom.clear();
                    admin_nutil.clear();
                    admin_mdp.clear();
                    admin_cmdp.clear();

                    //Affichage d'un message que l'inscription est valide
                    alerte.messageReussie("Votre compte a été enregistré avec succès");

                    //Fermer la fenêtre d'inscription et affichage de la fenêtre de connexion
                    admin_window.setVisible(false);
                    login_window.setVisible(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inscriptionEtudiant() {
        if (etd_nUtil.getText().isEmpty() || etd_mdp.getText().isEmpty() || etd_cmdp.getText().isEmpty()
                || etd_nom.getText().isEmpty() || etd_prenom.getText().isEmpty() || etd_dtn.getText().isEmpty()) {
            alerte.messageErreur("Veuillez remplir les champs vides");
        } else {
            //Création d'un lien à la base de donnée.
            connexion = DataBase.connectDB();

            ///Récupération de données de l'utilisateur.
            String dataSelctionner = "SELECT * FROM utilisateurs WHERE nom_utilisateur = '"
                    + etd_nUtil.getText() + "'";

            try {
                //création d'un objet qui va servir à l'éxecution des requêtes SQL.
                declaration = connexion.createStatement();
                resultat = declaration.executeQuery(dataSelctionner);

                //Afficahge d'un message d'erreur si l'utilisateur existe déjà.
                if (resultat.next()) {
                    alerte.messageErreur(etd_nUtil.getText() + " existe déjà !");
                } else if (!etd_mdp.getText().equals(etd_cmdp.getText())) {
                    alerte.messageErreur("Veuillez saisir à nouveau MOT DE PASSE");

                    //vérifiaction si la longeur du mot de passe est > 6.
                } else if (etd_mdp.getText().length() < 6) {
                    alerte.messageErreur("Mot de passe invalide au moins 6 caractère");
                } else {

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    String temp_etudiant = "ETD-" + String.valueOf(generateurIdEtudiant());

                    //Insertion des données dans la base de donnée
                    String dataInserer = "INSERT INTO utilisateurs (id_etudiant, nom, prenom, email, nom_utilisateur, 	mot_de_passe, date_naissance, date_inscription, role)"
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    preparer = connexion.prepareStatement(dataInserer);
                    preparer.setString(1, String.valueOf(temp_etudiant));
                    preparer.setString(2, etd_nom.getText());
                    preparer.setString(3, etd_prenom.getText());
                    preparer.setString(4, etd_mail.getText());
                    preparer.setString(5, etd_nUtil.getText());
                    preparer.setString(6, etd_mdp.getText());
                    preparer.setString(7, etd_dtn.getText());
                    preparer.setString(8, String.valueOf(sqlDate));
                    preparer.setString(9, "Etudiant");
                    //Exécution de la requête SQL.
                    preparer.executeUpdate();

                    String etd_inserstion = "INSERT INTO etudiant (id_etudiant, nom_utilisateur, mot_de_passe, email, nom, prenom, "
                            + "date_naissance, date_inscription, stauts_compte) "
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    preparer = connexion.prepareStatement(etd_inserstion);
                    preparer.setString(1, String.valueOf(temp_etudiant));
                    preparer.setString(2, etd_nUtil.getText());
                    preparer.setString(3, etd_mdp.getText());
                    preparer.setString(4, etd_mail.getText());
                    preparer.setString(5, etd_nom.getText());
                    preparer.setString(6, etd_prenom.getText());
                    preparer.setString(7, etd_dtn.getText());
                    preparer.setString(8, String.valueOf(sqlDate));
                    preparer.setString(9, String.valueOf("Approuve"));

                    preparer.executeUpdate();

                    //Vider les champs apres l'inscription
                    etd_cmdp.clear();
                    etd_dtn.clear();
                    etd_mail.clear();
                    etd_mdp.clear();
                    etd_nUtil.clear();
                    etd_nom.clear();
                    etd_prenom.clear();

                    //Affichage d'un message que l'inscription est valide
                    alerte.messageReussie("Votre compte a été enregistré avec succès");

                    //Fermer la fenêtre d'inscription et affichage de la fenêtre de connexion
                    login_window.setVisible(true);
                    etd_window.setVisible(false);
                }
                connexion.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void inscriptionEnseignant() {

        //Vérification si les champs ne sont pas vide.
        if (ens_nUtil.getText().isEmpty() || ens_mdp.getText().isEmpty() || ens_cmdp.getText().isEmpty()
                || ens_nom.getText().isEmpty() || ens_prenom.getText().isEmpty() || ens_dtn.getText().isEmpty()) {
            alerte.messageErreur("Veuillez remplir les champs vides");
        } else {
            //Création d'un lien à la base de donnée.
            connexion = DataBase.connectDB();

            //Récupération de données de l'utilisateur.
            String dataSelctionner = "SELECT * FROM utilisateurs WHERE nom_utilisateur = '"
                    + ens_nUtil.getText() + "'";

            try {

                //création d'un objet qui va servir à l'éxecution des requêtes SQL.
                declaration = connexion.createStatement();
                resultat = declaration.executeQuery(dataSelctionner);

                //Affichage d'un message d'erreur si l'utilisateur existe déjà.
                if (resultat.next()) {
                    alerte.messageErreur(ens_nUtil.getText() + " existe déjà !");

                    //Vérification si les deux champs ds mots de passe sont égeaux.    
                } else if (!ens_mdp.getText().equals(ens_cmdp.getText())) {
                    alerte.messageErreur("Veuillez saisir à nouveau MOT DE PASSE");

                    //vérifiaction si la longeur du mot de passe est > 6.
                } else if (ens_mdp.getText().length() < 6) {
                    alerte.messageErreur("Mot de passe invalide au moins 6 caractère");
                } else {

                    //Insertion des données dans la base de donnée
                    String dataInserer = "INSERT INTO utilisateurs (id_enseignant, nom, prenom, email, nom_utilisateur, mot_de_passe, date_naissance, date_inscription, role )"
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    String temp_enseignant = "ENS-" + String.valueOf(generateurIdEnseignant());

                    //Préparation de la requête SQL et récupération des données à insérer.
                    preparer = connexion.prepareStatement(dataInserer);
                    preparer.setString(1, String.valueOf(temp_enseignant));
                    preparer.setString(2, ens_nom.getText());
                    preparer.setString(3, ens_prenom.getText());
                    preparer.setString(4, ens_mail.getText());
                    preparer.setString(5, ens_nUtil.getText());
                    preparer.setString(6, ens_mdp.getText());
                    preparer.setString(7, ens_dtn.getText());
                    preparer.setString(8, String.valueOf(sqlDate));
                    preparer.setString(9, "Enseignant");

                    //Exécution de la requête SQL.
                    preparer.executeUpdate();

                    String insererEnseigant = "INSERT INTO enseignant(id_enseignant, nom_utilisateur, mot_de_passe, email, nom, prenom, date_naissance, date_inscription, status_compte)"
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
                    preparer = connexion.prepareStatement(insererEnseigant);
                    preparer.setString(1, temp_enseignant);
                    preparer.setString(2, ens_nUtil.getText());
                    preparer.setString(3, ens_mdp.getText());
                    preparer.setString(4, ens_mail.getText());
                    preparer.setString(5, ens_nom.getText());
                    preparer.setString(6, ens_prenom.getText());
                    preparer.setString(7, ens_dtn.getText());
                    preparer.setString(8, String.valueOf(sqlDate));
                    preparer.setString(9, "Approuve");

                    //System.out.println(preparer);
                    preparer.executeUpdate();

                    //Vider les champs apres l'inscription.
                    ens_cmdp.clear();
                    ens_dtn.clear();
                    ens_mail.clear();
                    ens_mdp.clear();
                    ens_nUtil.clear();
                    ens_nom.clear();
                    ens_prenom.clear();

                    //Affichage d'un message que l'inscription est valide.
                    alerte.messageReussie("Votre compte a été enregistré avec succès");

                    //Fermer la fenêtre d'inscription et affichage de la fenêtre de connexion
                    login_window.setVisible(true);
                    ens_window.setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //Génération de l'identifiant de l'étudiant.
    private int idEtd;

    public int generateurIdEtudiant() {
        String sql = "SELECT MAX(id) FROM etudiant";

        connexion = DataBase.connectDB();

        int temp_idEtd = 0;

        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                temp_idEtd = resultat.getInt("MAX(id)");
            }
            if (temp_idEtd == 0) {
                idEtd = 1;
            } else {
                idEtd = temp_idEtd + 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return idEtd;

    }

    //Génération de l'identifiant de l'enseignant.
    private int idEns = 0;

    public int generateurIdEnseignant() {
        String sql = "SELECT MAX(id) FROM enseignant";

        connexion = DataBase.connectDB();
        int temp_ensID = 0;
        try {
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();

            if (resultat.next()) {
                temp_ensID = resultat.getInt("MAX(id)");
            }
            if (temp_ensID == 0) {
                idEns = 1;
            } else {
                idEns = temp_ensID + 1;
            }
        } catch (Exception e) {
        }
        return idEns;
    }

    public void roleList() {
        List<String> listR = new ArrayList<>();
        for (String data : ListData.role) {
            listR.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listR);
        login_combo.setItems(listData);
    }

    //Cette fonction permet de passer d'une fenêtre à une autre en séléctionant la fenêtre qu'on veux.
    public void basculerWindow() {
        switch (login_combo.getSelectionModel().getSelectedItem()) {
            case "Admin":
                admin_window.setVisible(true);
                ens_window.setVisible(false);
                etd_window.setVisible(false);
                login_window.setVisible(false);
                break;
            case "Enseignant":
                ens_window.setVisible(true);
                admin_window.setVisible(false);
                etd_window.setVisible(false);
                login_window.setVisible(false);
                break;
            case "Etudiant":
                etd_window.setVisible(true);
                ens_window.setVisible(false);
                admin_window.setVisible(false);
                login_window.setVisible(false);
                break;
            default:
                break;
        }
    }

    //Cette fenêtre permet de passer des 3 fenêtre {"Admini", "Etudiant", "Enseignant"} à la fenêtre de connexion.
    public void signInWin() {
        login_window.setVisible(true);
        etd_window.setVisible(false);
        ens_window.setVisible(false);
        admin_window.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roleList();
    }

}
