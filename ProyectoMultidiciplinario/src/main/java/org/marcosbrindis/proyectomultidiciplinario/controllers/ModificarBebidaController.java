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
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

public class ModificarBebidaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomBackToModificarProductoModificarBebida;

    @FXML
    private Button ButtomEliminarBebida;

    @FXML
    private Button ButtomModificarBebida;

    @FXML
    private ComboBox<?> ComboBoxModificarTamaño;

    @FXML
    private ComboBox<?> ComboBoxModificarTipoBebida;

    @FXML
    private ListView<?> ListViewListaBebidas;

    @FXML
    private TextField TextFieldBuscarBebida;

    @FXML
    private TextField TextFieldModificarDescripcionBebida;

    @FXML
    private TextField TextFieldModificarPrecioBebida;

    @FXML
    private TextField TextFieldNameModificarBebida;
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToModificarProductoModificarBebida(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("modificarProducto-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ModificarProducto modificarProducto = fxmlLoader.getController();
            modificarProducto.setTaqueria(taqueria);
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
    void OnMouseClickedButtomEliminarBebida(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtomModificarBebida(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxModificarTamaño(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxModificarTipoBebida(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomBackToModificarProductoModificarBebida != null : "fx:id=\"ButtomBackToModificarProductoModificarBebida\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";
        assert ButtomEliminarBebida != null : "fx:id=\"ButtomEliminarBebida\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";
        assert ButtomModificarBebida != null : "fx:id=\"ButtomModificarBebida\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";
        assert ComboBoxModificarTamaño != null : "fx:id=\"ComboBoxModificarTamaño\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";
        assert ComboBoxModificarTipoBebida != null : "fx:id=\"ComboBoxModificarTipoBebida\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";
        assert ListViewListaBebidas != null : "fx:id=\"ListViewListaBebidas\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";
        assert TextFieldBuscarBebida != null : "fx:id=\"TextFieldBuscarBebida\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";
        assert TextFieldModificarDescripcionBebida != null : "fx:id=\"TextFieldModificarDescripcionBebida\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";
        assert TextFieldModificarPrecioBebida != null : "fx:id=\"TextFieldModificarPrecioBebida\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";
        assert TextFieldNameModificarBebida != null : "fx:id=\"TextFieldNameModificarBebida\" was not injected: check your FXML file 'modificarBebida-view.fxml'.";

    }

    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
        
    }

}
