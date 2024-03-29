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
                Usuario usuario = new Usuario(name, password1, rol);
                taqueria = new Taqueria();
                taqueria.addUser(usuario);

                //Comando para "conectar" interfaces:
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    LoginController loginController = fxmlLoader.getController();
                    loginController.setTaqueria(taqueria);
                    callSu.setTitle("Iniciar Sesion!");
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
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Contraseñas NO COINCIDEN!!!.");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hay campos sin llenar!!!.\n"+"Favor de llenarlos.");
            alert.showAndWait();
        }
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

    @FXML
    void initialize() {
    }

}
