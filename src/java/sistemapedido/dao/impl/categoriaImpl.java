 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistemapedido.dao.categoriaDao;
import sistemapedido.modelo.Categoria;
import sistemapedido.util.HibernateUtil;

/**
 *
 * @author Audioslave
 */
public class categoriaImpl implements categoriaDao{

    @Override
    public List getCategoriasAll() {
     List<Categoria> listado = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
        String sql="from Categoria";
         Transaction tx= null;
        try {
           tx= session.beginTransaction();
            listado= session.createQuery(sql).list();
            session.getTransaction().commit();
       } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
        }
       return  listado;
    }
    
}
