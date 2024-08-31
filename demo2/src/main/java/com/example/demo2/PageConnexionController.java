package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PageConnexionController {
    @FXML
    private TextField usernameTf2;

    @FXML
    private PasswordField passwordTf2;

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    void connexionTf2(ActionEvent event) throws IOException {
        String username=usernameTf2.getText();
        String password=passwordTf2.getText();
        if (username.equals("don") && password.equals("1234")){
            //chargement des autres pages
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Etudiant.fxml"));
            root=fxmlLoader.load();
            stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();


        }else {
                showAlert(" ","nom d'utilisateur ou mot de passe incorect");
        }

    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
