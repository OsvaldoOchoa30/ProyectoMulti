package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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

    @FXML
    void OnMouseClickedButtomLogin(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomLogin != null : "fx:id=\"ButtomLogin\" was not injected: check your FXML file 'login-view.fxml'.";
        assert TextFieldNameLogin != null : "fx:id=\"TextFieldNameLogin\" was not injected: check your FXML file 'login-view.fxml'.";
        assert TextFieldPaswordLogin != null : "fx:id=\"TextFieldPaswordLogin\" was not injected: check your FXML file 'login-view.fxml'.";

    }

}
