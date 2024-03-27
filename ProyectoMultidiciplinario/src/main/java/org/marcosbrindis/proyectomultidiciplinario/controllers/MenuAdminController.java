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

public class MenuAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private Button ButtomCrearNuevoUsuario;

    @FXML
    private Button ButtomModificarUsuarios;

    @FXML
    private Button ButtomAgregarProducto;

    @FXML
    private Button ButtomModificarProducto;

    @FXML
    private Button ButtomVerMenu;

    @FXML
    private Button ButtomCrearPedido;

    @FXML
    private Button ButtomCancelarPedido;

    @FXML
    private Button ButtomVerPedidos;

    @FXML
    private Button ButtomVentas;

    @FXML
    private Button ButtomCerrarSesion;

    Stage callSu = new Stage();
    Stage callAd = new Stage();




    @FXML
    void OnMouseClickedCrearNuevoUsuario(MouseEvent event) { //Moverme a la interfaz Crear Usuario
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearNuevoUsuario-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            callSu.setTitle("Crear Nuevo Usuario");
            callSu.setScene(scene);
            callSu.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void OnMouseClickedModificarUsuario(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("modificarUsuario-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            callSu.setTitle("Crear Nuevo Usuario");
            callSu.setScene(scene);
            callSu.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }


    @FXML
    void OnMouseClickedAgregarProducto(MouseEvent event) { //Moverme a la interfaz elegir Producto.
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("elegirProducto-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Agregar Producto.");
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
    void OnMouseClickedModificarProducto(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedVerMenu(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedCrearPedido(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedCancelarPedido(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedVerPedidos(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedVentas(MouseEvent event) {

    }


    @FXML
    void OnMouseClickedButtomCerrarSesion(MouseEvent event) { //Al dar click, me regresa al login, pero apesar que se le agreguen datos no activa el boton.
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            callSu.setTitle("Crear Nuevo Usuario");
            callSu.setScene(scene);
            callSu.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize() {
        assert ButtomAgregarProducto != null : "fx:id=\"ButtomAgregarProducto\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";
        assert ButtomCancelarPedido != null : "fx:id=\"ButtomCancelarPedido\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";
        assert ButtomCerrarSesion != null : "fx:id=\"ButtomCerrarSesion\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";
        assert ButtomCrearNuevoUsuario != null : "fx:id=\"ButtomCrearNuevoUsuario\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";
        assert ButtomCrearPedido != null : "fx:id=\"ButtomCrearPedido\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";
        assert ButtomModificarProducto != null : "fx:id=\"ButtomModificarProducto\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";
        assert ButtomModificarUsuarios != null : "fx:id=\"ButtomModificarUsuarios\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";
        assert ButtomVentas != null : "fx:id=\"ButtomVentas\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";
        assert ButtomVerMenu != null : "fx:id=\"ButtomVerMenu\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";
        assert ButtomVerPedidos != null : "fx:id=\"ButtomVerPedidos\" was not injected: check your FXML file 'menuAdmin-view.fxml'.";

    }

}

