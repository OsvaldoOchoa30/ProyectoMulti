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

public class CrearTacoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomBackToElegirProductoTaco;

    @FXML
    private Button ButtomCrearTaco;

    @FXML
    private ComboBox<?> ComboBoxTipoCarne;

    @FXML
    private TextField TextFieldDescripcionTaco;

    @FXML
    private TextField TextFieldNombreTaco;

    @FXML
    private TextField TextFieldPrecioTaco;

    //CallSu
    Stage callSu = new Stage();

    @FXML
    void OnMouseClickedButtomBackToElegirProductoTaco(MouseEvent event) {


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
    void OnMouseClickedButtomCrearTaco(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxTipoCarne(MouseEvent event) {

    }

    @FXML
    void initialize() {

            assert ButtomBackToElegirProductoTaco != null : "fx:id=\"ButtomBackToElegirProductoTaco\" was not injected: check your FXML file 'crearTaco-view.fxml'.";
            assert ButtomCrearTaco != null : "fx:id=\"ButtomCrearTaco\" was not injected: check your FXML file 'crearTaco-view.fxml'.";
            assert ComboBoxTipoCarne != null : "fx:id=\"ComboBoxTipoCarne\" was not injected: check your FXML file 'crearTaco-view.fxml'.";
            assert TextFieldDescripcionTaco != null : "fx:id=\"TextFieldDescripcionTaco\" was not injected: check your FXML file 'crearTaco-view.fxml'.";
            assert TextFieldNombreTaco != null : "fx:id=\"TextFieldNombreTaco\" was not injected: check your FXML file 'crearTaco-view.fxml'.";
            assert TextFieldPrecioTaco != null : "fx:id=\"TextFieldPrecioTaco\" was not injected: check your FXML file 'crearTaco-view.fxml'.";


    }

}
