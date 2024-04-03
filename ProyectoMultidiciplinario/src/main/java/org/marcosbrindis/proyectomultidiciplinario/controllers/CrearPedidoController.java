package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

import java.io.IOException;

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
    private Label LabelTotalAPagar;

    //Se crearon dos tablas y se asigno su nombre por su respectiva accion:
    //CrearPedido es la del lado izquierdo.
    //AgregarProducto es del lado derecho
    //De esta manera se dividieron las acciones, ya que tienen nombre similares el contenido de la tabla se le asigno a la que corresponde.

    @FXML
    private TableColumn<?, ?> TableColumnAgregarProductoID;

    @FXML
    private TableColumn<?, ?> TableColumnAgregarProductoNombre;

    @FXML
    private TableColumn<?, ?> TableColumnAgregarProductoPrecio;

    @FXML
    private TableColumn<?, ?> TableColumnCrearPedidoCantidad;

    @FXML
    private TableColumn<?, ?> TableColumnCrearPedidoID;

    @FXML
    private TableColumn<?, ?> TableColumnCrearPedidoPrecio;

    @FXML
    private TableColumn<?, ?> TableColumnCrearPedidoProducto;

    @FXML
    private TableColumn<?, ?> TableColumnCrearPedidoTotal;

    //Por si ocupas los ID de las tablas generales.

    @FXML
    private TableView<?> TableViewAgregarProducto; //Tabla General: Agregar Producto.

    @FXML
    private TableView<?> TableViewCrearPedido; //Tabla General: Crear Pedido.


    @FXML
    private TextField TextFieldBuscarProducto;
    private Taqueria taqueria;


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

    }

    @FXML
    void OnMouseClickedButtomDecrementar(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtomIncrementar(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtomQuitarProducto(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedButtomRealizarPedido(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedTextFieldBuscarProducto(MouseEvent event) {

    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

}
