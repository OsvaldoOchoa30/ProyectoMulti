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

public class ModificarProducto {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomBackToMenuModificarProducto;

    @FXML
    private Button ButtomModificarBebida;

    @FXML
    private Button ButtomModificarTaco;

    @FXML
    void OnMouseClickedButtomBackToMenuModificarProducto(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Menu del Administrador.");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void OnMouseClickedButtomModificarBebida(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtomModificarTaco(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("modificarTaco-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Modificar Producto.");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize() {
        assert ButtomBackToMenuModificarProducto != null : "fx:id=\"ButtomBackToMenuModificarProducto\" was not injected: check your FXML file 'modificarProducto-view.fxml'.";
        assert ButtomModificarBebida != null : "fx:id=\"ButtomModificarBebida\" was not injected: check your FXML file 'modificarProducto-view.fxml'.";
        assert ButtomModificarTaco != null : "fx:id=\"ButtomModificarTaco\" was not injected: check your FXML file 'modificarProducto-view.fxml'.";

    }

}

