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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sistematickets.modelo.dao.ReporteDAO;
import sistematickets.modelo.pojo.Reporte;
import sistematickets.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLHistorialReportesController implements Initializable {

    @FXML
    private TableView<Reporte> tbReportes;
    @FXML
    private TableColumn colTitulo;
    @FXML
    private TableColumn colDescripcion;
    @FXML
    private TableColumn colFecha;
    @FXML
    private TableColumn colModulo;
    @FXML
    private TableColumn colTipoReporte;
    @FXML
    private TableColumn colEstado;
    @FXML
    private TextField tfBuscar;
    
    private ObservableList<Reporte> listReporte;
    private ArrayList<Reporte> reportes;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarColumnasTablaReportes();
        cargarInformacion();
        configurarBusquedaReportes();
    }    
    
    
    private void inicializarColumnasTablaReportes() {
        colTitulo.setCellValueFactory (new PropertyValueFactory("titulo"));
        colDescripcion.setCellValueFactory (new PropertyValueFactory ("descripcion"));
        colFecha.setCellValueFactory (new PropertyValueFactory ("fechaCreacion"));
        colModulo.setCellValueFactory (new PropertyValueFactory ("modulo"));
        colTipoReporte.setCellValueFactory (new PropertyValueFactory ("tipoReporte"));
        colEstado.setCellValueFactory(new PropertyValueFactory("estadoSolucion"));
        listReporte = FXCollections.observableArrayList();
    }
    
    private void cargarInformacion() {
        try{
            ReporteDAO reporteDAO = new ReporteDAO();
            ArrayList<Reporte> resultadoConsulta = reporteDAO.obtenerReportes();
            listReporte.addAll(resultadoConsulta);
            tbReportes.setItems(listReporte);
        } catch (SQLException sQLException) {
            Utilidades.mostrarAlerta ("Error de conexión",
            "Por el momento no hay conexión con la Base de Datos", Alert.AlertType.ERROR);
        }
    }
    
    private void valorSeleccionadoTablaReportes(){
        int filaSeleccionada = tbReportes.getSelectionModel().getSelectedIndex();
        if(filaSeleccionada >= 0){
            Reporte reporte = listReporte.get(filaSeleccionada);
            abrirVentanaDetallesReporte(reporte, "Detalles Reporte", "FXMLDetallesReporte.fxml");
        }else{
            Utilidades.mostrarAlerta("Alumno no seleccionado",
            "Para editar la informacion de un alumno debes seleccionarlo de la tabla", 
            Alert.AlertType.WARNING);
        }
    }
    
    private void abrirVentanaDetallesReporte(Reporte reporte, String titulo, String ventana){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ventana));
            Parent root = loader.load();
            FXMLDetallesReporteController controladorDetalles = loader.getController();
            controladorDetalles.configurarEscena(reporte);
            Scene escenaFormulario = new Scene(root);
            Stage escenarioFormulario = new Stage();
            escenarioFormulario.setResizable(false);
            escenarioFormulario.setScene(escenaFormulario);
            escenarioFormulario.setTitle(titulo);
            escenarioFormulario.initModality(Modality.APPLICATION_MODAL);
            escenarioFormulario.showAndWait();
        } catch (IOException iOException) {
            Utilidades.mostrarAlerta("Error de sistema", "Hubo un error "
            + "al cargar la información. Por favor, inténtelo más tarde",Alert.AlertType.ERROR);
        }
    }
    
    private void configurarBusquedaReportes(){
        if(listReporte.size() > 0){
            FilteredList<Reporte> listaFiltrada = new FilteredList<>(listReporte,p->true);
            tfBuscar.textProperty().addListener(new ChangeListener<String>(){
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    listaFiltrada.setPredicate(predicate ->{
                        if(newValue == null || newValue.isEmpty()){
                            return true;
                        }
                        if(predicate.getTitulo().toLowerCase().contains(newValue.toLowerCase())){
                            return true;
                        }
                        if(predicate.getEstadoSolucion().getDescripcion().toLowerCase().contains(newValue.toLowerCase())){
                            return true;
                        }
                        return false;
                    });
                    
                }
                
            });
            SortedList<Reporte> ordenamientoReportes = new SortedList<>(listaFiltrada);
            ordenamientoReportes.comparatorProperty().bind(tbReportes.comparatorProperty());
            tbReportes.setItems(ordenamientoReportes);
        }
    }
    
    @FXML
    private void clickDetalles(MouseEvent event) {
        if(event.getClickCount() == 2){
            valorSeleccionadoTablaReportes();
        }
    }
    
}
