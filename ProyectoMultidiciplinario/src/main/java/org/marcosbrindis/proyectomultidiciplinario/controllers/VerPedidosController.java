package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

import java.io.IOException;

public class VerPedidosController {

    @FXML
    private Button ButtomBackToMenuVerPedidos;

    @FXML
    private Button ButtomCancelarOrden;

    @FXML
    private TableColumn<?, ?> TableColumnEstado;

    @FXML
    private TableColumn<?, ?> TableColumnFecha;

    @FXML
    private TableColumn<?, ?> TableColumnID;

    @FXML
    private TableColumn<?, ?> TableColumnTotal;

    @FXML
    private TableView<?> TableViewVerPedidos;
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuVerPedidos(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MenuAdminController menuAdminController = fxmlLoader.getController();
            menuAdminController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Menu!!!.");
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
    void OnMouseClickedButtomCancelarOrden(MouseEvent event) {

    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

}
