package org.marcosbrindis.proyectomultidiciplinario.controllers;

//

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

public class MenuEmpleadoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


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
    void OnMouseClickedCrearPedidoEMP(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearPedido-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            CrearPedidoController crearPedidoController = fxmlLoader.getController();
            crearPedidoController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Crear Pedido.");
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
    void OnMouseClickedVerMenuEMP(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("verMenu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            VerMenuController verMenuController = fxmlLoader.getController();
            verMenuController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Ver Menu.");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void OnMouseClickedVerPedidosEMP(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("verPedidos-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            VerPedidosController verPedidosController = fxmlLoader.getController();
            verPedidosController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Pedidos.");
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
    void OnMouseClickedButtonCerrarSesionEMP(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            LoginController loginController = fxmlLoader.getController();
            loginController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Login.");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    Stage callSu = new Stage();
    @FXML
    void OnMouseClickedButtonCocinaEMP(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("cocina-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            CocinaController cocinaController = fxmlLoader.getController();
            cocinaController.setTaqueria(taqueria);
            cocinaController.initialize();
            callSu.setTitle("Cocina.");
            callSu.setScene(scene);
            callSu.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

}
