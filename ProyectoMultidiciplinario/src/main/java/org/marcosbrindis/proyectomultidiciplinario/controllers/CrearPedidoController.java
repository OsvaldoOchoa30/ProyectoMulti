package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
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
import org.marcosbrindis.proyectomultidiciplinario.models.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Optional;

public class CrearPedidoController {

    @FXML
    private Button ButtomAgregarProducto;

    @FXML
    private Button ButtomBackToMenuCrearPedido;

    @FXML
    private Button ButtomDecrementar;

    @FXML
    private Button ButtomIncrementar;

    @FXML
    private Button ButtomQuitarProducto;

    @FXML
    private Button ButtomRealizarPedido;

    @FXML
    private TableColumn<Producto,String> tableColumnAgregarProductoID;

    @FXML
    private TableColumn<Producto, String> tableColumnAgregarProductoNombre;

    @FXML
    private TableColumn<Producto,Double> tableColumnAgregarProductoPrecio;

    @FXML
    private TableColumn<Producto, Integer> tableColumnCrearPedidoCantidad;

    @FXML
    private TableColumn<Producto,String> tableColumnCrearPedidoID;

    @FXML
    private TableColumn<Producto,Double> tableColumnCrearPedidoPrecio;

    @FXML
    private TableColumn<Producto,LinkedList<Producto>> tableColumnCrearPedidoProducto;

    @FXML
    private TableColumn<Producto,Double> tableColumnCrearPedidoTotal;

    @FXML
    private TableView<Producto> tableViewAgregarProducto; //Tabla General: Agregar Producto.

    @FXML
    private TableView<Producto> tableViewCrearPedido; //Tabla General: Crear Pedido.


    @FXML
    private TextField TextFieldBuscarProducto;
    @FXML
    private Label LabelTotalAPagar;
    private Taqueria taqueria;
    private LinkedList<Producto> ordenApoyo = new LinkedList<>();
    private Double totalTotal;


    @FXML
    void OnMouseClickedButtomBackToMenuCrearPedido(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MenuAdminController menuAdminController = fxmlLoader.getController();
            menuAdminController.setTaqueria(taqueria);
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

    @FXML
    void OnMouseClickedButtomAgregarProducto(MouseEvent event) {
        Producto productoSeleccionado = tableViewAgregarProducto.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            boolean productoExistente = false;
            for (Producto producto : ordenApoyo) {
                if (producto.getProductId().equals(productoSeleccionado.getProductId())) {
                    productoExistente = true;
                    break;
                }
            }
            if (!productoExistente) {
                ordenApoyo.add(productoSeleccionado);
                tableViewCrearPedido.setItems(FXCollections.observableArrayList(ordenApoyo));
            } else {
                System.out.println("El producto seleccionado ya está en la lista de pedidos.");
            }
        }
        calcularTotal();
    }

    @FXML
    void OnMouseClickedButtomDecrementar(MouseEvent event) {
        Producto productoSeleccionado = tableViewCrearPedido.getSelectionModel().getSelectedItem();
        if (productoSeleccionado == null) {
            System.out.println("no ha seleccionado nada");
            return;
        }
        if(productoSeleccionado.getQuantity()<= 1) {
            System.out.println("no puede ser menor a 1");
            return;
        }
        productoSeleccionado.decrementarCantidad();
        tableViewCrearPedido.refresh();
        calcularTotal();
    }

