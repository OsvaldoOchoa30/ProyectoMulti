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
    void OnMouseClickedButtomBackToElegirProductoTaco(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("elegirProducto-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ElegirProductoController elegirProductoController = fxmlLoader.getController();
            elegirProductoController.setTaqueria(taqueria);
            Stage stage = new Stage();
            stage.setTitle("Agregar Producto.");
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
        String name = TextFieldNombreTaco.getText();
        String descrip = TextFieldDescripcionTaco.getText();
        String precioString = TextFieldPrecioTaco.getText().replace("$", "");
        String typemeat = ComboBoxTipoCarne.getValue();
        try {
            Double precio = Double.parseDouble(precioString);
            if (name.isEmpty() || descrip.isEmpty() || precioString.isEmpty() || typemeat == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, complete todos los campos.");
                alert.showAndWait();
                return;
            }

            for (Producto producto : taqueria.getMenu()) {
                if (producto.getProductName().equals(name)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText(null);
                    alert.setContentText("El producto ya Existe.");
                    alert.showAndWait();
                    return;
                }
            }

            Taco taco = new Taco(name, descrip, precio, 0, typemeat);
            taqueria.addProduct(taco);

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AGREGADO!");
            alert.setHeaderText(null);
            alert.setContentText("Taco agregado correctamente.");
            alert.showAndWait();

            System.out.println("Taco agregado correctamente");
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
        if (ComboBoxTipoCarne.getItems().isEmpty()) {
            ArrayList<String> typeMeatCombobox = new ArrayList<>();
            typeMeatCombobox.add("Res");
            typeMeatCombobox.add("Puerco");
            typeMeatCombobox.add("pollo");
            ComboBoxTipoCarne.getItems().addAll(typeMeatCombobox);
        }
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

}
