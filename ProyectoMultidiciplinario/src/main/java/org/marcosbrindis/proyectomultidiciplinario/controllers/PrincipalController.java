package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;

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
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Usuario;

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

        String name= TextFieldName.getText();
        String password1= TextFieldOficialPassword.getText();
        String password2=TextFieldPassword.getText();
        String rol="Administrador";
        if (!name.isEmpty()&&!password1.isEmpty()) {
            if (password2.equals(password1)) {
                if (!verificarPassword(password1)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("La contraseña debe tener al menos 6 caracteres y al menos un número.");
                    agregarCssAlerta(alert);
                    alert.showAndWait();
                    return;
                }
                Usuario usuario = new Usuario(name, password1, rol);
                taqueria = new Taqueria();
                taqueria.addUser(usuario);
                taqueria.setUsuarioActual(usuario);

                //Comando para "conectar" interfaces:
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    LoginController loginController = fxmlLoader.getController();
                    loginController.setTaqueria(taqueria);
                    callSu.setTitle("Iniciar Sesion.");
                    callSu.setScene(scene);
                    callSu.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Las contraseñas no coinciden, intenta nuevamente.");
                agregarCssAlerta(alert);
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hay campos sin llenar.\n"+"Por favor llenalos correctamente..");
            agregarCssAlerta(alert);
            alert.showAndWait();
        }
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

    public boolean verificarPassword(String contrase) {
        return contrase.matches(".*\\d.*") && contrase.length() >= 6;
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
    @FXML
    void initialize() {
    }

}
