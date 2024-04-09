package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Usuario;

public class CrearNuevoUsuarioController {


    @FXML
    private Button ButtomBackToMenuNU;

    @FXML
    private Button ButtomCrearNU;

    @FXML
    private ComboBox<String> ComboBoxRolNU;

    @FXML
    private TextField TextFieldNombreNU;

    @FXML
    private TextField TextFieldPasswordCorrectaNU;

    @FXML
    private TextField TextFieldPasswordNU;

    //CallSu
    Stage callSu = new Stage();
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuNU(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            MenuAdminController menuAdminController = fxmlLoader.getController();
            menuAdminController.setTaqueria(taqueria);
            callSu.setTitle("Menu!!!");
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
    void OnMouseClickedButtomCrearNU(MouseEvent event) {
        String name = TextFieldNombreNU.getText();
        String password1 = TextFieldPasswordNU.getText();
        String password2 = TextFieldPasswordCorrectaNU.getText();
        String rolUser = ComboBoxRolNU.getValue();

        if (name.isEmpty() || password1.isEmpty() || password2.isEmpty() || rolUser == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }

        if (!password1.equals(password2)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Las contraseñas no coinciden.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }

        if (!verificarPassword(password1)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("La contraseña debe tener al menos 6 caracteres y al menos un número.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }


        for (Usuario existingUser : taqueria.getUserList()) {
            if (existingUser.getNameUser().equals(name)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("El usuario ya existe.!!!");
                agregarCssAlerta(alert);
                alert.showAndWait();
                return;
            }
        }


        Usuario usuario = new Usuario(name, password1, rolUser);
        taqueria.addUser(usuario);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("USUARIO CREADO");
        alert.setHeaderText(null);
        alert.setContentText("usuario creado correctamente!!!.");
        agregarCssAlerta(alert);
        alert.showAndWait();
        limpiarCampos();
    }

    @FXML
    void OnMouseClickedComboBoxRolNU(MouseEvent event) {
    }

    @FXML
    void initialize() {
        ArrayList<String> rolUsuarioCombobox = new ArrayList<>();
        rolUsuarioCombobox.add("Administrador");
        rolUsuarioCombobox.add("Empleado");
        ComboBoxRolNU.getItems().addAll(rolUsuarioCombobox);
    }
    public void limpiarCampos(){
        TextFieldNombreNU.clear();
        TextFieldPasswordNU.clear();
        TextFieldPasswordCorrectaNU.clear();
        ComboBoxRolNU.getSelectionModel().clearSelection();
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
        this.taqueria=taqueria;
    }
    public boolean verificarPassword(String contrase) {
        return contrase.matches(".*\\d.*") && contrase.length() >= 6;
    }

}
