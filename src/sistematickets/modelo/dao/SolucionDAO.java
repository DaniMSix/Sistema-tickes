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
import sistematickets.modelo.DataBaseConnection;
import sistematickets.modelo.pojo.Empleado;
import sistematickets.modelo.pojo.Reporte;
import sistematickets.modelo.pojo.Solucion;

/**
 *
 * @author Panther
 */
public class SolucionDAO {
    public Solucion obtenerSolucionPorIdReporte(Reporte reporte)throws SQLException{
        Solucion solucionReporte = new Solucion();
        DataBaseConnection dataBase = new DataBaseConnection();
        String consulta = "SELECT Descripcion,fechaSolucion FROM solucion WHERE idReporte = ?;";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, reporte.getIdReporte());
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (!resultadoConsulta.next()) {
            }else{
                solucionReporte.setDescripcion(resultadoConsulta.getString("Descripcion"));
                solucionReporte.setFechaSolucion(resultadoConsulta.getDate("fechaSolucion").toString());
            }
        }finally{
            dataBase.desconectar();
        }
        return solucionReporte;
    }
    
    public Empleado obtenerNombreEncargadoPorId(Solucion solucion)throws SQLException{
        Empleado empleadoNombre = new Empleado();
        DataBaseConnection dataBase = new DataBaseConnection();
        String consulta = "SELECT nombre from empleados, solucion where solucion.IdEmpleado = ?;";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (!resultadoConsulta.next()) {
            }else{
                
            }
        }finally{
            dataBase.desconectar();
        }
        return empleadoNombre;
    }
}
