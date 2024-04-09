package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Producto;
import org.marcosbrindis.proyectomultidiciplinario.models.Taco;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;


public class ModificarTacoController {

    @FXML
    private Button ButtomBackToModificarProductoModificarTaco;

    @FXML
    private Button ButtomEliminarTaco;

    @FXML
    private Button ButtomModificarTaco;

    @FXML
    private ComboBox<String> ComboBoxModificarTipoCarne;

    @FXML
    private ListView<Producto> ListViewListaTacos;

    @FXML
    private TextField TextFieldModificarDescripcionTaco;

    @FXML
    private TextField TextFieldModificarPrecioTaco;

    @FXML
    private TextField TextFieldNameModificarTaco;

    @FXML
    private TextField TextFieldNombreBuscarTaco;

    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToModificarProductoModificarTaco(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("modificarProducto-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ModificarProducto modificarProducto = fxmlLoader.getController();
            modificarProducto.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Modificar Producto.");
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
    void OnMouseClickedButtomEliminarTaco(MouseEvent event) {
        Producto productoSeleccionado = ListViewListaTacos.getSelectionModel().getSelectedItem();

        if (productoSeleccionado == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona un taco de la lista.");
            alert.showAndWait();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmar Eliminación");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("¿Seguro que quieres eliminar este taco?");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            taqueria.removeProduct(productoSeleccionado);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Taco Eliminado");
            successAlert.setHeaderText(null);
            successAlert.setContentText("El taco ha sido eliminado correctamente.");
            successAlert.showAndWait();
            actualizarListaTacos();

        }
    }

    @FXML
    void OnMouseClickedButtomModificarTaco(MouseEvent event) {
        try {
            Producto productoSeleccionado = ListViewListaTacos.getSelectionModel().getSelectedItem();
            if (productoSeleccionado == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, selecciona un taco de la lista.");
                agregarCssAlerta(alert);
                alert.showAndWait();
                return;
            }

            String nuevoNombre = TextFieldNameModificarTaco.getText();
            String nuevaDescripcion = TextFieldModificarDescripcionTaco.getText();
            double nuevoPrecio = Double.parseDouble(TextFieldModificarPrecioTaco.getText());
            String nuevoTipoCarne = ComboBoxModificarTipoCarne.getValue();

            if (nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty() || nuevoTipoCarne == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, complete todos los campos.");
                agregarCssAlerta(alert);
                alert.showAndWait();
                return;
            }
            for (Producto producto : taqueria.getMenu()) {
                if (!producto.equals(productoSeleccionado) && producto.getProductName().equalsIgnoreCase(nuevoNombre)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("El nombre '" + nuevoNombre + "' ya está siendo utilizado por otro producto.");
                    agregarCssAlerta(alert);
                    alert.showAndWait();
                    return;
                }
            }
            String idProductoSeleccionado = productoSeleccionado.getProductId();

            taqueria.modifyProduct(idProductoSeleccionado, nuevoNombre, nuevaDescripcion, nuevoPrecio, nuevoTipoCarne, null, null);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Taco Modificado");
            alert.setHeaderText(null);
            alert.setContentText("El taco ha sido modificado correctamente.");
            agregarCssAlerta(alert);
            alert.showAndWait();

            actualizarListaTacos();
       /*for (Producto producto : taqueria.getMenu()) {
            if (producto instanceof Taco) {
                System.out.println(producto.toString() + " - Tipo de carne: " + ((Taco) producto).getTypeMeat());
            }
        }*/
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese un valor válido para el precio.");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    void OnMouseClickedComboBoxTipoCarne(MouseEvent event) {
    }

    @FXML
    void initialize() {
        if (ComboBoxModificarTipoCarne.getItems().isEmpty()) {
            ArrayList<String> typeMeatCombobox = new ArrayList<>();
            typeMeatCombobox.add("Res");
            typeMeatCombobox.add("Puerco");
            typeMeatCombobox.add("pollo");
            ComboBoxModificarTipoCarne.getItems().addAll(typeMeatCombobox);
        }

        if (taqueria != null) {
            TextFieldNombreBuscarTaco.textProperty().addListener((observable, oldValue, newValue) -> {
                buscarTacos(newValue);
            });

            ListViewListaTacos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    TextFieldNameModificarTaco.setText(newValue.getProductName());
                    TextFieldModificarDescripcionTaco.setText(newValue.getProductDescription());
                    TextFieldModificarPrecioTaco.setText(String.valueOf(newValue.getProductPrice()));

                    if (newValue instanceof Taco) {
                        String tipoCarne = ((Taco) newValue).getTypeMeat();
                        ComboBoxModificarTipoCarne.setValue(tipoCarne);
                    } else {
                        ComboBoxModificarTipoCarne.getSelectionModel().clearSelection();
                    }
                }
            });
        }
        actualizarListaTacos();
    }
    public void buscarTacos(String nombre) {
        if (taqueria != null && nombre != null && !nombre.isEmpty()) {
            ObservableList<Producto> productosFiltrados = FXCollections.observableArrayList();
            for (Producto producto : taqueria.getMenu()) {
                if (producto.getProductName().toLowerCase().contains(nombre.toLowerCase())) {
                    productosFiltrados.add(producto);
                }
            }
            ListViewListaTacos.setItems(productosFiltrados);
        } else {
            ListViewListaTacos.setItems(FXCollections.observableArrayList());
            actualizarListaTacos();
        }
    }

    public void actualizarListaTacos() {
        if (taqueria != null) {
            ObservableList<Producto> productos = FXCollections.observableArrayList();

            for (Producto producto : taqueria.getMenu()) {
                if (producto instanceof Taco) {
                    productos.add(producto);
                }
            }
            ListViewListaTacos.setCellFactory(param -> new ListCell<Producto>() {
                @Override
                protected void updateItem(Producto producto, boolean empty) {
                    super.updateItem(producto, empty);
                    if (empty || producto == null || producto.getProductName() == null) {
                        setText(null);
                    } else {
                        setText(producto.getProductId() + " ----> " + producto.getProductName());
                    }
                }
            });

            ListViewListaTacos.setItems(productos);
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
        if (taqueria != null) {
            actualizarListaTacos();
        }
    }
}
