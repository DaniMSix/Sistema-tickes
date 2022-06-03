/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import passwordencryptor.SHA_512;
import sistematickets.modelo.DataBaseConnection;
import sistematickets.modelo.pojo.Usuario;
import sistematickets.util.Constantes;


        
   public class UsuarioDAO {
    public Usuario iniciarSesion(String nombreUsuario, String contrasenia) throws SQLException{
        Usuario usuarioAIdentificar = new Usuario();
        DataBaseConnection dataBase = new DataBaseConnection();
        //SHA_512 encriptador = new SHA_512();
        String consulta = "SELECT U.IdUsuario, U.usuario, CU.IdEmpleado FROM usuarios U inner "
                        + "join empleadosroles CU ON CU.IdUsuario  = U.IdUsuario "
                        + "WHERE usuario = ? AND contrasena = ?;";
        try (Connection conexion = dataBase.getConexion()){
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreUsuario); 
            sentencia.setString(2, contrasenia);
            // sentencia.setString(2, encriptador.getSHA512(contrasenia));
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if(resultadoConsulta.next()){
                usuarioAIdentificar.setIdUsuario(resultadoConsulta.getInt("IdUsuario"));
                usuarioAIdentificar.setNombreUsuario(resultadoConsulta.getString("usuario"));
                usuarioAIdentificar.setRol(resultadoConsulta.getInt("IdEmpleado"));
                usuarioAIdentificar.setCodigoRespuesta(Constantes.CODIGO_OPERACION_CORRECTA);
                
            }else{
                usuarioAIdentificar.setCodigoRespuesta(Constantes.CODIGO_CREDENCIALES_INCORRECTAS);
            }
        }finally{
            dataBase.desconectar();
        }
        return usuarioAIdentificar;
    }
    
    public Usuario iniciarSesionCliente(String nombreUsuario, String contrasenia) throws SQLException{
        Usuario usuarioAIdentificar = new Usuario();
        DataBaseConnection dataBase = new DataBaseConnection();
        //SHA_512 encriptador = new SHA_512();
        String consulta = "SELECT U.IdUsuario, U.usuario, CU.IdRol FROM usuarios U " +
                          "inner join clientesusuarios CU ON CU.IdUsuario = U.IdUsuario " +
                          "WHERE usuario = ? AND contrasena = ?;";
        try (Connection conexion = dataBase.getConexion()){
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreUsuario); 
            sentencia.setString(2, contrasenia);
            // sentencia.setString(2, encriptador.getSHA512(contrasenia));
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if(resultadoConsulta.next()){
                usuarioAIdentificar.setIdUsuario(resultadoConsulta.getInt("IdUsuario"));
                usuarioAIdentificar.setNombreUsuario(resultadoConsulta.getString("usuario"));
                usuarioAIdentificar.setRol(resultadoConsulta.getInt("IdRol"));
                usuarioAIdentificar.setCodigoRespuesta(Constantes.CODIGO_OPERACION_CORRECTA);
                
            }else{
                usuarioAIdentificar.setCodigoRespuesta(Constantes.CODIGO_CREDENCIALES_INCORRECTAS);
            }
        }finally{
            dataBase.desconectar();
        }
        return usuarioAIdentificar;
    }
}