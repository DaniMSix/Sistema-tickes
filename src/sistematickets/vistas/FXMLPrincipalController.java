/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematickets.vistas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sistematickets.modelo.dao.ReporteDAO;
import sistematickets.modelo.pojo.Reporte;
import sistematickets.util.Utilidades;


public class FXMLPrincipalController implements Initializable { 

    @FXML
    private Menu menuAdmin;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void tipoMenu(int rol){   
        switch(rol){
            case 0:
                menuAdmin.setVisible(false);
                break;
            default:
                    break;
                
        }
    }
    


    private void abrirVentana(String titulo, String rutaVentana){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaVentana));
            Parent root = loader.load();
            Scene escenarioVentana = new Scene(root);
            Stage ventana = new Stage();
            ventana.setResizable(false);
            //ventana.getIcons().add(new Image("sistematickets/img/directorio.png"));
            ventana.setScene(escenarioVentana);
            ventana.setTitle(titulo);
            ventana.initModality(Modality.APPLICATION_MODAL);
            ventana.showAndWait();
        } catch (IOException iOException) {
            Utilidades.mostrarAlerta("Error de sistema", "Hubo un error "
            + "al cargar la información. Por favor, inténtelo más tarde",Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void abrirVentanaSugerencias(ActionEvent event) {
        abrirVentana("Sugerencias","FXMLSugerencias.fxml");
    }
    
    @FXML
    private void abrirVentanaHistorialReportes(ActionEvent event) {
        ArrayList<Reporte> resultadoConsulta = null;
        try {
            ReporteDAO reporteDAO = new ReporteDAO();
            resultadoConsulta = reporteDAO.obtenerReportes();
        } catch (SQLException sQLException) {
            Utilidades.mostrarAlerta ("Error de conexión",
            "Por el momento no hay conexión con la Base de Datos", Alert.AlertType.ERROR);
        }
        if(!resultadoConsulta.isEmpty()){
            abrirVentana("Historial de reportes", "FXMLHistorialReportes.fxml");
        }else{
            Utilidades.mostrarAlerta("No hay reportes", "Aún no existen reportes registrados", 
            Alert.AlertType.INFORMATION);
        }
        
    }
}
