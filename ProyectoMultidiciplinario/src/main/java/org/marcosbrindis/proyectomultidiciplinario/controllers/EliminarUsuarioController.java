package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Producto;
import org.marcosbrindis.proyectomultidiciplinario.models.Taco;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class EliminarUsuarioController {

    @FXML
    private Button ButtomBackToMenuEliminarUsuario;

    @FXML
    private Button ButtomEliminarUsuario;

    @FXML
    private Label LabelNombreUsuario;

    @FXML
    private Label LabelRolUsuario;

    @FXML
    private ListView<Usuario> ListViewListaUsuarios;
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuButtomBackToMenuEliminarUsuario(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MenuAdminController menuAdminController = fxmlLoader.getController();
            menuAdminController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Menu!!!.");
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
    void OnMouseClickedButtomEliminarUsuario(MouseEvent event) {
        Usuario usuarioSeleccionado = ListViewListaUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un usuario de la lista.");
            alert.showAndWait();
            return;
        }

        if (usuarioSeleccionado.getRolUser().equals("Administrador") && contarAdministradores() == 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se puede eliminar al último administrador.");
            alert.showAndWait();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmar Eliminación");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("¿Seguro que quieres eliminar este Usuario?");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            taqueria.removeUser(usuarioSeleccionado);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Usuario Eliminado");
            successAlert.setHeaderText(null);
            successAlert.setContentText("El Usuario ha sido eliminado correctamente.");
            successAlert.showAndWait();
            actualizarListaUsuarios();
        }
    }
    public int contarAdministradores() {
        int count = 0;
        for (Usuario usuario : taqueria.getUserList()) {
            if (usuario.getRolUser().equals("Administrador")) {
                count++;
            }
        }
        return count;
    }

    @FXML
    void initialize() {
        actualizarListaUsuarios();
        ListViewListaUsuarios.setCellFactory(param -> new ListCell<Usuario>() {
            @Override
            protected void updateItem(Usuario usuario, boolean empty) {
                super.updateItem(usuario, empty);
                if (empty || usuario == null) {
                    setText(null);
                } else {
                    setText(usuario.getNameUser());
                }
            }
        });
        ListViewListaUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                LabelNombreUsuario.setText("  "+newValue.getNameUser());
                LabelRolUsuario.setText("  "+newValue.getRolUser());
            } else {
                LabelNombreUsuario.setText("");
                LabelRolUsuario.setText("");
            }
        });
    }

    public void actualizarListaUsuarios() {
        if (taqueria != null) {
            ObservableList<Usuario> usuarios = FXCollections.observableArrayList(taqueria.getUserList());
            ListViewListaUsuarios.setItems(usuarios);
        }
    }

    public void setTaqueria(Taqueria taqueria){
        this.taqueria = taqueria;
        actualizarListaUsuarios();
    }
}