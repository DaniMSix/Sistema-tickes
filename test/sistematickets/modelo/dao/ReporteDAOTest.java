/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistematickets.modelo.dao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistematickets.modelo.pojo.Reporte;

/**
 *
 * @author THE CHAVI’S
 */
public class ReporteDAOTest {
    
    public ReporteDAOTest() {
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
    public void testRegistrarReporteExito() {
        try {
            System.out.println("registrarReporte");
            Reporte reporte = new Reporte();
            reporte.setTitulo("Mal servicio de atencion al cliente");
            reporte.setDescripcion("Fui a las oficinas de la empresa y nadie " + 
            "al paracer nadie trabaja ahí");
            reporte.getModulo().setIdModulo(6);
            reporte.getTipoReporte().setIdTipoReporte(4);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            reporte.setFechaCreacion(dtf.format(LocalDateTime.now()));
            reporte.getEstadoSolucion().setIdEstadoSolucion(1);
            ReporteDAO instance = new ReporteDAO();
            boolean resultadoEsperado = true;
            boolean resultado = instance.registrarReporte(reporte);
            assertEquals("testRegistrarReporte",resultadoEsperado, resultado);
        } catch (SQLException sQLException) {
            Logger.getLogger(ReporteDAOTest.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }

    @Test
    public void testRegistrarReporteError() {
        try {
            System.out.println("registrarReporte");
            Reporte reporte = new Reporte();
            reporte.setDescripcion("Fui a las oficinas de la empresa y nadie " + 
            "al paracer nadie trabaja ahí");
            reporte.getModulo().setIdModulo(6);
            reporte.getTipoReporte().setIdTipoReporte(4);
            reporte.getEstadoSolucion().setIdEstadoSolucion(1);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            reporte.setFechaCreacion(dtf.format(LocalDateTime.now()));
            ReporteDAO reporteDao = new ReporteDAO();
            boolean resultadoEsperado = false;
            boolean resultado = reporteDao.registrarReporte(reporte);
            assertEquals("testRegistrarReporte",resultadoEsperado, resultado);
        } catch (SQLException sQLException) {
            Logger.getLogger(ReporteDAOTest.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }
    
    @Test
    public void testObtenerReportesExito(){
        System.out.println("obtenerReportes");
        ReporteDAO reporteDao = new ReporteDAO();
        Reporte reporte = new Reporte();
        reporte.setTitulo("Me trataron");
        reporte.setDescripcion("Los repartidores fueron groceros");
        reporte.setIdReporte(26);
        reporte.setFechaCreacion("2022-05-14");
        ArrayList<Reporte> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(reporte);
        ArrayList<Reporte> resultado;
        try {
            resultado = reporteDao.obtenerReportes();
            assertEquals(" testObtenerReportes",resultadoEsperado.get(0), resultado.get(1));
        } catch (SQLException sQLException) {
            Logger.getLogger(ReporteDAOTest.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }
    
     @Test
    public void testObtenerReportesError(){
        System.out.println("obtenerReportes");
        ReporteDAO reporteDao = new ReporteDAO();
        Reporte reporte = new Reporte();
        reporte.setTitulo("Me tratron");
        reporte.setDescripcion("Los repartidores fueron groceros");
        reporte.getModulo().setIdModulo(5);
        reporte.getTipoReporte().setIdTipoReporte(1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        reporte.setFechaCreacion(dtf.format(LocalDateTime.now()));
        ArrayList<Reporte> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(reporte);
        ArrayList<Reporte> resultado;
        try {
            resultado = reporteDao.obtenerReportes();
            assertEquals(" testObtenerReportes",resultadoEsperado.get(0), resultado.get(0));
        } catch (SQLException sQLException) {
            Logger.getLogger(ReporteDAOTest.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }
}
