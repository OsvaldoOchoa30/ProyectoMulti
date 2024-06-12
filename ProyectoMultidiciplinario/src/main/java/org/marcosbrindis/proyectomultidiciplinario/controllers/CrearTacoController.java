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
import org.marcosbrindis.proyectomultidiciplinario.models.Producto;
import org.marcosbrindis.proyectomultidiciplinario.models.Taco;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

public class CrearTacoController {

    @FXML
    private Button ButtomBackToElegirProductoTaco;

    @FXML
    private Button ButtomCrearTaco;

    @FXML
    private ComboBox<String> ComboBoxTipoCarne;

    @FXML
    private TextField TextFieldDescripcionTaco;

    @FXML
    private TextField TextFieldNombreTaco;

    @FXML
    private TextField TextFieldPrecioTaco;

    //CallSu
    Stage callSu = new Stage();
    private Taqueria taqueria;

    @FXML
    void OnMouseClickedButtomBackToElegirProductoTaco(MouseEvent event) { //Boton para regresar al menu Elegir Producto.
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
    void OnMouseClickedButtomCrearTaco(MouseEvent event) {
        //LLenamos los datos del textfield.
        String name = TextFieldNombreTaco.getText();
        String descrip = TextFieldDescripcionTaco.getText();
        String precioString = TextFieldPrecioTaco.getText().replace("$", "");
        String typemeat = ComboBoxTipoCarne.getValue();

        try {
            Double precio = Double.parseDouble(precioString);
            if (name.isEmpty() || descrip.isEmpty() || precioString.isEmpty() || typemeat == null) {
                //Si los elementos estan vacios...
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, complete todos los campos.");
                agregarCssAlerta(alert);
                alert.showAndWait();
                return;
            }

            for (Producto producto : taqueria.getMenu()) { //Busca dentro del arrayList Menu.
                //Si existe un producto con el mismo nombre...
                if (producto.getProductName().equals(name)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error.");
                    alert.setHeaderText(null);
                    alert.setContentText("El producto ya existe.");
                    agregarCssAlerta(alert);
                    alert.showAndWait();
                    return;
                }
            }

            //Al pasar todos los requisitos se crea un objeto de la clase taco que guarda los datos asignados.
            Taco taco = new Taco(name, descrip, precio, 1, typemeat);
            taqueria.addProduct(taco); //agregamos el Taco al ArrayList Menu.

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("AGREGADO!");
            alert.setHeaderText(null);
            alert.setContentText("Taco agregado correctamente.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            limpiarCampos();
            System.out.println("Taco agregado correctamente");

        } catch (NumberFormatException e) {
            //Al no colocar caracteres numericos dentro del textfield precio...
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese un valor válido para el precio.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            return;
        }
    }

    @FXML
    void OnMouseClickedComboBoxTipoCarne(MouseEvent event) {

    }

    @FXML
    void initialize() {
        if (ComboBoxTipoCarne.getItems().isEmpty()) {
            ArrayList<String> typeMeatCombobox = new ArrayList<>();
            typeMeatCombobox.add("Res");
            typeMeatCombobox.add("Puerco");
            typeMeatCombobox.add("Pollo");
            ComboBoxTipoCarne.getItems().addAll(typeMeatCombobox);
            ComboBoxTipoCarne.setPromptText("Tipo de Carne");
        }
    }
    public void limpiarCampos(){
        ComboBoxTipoCarne.getSelectionModel().clearSelection();
        ComboBoxTipoCarne.setPromptText("Tipo de Carne");
        TextFieldDescripcionTaco.clear();
        TextFieldNombreTaco.clear();
        TextFieldPrecioTaco.clear();
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
    }
}
