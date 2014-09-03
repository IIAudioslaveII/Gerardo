/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import sistemapedido.dao.categoriaDao;
import sistemapedido.dao.impl.categoriaImpl;
import sistemapedido.modelo.Categoria;

/**
 *
 * @author Audioslave
 */
@ManagedBean
@RequestScoped
public class categoriaBean {
    private List<SelectItem> selectItemsCategorias;
    private List<Categoria> categorias;
    private Categoria selectedCategoria;
    
    private String itemSeleccionado;
    
    private int idItemSeleccionado;

    public int getIdItemSeleccionado() {
        return idItemSeleccionado;
    }

    public void setIdItemSeleccionado(int idItemSeleccionado) {
        this.idItemSeleccionado = idItemSeleccionado;
    }


    public String getItemSeleccionado() {
        return itemSeleccionado;
    }

    public void setItemSeleccionado(String itemSeleccionado) {
        this.itemSeleccionado = itemSeleccionado;
    }
    
    
    
    
    /**
     * 
     * Creates a new instance of categoriaBean
     */
    public categoriaBean() {
        selectedCategoria = new Categoria();
        this.categorias = new ArrayList<Categoria> ();
        
        
        
        
        this.selectItemsCategorias = new ArrayList<SelectItem>();
        categoriaDao dao = new categoriaImpl();
        List<Categoria> categoriaselect = dao.getCategoriasAll();
        for (Categoria categoria : categoriaselect) {
            SelectItem selectItem = new SelectItem(categoria.getIdCategoria(),categoria.getNombCategoria() );
            this.selectItemsCategorias.add(selectItem);
        }   
        
        
        
        
    }

    public List<SelectItem> getSelectItemsCategorias() {       
        return selectItemsCategorias;
    }
    

    public void setSelectItemsCategorias(List<SelectItem> selectItemsCategorias) {
        this.selectItemsCategorias = selectItemsCategorias;
    }
    
    
    
    
    
    
    
}
