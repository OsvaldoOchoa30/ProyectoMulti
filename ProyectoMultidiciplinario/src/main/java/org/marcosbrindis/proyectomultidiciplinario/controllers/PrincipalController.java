package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.DatabaseConnection; //Se agrego esto
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Usuario;

import java.io.IOException;
import java.sql.SQLException;

public class PrincipalController {

    @FXML
    private Button ButtomCrear;

    @FXML
    private TextField TextFieldName;

    @FXML
    private TextField TextFieldOficialPassword;

    @FXML
    private TextField TextFieldPassword;

    Taqueria taqueria;

    Stage callSu = new Stage();

    @FXML
    void OnMouseClickedButtomCrear(MouseEvent event) {
        String name = TextFieldName.getText();
        String password1 = TextFieldOficialPassword.getText();
        String password2 = TextFieldPassword.getText();
        String rol = "Administrador";

        if (!name.isEmpty() && !password1.isEmpty()) {
            if (password2.equals(password1)) {
               /* if (!verificarPassword(password1)) {
                    showAlert(Alert.AlertType.ERROR, "Error", "La contraseña debe tener al menos 6 caracteres y al menos un número.");
                    return;
                } */

                try {
                    DatabaseConnection.createUser(name, password1, rol);
                    Usuario usuario = new Usuario(name, password1, rol);
                    taqueria = new Taqueria();
                    taqueria.addUser(usuario);
                    taqueria.setUsuarioActual(usuario);

                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    LoginController loginController = fxmlLoader.getController();
                    loginController.setTaqueria(taqueria);
                    callSu.setTitle("Iniciar Sesion.");
                    callSu.setScene(scene);
                    callSu.show();
                    closeCurrentStage(event);
                } catch (SQLException | IOException e) {
                    showAlert(Alert.AlertType.ERROR, "Error", "Ocurrió un error al crear el usuario: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Las contraseñas no coinciden, intenta nuevamente.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Hay campos sin llenar.\nPor favor llénalos correctamente.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        agregarCssAlerta(alert);
        alert.showAndWait();
    }

    private void closeCurrentStage(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void setTaqueria(Taqueria taqueria) {
        this.taqueria = taqueria;
    }

    public boolean verificarPassword(String contrase) {
        return contrase.matches(".\\d.") && contrase.length() >= 6;
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

    @FXML
    void initialize() {
    }
}