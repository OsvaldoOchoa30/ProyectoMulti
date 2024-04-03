package org.marcosbrindis.proyectomultidiciplinario.controllers;

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

public class MenuAdminController {

    @FXML
    private Button ButtomCocina;

    @FXML
    private Button ButtomCrearNuevoUsuario;

    @FXML
    private Button ButtomModificarUsuarios;

    @FXML
    private Button ButtomEliminarUsuario;

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

    private Taqueria taqueria;


    @FXML
    void OnMouseClickedButtomCocina(MouseEvent event) { //Boton para la interfaz: Cocina
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("cocina-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            CocinaController cocinaController = fxmlLoader.getController();
            cocinaController.setTaqueria(taqueria);
            callSu.setTitle("Cocina!");
            callSu.setScene(scene);
            callSu.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void OnMouseClickedCrearNuevoUsuario(MouseEvent event) { //Moverme a la interfaz Crear Usuario
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearNuevoUsuario-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            CrearNuevoUsuarioController crearNuevoUsuarioController = fxmlLoader.getController();
            crearNuevoUsuarioController.setTaqueria(taqueria);
            callSu.setTitle("Crear Usuario!");
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
            Scene scene = new Scene(fxmlLoader.load());
            ModificarUsuarioController modificarUsuarioController = fxmlLoader.getController();
            modificarUsuarioController.setTaqueria(taqueria);
            modificarUsuarioController.initialize();
            callSu.setTitle("Modificar Usuario!");
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
    void OnMouseClickedButtomEliminarUsuario(MouseEvent event) { //Boton para eliminar Usuario(s).
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("eliminarUsuario-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            EliminarUsuarioController eliminarUsuarioController = fxmlLoader.getController();
            eliminarUsuarioController.setTaqueria(taqueria);
            eliminarUsuarioController.initialize();
            callSu.setTitle("Eliminar Usuario!");
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
            ElegirProductoController elegirProductoController = fxmlLoader.getController();
            elegirProductoController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Elegir tipo de Producto.");
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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("modificarProducto-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ModificarProducto modificarProducto = fxmlLoader.getController();
            modificarProducto.setTaqueria(taqueria);
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
    void OnMouseClickedVerMenu(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("verMenu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            VerMenuController verMenuController = fxmlLoader.getController();
            verMenuController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Ver Menu!!!.");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void OnMouseClickedCrearPedido(MouseEvent event) {
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
    void OnMouseClickedCancelarPedido(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedVerPedidos(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("verPedidos-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            VerPedidosController verPedidosController = fxmlLoader.getController();
            verPedidosController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("pedidos.");
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
    void OnMouseClickedVentas(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("verVentas-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            VerVentasController verVentasController = fxmlLoader.getController();
            verVentasController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Ventas.");
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
    void OnMouseClickedButtomCerrarSesion(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            LoginController loginController = fxmlLoader.getController();
            loginController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Login!.");
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

    @FXML
    void initialize() {
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }
}

