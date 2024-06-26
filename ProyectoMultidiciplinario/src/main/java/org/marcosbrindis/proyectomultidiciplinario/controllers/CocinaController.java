package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Pedido;
import org.marcosbrindis.proyectomultidiciplinario.models.Producto;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Venta;

import java.io.IOException;

public class CocinaController {

    @FXML
    private Button ButtomBackToMenuCocina;

    @FXML
    private Button ButtomFinalizarPedido;

    @FXML
    private Label labelIdPedidos;

    @FXML
    private Label labelListaPedidos;
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuCocina(MouseEvent event) { //Cerrar interfaz Cocina.
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnMouseClickedButtomFinalizarPedido(MouseEvent event) {
        if (taqueria != null && !taqueria.getOrderList().isEmpty()) { //Si taqueria no es nula y si la lista de pedidos (orderList) de la taquería no está vacía.
            Pedido pedidoFinalizado = taqueria.getOrderList().poll(); //Extrae el primer pedido de la lista (usando poll()), lo agrega a la lista de ventas de la taquería (Venta) y lo almacena en la variable pedidoFinalizado.
            taqueria.getVenta().agregarVenta(pedidoFinalizado);

            if (!pedidoFinalizado.getStatus()) { //si pedido finalizado es false...
                actualizarLabels(); //Llama al metodo actualizarLabels.
                return;
            }

            actualizarLabels(); //Llama al metodo actualizarLabels.

            for (Pedido pedido : taqueria.getOrderList()) {
                if (pedido.getStatus()) { //Si encuentra un pedido que aún no está finalizado...
                    actualizarLabels(); // Metodo actualizarLabels.
                    return;
                }
            }


        } else { //Entoces marca el siguiente mensaje.
            labelListaPedidos.setText("No hay pedidos en la cola.");
            labelIdPedidos.setText("");
        }

    }

    @FXML
    void initialize() {
        actualizarLabels();
    }
    public void actualizarLabels() { //Metodo para actualizar labels.
        String listaPedidos = "";
        String IdPedidos = "";

        if (taqueria != null && !taqueria.getOrderList().isEmpty()) { //Si taqueria no es nula y la lista de taqueria no esta vacia...
            while (!taqueria.getOrderList().isEmpty() && !taqueria.getOrderList().peek().getStatus()) {
                taqueria.getVenta().agregarVenta(taqueria.getOrderList().peek());
                taqueria.getOrderList().poll();
                //se agrega a la lista de ventas de la taquería (Venta) y se elimina de la lista de pedidos.
            }
            if (!taqueria.getOrderList().isEmpty()) {
                Pedido peekPedido = taqueria.getOrderList().peek();
                for (Producto producto : peekPedido.getOrden()) {
                    listaPedidos += producto.toString();
                }
                IdPedidos += peekPedido.getIdPedido();
            } else {
                listaPedidos = "No hay pedidos en la cola.";
            }
        } else {
            listaPedidos = "No hay pedidos en la cola.";
        }
        labelListaPedidos.setText(listaPedidos);
        labelIdPedidos.setText(IdPedidos);
    }

    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }
}
