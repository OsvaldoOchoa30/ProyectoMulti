package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class VerVentasController {

    @FXML
    private Button ButtomBackToMenuVentas;

    @FXML
    private Button ButtomCancelarVenta;

    @FXML
    private Label LabelTotalFinal;

    @FXML
    private TableColumn<?, ?> TableColumnVentasConsumibles;

    @FXML
    private TableColumn<?, ?> TableColumnVentasEstado;

    @FXML
    private TableColumn<?, ?> TableColumnVentasFecha;

    @FXML
    private TableColumn<?, ?> TableColumnVentasID;

    @FXML
    private TableColumn<?, ?> TableColumnVentasTotal;

    @FXML
    private TableView<?> TableViewVentas;

    @FXML
    void OnMouseClickedButtomBackToMenuVentas(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtomCancelarVenta(MouseEvent event) {

    }

}
