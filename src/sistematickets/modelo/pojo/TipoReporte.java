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
public class TipoReporte {
    private Integer idTipoReporte;
    private String descripcion;

    public TipoReporte() {
    }
    
    public TipoReporte(Integer idTipoReporte, String descripcion) {
        this.idTipoReporte = idTipoReporte;
        this.descripcion = descripcion;
    }

    public TipoReporte(Integer idTipoReporte) {
        this.idTipoReporte = idTipoReporte;
    }
    
    public Integer getIdTipoReporte() {
        return idTipoReporte;
    }

    public void setIdTipoReporte(Integer idTipoReporte) {
        this.idTipoReporte = idTipoReporte;
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
