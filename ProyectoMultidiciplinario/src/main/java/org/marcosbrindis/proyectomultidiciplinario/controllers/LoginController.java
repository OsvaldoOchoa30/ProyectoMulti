package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.util.HashMap;
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


public class LoginController {

    @FXML
    private Button ButtomLogin;

    @FXML
    private TextField TextFieldNameLogin;

    @FXML
    private TextField TextFieldPaswordLogin;

    Stage callSu = new Stage();
    private Taqueria taqueria;
    private HashMap<String,Usuario > clonUsuarios = new HashMap();

    @FXML
    void OnMouseClickedButtomLogin(MouseEvent event) {
        String userName= TextFieldNameLogin.getText();
        String userPassword=TextFieldPaswordLogin.getText();

        if (!clonUsuarios.isEmpty()){
            if (clonUsuarios.containsKey(userName)) {
                Usuario usuario = clonUsuarios.get(userName);
                if (userPassword.equals(usuario.getPassword())) {
                    if (usuario.getRolUser().equals("Administrador")){
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
                            Scene scene = null;
                            scene = new Scene(fxmlLoader.load());
                            MenuAdminController menuAdminController = fxmlLoader.getController();
                            menuAdminController.setTaqueria(taqueria);
                            callSu.setTitle("Login!");
                            callSu.setScene(scene);
                            callSu.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
                    }else{
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuEmpleado-view.fxml"));
                            Scene scene = null;
                            scene = new Scene(fxmlLoader.load());
                            MenuEmpleadoController menuEmpleadoController = fxmlLoader.getController();
                            menuEmpleadoController.setTaqueria(taqueria);
                            callSu.setTitle("Login!");
                            callSu.setScene(scene);
                            callSu.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
                    }
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Contraseñas Incorrecta!!!.");
                    alert.showAndWait();
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Nombre de usuario no encontrado!!!.");
                alert.showAndWait();
            }
        }
    }

    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
        for (Usuario actual:taqueria.getUserList()){
            clonUsuarios.put(actual.getNameUser(),actual);
        }
    }

    @FXML
    void initialize() {
    }

}
