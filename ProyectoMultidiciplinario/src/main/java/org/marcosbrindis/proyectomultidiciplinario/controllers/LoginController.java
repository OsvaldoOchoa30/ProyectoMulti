package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.sql.SQLException;
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
import org.marcosbrindis.proyectomultidiciplinario.models.DatabaseConnection;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Usuario;

public class LoginController {

    @FXML
    private Button ButtomLogin;

    @FXML
    private TextField TextFieldNameLogin;

    @FXML
    private TextField TextFieldPaswordLogin;

    Stage callSu = new Stage();
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomLogin(MouseEvent event) { // Botón para iniciar sesión.
        String userName = TextFieldNameLogin.getText(); // TextField de nombre.
        String userPassword = TextFieldPaswordLogin.getText(); // TextField de password.

        try {
            Usuario usuario = DatabaseConnection.getUser(userName); // Obtener usuario de la base de datos.
            if (usuario != null) {
                System.out.println("Usuario encontrado: " + usuario.getNameUser() + ", Rol: " + usuario.getRolUser());
                if (userPassword.equals(usuario.getPassword())) { // Si la contraseña es correcta...
                    taqueria.setUsuarioActual(usuario); // Taqueria define al usuario.
                    System.out.println("Usuario actual: " + usuario.getNameUser() + ", Rol: " + usuario.getRolUser());
                    if (usuario.getRolUser().equals("Administrador")) { // Si el rol es Administrador, nos permite entrar a su interfaz.
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            MenuAdminController menuAdminController = fxmlLoader.getController();
                            menuAdminController.setTaqueria(taqueria);
                            callSu.setTitle("Menu.");
                            callSu.setScene(scene);
                            callSu.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else { // Si el rol es Empleado, nos manda a otra interfaz.
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuEmpleado-view.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            MenuEmpleadoController menuEmpleadoController = fxmlLoader.getController();
                            menuEmpleadoController.setTaqueria(taqueria);
                            callSu.setTitle("Menu.");
                            callSu.setScene(scene);
                            callSu.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                } else { // Si la contraseña es incorrecta...
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error.");
                    alert.setHeaderText(null);
                    alert.setContentText("Contraseña Incorrecta.");
                    agregarCssAlerta(alert);
                    alert.showAndWait();
                }
            } else { // Si no se encuentra el nombre de usuario...
                System.out.println("Nombre de usuario no encontrado: " + userName);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Nombre de usuario no encontrado.");
                agregarCssAlerta(alert);
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText(null);
            alert.setContentText("Ocurrió un error al intentar iniciar sesión.");
            agregarCssAlerta(alert);
            alert.showAndWait();
        }
    }

    public void setTaqueria(Taqueria taqueria) {
        this.taqueria = taqueria;
    }

    @FXML
    void initialize() {
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
}