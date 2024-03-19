package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

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
    void initialize() {
        assert ButtomCancelarPedidoEMP != null : "fx:id=\"ButtomCancelarPedidoEMP\" was not injected: check your FXML file 'menuEmpleado-view.fxml'.";
        assert ButtomCrearPedidoEMP != null : "fx:id=\"ButtomCrearPedidoEMP\" was not injected: check your FXML file 'menuEmpleado-view.fxml'.";
        assert ButtomVerMenuEMP != null : "fx:id=\"ButtomVerMenuEMP\" was not injected: check your FXML file 'menuEmpleado-view.fxml'.";
        assert ButtomVerPedidosEMP != null : "fx:id=\"ButtomVerPedidosEMP\" was not injected: check your FXML file 'menuEmpleado-view.fxml'.";

    }

}
