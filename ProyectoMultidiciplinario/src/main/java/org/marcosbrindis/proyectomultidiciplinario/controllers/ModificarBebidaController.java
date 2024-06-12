package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

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
import org.marcosbrindis.proyectomultidiciplinario.models.Bebida;
import org.marcosbrindis.proyectomultidiciplinario.models.Producto;
import org.marcosbrindis.proyectomultidiciplinario.models.Taco;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

public class ModificarBebidaController {


    @FXML
    private Button ButtomBackToModificarProductoModificarBebida;

    @FXML
    private Button ButtomEliminarBebida;

    @FXML
    private Button ButtomModificarBebida;

    @FXML
    private ComboBox<String> ComboBoxModificarTamaño;

    @FXML
    private ComboBox<String> ComboBoxModificarTipoBebida;

    @FXML
    private ListView<Producto> ListViewListaBebidas;

    @FXML
    private TextField TextFieldBuscarBebida;

    @FXML
    private TextField TextFieldModificarDescripcionBebida;

    @FXML
    private TextField TextFieldModificarPrecioBebida;

    @FXML
    private TextField TextFieldNameModificarBebida;
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToModificarProductoModificarBebida(MouseEvent event) {
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
    void OnMouseClickedButtomEliminarBebida(MouseEvent event) {
        Producto productoSeleccionado = ListViewListaBebidas.getSelectionModel().getSelectedItem();
        //Al no seleccionar un elemento de la tabla y dar click...
        if (productoSeleccionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error.");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona una Bebida de la lista.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        agregarCssAlerta(confirmAlert);
        confirmAlert.setTitle("Confirmar Eliminación.");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("¿Seguro que quieres eliminar esta bebida?");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            //Al aceptar eliminar la bebida se remueve del ArrayList Producto
            taqueria.removeProduct(productoSeleccionado);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Bebida Eliminada.");
            successAlert.setHeaderText(null);
            successAlert.setContentText("La Bebida ha sido eliminada correctamente.");
            agregarCssAlerta(successAlert);
            successAlert.showAndWait();
            actualizarListaBebidas();
        }
    }

    @FXML
    void OnMouseClickedButtomModificarBebida(MouseEvent event) {
        try {
            //Al no seleccionar un elemento de la tabla y dar click...
            Producto productoSeleccionado = ListViewListaBebidas.getSelectionModel().getSelectedItem();
            if (productoSeleccionado == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, selecciona una Bebida de la lista.");
                agregarCssAlerta(alert);
                alert.showAndWait();
                return;
            }

            //Se rellenan los elementos.
            String nuevoNombre = TextFieldNameModificarBebida.getText();
            String nuevaDescripcion = TextFieldModificarDescripcionBebida.getText();
            double nuevoPrecio = Double.parseDouble(TextFieldModificarPrecioBebida.getText());
            String nuevoTipoBebida = ComboBoxModificarTipoBebida.getValue();
            String nuevosizeBebida = ComboBoxModificarTamaño.getValue();

            if (nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty() || nuevoTipoBebida == null || nuevosizeBebida == null) {
                //Al no tener llenos todos los elementos...
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, complete todos los campos.");
                agregarCssAlerta(alert);
                alert.showAndWait();
                return;
            }
            for (Producto producto : taqueria.getMenu()) {
                //Si el nombre a modificar ya existe...
                if (!producto.equals(productoSeleccionado) && producto.getProductName().equalsIgnoreCase(nuevoNombre)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error.");
                    alert.setHeaderText(null);
                    alert.setContentText("El nombre '" + nuevoNombre + "' ya está siendo utilizado por otro producto.");
                    agregarCssAlerta(alert);
                    alert.showAndWait();
                    return;
                }
            }
            String idProductoSeleccionado = productoSeleccionado.getProductId();

            //Al pasar exitosamente todos los requisitos, se modidica los datos.
            taqueria.modifyProduct(idProductoSeleccionado, nuevoNombre, nuevaDescripcion, nuevoPrecio, null, nuevoTipoBebida, nuevosizeBebida);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bebida Modificada.");
            alert.setHeaderText(null);
            alert.setContentText("La Bebida ha sido modificada correctamente.");
            agregarCssAlerta(alert);
            alert.showAndWait();

            actualizarListaBebidas();
       /*for (Producto producto : taqueria.getMenu()) {
            if (producto instanceof Taco) {
                System.out.println(producto.toString() + " - Tipo de carne: " + ((Taco) producto).getTypeMeat());
            }
        }*/
        } catch (NumberFormatException e) { //Se debe ingresar datos numericos en el precio.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error.");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese un valor válido para el precio.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }
    }

    @FXML
    void OnMouseClickedComboBoxModificarTamaño(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxModificarTipoBebida(MouseEvent event) {

    }

    @FXML
    void initialize() {
        if (ComboBoxModificarTamaño.getItems().isEmpty()) {
            ArrayList<String> sizeBebida = new ArrayList<>();
            sizeBebida.add("Chica.");
            sizeBebida.add("Mediana.");
            sizeBebida.add("Grande.");
            ComboBoxModificarTamaño.getItems().addAll(sizeBebida);
        }
        if (ComboBoxModificarTipoBebida.getItems().isEmpty()) {
            ArrayList<String> typeBebida = new ArrayList<>();
            typeBebida.add("Alcohólica.");
            typeBebida.add("Natural.");
            typeBebida.add("Refresco.");
            ComboBoxModificarTipoBebida.getItems().addAll(typeBebida);
        }

        if (taqueria != null) {
            TextFieldBuscarBebida.textProperty().addListener((observable, oldValue, newValue) -> {
                buscarBebida(newValue);
            });

            ListViewListaBebidas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    TextFieldNameModificarBebida.setText(newValue.getProductName());
                    TextFieldModificarDescripcionBebida.setText(newValue.getProductDescription());
                    TextFieldModificarPrecioBebida.setText(String.valueOf(newValue.getProductPrice()));

                    if (newValue instanceof Bebida) {
                        String tipoBebida = ((Bebida) newValue).getTypeDrink();
                        ComboBoxModificarTipoBebida.setValue(tipoBebida);

                        String tamañoBebida = ((Bebida) newValue).getSizeDrink();
                        ComboBoxModificarTamaño.setValue(tamañoBebida);
                    } else {
                        ComboBoxModificarTipoBebida.getSelectionModel().clearSelection();
                        ComboBoxModificarTamaño.getSelectionModel().clearSelection();
                    }
                }
            });
        }
        actualizarListaBebidas();
    }

    public void buscarBebida(String nombre) {
        if (taqueria != null && nombre != null && !nombre.isEmpty()) {
            ObservableList<Producto> productosFiltrados = FXCollections.observableArrayList();
            for (Producto producto : taqueria.getMenu()) {
                if (producto instanceof Bebida && producto.getProductName().toLowerCase().contains(nombre.toLowerCase())) {
                    productosFiltrados.add(producto);
                }
            }
            ListViewListaBebidas.setItems(productosFiltrados);
        } else {
            ListViewListaBebidas.setItems(FXCollections.observableArrayList());
            actualizarListaBebidas();
        }
    }

    public void actualizarListaBebidas() {
        if (taqueria != null) {
            ObservableList<Producto> bebidas = FXCollections.observableArrayList();

            for (Producto producto : taqueria.getMenu()) {
                if (producto instanceof Bebida) {
                    bebidas.add(producto);
                }
            }
            ListViewListaBebidas.setCellFactory(param -> new ListCell<Producto>() {
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

            ListViewListaBebidas.setItems(bebidas);
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

    public void setTaqueria(Taqueria taqueria) {
        this.taqueria = taqueria;
        if (taqueria != null) {
            actualizarListaBebidas();
        }
    }
}
