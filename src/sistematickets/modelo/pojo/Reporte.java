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
public class Reporte {
    private int idReporte;
    private String descripcion;
    private String titulo;
    private String fechaCreacion;
    private EstadoSolucion estadoSolucion;
    private Modulo modulo;
    private TipoReporte tipoReporte;

    public Reporte() {
        this.modulo = new Modulo();
        this.tipoReporte = new TipoReporte();
        this.estadoSolucion = new EstadoSolucion();
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public TipoReporte getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(TipoReporte tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public EstadoSolucion getEstadoSolucion() {
        return estadoSolucion;
    }

    public void setEstadoSolucion(EstadoSolucion estadoSolucion) {
        this.estadoSolucion = estadoSolucion;
    }
    
    @Override
    public String toString(){
        return "Id reporte: " + idReporte + " Descripcion: " + descripcion + " Titulo: " + titulo + 
        " Fecha: " + fechaCreacion + " Modulo: " + modulo.toString() + " Tipo: " + tipoReporte.toString() + "";
    }
    
    @Override
    public boolean equals(Object object) {
        boolean isEquals=false;
        if (object == this) {
            isEquals=true;
        }
        if (object!= null && object instanceof Reporte) {
            Reporte other = (Reporte) object;
            isEquals=this.getIdReporte() == other.getIdReporte() &&
                    this.getDescripcion().equals(other.getDescripcion()) &&
                    this.getTitulo().equals(other.getTitulo()) &&
                    this.getFechaCreacion().equals(other.getFechaCreacion());
        }
        return isEquals;
    }
}
