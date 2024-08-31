package com.example.demo2;

import com.app.poo.EtudiantDao;
import com.sun.jdi.connect.spi.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DataBaseController {

    @FXML
    private TableView<Etudiant> tableetudiant;
    @FXML
    private TableColumn<Etudiant, Integer> idtf2;

    @FXML
    private TableColumn<Etudiant, String> nomtf2;

    @FXML
    private TableColumn<Etudiant, String> prenomtf2;

    @FXML
    private TableColumn<Etudiant, Integer> agetf2;

    @FXML
    private TableColumn<Etudiant, String> sexeTf2;

    @FXML
    private TableColumn<Etudiant, String> datenaisstf2;

    @FXML
    private TableColumn<Etudiant, String> passwordtf2;

    @FXML
    private TableColumn<Etudiant, String> adressetf2;

    @FXML
    private TableColumn<Etudiant, String> emailTf2;

    @FXML
    private TableColumn<Etudiant, String> phonetf2;

    @FXML
    private TableColumn<Etudiant,byte[]> imagetf2;


    private ObservableList<Etudiant> etudiantData;

    EtudiantDao etudiantDao=new EtudiantDao();



    public void initialize() {
      try{

        idtf2.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nomtf2.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        prenomtf2.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        agetf2.setCellValueFactory(new PropertyValueFactory<>("Age"));
        sexeTf2.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
        datenaisstf2.setCellValueFactory(new PropertyValueFactory<>("DateNaiss"));
        passwordtf2.setCellValueFactory(new PropertyValueFactory<>("MotDePasse"));
        adressetf2.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        emailTf2.setCellValueFactory(new PropertyValueFactory<>("Email"));
        phonetf2.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        imagetf2.setCellValueFactory(new PropertyValueFactory<>("Image"));

        etudiantData = FXCollections.observableArrayList(etudiantDao.findAll());
        tableetudiant.setItems(etudiantData);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}



    @FXML
    void retourtf2(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Etudiant.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            ////stage.setTitle("Informations des étudiants");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }

