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
public class ClienteUsuario {
    Usuario usuario;
    Cliente cliente;
    
    public ClienteUsuario(){
        this.usuario = new Usuario();
        this.cliente = new Cliente();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
