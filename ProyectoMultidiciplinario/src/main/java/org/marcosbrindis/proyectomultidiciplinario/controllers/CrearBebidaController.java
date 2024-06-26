package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Bebida;
import org.marcosbrindis.proyectomultidiciplinario.models.Producto;
import org.marcosbrindis.proyectomultidiciplinario.models.Taco;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

public class CrearBebidaController {


    @FXML
    private Button ButtomBackToElegirProductoBebida;

    @FXML
    private Button ButtomCrearBebida;

    @FXML
    private ComboBox<String> ComboBoxSizeBebida;

    @FXML
    private ComboBox<String> ComboBoxTipoBebida;

    @FXML
    private TextField TextFieldDescripcionBebida;

    @FXML
    private TextField TextFieldNombreBebida;

    @FXML
    private TextField TextFieldPrecioBebida;


    private Taqueria taqueria;


    @FXML
    void ButtomBackToElegirProductoBebida(MouseEvent event) { //Regresar interfaz al menu.
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("elegirProducto-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ElegirProductoController elegirProductoController = fxmlLoader.getController();
            elegirProductoController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Elegir tipo de Producto.");
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
    void OnMouseClickedButtomCrear(MouseEvent event) {
        //Se rellenan los datos.
        String name = TextFieldNombreBebida.getText();
        String descrip = TextFieldDescripcionBebida.getText();
        String precioString = TextFieldPrecioBebida.getText().replace("$", "");
        String sizeBeb = ComboBoxSizeBebida.getValue();
        String typeBeb = ComboBoxTipoBebida.getValue();
        try {
            Double precio = Double.parseDouble(precioString);
            if (name.isEmpty() || descrip.isEmpty() || precioString.isEmpty() || sizeBeb == null || typeBeb == null) {
                //Si los elementos estan vacios.
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, complete todos los campos.");
                agregarCssAlerta(alert);
                alert.showAndWait();
                return;
            }

            for (Producto producto : taqueria.getMenu()) { //Revisa si el producto existe.
                if (producto.getProductName().equals(name)) { //Si el nimbre ingresado coincide con un producto creado...
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("El producto ya existe.");
                    agregarCssAlerta(alert);
                    alert.showAndWait();
                    return;
                }
            }

            Bebida bebida = new Bebida(name, descrip, precio, 1, typeBeb,sizeBeb); //Se crea una instancia de la clase bebida con los datos obtenidos.
            taqueria.addProduct(bebida); //se agrega el producto al ArrayList Menu

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Agregado Exitosamente.");
            alert.setHeaderText(null);
            alert.setContentText("Bebida agregada correctamente.");
            agregarCssAlerta(alert);
            alert.showAndWait();

            limpiarCampos();

            System.out.println("Bebida se agrego.");
            for (Producto taqueria1 : taqueria.getMenu()) {
                System.out.println(taqueria1.toString());
            }

        } catch (NumberFormatException e) {
            //Al no ingresar datos numericos en el precio
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese un valor válido para el precio.");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    void OnMouseClickedComboBoxSizeBebida(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedComboBoxTipoBebida(MouseEvent event) {

    }

    @FXML
    void initialize() {
        //Inicializan los combo box
        if (ComboBoxTipoBebida.getItems().isEmpty()) {
            ArrayList<String> typeBebida = new ArrayList<>();
            typeBebida.add("Alcohólica.");
            typeBebida.add("Natural.");
            typeBebida.add("Refresco.");
            ComboBoxTipoBebida.getItems().addAll(typeBebida);
        }

        if (ComboBoxSizeBebida.getItems().isEmpty()) {
            ArrayList<String> sizeBebida = new ArrayList<>();
            sizeBebida.add("Chica.");
            sizeBebida.add("Mediana.");
            sizeBebida.add("Grande.");
            ComboBoxSizeBebida.getItems().addAll(sizeBebida);
        }
    }
    public void limpiarCampos(){
        ComboBoxSizeBebida.getSelectionModel().clearSelection();
        TextFieldDescripcionBebida.clear();
        TextFieldNombreBebida.clear();
        TextFieldPrecioBebida.clear();
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
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

}
