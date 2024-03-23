package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;

public class PrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomCrear;

    @FXML
    private TextField TextFieldName;

    @FXML
    private TextField TextFieldOficialPassword;

    @FXML
    private TextField TextFieldPassword;

    Stage callSu = new Stage();
    Stage callAd = new Stage();
    @FXML
    void OnMouseClickedButtomCrear(MouseEvent event) {
        //Comando para "conectar" interfaces:
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            callSu.setTitle("Hello!");
            callSu.setScene(scene);
            callSu.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void initialize() {
        assert ButtomCrear != null : "fx:id=\"ButtomCrear\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert TextFieldName != null : "fx:id=\"TextFieldName\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert TextFieldOficialPassword != null : "fx:id=\"TextFieldOficialPassword\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert TextFieldPassword != null : "fx:id=\"TextFieldPassword\" was not injected: check your FXML file 'principal-view.fxml'.";

    }

}
