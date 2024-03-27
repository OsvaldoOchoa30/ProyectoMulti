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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;

public class ModificarTacoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomBackToModificarProductoModificarTaco;

    @FXML
    private Button ButtomModificarTaco;

    @FXML
    private ComboBox<?> ComboBoxModificarTipoCarne;

    @FXML
    private ListView<?> ListViewListaTacos;

    @FXML
    private TextField TextFieldModificarPrecioTaco;

    @FXML
    private TextField TextFieldNombreModificarTaco;

    @FXML
    private TextField TextFieldPasswordModificarDescripcionTaco;

    @FXML
    private TextField TextFieldPasswordModificarTaco;

    @FXML
    void OnMouseClickedButtomBackToModificarProductoModificarTaco(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("modificarProducto-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Modificar Producto.");
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
    void OnMouseClickedButtomModificarTaco(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxTipoCarne(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomBackToModificarProductoModificarTaco != null : "fx:id=\"ButtomBackToModificarProductoModificarTaco\" was not injected: check your FXML file 'modificarTaco-view.fxml'.";
        assert ButtomModificarTaco != null : "fx:id=\"ButtomModificarTaco\" was not injected: check your FXML file 'modificarTaco-view.fxml'.";
        assert ComboBoxModificarTipoCarne != null : "fx:id=\"ComboBoxModificarTipoCarne\" was not injected: check your FXML file 'modificarTaco-view.fxml'.";
        assert ListViewListaTacos != null : "fx:id=\"ListViewListaTacos\" was not injected: check your FXML file 'modificarTaco-view.fxml'.";
        assert TextFieldModificarPrecioTaco != null : "fx:id=\"TextFieldModificarPrecioTaco\" was not injected: check your FXML file 'modificarTaco-view.fxml'.";
        assert TextFieldNombreModificarTaco != null : "fx:id=\"TextFieldNombreModificarTaco\" was not injected: check your FXML file 'modificarTaco-view.fxml'.";
        assert TextFieldPasswordModificarDescripcionTaco != null : "fx:id=\"TextFieldPasswordModificarDescripcionTaco\" was not injected: check your FXML file 'modificarTaco-view.fxml'.";
        assert TextFieldPasswordModificarTaco != null : "fx:id=\"TextFieldPasswordModificarTaco\" was not injected: check your FXML file 'modificarTaco-view.fxml'.";

    }

}
