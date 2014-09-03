/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.modelo;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
    
    @Entity 
    @Table(name="cliente")
public class Cliente implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
        @Column(name = "IDCLIENTE")
        private int idCliente;
        @Column(name = "APELLIDO")
        private String apellido;
        @Column(name = "NOMBRE")
        private String nombre;
        @Column (name="DIRECCION")
        private String direccion;   
        @Column(name="TELEFONO")
        private int telefono;
        @Column(name = "USUARIO")
        private String usuario;
        @Column(name = "CONTRASEÑA")
        private String contraseña;

    public Cliente() {
    }

    public Cliente(int idCliente, String apellido, String nombre, String direccion, int telefono, String usuario, String contraseña) {
        this.idCliente= idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
 }