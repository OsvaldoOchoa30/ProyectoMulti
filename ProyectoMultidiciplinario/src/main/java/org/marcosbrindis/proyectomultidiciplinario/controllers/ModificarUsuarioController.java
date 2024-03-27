package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;

public class ModificarUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtomBacktoMenuMU;

    @FXML
    private Button ButtomModificarUsuario;

    @FXML
    private ListView<?> ListViewListaUsuarios;

    @FXML
    private TextField TextFieldConfirmarPasswordModificarUusario;

    @FXML
    private TextField TextFieldNombreModificarUsuario;

    @FXML
    private TextField TextFieldPasswordModificarUsuario;

    @FXML
    void OnMouseClickedButtomBacktoMenuMU(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
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
    void OnMouseClickedButtomModificarUsuario(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtomBacktoMenuMU != null : "fx:id=\"ButtomBacktoMenuMU\" was not injected: check your FXML file 'modificarUsuario-view.fxml'.";
        assert ButtomModificarUsuario != null : "fx:id=\"ButtomModificarUsuario\" was not injected: check your FXML file 'modificarUsuario-view.fxml'.";
        assert ListViewListaUsuarios != null : "fx:id=\"ListViewListaUsuarios\" was not injected: check your FXML file 'modificarUsuario-view.fxml'.";
        assert TextFieldConfirmarPasswordModificarUusario != null : "fx:id=\"TextFieldConfirmarPasswordModificarUusario\" was not injected: check your FXML file 'modificarUsuario-view.fxml'.";
        assert TextFieldNombreModificarUsuario != null : "fx:id=\"TextFieldNombreModificarUsuario\" was not injected: check your FXML file 'modificarUsuario-view.fxml'.";
        assert TextFieldPasswordModificarUsuario != null : "fx:id=\"TextFieldPasswordModificarUsuario\" was not injected: check your FXML file 'modificarUsuario-view.fxml'.";

    }

}
