package com.example.demo2;

import com.app.poo.EtudiantDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class EtudiantController {

    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private Button parentButton;

    @FXML
    private VBox buttonBox;

    @FXML
    private Button savetf2;

    @FXML
    private Button udatetf2;

    @FXML
    private Button findtf2;

    @FXML
    private Button deletetf2;

    @FXML
    private Button detelealltf2;

    @FXML
    private TextField idifianttf2;

    @FXML
    private TextField nomtf2;

    @FXML
    private TextField prenomtf2;

    @FXML
    private TextField agetf2;

    @FXML
    private TextField adresstf2;

    @FXML
    private TextField emailtf2;

    @FXML
    private TextField phonetf2;

    @FXML
    private TextField datnaisstf2;

    @FXML
    private PasswordField passwordtf2;

    @FXML
    private ComboBox<String> sexetf2;



    @FXML
    private ImageView imageView;


    @FXML
    private Label messageLabel;

    private byte[] imageBytes;




    EtudiantDao etudiantDao = new EtudiantDao();

    @FXML
    public void initialize() {
        // Initialize ComboBox items if not done in FXML
        sexetf2.getItems().addAll("Masculin", "Féminin");
    }


    @FXML
    void deletebtn(ActionEvent event) {
        try {
            int id = Integer.parseInt(idifianttf2.getText());
            if (id == 0) {
                showAlert(" ", "L'ID ne peut pas être nul ou égal à zéro");
                return;
            }
            etudiantDao.delete(id);
            clearFields();
            showAlert(" ", "Étudiant supprimé avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(" ", "Erreur lors de la suppression de l'étudiant");
        }

    }

    @FXML
    void findbtn(ActionEvent event) {
        try {
            int Id = Integer.parseInt(idifianttf2.getText());
            if (Id == 0) {
                showAlert(" ", "L'ID ne peut pas être nul ou égal à zéro");
                return;
            }
            Etudiant etudiant = etudiantDao.find(Id);
            if (etudiant != null) {
                nomtf2.setText(etudiant.getNom());
                prenomtf2.setText(etudiant.getPrenom());
                agetf2.setText(String.valueOf(etudiant.getAge()));
                sexetf2.setValue(etudiant.getSexe());
                //datnaisstf2.setAccessibleText(etudiant.getDateNaiss());
                datnaisstf2.setText(etudiant.getDateNaiss());
                passwordtf2.setText(etudiant.getMotDePasse());
                adresstf2.setText(etudiant.getAdresse());
                emailtf2.setText(etudiant.getEmail());
                phonetf2.setText(etudiant.getTelephone());

                if (etudiant.getImage() != null) {
                    ByteArrayInputStream bis = new ByteArrayInputStream(etudiant.getImage());
                    Image image = new Image(bis);
                    imageView.setImage(image);
                }
            } else {
                // vider les champs
                clearFields();

                //message d'alerte
                showAlert("Erreur", "Aucun étudiant trouvé avec cet ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    void savebtn(ActionEvent event) {
        try {
            int Id = Integer.parseInt(idifianttf2.getText());
            if (Id == 0) {
                showAlert(" ", "L'ID ne peut pas être nul ou égal à zéro");
                return;
            }
            String Nom = nomtf2.getText();
            String Prenom = prenomtf2.getText();
            int Age = Integer.parseInt(agetf2.getText());
            String Sexe = sexetf2.getValue();
            String DateNaiss = datnaisstf2.getText();
            String MotDePass = passwordtf2.getText();
            String Adresse = adresstf2.getText();
            String Email = emailtf2.getText();
            String Telephone = phonetf2.getText();

            byte[] imageBytes = this.imageBytes;


            Etudiant etudiant = new Etudiant(Id, Nom, Prenom, Age, Sexe, DateNaiss, MotDePass, Adresse, Email, Telephone,imageBytes);

            etudiantDao.save(etudiant);
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void toggleButtons(ActionEvent event) {
        boolean isVisible = buttonBox.isVisible();
        buttonBox.setVisible(!isVisible);

    }

    @FXML
    void updatebtn(ActionEvent event) {
        try {

            int Id = Integer.parseInt(idifianttf2.getText());
            if (Id == 0 & Id <= 0) {
                showAlert(" ", "L'ID ne peut pas être nul ou égal à zéro");
                return;
            }
            String Nom = nomtf2.getText();
            String Prenom = prenomtf2.getText();
            int Age = Integer.parseInt(agetf2.getText());
            String Sexe = sexetf2.getValue();
            String DateNaiss = datnaisstf2.getText();
            String MotDePass = passwordtf2.getText();
            String Adresse = adresstf2.getText();
            String Email = emailtf2.getText();
            String Telephone = phonetf2.getText();



            Etudiant etudiant = new Etudiant(Id, Nom, Prenom, Age, Sexe, DateNaiss, MotDePass, Adresse, Email, Telephone,imageBytes);

            etudiantDao.update(etudiant);
            clearFields();
            showAlert(" ", "Étudiant mis à jour avec succès");

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(" ", "Erreur lors de la mise à jour de l'étudiant");
        }

    }

    @FXML
    void database(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataBase.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Informations des étudiants");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deleteallbtn(ActionEvent event) {

        try {
            etudiantDao.deleteAll();
            clearFields();
            showAlert(" ", "Tous les étudiants ont été supprimés avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(" ", "Erreur lors de la suppression de tous les étudiants");
        }

    }


    private void clearFields() {
        idifianttf2.clear();
        nomtf2.clear();
        prenomtf2.clear();
        phonetf2.clear();
        agetf2.clear();
        sexetf2.setValue(null);
        datnaisstf2.clear();
        passwordtf2.clear();
        adresstf2.clear();
        emailtf2.clear();
        phonetf2.clear();
        imageView.setImage(null);
        imageBytes = null;
    }

    @FXML
    void choisirImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Tous les fichiers", "*.*")
        );

        // Afficher la boîte de dialogue et attendre que l'utilisateur choisisse un fichier
        File selectedFile = fileChooser.showOpenDialog(stage); // Remplacez `stage` par votre référence à la fenêtre principale (Stage)

        if (selectedFile != null) {
            // Convertir le fichier sélectionné en tableau de bytes
            byte[] imageBytes = convertirEnBytes(selectedFile);

            // Afficher l'image ou faire autre chose avec l'image choisie
            afficherImage(imageBytes);
        }
    }

    private byte[] convertirEnBytes(File file) {
        try {
            Path path = file.toPath();
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void afficherImage(byte[] imageBytes) {
        // Afficher l'image dans votre application si nécessaire
        try {
            if (imageBytes == null || imageBytes.length == 0) {
                // Gérer le cas où l'image est vide ou nulle
                // Par exemple, afficher une image par défaut ou un message d'erreur
                imageView.setImage(new Image("/path/to/defaultImage.png")); // Image par défaut
            } else {
                Image image = new Image(new ByteArrayInputStream(imageBytes));
                imageView.setImage(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs d'affichage de l'image
        }
    }



    @FXML
    void uploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                FileInputStream fis = new FileInputStream(file);
                imageBytes = fis.readAllBytes();
                Image image = new Image(new ByteArrayInputStream(imageBytes));
                imageView.setImage(image);
            } catch (IOException e) {
                showAlert("ERROR", "Erreur lors du chargement de l'image: " + e.getMessage());
            }
        }
    }



}
