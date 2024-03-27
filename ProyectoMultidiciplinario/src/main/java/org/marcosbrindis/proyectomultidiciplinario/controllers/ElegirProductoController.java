package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;

public class ElegirProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomBackToMenuElegirProducto;

    @FXML
    private Button ButtomBebida;


    @FXML
    private Button ButtomTaco;
    //CallSu
    Stage callSu = new Stage();

    @FXML
    void OnMouseClickedButtomBackToMenuElegirProducto(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtomBebida(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearBebida-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            callSu.setTitle("Crear Nuevo Usuario");
            callSu.setScene(scene);
            callSu.show();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void OnMouseClickedButtomTaco(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearTaco-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            callSu.setTitle("Crear Nuevo Usuario");
            callSu.setScene(scene);
            callSu.show();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void initialize() {
        assert ButtomBackToMenuElegirProducto != null : "fx:id=\"ButtomBackToMenuElegirProducto\" was not injected: check your FXML file 'elegirProducto-view.fxml'.";
        assert ButtomBebida != null : "fx:id=\"ButtomBebida\" was not injected: check your FXML file 'elegirProducto-view.fxml'.";
        assert ButtomTaco != null : "fx:id=\"ButtomTaco\" was not injected: check your FXML file 'elegirProducto-view.fxml'.";

    }

}

