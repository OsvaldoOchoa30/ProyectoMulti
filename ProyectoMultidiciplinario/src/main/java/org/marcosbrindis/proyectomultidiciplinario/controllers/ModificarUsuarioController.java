package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.DatabaseConnection;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Usuario;

public class ModificarUsuarioController {

    @FXML
    private Button ButtomBacktoMenuMU;

    @FXML
    private Button ButtomModificarUsuario;

    @FXML
    private ListView<String> ListViewListaUsuarios;

    @FXML
    private TextField TextFieldConfirmarPasswordModificarUusario;

    @FXML
    private TextField TextFieldNombreModificarUsuario;

    @FXML
    private TextField TextFieldPasswordModificarUsuario;

    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBacktoMenuMU(MouseEvent event) { //Boton para regresar al Menu Principal.
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
    void OnMouseClickedButtomModificarUsuario(MouseEvent event) {
        String nombreUsuarioSeleccionado = ListViewListaUsuarios.getSelectionModel().getSelectedItem();
        if (nombreUsuarioSeleccionado == null) { //Si no esta seleccionado ningun usuario y se da click...
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia.");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione un usuario.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }

        String password1 = TextFieldPasswordModificarUsuario.getText();
        String password2 = TextFieldConfirmarPasswordModificarUusario.getText();

        if (!password1.equals(password2)) { //Si las passwords no coinciden...
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText(null);
            alert.setContentText("Las contraseñas no coinciden.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }

        /*if (!verificarPassword(password1)) { //Si la password no cumple con los requisitos...
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText(null);
            alert.setContentText("La contraseña debe tener al menos 6 caracteres y al menos un número.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        } */

        try {
            DatabaseConnection.updateUserPassword(nombreUsuarioSeleccionado, password1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Contraseña modificada.");
            alert.setHeaderText(null);
            alert.setContentText("La contraseña ha sido modificada correctamente.");
            agregarCssAlerta(alert);
            alert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText(null);
            alert.setContentText("Ocurrió un error al modificar la contraseña.");
            agregarCssAlerta(alert);
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {
        // Cargar usuarios desde la base de datos
        try {
            ObservableList<String> nombresUsuarios = FXCollections.observableArrayList();
            for (Usuario usuario : DatabaseConnection.getAllUsers()) {
                nombresUsuarios.add(usuario.getNameUser());
            }

            ListViewListaUsuarios.setItems(nombresUsuarios);

            ListViewListaUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                TextFieldNombreModificarUsuario.setText(newValue);
            });

            TextFieldNombreModificarUsuario.setOnKeyReleased(event -> {
                String nuevoNombre = TextFieldNombreModificarUsuario.getText();
                if (nombresUsuarios.contains(nuevoNombre)) {
                    ListViewListaUsuarios.getSelectionModel().select(nuevoNombre);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al cargar los usuarios desde la base de datos.");
        }
    }

    public void agregarCssAlerta(Alert alert){
        try {
            String cssFile = getClass().getResource("/Style.css").toExternalForm();
            alert.getDialogPane().getStylesheets().add(cssFile);
        } catch (NullPointerException e) {
            System.err.println("No se pudo encontrar el archivo CSS.");
            e.printStackTrace();
        }
    }

    public void setTaqueria(Taqueria taqueria){
        this.taqueria = taqueria;
    }

    public boolean verificarPassword(String contrase) {
        return contrase.matches(".\\d.") && contrase.length() >= 6;
    }
}