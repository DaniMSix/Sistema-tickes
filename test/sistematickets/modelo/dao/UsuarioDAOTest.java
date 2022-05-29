/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistematickets.modelo.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistematickets.modelo.pojo.Usuario;
import sistematickets.util.Constantes;

/**
 *
 * @author THE CHAVI’S
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIniciarSesionExito() {
        System.out.println("iniciarSesion");
        String nombreUsuario = "CeciliaL";
        String contrasenia = "2R1IHN3F";
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario resultadoEsperado = new Usuario();
        resultadoEsperado.setNombreUsuario("CeciliaL");
        resultadoEsperado.setIdUsuario(2);
        resultadoEsperado.setCodigoRespuesta(Constantes.CODIGO_OPERACION_CORRECTA);
        Usuario resultado;
        try {
            resultado = usuarioDao.iniciarSesion(nombreUsuario, contrasenia);
            assertEquals(resultadoEsperado, resultado);
        } catch (SQLException sQLException) {
            Logger.getLogger(UsuarioDAOTest.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }
    
    @Test
    public void testIniciarSesionError() {
        System.out.println("iniciarSesion");
        String nombreUsuario = "CeciliaL";
        String contrasenia = "2R1IHNF";
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario resultadoEsperado = new Usuario();
        resultadoEsperado.setNombreUsuario("CeciliaL");
        resultadoEsperado.setIdUsuario(2);
        resultadoEsperado.setCodigoRespuesta(401);
        Usuario resultado;
        try {
            resultado = usuarioDao.iniciarSesion(nombreUsuario, contrasenia);
            assertEquals(resultadoEsperado, resultado);
        } catch (SQLException sQLException) {
            Logger.getLogger(UsuarioDAOTest.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }
}
