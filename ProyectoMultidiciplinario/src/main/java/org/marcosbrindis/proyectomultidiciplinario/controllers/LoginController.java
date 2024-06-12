package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.marcosbrindis.proyectomultidiciplinario.App;
import org.marcosbrindis.proyectomultidiciplinario.models.Taqueria;
import org.marcosbrindis.proyectomultidiciplinario.models.Usuario;


public class LoginController {

    @FXML
    private Button ButtomLogin;

    @FXML
    private TextField TextFieldNameLogin;

    @FXML
    private TextField TextFieldPaswordLogin;

    Stage callSu = new Stage();
    private Taqueria taqueria;
    private HashMap<String,Usuario > clonUsuarios = new HashMap();

    @FXML
    void OnMouseClickedButtomLogin(MouseEvent event) { //Boton para iniciar sesion.
        String userName= TextFieldNameLogin.getText(); //text field de nombre.
        String userPassword=TextFieldPaswordLogin.getText(); //textfield de password.

        if (!clonUsuarios.isEmpty()){ //si el hashmap no esta vacio...
            if (clonUsuarios.containsKey(userName)) {
                Usuario usuario = clonUsuarios.get(userName);
                if (userPassword.equals(usuario.getPassword())) { //Si la password es igual a la password guardada...
                    taqueria.setUsuarioActual(usuario); //Taqueria define al usuario.
                    System.out.println("Usuario actual: " + usuario.getNameUser() + ", Rol: " + usuario.getRolUser());
                    if (usuario.getRolUser().equals("Administrador")){ //Si el rol asignado es Administrador, nos permite entrar a su interfaz.
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuAdmin-view.fxml"));
                            Scene scene = null;
                            scene = new Scene(fxmlLoader.load());
                            MenuAdminController menuAdminController = fxmlLoader.getController();
                            menuAdminController.setTaqueria(taqueria);
                            callSu.setTitle("Menu.");
                            callSu.setScene(scene);
                            callSu.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
                    }else{ //Pero si el rol es Empleado, nos manda a otra interfaz.
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuEmpleado-view.fxml"));
                            Scene scene = null;
                            scene = new Scene(fxmlLoader.load());
                            MenuEmpleadoController menuEmpleadoController = fxmlLoader.getController();
                            menuEmpleadoController.setTaqueria(taqueria);
                            callSu.setTitle("Menu.");
                            callSu.setScene(scene);
                            callSu.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
                    }
                }else { //si la password no es igual que la guardada...
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error.");
                    alert.setHeaderText(null);
                    alert.setContentText("Contraseña Incorrecta.");
                    agregarCssAlerta(alert);
                    alert.showAndWait();
                }
            }else { //Si no se encuentra el nombre de usuario...
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Nombre de usuario no encontrado.");
                agregarCssAlerta(alert);
                alert.showAndWait();
            }
        }
    }

    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
        for (Usuario actual:taqueria.getUserList()){
            clonUsuarios.put(actual.getNameUser(),actual);
        }
    }

    @FXML
    void initialize() {
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
