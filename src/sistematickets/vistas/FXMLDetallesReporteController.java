/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematickets.vistas;

import java.net.URL;
import java.sql.SQLException;
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
import sistematickets.modelo.dao.SolucionDAO;
import sistematickets.modelo.pojo.Empleado;
import sistematickets.modelo.pojo.Reporte;
import sistematickets.modelo.pojo.Solucion;
import sistematickets.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLDetallesReporteController implements Initializable {

    @FXML
    private TextField tfTitulo;
    @FXML
    private TextField tfFechaCreacion;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private TextArea taSolucion;
    @FXML
    private TextField tfFechaSolucion;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfModulo;
    @FXML
    private TextField tfTipoReporte;
    
    private Reporte reporteDetalle;
    
    private Empleado empleadoNombre;
    @FXML
    private TextField tfEncargado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void configurarEscena(Reporte reporteDetalle){
        this.reporteDetalle = reporteDetalle;
        cargarInformacionReporte();
        configurarComponentes();
    }
    
    private void cargarInformacionReporte(){
        tfTitulo.setText(reporteDetalle.getTitulo());
        tfFechaCreacion.setText(reporteDetalle.getFechaCreacion());
        taDescripcion.setText(reporteDetalle.getDescripcion());
        tfEstado.setText(reporteDetalle.getEstadoSolucion().toString());
        tfModulo.setText(reporteDetalle.getModulo().toString());
        tfTipoReporte.setText(reporteDetalle.getTipoReporte().toString());
        
                
        try {
            taSolucion.setText(obtenerSolucionReporte().getDescripcion());
            tfFechaSolucion.setText(obtenerSolucionReporte().getFechaSolucion());
            //tfEncargado.setText(obtenerNombreEmpleado().getNombre());
        } catch (SQLException sQLException) {
            Utilidades.mostrarAlerta ("Error de conexión",
            "Por el momento no hay conexión con la Base de Datos", Alert.AlertType.ERROR);
        }
    }
    
    private Solucion obtenerSolucionReporte() throws SQLException{
        SolucionDAO solucionReporteDAO = new SolucionDAO();
        Solucion solucionReporte = solucionReporteDAO.obtenerSolucionPorIdReporte(reporteDetalle);
        return solucionReporte;
    }
    
    
    
    private void configurarComponentes(){
        tfEstado.setEditable(false);
        tfModulo.setEditable(false);
        tfTipoReporte.setEditable(false);
        taDescripcion.setEditable(false);
        taSolucion.setEditable(false);
        tfFechaCreacion.setEditable(false);
        tfFechaSolucion.setEditable(false);
        tfTitulo.setEditable(false);
        tfEncargado.setEditable(false);
    }

    @FXML
    private void salirVentana(ActionEvent event) {
        Optional<ButtonType> respuestaDialogo = Utilidades.mostrarAlertas("Salir",
        "¿Está seguro que desea salir?", Alert.AlertType.CONFIRMATION);
        if (respuestaDialogo.get() == ButtonType.OK) {
            Stage escenarioPrincipal = (Stage) tfTipoReporte.getScene().getWindow();
            escenarioPrincipal.close();
        }
    }
}
