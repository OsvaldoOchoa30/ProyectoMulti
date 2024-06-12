package org.marcosbrindis.proyectomultidiciplinario.controllers;

import java.io.IOException;

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

public class PrincipalController {

    @FXML
    private Button ButtomCrear;

    @FXML
    private TextField TextFieldName;

    @FXML
    private TextField TextFieldOficialPassword;

    @FXML
    private TextField TextFieldPassword;

    Taqueria taqueria;

    Stage callSu = new Stage();
    @FXML
    void OnMouseClickedButtomCrear(MouseEvent event) {

        String name= TextFieldName.getText(); //obtiene el nombre ingresado.
        String password1= TextFieldOficialPassword.getText(); //obtiene password.
        String password2=TextFieldPassword.getText(); //obtiene la verificacion de password.
        String rol="Administrador";
        if (!name.isEmpty()&&!password1.isEmpty()) { //Si el contenido de nombre y password no estan vacios...
            //Entramos a una decision de verificacion de passwords.
            if (password2.equals(password1)) { //Si password2 es igual a password 1...
                if (!verificarPassword(password1)) { //Entramos al metododo de Verificar password.
                    //Si dicho metodo se vuelve false, arroja la siguiente alerta:
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("La contraseña debe tener al menos 6 caracteres y al menos un número.");
                    agregarCssAlerta(alert);
                    alert.showAndWait();
                    return;
                }
                //Al pasar los requisitos y llenar correctamente los datos...
                Usuario usuario = new Usuario(name, password1, rol); //Se crea un objeto de la clase Usuario con los datos asignados previamente.
                taqueria = new Taqueria(); //Se crea un nuevo objeto de la clase taqueria.
                taqueria.addUser(usuario); //taqueria agrega al usuario creado al ArrayList<Usuario>.
                taqueria.setUsuarioActual(usuario); //taqueria definie al usuario actual.

                //Comando para "conectar" interfaces:
                try { //Al agregarse el usuario exitosamente nos llevara a la siguiente interfaz.
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    LoginController loginController = fxmlLoader.getController();
                    loginController.setTaqueria(taqueria);
                    callSu.setTitle("Iniciar Sesion.");
                    callSu.setScene(scene);
                    callSu.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            } else { //si las password no son las mismas...
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Las contraseñas no coinciden, intenta nuevamente.");
                agregarCssAlerta(alert);
                alert.showAndWait();
            }
        }else { //Al estar vacios los text fields...
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hay campos sin llenar.\n"+"Por favor llenalos correctamente..");
            agregarCssAlerta(alert);
            alert.showAndWait();
        }
    }
    public void setTaqueria(Taqueria taqueria){
        this.taqueria=taqueria;
    }

    public boolean verificarPassword(String contrase) { //Metodo boolean para verificar la password.
        //la primera parte significa que debe de tener al menos un digito.
        //la segunda parte marca que tiene que ser una password que sea igual o mayor a 6 caracteres.
        return contrase.matches(".*\\d.*") && contrase.length() >= 6;
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
    @FXML
    void initialize() {
    }

}
