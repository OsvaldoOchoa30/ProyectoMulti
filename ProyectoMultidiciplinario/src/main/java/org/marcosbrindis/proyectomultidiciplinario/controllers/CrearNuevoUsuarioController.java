package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CrearNuevoUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomBackToMenuNU;

    @FXML
    private Button ButtomCrearNU;

    @FXML
    private ComboBox<?> ComboBoxRolNU;

    @FXML
    private TextField TextFieldNombreNU;

    @FXML
    private TextField TextFieldPasswordCorrectaNU;

    @FXML
    private TextField TextFieldPasswordNU;

    @FXML
    void OnMouseClickedButtomBackToMenuNU(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtomCrearNU(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxRolNU(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomBackToMenuNU != null : "fx:id=\"ButtomBackToMenuNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert ButtomCrearNU != null : "fx:id=\"ButtomCrearNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert ComboBoxRolNU != null : "fx:id=\"ComboBoxRolNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert TextFieldNombreNU != null : "fx:id=\"TextFieldNombreNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert TextFieldPasswordCorrectaNU != null : "fx:id=\"TextFieldPasswordCorrectaNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert TextFieldPasswordNU != null : "fx:id=\"TextFieldPasswordNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";

    }

}
