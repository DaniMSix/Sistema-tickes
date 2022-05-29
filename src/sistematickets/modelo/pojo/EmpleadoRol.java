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
public class EmpleadoRol {
    int idEmpleadoRol;
    Usuario usuario;
    Rol rol;
    Empleado empleado;
    
    public EmpleadoRol(){
        this.usuario = new Usuario();
        this.rol = new Rol();
        this.empleado = new Empleado();
    }

    public int getIdEmpleadoRol() {
        return idEmpleadoRol;
    }

    public void setIdEmpleadoRol(int idEmpleadoRol) {
        this.idEmpleadoRol = idEmpleadoRol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empleado getEmpledo() {
        return empleado;
    }

    public void setEmpledo(Empleado empledo) {
        this.empleado = empleado;
    }
}
