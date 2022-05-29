/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematickets.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistematickets.modelo.DataBaseConnection;
import sistematickets.modelo.pojo.EstadoSolucion;
import sistematickets.modelo.pojo.Modulo;
import sistematickets.modelo.pojo.Reporte;
import sistematickets.modelo.pojo.TipoReporte;

/**
 *
 * @author Usuario
 */
public class ReporteDAO {
    
    public boolean registrarReporte(Reporte reporte) throws SQLException{
        DataBaseConnection dataBase = new DataBaseConnection();
        boolean verificacionRegistro = false;
        String consulta = "INSERT INTO reporte values(NULL,?,?,?,?,?,?);";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, reporte.getDescripcion());
            sentencia.setString(2, reporte.getTitulo());
            sentencia.setDate(3, java.sql.Date.valueOf(reporte.getFechaCreacion()));
            sentencia.setInt(4, reporte.getModulo().getIdModulo());
            sentencia.setInt(5, reporte.getTipoReporte().getIdTipoReporte());
            sentencia.setInt(6, reporte.getEstadoSolucion().getIdEstadoSolucion());
            verificacionRegistro = sentencia.executeUpdate()!=0;
        }finally{
            dataBase.desconectar();
        }
        return verificacionRegistro;
    }
    
    public ArrayList<Reporte> obtenerReportes() throws SQLException {
        ArrayList<Reporte> reportesObtenidos = new ArrayList<>();
        DataBaseConnection dataBase = new DataBaseConnection();
        String consulta = "SELECT reporte.idReporte, reporte.Descripcion,reporte.Titulo, reporte.FechaCreacion, " +
        "modulo.Descripcion AS ModuloDescripcion, tiporeporte.Descripcion AS TipoReporteDescripcion, " +
        "estadosolucion.Descripcion AS Estado " +
        "FROM reporte " +
        "INNER JOIN modulo ON reporte.IdModulo = modulo.IdModulo " +
        "INNER JOIN tiporeporte ON reporte.IdTipoReporte = tiporeporte.IdTipoReporte " +
        "INNER JOIN estadosolucion ON reporte.idEstadoSolucion = estadosolucion.IdEstadoSolucion;";
        try (Connection conexion = dataBase.getConexion()) {
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            while(resultadoConsulta.next()){
                Reporte reporteEncontrado = new Reporte();
                Modulo moduloDelReporteEncontrado = new Modulo();
                TipoReporte tipoReporte = new TipoReporte();
                EstadoSolucion estadoSolucion = new EstadoSolucion();
                
                moduloDelReporteEncontrado.setDescripcion(resultadoConsulta.getString("ModuloDescripcion"));
                tipoReporte.setDescripcion(resultadoConsulta.getString("TipoReporteDescripcion"));
                estadoSolucion.setDescripcion(resultadoConsulta.getString("Estado"));
                
                reporteEncontrado.setIdReporte(resultadoConsulta.getInt("idReporte"));
                reporteEncontrado.setTitulo(resultadoConsulta.getString("Titulo"));
                reporteEncontrado.setDescripcion(resultadoConsulta.getString("Descripcion"));
                reporteEncontrado.setFechaCreacion(resultadoConsulta.getDate("FechaCreacion").toString());
                reporteEncontrado.setModulo(moduloDelReporteEncontrado);
                reporteEncontrado.setTipoReporte(tipoReporte);
                reporteEncontrado.setEstadoSolucion(estadoSolucion);
                reportesObtenidos.add(reporteEncontrado);
            }
        } finally {
            dataBase.desconectar();
        }
        return reportesObtenidos;
    }
}
