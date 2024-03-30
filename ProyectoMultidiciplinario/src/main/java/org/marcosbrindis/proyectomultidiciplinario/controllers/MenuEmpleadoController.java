package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

public class MenuEmpleadoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomCancelarPedidoEMP;

    @FXML
    private Button ButtomCrearPedidoEMP;

    @FXML
    private Button ButtomVerMenuEMP;

    @FXML
    private Button ButtomVerPedidosEMP;

    @FXML
    private Button ButtonCerrarSesionEMP;

    @FXML
    private Button ButtonCocinaEMP;
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedCancelarPedidoEMP(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedCrearPedidoEMP(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedVerMenuEMP(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedVerPedidosEMP(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtonCerrarSesionEMP(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtonCocinaEMP(MouseEvent event) {

    }

    @FXML
    void initialize() {
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

}
