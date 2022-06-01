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
import sistematickets.modelo.pojo.Usuario;
import sistematickets.util.Constantes;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {
    public Usuario iniciarSesion(String nombreUsuario, String contrasenia) throws SQLException{
        Usuario usuarioAIdentificar = new Usuario();
        DataBaseConnection dataBase = new DataBaseConnection();
        String consulta = "SELECT* FROM usuarios WHERE (usuario = ?) AND (contrasena = ?);";
        try (Connection conexion = dataBase.getConexion()){
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreUsuario); 
            sentencia.setString(2, contrasenia);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if(resultadoConsulta.next()){
                usuarioAIdentificar.setIdUsuario(resultadoConsulta.getInt("IdUsuario"));
                usuarioAIdentificar.setNombreUsuario(resultadoConsulta.getString("usuario"));
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