    @FXML
    void OnMouseClickedButtomIncrementar(MouseEvent event) {
        Producto productoSeleccionado = tableViewCrearPedido.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            productoSeleccionado.incrementarCantidad();
            tableViewCrearPedido.refresh();
            calcularTotal();
        }
    }

    @FXML
    void OnMouseClickedButtomQuitarProducto(MouseEvent event) {
        Producto productoSeleccionado = tableViewCrearPedido.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            ordenApoyo.remove(productoSeleccionado);
            tableViewCrearPedido.setItems(FXCollections.observableArrayList(ordenApoyo));
            tableViewCrearPedido.refresh();
            productoSeleccionado.setQuantity(1);
            calcularTotal();
        }
    }

    @FXML
    void OnMouseClickedButtomRealizarPedido(MouseEvent event) {
        calcularTotal();
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmar Pedido");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("¿Seguro que quieres Realiza el pedido?");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            LinkedList<Producto> copiaOrden = new LinkedList<>();
            for (Producto producto : ordenApoyo) {
                copiaOrden.add(new Producto(
                        producto.getProductName(),
                        producto.getProductDescription(),
                        producto.getProductPrice(),
                        producto.getQuantity()
                ));
            }
            Pedido pedido = new Pedido(totalTotal, copiaOrden);
            taqueria.agregarPedido(pedido);
            for (Producto producto : ordenApoyo) {
                producto.setQuantity(1);
            }
            ordenApoyo.clear();
            tableViewCrearPedido.setItems(FXCollections.observableArrayList(ordenApoyo));
            tableViewCrearPedido.refresh();
            calcularTotal();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Pedido realizado.");
            successAlert.setHeaderText(null);
            successAlert.setContentText("El pedido se realizó correctamente.");
            successAlert.showAndWait();
        }
        /*for (Pedido pedido : taqueria.getOrderList()) {
            System.out.println(pedido.toString());
        }*/
    }

    @FXML
    void OnMouseClickedTextFieldBuscarProducto(MouseEvent event) {
    }

    @FXML
    void initialize() {
        configureAgregarProductosTable();
        configureCrearPedidoTable();

        TextFieldBuscarProducto.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrarProductos(newValue.trim().toLowerCase());
        });
    }
    public void calcularTotal() {
        totalTotal = 0.0;
        for (Producto producto : ordenApoyo) {
            totalTotal += producto.getTotalPrice();
        }
        LabelTotalAPagar.setText(String.format("%.2f", totalTotal));
    }

    public void configureCrearPedidoTable() {
        if (tableColumnCrearPedidoID != null && tableColumnCrearPedidoCantidad != null &&
                tableColumnCrearPedidoPrecio != null && tableColumnCrearPedidoProducto != null
                && tableColumnCrearPedidoTotal != null) {
            tableColumnCrearPedidoID.setCellValueFactory(new PropertyValueFactory<>("productId"));
            tableColumnCrearPedidoProducto.setCellValueFactory(new PropertyValueFactory<>("productName"));
            tableColumnCrearPedidoPrecio.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
            tableColumnCrearPedidoCantidad.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            tableColumnCrearPedidoTotal.setCellValueFactory(cellData -> {
                double totalPrice = cellData.getValue().getTotalPrice();
                return new SimpleDoubleProperty(totalPrice).asObject();
            });
        }
    }


    public void configureAgregarProductosTable() {
        if (tableColumnAgregarProductoID != null && tableColumnAgregarProductoNombre != null &&
                tableColumnAgregarProductoPrecio != null) {
            tableColumnAgregarProductoID.setCellValueFactory(new PropertyValueFactory<>("productId"));
            tableColumnAgregarProductoNombre.setCellValueFactory(new PropertyValueFactory<>("productName"));
            tableColumnAgregarProductoPrecio.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        }
    }

    public void filtrarProductos(String textoBusqueda) {
        if (!textoBusqueda.isEmpty()) {
            ObservableList<Producto> productosFiltrados = FXCollections.observableArrayList();

            for (Producto producto : tableViewAgregarProducto.getItems()) {
                if (producto.getProductName().toLowerCase().contains(textoBusqueda)) {
                    productosFiltrados.add(producto);
                }
            }
            tableViewAgregarProducto.setItems(productosFiltrados);
        } else {
            tableViewAgregarProducto.setItems(FXCollections.observableArrayList(taqueria.getMenu()));
        }
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria = taqueria;
        if (tableViewAgregarProducto != null && taqueria != null) {
            ObservableList<Producto> productoData = FXCollections.observableArrayList();
            for (Producto producto : taqueria.getMenu()) {
                productoData.add(producto);
            }
            tableViewAgregarProducto.setItems(productoData);
        }
    }
}
