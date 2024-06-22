package systemmnguniversity;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class AjoutEtudiantController implements Initializable {

    //Identifiant des composant graphique.
    @FXML
    private TextField ajouEtudText_nom;

    @FXML
    private TextField ajouEtudText_matricule;

    @FXML
    private ComboBox<String> ajouEtudCombo_annee;

    @FXML
    private ComboBox<String> ajouEtudCombo_statuts;

    @FXML
    private ComboBox<String> ajouEtudCombo_statutsPaiment;

    @FXML
    private DatePicker ajouEtudDate_dateNaiss;

    @FXML
    private ComboBox<String> ajouEtudCombo_section;

    @FXML
    private ComboBox<String> ajouEtudCombo_sexe;

    @FXML
    private TextField ajouEtudText_email;

    @FXML
    private ImageView ajouEtud_imageView;

    @FXML
    private Button ajouEtudBtn_ajouter;

    @FXML
    private TextField ajouEtudText_paiment;

    @FXML
    private TextField ajouEtudText_prenom;

    @FXML
    private Button ajouEtudBtn_modifier;

    @FXML
    private Button ajouEtudBtn_importer;

    @FXML
    private ComboBox<String> ajouEtudCombo_cours;

    //Outils de la base de données.
    Connection connexion;
    private PreparedStatement preparer = null;
    private ResultSet resultat;

    private Image image;

    private MessageAlerte alert = new MessageAlerte();

    public void ajoutBtn() {
        if (ajouEtudText_matricule.getText().isEmpty() || ajouEtudText_email.getText().isEmpty()
                || ajouEtudText_nom.getText().isEmpty() || ajouEtudText_prenom.getText().isEmpty()
                || ajouEtudText_paiment.getText().isEmpty() || ajouEtudDate_dateNaiss.getValue() == null
                || ajouEtudCombo_sexe.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_cours.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_section.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_annee.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_statutsPaiment.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_statuts.getSelectionModel().getSelectedItem().isEmpty()
                || ListData.source == null || "".equals(ListData.source)) {
            alert.messageErreur("Veuillez remplir les champs vides");
        } else {
            connexion = DataBase.connectDB();

            String controleMatricule = "SELECT * FROM etudiant WHERE id_etudiant = '"
                    + ajouEtudText_matricule.getText() + "'";

            try {
                preparer = connexion.prepareStatement(controleMatricule);
                resultat = preparer.executeQuery();

                if (resultat.next()) {
                    alert.messageErreur("Cette matricule: " + ajouEtudText_matricule.getText() + "est déja prise");
                } else {

                    String insererData = "INSERT INTO etudiant (id_etudiant, email, nom, prenom, date_naissance,"
                            + " genre, image, date_inscription, cours, section, semestre, paiment, stauts_paiment"
                            + ", stauts_compte)"
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    preparer = connexion.prepareStatement(insererData);
                    preparer.setString(1, ajouEtudText_matricule.getText());
                    preparer.setString(2, ajouEtudText_email.getText());
                    preparer.setString(3, ajouEtudText_nom.getText());
                    preparer.setString(4, ajouEtudText_prenom.getText());
                    preparer.setString(5, String.valueOf(ajouEtudDate_dateNaiss.getValue()));
                    preparer.setString(6, ajouEtudCombo_sexe.getSelectionModel().getSelectedItem());

                    //récupération de chemin de l'image.
                    String chemin = ListData.source;
                    chemin = chemin.replace("//", "////");
                    preparer.setString(7, chemin);

                    //Récupération de la date de l'inscription.
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    preparer.setString(8, String.valueOf(sqlDate));

                    preparer.setString(9, ajouEtudCombo_cours.getSelectionModel().getSelectedItem());
                    preparer.setString(10, ajouEtudCombo_section.getSelectionModel().getSelectedItem());
                    preparer.setString(11, ajouEtudCombo_annee.getSelectionModel().getSelectedItem());
                    preparer.setString(12, ajouEtudText_paiment.getText());
                    preparer.setString(13, ajouEtudCombo_statutsPaiment.getSelectionModel().getSelectedItem());
                    preparer.setString(14, ajouEtudCombo_statuts.getSelectionModel().getSelectedItem());

                    preparer.executeUpdate();

                    System.out.println("succès");

                    Path transfer = Paths.get(chemin);
                    Path copy = Paths.get("C:\\Users\\RSservices\\Documents\\NetBeansProjects\\SystemMngUniversity\\src\\annuaire_etudiant"
                            + ajouEtudText_matricule.getText() + ".jpg");

                    Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);

                    alert.messageReussie("Le compte a été enregistré avec succès");
                    viderChamps();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void modifierBtn() {

        if (ajouEtudText_matricule.getText().isEmpty() || ajouEtudText_email.getText().isEmpty()
                || ajouEtudText_nom.getText().isEmpty() || ajouEtudText_prenom.getText().isEmpty()
                || ajouEtudText_paiment.getText().isEmpty() || ajouEtudDate_dateNaiss.getValue() == null
                || ajouEtudCombo_sexe.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_cours.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_section.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_annee.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_statutsPaiment.getSelectionModel().getSelectedItem().isEmpty()
                || ajouEtudCombo_statuts.getSelectionModel().getSelectedItem().isEmpty()
                || ListData.source == null || "".equals(ListData.source)) {
            alert.messageErreur("Veuillez remplir les champs vides");
        } else {

            if (alert.confirmeMessage("êtes vous sur de vouloir modifier l'étudiant ID"
                    + ajouEtudText_matricule.getText())) {
                connexion = DataBase.connectDB();
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String chemin = ListData.source;
                chemin = chemin.replace("\\", "\\\\");

                try {
                    Path transfere = Paths.get(chemin);
                    Path copy = Paths.get("C:\\Users\\RSservices\\Documents\\NetBeansProjects\\SystemMngUniversity\\src\\annuaire_etudiant"
                            + ajouEtudText_matricule.getText() + ".jpg");

                    Files.copy(transfere, copy, StandardCopyOption.REPLACE_EXISTING);

                    String modData = "UPDATE etudiant SET "
                            + "email = '" + ajouEtudText_email.getText() + "', "
                            + "nom = '" + ajouEtudText_nom.getText() + "', "
                            + "prenom = '" + ajouEtudText_prenom.getText() + "', "
                            + "date_naissance = '" + ajouEtudDate_dateNaiss.getValue() + "', "
                            + "genre = '" + ajouEtudCombo_sexe.getSelectionModel().getSelectedItem() + "', "
                            + "image = '" + ListData.source + "', "
                            + "date_modification = '" + String.valueOf(sqlDate) + "', "
                            + "cours = '" + ajouEtudCombo_cours.getSelectionModel().getSelectedItem() + "', "
                            + "section = '" + ajouEtudCombo_section.getSelectionModel().getSelectedItem() + "', "
                            + "semestre = '" + ajouEtudCombo_annee.getSelectionModel().getSelectedItem() + "', "
                            + "paiment = '" + ajouEtudText_paiment.getText() + "', "
                            + "stauts_paiment = '" + ajouEtudCombo_statutsPaiment.getSelectionModel().getSelectedItem() + "', "
                            + "stauts_compte = '" + ajouEtudCombo_statuts.getSelectionModel().getSelectedItem()
                            + "'WHERE id_etudiant = '" + ajouEtudText_matricule.getText() + "'";

                    preparer = connexion.prepareStatement(modData);
                    preparer.executeUpdate();

                    alert.messageReussie("Modification réussie");
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                alert.messageErreur("Annuler");

            }
        }

    }

    //Vider les champs après l'ajout.
    public void viderChamps() {

        affMatriculeEtud();
        ajouEtudText_email.clear();
        ajouEtudText_nom.clear();
        ajouEtudText_prenom.clear();
        ajouEtudCombo_sexe.getSelectionModel().clearSelection();

        ListData.source = "";
        ajouEtud_imageView.setImage(null);

        ajouEtudCombo_cours.getSelectionModel().clearSelection();
        ajouEtudCombo_section.getSelectionModel().clearSelection();
        ajouEtudCombo_annee.getSelectionModel().clearSelection();
        ajouEtudText_paiment.clear();
        ajouEtudCombo_statutsPaiment.getSelectionModel().clearSelection();
        ajouEtudCombo_statuts.getSelectionModel().clearSelection();
    }

    //récupérer les donner pour la modification
    public void modifierChamps() {

        if (ListData.temp_idEtud != null) {
            ajouEtudText_matricule.setText(ListData.temp_idEtud);
            ajouEtudText_email.setText(ListData.temp_emailEtud);
            ajouEtudText_nom.setText(ListData.temp_nomEtud);
            ajouEtudText_prenom.setText(ListData.temp_prenomEtud);
            ajouEtudDate_dateNaiss.setValue(LocalDate.parse(String.valueOf(ListData.temp_dateNaissEtud)));
            ajouEtudCombo_sexe.getSelectionModel().select(ListData.temp_sexeEtud);
            ajouEtudCombo_cours.getSelectionModel().select(ListData.temp_coursEtud);
            ajouEtudCombo_section.getSelectionModel().select(ListData.temp_sectionEtud);
            ajouEtudCombo_annee.getSelectionModel().select(ListData.temp_anneeEtud);
            ajouEtudText_paiment.setText(String.valueOf(ListData.temp_paimentEtud));
            ajouEtudCombo_statutsPaiment.getSelectionModel().select(ListData.temp_stPaimEtud);
            ajouEtudCombo_statuts.getSelectionModel().select(ListData.temp_stEtud);

        }

    }
    //Prix de chaque formation choisis.

    public void prixFormation() {
        double price = 0;
        //{"Cisco", "Java EE", "JavaFX", "Python", "Linux", "Algorithmique", "HTML/CSS/JavaScripts/PHP", "Anglais", "C++"}

        /*if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem() != null) {
            if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Cisco")) {
                price = 65000;
            } else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Java EE")) {
                price = 10000;
            } else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("JavaFX")) {
                price = 8000;
            } else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Python")) {
                price = 1500;
            } else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Linux")) {
                price = 20000;
            } else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Algorithmique")) {
                price = 5000;
            } else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("HTML/CSS/JavaScripts/PHP")) {
                price = 12000;
            } else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("C++")) {
                price = 16000;
            } else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Anglais")) {
                price = 6000;
            }else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Français")) {
                price = 5000;
            }else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Arabe")) {
                price = 2000;
            }else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Mecanique")) {
                price = 13000;
            }else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Chemie")) {
                price = 30000;
            }else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Analyse")) {
                price = 4000;
            }else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Algebre")) {
                price = 4500;
            }else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Installation Lan")) {
                price = 40000;
            }else if (ajouEtudCombo_cours.getSelectionModel().getSelectedItem().equals("Technologie IP")) {
                price = 35000;
            }

            //ajouEtudText_paiment.setText(String.valueOf(price) + " DA");
        }*/
        
        String sql = "SELECT * FROM cours WHERE cours = '"
                +ajouEtudCombo_cours.getSelectionModel().getSelectedItem()+"' AND dateSuppression IS NULL";
        
        connexion = DataBase.connectDB();
        try {
            preparer = connexion.prepareStatement(sql);
            
            
            resultat = preparer.executeQuery();
            
            if(resultat.next()){
                price = resultat.getDouble("prix");
                ajouEtudText_paiment.setText(String.valueOf(price));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Pour importer l'image
    public void importBtn() {
        FileChooser open = new FileChooser();
        open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*.jpg", "*.jpeg", "*.png"));

        File file = open.showOpenDialog(ajouEtudBtn_importer.getScene().getWindow());

        if (file != null) {
            ListData.source = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 105, 125, false, true);
            ajouEtud_imageView.setImage(image);

        }
    }

    //Pour donner l'dentifiant de l'étudiant.
    public void affMatriculeEtud() {
        FXMLDocumentController control = new FXMLDocumentController();

        String temp_etudiant = "ETD-" + String.valueOf(control.generateurIdEtudiant());
        ajouEtudText_matricule.setText(String.valueOf(temp_etudiant));
    }

    //Pour l'affichage de la liste de annee dans le combo box
    public void anneeList() {

        List<String> listA = new ArrayList<>();

        listA.addAll(Arrays.asList(ListData.annee));
        ObservableList list1 = FXCollections.observableArrayList(listA);
        ajouEtudCombo_annee.setItems(list1);
    }

    //Pour l'affichage de la liste de section dans le combo box
    public void sectionList() {

        List<String> listS = new ArrayList<>();

        listS.addAll(Arrays.asList(ListData.setion));
        ObservableList list2 = FXCollections.observableArrayList(listS);
        ajouEtudCombo_section.setItems(list2);
    }

    //Pour l'affichage de la liste de cours dans le combo box
    public void coursList() {

        /*List<String> listC = new ArrayList<>();

        listC.addAll(Arrays.asList(ListData.cours));
        ObservableList list3 = FXCollections.observableArrayList(listC);
        ajouEtudCombo_cours.setItems(list3);

        prixFormation();*/
        
        String sql = "SELECT * FROM cours WHERE dateSuppression IS NULL";
        
        connexion = DataBase.connectDB();
        try {
            ObservableList list3 = FXCollections.observableArrayList();
            
            preparer = connexion.prepareStatement(sql);
            resultat = preparer.executeQuery();
            
            while(resultat.next()){
                list3.add(resultat.getString("cours"));
            }
            ajouEtudCombo_cours.setItems(list3);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        prixFormation();
        
    }

    //Pour l'affichage de la liste de sexe dans le combo box
    public void sexeList() {

        List<String> listS = new ArrayList<>();

        listS.addAll(Arrays.asList(ListData.sexe));
        ObservableList list4 = FXCollections.observableArrayList(listS);
        ajouEtudCombo_sexe.setItems(list4);
    }

    //Pour l'affichage de la liste de statut paiment dans le combo box
    public void statutPaimentList() {

        List<String> listSP = new ArrayList<>();

        listSP.addAll(Arrays.asList(ListData.paiStatus));
        ObservableList list5 = FXCollections.observableArrayList(listSP);
        ajouEtudCombo_statutsPaiment.setItems(list5);
    }

    public void statutList() {

        List<String> listST = new ArrayList<>();

        listST.addAll(Arrays.asList(ListData.statuts));
        ObservableList list5 = FXCollections.observableArrayList(listST);
        ajouEtudCombo_statuts.setItems(list5);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anneeList();
        sectionList();
        coursList();
        sexeList();
        statutPaimentList();
        statutList();

        affMatriculeEtud();

        modifierChamps();
    }

}
