/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets.modelo.pojo;



/**
 *
 * @author Usuario
 */
public class Usuario {
    private Integer idUsuario;
    private String nombreUsuario;
    private String contrasenia;
    private Integer codigoRespuesta;
    private Integer rol;
    
    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }
    

    public Usuario() {
    }

 /*   public Usuario(Integer idUsuario, String nombreUsuario, String contrasenia, Integer codigoRespuesta) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.codigoRespuesta = codigoRespuesta;
    }*/

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idCliente) {
        this.idUsuario = idCliente;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String username) {
        this.nombreUsuario = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String password) {
        this.contrasenia = password;
    }

    public Integer getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(Integer codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }
    
    @Override
    public String toString(){
        return "IdUsuario: " + idUsuario + " Nombre: " + nombreUsuario +
        " Codigo de respuesta a identificacion: " + codigoRespuesta;
    }
    
    @Override
    public boolean equals(Object object) {
        boolean isEquals=false;
        if (object == this) {
            isEquals=true;
        }
        if (object!= null && object instanceof Usuario) {
            Usuario other = (Usuario) object;
            isEquals = this.getIdUsuario().equals(other.getIdUsuario()) &&
                    this.getNombreUsuario().equals(other.getNombreUsuario());
        }
        return isEquals;
    }
}
