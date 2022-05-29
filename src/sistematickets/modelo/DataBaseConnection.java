/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematickets.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author Usuario
 */

public class DataBaseConnection {
    private Connection conexion;   
    
    public Connection getConexion() throws SQLException{
        conectar();
        return conexion;
    }
    
    public void conectar() throws SQLException {
        String directoryName = System.getProperty("user.dir");
        String absolute = directoryName + "\\src\\sistematickets\\modelo\\DBConfig.txt";
        try {
            FileInputStream archivoConfiguracion = new FileInputStream(absolute);
            Properties atributos = new Properties();
            atributos.load(archivoConfiguracion);
            archivoConfiguracion.close();
            String direccionBD = atributos.getProperty("DireccionBD");
            String usuario = atributos.getProperty("Usuario");
            String contrasenia = atributos.getProperty("Contrasenia");
            conexion = DriverManager.getConnection(direccionBD, usuario, contrasenia);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException iOException){
            System.out.println(iOException.getMessage());
        }
    }
    
    public void desconectar() throws SQLException{
        if (conexion!=null){
            if (!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}