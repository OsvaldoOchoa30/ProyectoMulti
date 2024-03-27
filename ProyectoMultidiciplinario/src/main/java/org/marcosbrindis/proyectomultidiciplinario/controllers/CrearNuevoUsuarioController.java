package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;

public class CrearNuevoUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomBackToMenuNU;

    @FXML
    private Button ButtomCrearNU;

    @FXML
    private ComboBox<?> ComboBoxRolNU;

    @FXML
    private TextField TextFieldNombreNU;

    @FXML
    private TextField TextFieldPasswordCorrectaNU;

    @FXML
    private TextField TextFieldPasswordNU;

    //CallSu
    Stage callSu = new Stage();

    @FXML
    void OnMouseClickedButtomBackToMenuNU(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            callSu.setTitle("Crear Nuevo Usuario");
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

    }

    @FXML
    void OnMouseClickedComboBoxRolNU(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomBackToMenuNU != null : "fx:id=\"ButtomBackToMenuNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert ButtomCrearNU != null : "fx:id=\"ButtomCrearNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert ComboBoxRolNU != null : "fx:id=\"ComboBoxRolNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert TextFieldNombreNU != null : "fx:id=\"TextFieldNombreNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert TextFieldPasswordCorrectaNU != null : "fx:id=\"TextFieldPasswordCorrectaNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";
        assert TextFieldPasswordNU != null : "fx:id=\"TextFieldPasswordNU\" was not injected: check your FXML file 'crearNuevoUsuario-view.fxml'.";

    }

}
