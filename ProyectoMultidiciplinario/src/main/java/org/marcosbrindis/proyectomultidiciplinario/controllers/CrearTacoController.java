package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CrearTacoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomCrearTaco;

    @FXML
    private ComboBox<?> ComboBoxTipoCarne;

    @FXML
    private TextField TextFieldDescripcionTaco;

    @FXML
    private TextField TextFieldNombreTaco;

    @FXML
    private TextField TextFieldPrecioTaco;

    @FXML
    void OnMouseClickedButtomCrearTaco(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxTipoCarne(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomCrearTaco != null : "fx:id=\"ButtomCrearTaco\" was not injected: check your FXML file 'crearTaco-view.fxml'.";
        assert ComboBoxTipoCarne != null : "fx:id=\"ComboBoxTipoCarne\" was not injected: check your FXML file 'crearTaco-view.fxml'.";
        assert TextFieldDescripcionTaco != null : "fx:id=\"TextFieldDescripcionTaco\" was not injected: check your FXML file 'crearTaco-view.fxml'.";
        assert TextFieldNombreTaco != null : "fx:id=\"TextFieldNombreTaco\" was not injected: check your FXML file 'crearTaco-view.fxml'.";
        assert TextFieldPrecioTaco != null : "fx:id=\"TextFieldPrecioTaco\" was not injected: check your FXML file 'crearTaco-view.fxml'.";

    }

}
