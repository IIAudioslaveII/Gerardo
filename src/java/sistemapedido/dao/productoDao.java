/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.dao;

import java.util.List;
import sistemapedido.modelo.Producto;

/**
 *
 * @author Audioslave
 */
public interface productoDao {
       
    public boolean create(Producto producto);
    public List getProductosAll();
    public boolean update(Producto producto);
    public boolean delete(Integer id);
}
