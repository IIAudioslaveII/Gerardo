/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.modelo;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Audioslave
 */
  @ManagedBean
    
    @Entity 
    @Table(name="producto")
public class Producto implements Serializable {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private int idProducto;
    private String nomnProducto;
    private double precioU;
    private int Stock;
    private int idCategoria;

    public Producto( String nomnProducto, double precioU, int Stock, int idCategoria) {
        this.nomnProducto = nomnProducto;
        this.precioU = precioU;
        this.Stock = Stock;
        this.idCategoria = idCategoria;
    }

    public Producto() {
    }

    
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomnProducto() {
        return nomnProducto;
    }

    public void setNomnProducto(String nomnProducto) {
        this.nomnProducto = nomnProducto;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
}
