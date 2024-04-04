package org.marcosbrindis.proyectomultidiciplinario.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Bebida;
import org.marcosbrindis.proyectomultidiciplinario.models.Producto;
import org.marcosbrindis.proyectomultidiciplinario.models.Taco;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

import java.io.IOException;

public class VerMenuController {

    @FXML
    private TableView<Producto> tableViewTacos;

    @FXML
    private TableView<Producto> tableViewBebidas;

    @FXML
    private TableColumn<Producto, String> tableColumnTacosNombre;

    @FXML
    private TableColumn<Producto, String> tableColumnTacosDescripcion;

    @FXML
    private TableColumn<Producto, Double> tableColumnTacosPrecio;

    @FXML
    private TableColumn<Producto, String> tableColumnTacosCarne;

    @FXML
    private TableColumn<Producto, String> tableColumnBebidasNombre;

    @FXML
    private TableColumn<Producto, String> tableColumnBebidasDescripcion;

    @FXML
    private TableColumn<Producto, Double> tableColumnBebidasPrecio;

    @FXML
    private TableColumn<Producto, String> tableColumnBebidasTipo;

    @FXML
    private TableColumn<Producto, String> tableColumnBebidasSize;

    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToMenuAdmMenu(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        configureTacosTable();
        configureBebidasTable();
    }

    public void setTaqueria(Taqueria taqueria){
        this.taqueria = taqueria;
        if (tableViewTacos != null && tableViewBebidas != null && taqueria != null) {

            ObservableList<Producto> tacosData = FXCollections.observableArrayList();
            for (Producto producto : taqueria.getMenu()) {
                if (producto instanceof Taco) {
                    tacosData.add(producto);
                }
            }
            tableViewTacos.setItems(tacosData);

            ObservableList<Producto> bebidasData = FXCollections.observableArrayList();
            for (Producto producto : taqueria.getMenu()) {
                if (producto instanceof Bebida) {
                    bebidasData.add(producto);
                }
            }
            tableViewBebidas.setItems(bebidasData);
        }
    }

    public void configureTacosTable() {
        if (tableColumnTacosNombre != null && tableColumnTacosDescripcion != null &&
                tableColumnTacosPrecio != null && tableColumnTacosCarne != null) {
            tableColumnTacosNombre.setCellValueFactory(new PropertyValueFactory<>("productName"));
            tableColumnTacosDescripcion.setCellValueFactory(new PropertyValueFactory<>("productDescription"));
            tableColumnTacosPrecio.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

            tableColumnTacosCarne.setCellValueFactory(cellData -> new SimpleStringProperty(((Taco) cellData.getValue()).getTypeMeat()));
        }
    }

    public void configureBebidasTable() {
        if (tableColumnBebidasNombre != null && tableColumnBebidasDescripcion != null &&
                tableColumnBebidasPrecio != null && tableColumnBebidasTipo != null && tableColumnBebidasSize != null) {

            tableColumnBebidasNombre.setCellValueFactory(new PropertyValueFactory<>("productName"));
            tableColumnBebidasDescripcion.setCellValueFactory(new PropertyValueFactory<>("productDescription"));
            tableColumnBebidasPrecio.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

            tableColumnBebidasTipo.setCellValueFactory(cellData -> new SimpleStringProperty(((Bebida) cellData.getValue()).getTypeDrink()));
            tableColumnBebidasSize.setCellValueFactory(cellData -> new SimpleStringProperty(((Bebida) cellData.getValue()).getSizeDrink()));
        }
    }
}

