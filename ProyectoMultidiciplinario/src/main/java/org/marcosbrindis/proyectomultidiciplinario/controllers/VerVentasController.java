package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Pedido;
import org.marcosbrindis.proyectomultidiciplinario.models.Producto;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Venta;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

public class VerVentasController {

    @FXML
    private Button ButtomBackToMenuVentas;

    @FXML
    private Button ButtomCancelarVenta;

    @FXML
    private Label LabelTotalFinal;

    @FXML
    private TableColumn<Pedido, LinkedList<Producto>> tableColumnVentasConsumibles;

    @FXML
    private TableColumn<Pedido,Boolean> tableColumnVentasEstado;

    @FXML
    private TableColumn<Pedido, LocalDate> tableColumnVentasFecha;

    @FXML
    private TableColumn<Pedido,String> tableColumnVentasID;

    @FXML
    private TableColumn<Pedido, Double> tableColumnVentasTotal;

    @FXML
    private TableView<Pedido> tableViewVentas;
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuVentas(MouseEvent event) {
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
    void OnMouseClickedButtomCancelarVenta(MouseEvent event) {
        Pedido ventaSeleccionada = tableViewVentas.getSelectionModel().getSelectedItem();
        if (ventaSeleccionada != null) {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            agregarCssAlerta(confirmAlert);
            confirmAlert.setTitle("Confirmar Cancelacion");
            confirmAlert.setHeaderText(null);
            confirmAlert.setContentText("¿Seguro que quieres Cancelar este Pedido?");

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                ventaSeleccionada.setStatus(false);

                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Pedido Cancelado");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("El Pedido ha sido Cancelado correctamente.");
                    agregarCssAlerta(successAlert);
                    successAlert.showAndWait();
                    tableViewVentas.refresh();
                double totalVentas = calcularTotalVentas();
                LabelTotalFinal.setText(String.format("%.2f", totalVentas));
            }
        }
    }

    @FXML
    void initialize() {
        configureVerVentasTable();
        double totalVentas = calcularTotalVentas();
        LabelTotalFinal.setText(String.format("%.2f", totalVentas));

    }
    public double calcularTotalVentas() {
        double total = 0.0;
        if (taqueria != null) {
            for (Pedido venta : taqueria.getVenta().getSalesList()) {
                if (venta.getStatus()) {
                    total += venta.getTotal();
                }
            }
        }
        return total;
    }
    public void configureVerVentasTable() {
        if (tableColumnVentasConsumibles != null && tableColumnVentasEstado != null &&tableColumnVentasID != null&&
                tableColumnVentasFecha != null && tableColumnVentasTotal != null) {
            tableColumnVentasID.setCellValueFactory(new PropertyValueFactory<>("idPedido"));
            tableColumnVentasFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            tableColumnVentasConsumibles.setCellValueFactory(new PropertyValueFactory<>("orden"));
            tableColumnVentasTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
            tableColumnVentasEstado.setCellValueFactory(new PropertyValueFactory<>("status"));
        }
    }
    public void agregarCssAlerta(Alert alert){
        try {
            String cssFile = getClass().getResource("/Style.css").toExternalForm();
            alert.getDialogPane().getStylesheets().add(cssFile);
        } catch (NullPointerException e) {
            System.err.println("No se pudo encontrar el archivo CSS.");
            e.printStackTrace();
        }
    }

    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
        if (tableViewVentas != null && taqueria != null) {
            ArrayList<Pedido> listaVentas = taqueria.getVenta().getSalesList();
            tableViewVentas.setItems(FXCollections.observableArrayList(listaVentas));
        }
    }

}
