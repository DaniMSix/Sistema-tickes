/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistematickets.modelo.DataBaseConnection;
import sistematickets.modelo.pojo.Empleado;
import sistematickets.modelo.pojo.Solucion;

/**
 *
 * @author DMS19
 */
public class EmpleadoDAO {
    /*
    public Solucion obtenerNombreEncargadoPorId(Empleado empleado)throws SQLException{
        Solucion nombreEmpleado = new Solucion();
        DataBaseConnection dataBase = new DataBaseConnection();
        String consulta = "SELECT nombre from empleados, solucion where empleados.IdEmpleado = ?;";
        try(Connection conexion = dataBase.getConexion()){
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, empleado.getIdEmpleado());
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (!resultadoConsulta.next()) {
            }else{
                nombreEmpleado.
            }
        }finally{
            dataBase.desconectar();
        }
        return nombreEmpleado;
    }
    */
}
