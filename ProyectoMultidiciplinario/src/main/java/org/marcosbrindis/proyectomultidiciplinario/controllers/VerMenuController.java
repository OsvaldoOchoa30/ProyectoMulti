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

public class VerMenuController {

    @FXML
    private Button ButtomBackToMenuAdmMenu;

    @FXML
    private TableColumn<?, ?> TableColumnBebidasDescripcion;

    @FXML
    private TableColumn<?, ?> TableColumnBebidasNombre;

    @FXML
    private TableColumn<?, ?> TableColumnBebidasPrecio;

    @FXML
    private TableColumn<?, ?> TableColumnBebidasSize;

    @FXML
    private TableColumn<?, ?> TableColumnBebidasTipo;

    @FXML
    private TableColumn<?, ?> TableColumnTacosCarne;

    @FXML
    private TableColumn<?, ?> TableColumnTacosDescripcion;

    @FXML
    private TableColumn<?, ?> TableColumnTacosNombre;

    @FXML
    private TableColumn<?, ?> TableColumnTacosPrecio;

    @FXML
    private TableView<?> TableViewTacos; //Tabla General: Tacos

    @FXML
    private TableView<?> TableViewbebidas; //Tabla General: Bebidas
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuAdmMenu(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

}
