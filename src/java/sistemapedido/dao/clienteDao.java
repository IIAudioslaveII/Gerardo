/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.dao;

import java.util.List;
import sistemapedido.modelo.Cliente;

/**
 *
 * @author Audioslave
 */
public interface clienteDao {
    
    
    public boolean create(Cliente cliente);
    public List getClientesAll();
    public boolean update(Cliente cliente);
    public boolean deleteC(Integer id);
}
