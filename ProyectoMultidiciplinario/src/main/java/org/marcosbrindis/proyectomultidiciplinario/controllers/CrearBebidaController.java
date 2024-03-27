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

public class CrearBebidaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomBackToElegirProductoBebida;

    @FXML
    private Button ButtomCrearBebida;

    @FXML
    private ComboBox<?> ComboBoxSizeBebida;

    @FXML
    private ComboBox<?> ComboBoxTipoBebida;

    @FXML
    private TextField TextFieldDescripcionBebida;

    @FXML
    private TextField TextFieldNombreBebida;

    @FXML
    private TextField TextFieldPrecioBebida;

    Stage callSu = new Stage();


    @FXML
    void ButtomBackToElegirProductoBebida(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("elegirProducto-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Agregar Producto.");
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
    void OnMouseClickedButtomCrear(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxSizeBebida(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxTipoBebida(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomBackToElegirProductoBebida != null : "fx:id=\"ButtomBackToElegirProductoBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert ButtomCrearBebida != null : "fx:id=\"ButtomCrearBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert ComboBoxSizeBebida != null : "fx:id=\"ComboBoxSizeBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert ComboBoxTipoBebida != null : "fx:id=\"ComboBoxTipoBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert TextFieldDescripcionBebida != null : "fx:id=\"TextFieldDescripcionBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert TextFieldNombreBebida != null : "fx:id=\"TextFieldNombreBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";
        assert TextFieldPrecioBebida != null : "fx:id=\"TextFieldPrecioBebida\" was not injected: check your FXML file 'crearBebida-view.fxml'.";

    }

}
