/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematickets.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;
import sistematickets.modelo.dao.ReporteDAO;
import sistematickets.modelo.pojo.EstadoSolucion;
import sistematickets.modelo.pojo.Modulo;
import sistematickets.modelo.pojo.Reporte;
import sistematickets.modelo.pojo.Solucion;
import sistematickets.modelo.pojo.TipoReporte;
import sistematickets.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLSugerenciasController implements Initializable {

    @FXML
    private TextField tfTitulo;
    @FXML
    private TextArea taDescripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void enviarSugerencia(ActionEvent event) {
        if(StringUtils.isBlank(tfTitulo.getText()) || StringUtils.isBlank(taDescripcion.getText()) ||
           StringUtils.isBlank(tfTitulo.getText()) && StringUtils.isBlank(taDescripcion.getText())) {
            Utilidades.mostrarAlerta("Campos vacios",
            "No puede dejar campos vacios. Por favor verifique que todos los campos estén llenos",
            Alert.AlertType.WARNING);
        }else{
            ReporteDAO nuevoReporteDAO = new ReporteDAO();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Reporte nuevoReporte = new Reporte();
                TipoReporte tipoReporte = new TipoReporte();
                Modulo moduloReporte = new Modulo();
                EstadoSolucion estadoSolucionReporte = new EstadoSolucion();
                estadoSolucionReporte.setIdEstadoSolucion(1);
                tipoReporte.setIdTipoReporte(4);
                moduloReporte.setIdModulo(6);
                nuevoReporte.setTitulo(tfTitulo.getText());
                nuevoReporte.setDescripcion(taDescripcion.getText());
                nuevoReporte.setTipoReporte(tipoReporte);
                nuevoReporte.setModulo(moduloReporte);
                nuevoReporte.setEstadoSolucion(estadoSolucionReporte);
                nuevoReporte.setFechaCreacion(dtf.format(LocalDateTime.now()));
            try {
                nuevoReporteDAO.registrarReporte(nuevoReporte);
                Optional<ButtonType> respuestaDialogo = Utilidades.mostrarAlertas("Información enviada",
                "¡La información ha sido enviada!", Alert.AlertType.INFORMATION);
                if (respuestaDialogo.get() == ButtonType.OK) {
                    Stage escenarioPrincipal = (Stage) taDescripcion.getScene().getWindow();
                    escenarioPrincipal.close();
                }
            } catch (SQLException e) {
                Utilidades.mostrarAlerta("Error de conexion",
                "Lo sentimos por el momento no hay conexion con la base de datos, intentelo mas tarde",
                Alert.AlertType.ERROR);
            }
        }
        
    }

    @FXML
    private void cancelarEnvioDeSugerencia(ActionEvent event) {
        Optional<ButtonType> respuestaDialogo = Utilidades.mostrarAlertas("Cancelar operación",
        "¿Está seguro que desea cancelar?", Alert.AlertType.CONFIRMATION);
        if (respuestaDialogo.get() == ButtonType.OK) {
            Stage escenarioPrincipal = (Stage) taDescripcion.getScene().getWindow();
            escenarioPrincipal.close();
        }
    }
    
}
