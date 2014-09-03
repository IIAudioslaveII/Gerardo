/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.dao;

import java.util.List;
import sistemapedido.modelo.Pedido;

/**
 *
 * @author Audioslave
 */
public interface pedidoDao {
    
    
    public boolean create(Pedido pedido);
    public List<Pedido> getPedidosAll();
    
}
