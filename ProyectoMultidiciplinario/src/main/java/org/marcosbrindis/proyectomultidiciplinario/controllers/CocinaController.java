package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

import java.io.IOException;

public class CocinaController {

    @FXML
    private Button ButtomBackToMenuCocina;

    @FXML
    private Button ButtomFinalizarPedido;

    @FXML
    private Label LabelCantidad;

    @FXML
    private Label LabelNombre;
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuCocina(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnMouseClickedButtomFinalizarPedido(MouseEvent event) {

    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

}
