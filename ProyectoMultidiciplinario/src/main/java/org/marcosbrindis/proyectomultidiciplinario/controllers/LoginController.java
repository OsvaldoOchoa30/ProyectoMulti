package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;


public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomLogin;

    @FXML
    private TextField TextFieldNameLogin;

    @FXML
    private TextField TextFieldPaswordLogin;

    Stage callSu = new Stage();
    Stage callAd = new Stage();

    @FXML
    void OnMouseClickedButtomLogin(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            callSu.setTitle("Hello!");
            callSu.setScene(scene);
            callSu.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void initialize() {
        assert ButtomLogin != null : "fx:id=\"ButtomLogin\" was not injected: check your FXML file 'login-view.fxml'.";
        assert TextFieldNameLogin != null : "fx:id=\"TextFieldNameLogin\" was not injected: check your FXML file 'login-view.fxml'.";
        assert TextFieldPaswordLogin != null : "fx:id=\"TextFieldPaswordLogin\" was not injected: check your FXML file 'login-view.fxml'.";

    }

}
