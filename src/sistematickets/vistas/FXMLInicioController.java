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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
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
            usuarioAIdentificar = usuarioDAO.IniciarSesionCliente(username, password);
            //CRear dos usuarios usuarioAIdentificar2 = IniciarSesion(username, password)
            //if()
            if(usuarioAIdentificar.getCodigoRespuesta() == Constantes.CODIGO_OPERACION_CORRECTA){
                Utilidades.mostrarAlerta("Usuario verificado","Bienvenido(a) al sistema",
                Alert.AlertType.INFORMATION);
                abrirPantallaPrincipal(usuarioAIdentificar.getRol());
                //else if
                // Comprobobar usuarioAIdentificar2 copiar de lo arriba 
                //abrirPantallaPrincipal(usuarioAIdentificar2.getRol());
                
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
    private void abrirPantallaPrincipal(int rol){
        try {
            Stage ventanaPrincipal = new Stage();
            FXMLLoader loader = new FXMLLoader();         
            Parent escenario = loader.load(getClass().getResource("/sistematickets/vistas/FXMLPrincipal.fxml").openStream());
            FXMLPrincipalController principalController = (FXMLPrincipalController) loader.getController();
            principalController.tipoMenu(rol);
            Scene scene = new Scene(escenario);
            ventanaPrincipal.setScene(scene);
            ventanaPrincipal.setTitle("Sistema Tickets");
            ventanaPrincipal.initModality(Modality.APPLICATION_MODAL);
            ventanaPrincipal.show();
            
            Stage stageActual = (Stage) txtUsuario.getScene().getWindow();
            Stage stage = (Stage) stageActual.getScene().getWindow();
            stage.close();
            
            /*Stage menu = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("/uv/fei/gui/interfaces/Menu.fxml"));
            MenuController menuController = (MenuController) loader.getController();
            menuController.recibirParametrosTesista(tesista);
            Scene scene = new Scene(root);
            menu.setScene(scene);
            menu.setTitle("Menu de tesista");
            menu.alwaysOnTopProperty();
            menu.getIcons().add(new Image("/uv/fei/Img/book.png"));
            
            menu.show();*/


            
        } catch (IOException iOException) {
            //Utilidades.mostrarAlerta("Error de sistema 6", "Hubo un error "
            //+ "al cargar la información. Por favor, inténtelo más tarde",Alert.AlertType.ERROR);
            Logger.getLogger(FXMLInicioController.class.getName()).log(Level.SEVERE, null, iOException);
        }
        
    }
    
}
