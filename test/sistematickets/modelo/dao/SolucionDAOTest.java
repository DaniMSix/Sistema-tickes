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
import sistematickets.modelo.pojo.Reporte;
import sistematickets.modelo.pojo.Solucion;

/**
 *
 * @author THE CHAVI’S
 */
public class SolucionDAOTest {
    
    public SolucionDAOTest() {
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

    /**
     * Test of obtenerSolucionPorIdReporte method, of class SolucionDAO.
     */
    @Test
    public void testObtenerSolucionPorIdReporteExito() {
        System.out.println("obtenerSolucionPorIdReporte");
        Reporte reporte = new Reporte();
        SolucionDAO solucionDao = new SolucionDAO();
        Solucion resultadoEsperado = new Solucion();
        resultadoEsperado.setDescripcion("Se hablo con los repartidores y fueron " + 
        "despedidos ya que contaban con varias quejas previas de la misma índole.");
        resultadoEsperado.setFechaSolucion("2022-05-25");
        Solucion resultado;
        try {
            reporte.setIdReporte(26);
            resultado = solucionDao.obtenerSolucionPorIdReporte(reporte);
            assertEquals(resultadoEsperado, resultado);
        } catch (SQLException sQLException) {
            Logger.getLogger(SolucionDAOTest.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }
    
    @Test
    public void testObtenerSolucionPorIdReporteError() throws Exception {
        System.out.println("obtenerSolucionPorIdReporte");
        Reporte reporte = new Reporte();
        SolucionDAO solucionDao = new SolucionDAO();
        Solucion resultadoEsperado = new Solucion();
        resultadoEsperado.setDescripcion("Se hablo con los repartidores y fueron " + 
        "despedidos ya que contaban con varias quejas previas de la misma índole.");
        resultadoEsperado.setFechaSolucion("2022-10-25");
        Solucion resultado;
        try {
            reporte.setIdReporte(26);
            resultado = solucionDao.obtenerSolucionPorIdReporte(reporte);
            assertEquals(resultadoEsperado, resultado);
        } catch (SQLException sQLException) {
            Logger.getLogger(SolucionDAOTest.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }
}
