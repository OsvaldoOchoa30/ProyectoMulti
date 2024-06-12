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
import org.marcosbrindis.proyectomultidiciplinario.models.DatabaseConnection;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
            stage.setTitle("Menu.");
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
        if (usuarioSeleccionado == null) { // Si no se selecciona un usuario y se da click al boton...
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error.");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un usuario de la lista.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }

        if (usuarioSeleccionado.getRolUser().equals("Administrador") && contarAdministradores() == 1) {
            // No se puede eliminar al último Admin.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText(null);
            alert.setContentText("No se puede eliminar al último administrador.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }

        // Alerta de Confirmación.
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        agregarCssAlerta(confirmAlert);
        confirmAlert.setTitle("Confirmar Eliminación.");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("¿Seguro que desea eliminar este Usuario?");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) { // Si se confirma presionando el botón...
            try {
                DatabaseConnection.deleteUser(usuarioSeleccionado.getNameUser()); // Eliminar usuario de la base de datos.
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Usuario Eliminado.");
                successAlert.setHeaderText(null);
                successAlert.setContentText("El Usuario ha sido eliminado correctamente.");
                agregarCssAlerta(successAlert);
                successAlert.showAndWait();
                actualizarListaUsuarios();
            } catch (SQLException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Ocurrió un error al eliminar el usuario.");
                agregarCssAlerta(alert);
                alert.showAndWait();
            }
        }
    }

    public int contarAdministradores() {
        int count = 0;
        for (Usuario usuario : ListViewListaUsuarios.getItems()) {
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
                LabelNombreUsuario.setText("  " + newValue.getNameUser());
                LabelRolUsuario.setText("  " + newValue.getRolUser());
            } else {
                LabelNombreUsuario.setText("");
                LabelRolUsuario.setText("");
            }
        });
    }

    public void actualizarListaUsuarios() {
        try {
            List<Usuario> usuarios = DatabaseConnection.getAllUsers(); // Cargar usuarios desde la base de datos.
            ObservableList<Usuario> observableUsuarios = FXCollections.observableArrayList(usuarios);
            ListViewListaUsuarios.setItems(observableUsuarios);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al cargar los usuarios desde la base de datos.");
        }
    }

    public void agregarCssAlerta(Alert alert) {
        try {
            String cssFile = getClass().getResource("/Style.css").toExternalForm();
            alert.getDialogPane().getStylesheets().add(cssFile);
        } catch (NullPointerException e) {
            System.err.println("No se pudo encontrar el archivo CSS.");
            e.printStackTrace();
        }
    }

    public void setTaqueria(Taqueria taqueria) {
        this.taqueria = taqueria;
        actualizarListaUsuarios();
    }
}