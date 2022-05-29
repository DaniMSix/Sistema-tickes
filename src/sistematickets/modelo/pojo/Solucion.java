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
public class Solucion {
    
    private int idSolucion;
    private String descripcion;
    private String fechaSolucion;
    private int idEstado;
    private int idReporte;
    private int idEmpleado;

    public Solucion() {
    }

    public Solucion(int idSolucion, String descripcion, String fechaSolucion, int idEstado,
    int idReporte, int idEmpleado) {
        this.idSolucion = idSolucion;
        this.descripcion = descripcion;
        this.fechaSolucion = fechaSolucion;
        this.idEstado = idEstado;
        this.idReporte = idReporte;
        this.idEmpleado = idEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(String fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public int getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(int idSolucion) {
        this.idSolucion = idSolucion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString(){
        return "Solucion: " + descripcion + " Fecha: " + fechaSolucion;
    }
    
    @Override
    public boolean equals(Object object) {
        boolean isEquals=false;
        if (object == this) {
            isEquals=true;
        }
        if (object!= null && object instanceof Solucion) {
            Solucion other = (Solucion) object;
            isEquals = this.getDescripcion().equals(other.getDescripcion()) &&
                    this.getFechaSolucion().equals(other.getFechaSolucion());
        }
        return isEquals;
    }
}
