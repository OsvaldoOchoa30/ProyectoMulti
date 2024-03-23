package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CrearBebidaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomCrearBebida;

    @FXML
    private ComboBox<?> ComboBoxSizeBebida;

    @FXML
    private ComboBox<?> ComboBoxTipoBebida;

    @FXML
    private TextField TextFieldDescripcionBebida;

    @FXML
    private TextField TextFieldNombreBebida;

    @FXML
    private TextField TextFieldPrecioBebida;

    @FXML
    void OnMouseClickedButtomCrear(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxSizeBebida(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxTipoBebida(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomCrearBebida != null : "fx:id=\"ButtomCrearBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert ComboBoxSizeBebida != null : "fx:id=\"ComboBoxSizeBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert ComboBoxTipoBebida != null : "fx:id=\"ComboBoxTipoBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert TextFieldDescripcionBebida != null : "fx:id=\"TextFieldDescripcionBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert TextFieldNombreBebida != null : "fx:id=\"TextFieldNombreBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert TextFieldPrecioBebida != null : "fx:id=\"TextFieldPrecioBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";

    }

}
