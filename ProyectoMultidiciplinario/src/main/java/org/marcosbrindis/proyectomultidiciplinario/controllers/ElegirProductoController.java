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
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

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
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuElegirProducto(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MenuAdminController menuAdminController = fxmlLoader.getController();
            menuAdminController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Menu!!!");
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
    void OnMouseClickedButtomBebida(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearBebida-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            CrearBebidaController crearBebidaController = fxmlLoader.getController();
            crearBebidaController.setTaqueria(taqueria);
            crearBebidaController.initialize();
            callSu.setTitle("Bebidas");
            callSu.setScene(scene);
            callSu.show();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void OnMouseClickedButtomTaco(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearTaco-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            CrearTacoController crearTacoController = fxmlLoader.getController();
            crearTacoController.setTaqueria(taqueria);
            crearTacoController.initialize();
            callSu.setTitle("Tacos");
            callSu.setScene(scene);
            callSu.show();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

}

