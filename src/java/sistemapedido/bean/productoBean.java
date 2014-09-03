    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import sistemapedido.dao.clienteDao;
import sistemapedido.dao.impl.clienteImpl;
import sistemapedido.dao.impl.productoImpl;
import sistemapedido.dao.productoDao;
import sistemapedido.modelo.Producto;

/**
 *
 * @author Audioslave
 */
@ManagedBean
@RequestScoped
public class productoBean {
    
    private List<Producto> productos;
    private Producto selectedProducto;

    
      
    public productoBean() {
        selectedProducto = new Producto();
        this.productos = new ArrayList<Producto>();
    }
    
    
    public List<Producto> getProductos() {
        productoDao dao = new productoImpl();
        productos = dao.getProductosAll();
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    } 
    
    public void crear() {
        productoDao ProductoDao = new productoImpl();
        String msg;
        if (ProductoDao.create(selectedProducto)) {
            msg = "Se creo correctamente el registro ";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al crear el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    
    public void eliminar(int i) {
        String msg;
        productoDao ProductoDao = new productoImpl();
        if (ProductoDao.delete(i)) {
            msg = "Se elimino correctamente el registro ";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
    
    
    
    

