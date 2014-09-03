/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import sistemapedido.dao.clienteDao;
import sistemapedido.dao.impl.clienteImpl;
import sistemapedido.modelo.Cliente;

/**
 *
 * @author Audioslave
 */

@ManagedBean
@RequestScoped
public class clienteBean implements Serializable{
    
  

    private List<Cliente> clientes;
    private Cliente clienteSelected;
    

      
    public clienteBean() {
        clienteSelected = new Cliente();
        this.clientes = new ArrayList<Cliente>();
    }

    public List<Cliente> getClientes(){
          clienteDao dao = new clienteImpl();
        this.clientes = dao.getClientesAll();
        return clientes;
    }
    

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getClienteSelected() {
        
        return clienteSelected;
    }

    public void setClienteSelected(Cliente clienteSelected) {
        this.clienteSelected = clienteSelected;
    }

    public void crear() {
        clienteDao ClienteDao = new clienteImpl();
        String msg;
        if (ClienteDao.create(clienteSelected)) {
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
        System.out.println("Codigo:"+ clienteSelected.getIdCliente());
        clienteDao ClienteDao = new clienteImpl();
        String msg;
        if (ClienteDao.deleteC(i)){
            msg = "Se elimino correctamente el registro ";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void actualizar(Cliente cliente){
        clienteDao ClienteDao= new clienteImpl();
        String msg;
        if(ClienteDao.update(cliente)){
            System.out.println("CLIENTEEE APELLIDO "+clienteSelected.getApellido());
            msg="se actualizo correctamente";
           FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
           FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="error al actualizar";
           FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
           FacesContext.getCurrentInstance().addMessage(null, message);
                    
        }
        
        
        
 
    }   
    

    
}