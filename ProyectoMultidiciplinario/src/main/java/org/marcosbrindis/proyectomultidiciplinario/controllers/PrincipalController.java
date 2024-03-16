package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomCrear;

    @FXML
    private TextField TextFieldName;

    @FXML
    private TextField TextFieldOficialPassword;

    @FXML
    private TextField TextFieldPassword;

    @FXML
    void OnMouseClickedButtomCrear(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomCrear != null : "fx:id=\"ButtomCrear\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert TextFieldName != null : "fx:id=\"TextFieldName\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert TextFieldOficialPassword != null : "fx:id=\"TextFieldOficialPassword\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert TextFieldPassword != null : "fx:id=\"TextFieldPassword\" was not injected: check your FXML file 'principal-view.fxml'.";

    }

}
