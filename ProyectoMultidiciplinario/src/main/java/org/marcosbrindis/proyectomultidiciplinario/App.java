package org.marcosbrindis.proyectomultidiciplinario;
//Proyecto Multidiciplinario inicado: Marcos Brindis y Osvaldo Ochoa
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.controllers.PrincipalController;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;

import java.io.IOException;

public class App extends Application {
    private Taqueria taqueria;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("principal-view.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        PrincipalController principalController = fxmlLoader.getController();
        principalController.setTaqueria(taqueria);
        Scene scene = new Scene(root);
        stage.setTitle("Crear Usuario!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}