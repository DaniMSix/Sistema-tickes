/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematickets.modelo.pojo;

/**
 *
 * @author Usuario
 */
public class Modulo {
    private Integer idModulo;
    private String descripcion;

    public Modulo() {
    }

    public Modulo(Integer idModulo, String descripcion) {
        this.idModulo = idModulo;
        this.descripcion = descripcion;
    }

    public Modulo(Integer idModulo) {
        this.idModulo = idModulo;
    }
    
    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
}
