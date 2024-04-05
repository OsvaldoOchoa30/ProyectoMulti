package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class VerPedidosController {

    @FXML
    private Button ButtomBackToMenuVerPedidos;

    @FXML
    private Button ButtomCancelarOrden;

    @FXML
    private TableColumn<Pedido,Boolean> tableColumnEstado;

    @FXML
    private TableColumn<Pedido, LocalDate> tableColumnFecha;

    @FXML
    private TableColumn<Pedido, String> tableColumnID;

    @FXML
    private TableColumn<Pedido, Double> tableColumnTotal;

    @FXML
    private TableView<Pedido> tableViewVerPedidos;
    @FXML
    private TextField TextFieldBuscarPedidos;
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuVerPedidos(MouseEvent event) {
        if(taqueria.getUsuarioActual().getRolUser().equals("Administrador")) {
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
        }else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuEmpleado-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                MenuEmpleadoController menuEmpleadoController = fxmlLoader.getController();
                menuEmpleadoController.setTaqueria(taqueria);
                Stage stage = new Stage();
                stage.setTitle("Menu!!!");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }

    }
    @FXML
    void OnMouseClickedTextFieldBuscarPedidos(MouseEvent event){

    }
    @FXML
    void OnMouseClickedButtomCancelarOrden(MouseEvent event) {
        Pedido pedidoSeleccionado = tableViewVerPedidos.getSelectionModel().getSelectedItem();
        if (pedidoSeleccionado != null) {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Confirmar Cancelacion");
            confirmAlert.setHeaderText(null);
            confirmAlert.setContentText("¿Seguro que quieres Cancelar este Pedido?");

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                boolean actualizacionExitosa = taqueria.actualizarEstadoPedido(pedidoSeleccionado, false);
                if (actualizacionExitosa) {
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Pedido Cancelado");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("El Pedido ha sido Cancelado correctamente.");
                    successAlert.showAndWait();
                    tableViewVerPedidos.refresh();
                } else {
                    Alert warningAlert = new Alert(Alert.AlertType.WARNING);
                    warningAlert.setTitle("Advertencia");
                    warningAlert.setHeaderText(null);
                    warningAlert.setContentText("No se puede cancelar este pedido, ya que ya está en proceso.");
                    warningAlert.showAndWait();
                }
            }
        }
    }
    @FXML
    void initialize() {
        configureVerPedidosTable();
        TextFieldBuscarPedidos.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrarPedidos(newValue.trim().toLowerCase());
        });

    }
    public void filtrarPedidos(String textoBusqueda) {
        if (!textoBusqueda.isEmpty()) {
            ObservableList<Pedido> pedidosFiltrados = FXCollections.observableArrayList();
            for (Pedido pedido : tableViewVerPedidos.getItems()) {
                if (pedido.getIdPedido().toLowerCase().contains(textoBusqueda.toLowerCase())) {
                    pedidosFiltrados.add(pedido);
                }
            }
            tableViewVerPedidos.setItems(pedidosFiltrados);
        } else {
            tableViewVerPedidos.setItems(FXCollections.observableArrayList(taqueria.getOrderList()));
        }
    }
    public void configureVerPedidosTable() {
        if (tableColumnID != null && tableColumnEstado != null &&tableColumnFecha != null&&
                tableColumnTotal != null) {
            tableColumnID.setCellValueFactory(new PropertyValueFactory<>("idPedido"));
            tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            tableColumnEstado.setCellValueFactory(new PropertyValueFactory<>("status"));
            tableColumnTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        }
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria = taqueria;
        if (tableViewVerPedidos != null && taqueria != null) {
            ObservableList<Pedido> pedidoData = FXCollections.observableArrayList(taqueria.getOrderList());
            tableViewVerPedidos.setItems(pedidoData);
        }
    }
}
