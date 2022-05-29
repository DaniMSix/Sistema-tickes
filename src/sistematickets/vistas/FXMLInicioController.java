/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematickets.vistas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistematickets.modelo.dao.UsuarioDAO;
import sistematickets.modelo.pojo.Usuario;
import sistematickets.util.Constantes;
import sistematickets.util.Utilidades;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Usuario
 */
public class FXMLInicioController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasenia;
    @FXML
    private Label lbErrorUsuario;
    @FXML
    private Label lbErrorContrasenia;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void iniciarSesion(ActionEvent event) {
        lbErrorContrasenia.setText("");
        lbErrorUsuario.setText("");
        
        String nombreUsuario = txtUsuario.getText();
        String constrasenia = txtContrasenia.getText();
        boolean usuarioValido = true;
        
        if(StringUtils.isBlank(nombreUsuario)){
            lbErrorUsuario.setText("Campo Usuario Requerido");
            usuarioValido = false;
        }
        
        if(StringUtils.isBlank(constrasenia)){
            lbErrorContrasenia.setText("Campo Contraseña Requerido");
            usuarioValido = false;
        }
        
        if (usuarioValido) {
            validarUsuarioBD(nombreUsuario, constrasenia);
        }
    }
    private void validarUsuarioBD(String username, String password){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            Usuario usuarioAIdentificar;
            usuarioAIdentificar = usuarioDAO.iniciarSesion(username, password);
            if(usuarioAIdentificar.getCodigoRespuesta() == Constantes.CODIGO_OPERACION_CORRECTA){
                Utilidades.mostrarAlerta("Usuario verificado","Bienvenido(a) al sistema",
                Alert.AlertType.INFORMATION);
                abrirPantallaPrincipal();
            }else if(usuarioAIdentificar.getCodigoRespuesta() == Constantes.CODIGO_CREDENCIALES_INCORRECTAS){
                Utilidades.mostrarAlerta("Credenciales Incorrectas",
                "Usuario y/o contraseña incorrectos, favor de verificarlos", Alert.AlertType.WARNING);
                txtUsuario.setText("");
                txtContrasenia.setText("");
            }
        } catch (SQLException sQLException) {
            Utilidades.mostrarAlerta("Error de conexion",
            "Lo sentimos por el momento no hay conexion con la base de datos, intentelo mas tarde",
            Alert.AlertType.ERROR);
        }
    }
    private void abrirPantallaPrincipal(){
        try {
            Stage ventanaPrincipal = (Stage) txtUsuario.getScene().getWindow();
            Scene escenario = new Scene(FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml")));
            ventanaPrincipal.setScene(escenario);
            ventanaPrincipal.setTitle("Sistema Tickets");
            ventanaPrincipal.show();
        } catch (IOException iOException) {
            Utilidades.mostrarAlerta("Error de sistema", "Hubo un error "
            + "al cargar la información. Por favor, inténtelo más tarde",Alert.AlertType.ERROR);
        }
        
    }
    
}
