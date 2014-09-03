/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistemapedido.dao.productoDao;
import sistemapedido.modelo.Producto;
import sistemapedido.util.HibernateUtil;

/**
 *
 * @author Audioslave
 */
public class productoImpl  implements productoDao{

    @Override
    public boolean create(Producto producto) {
        boolean flag= false;
         Transaction tx= null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx= session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
            flag= true;
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
        }
       return  flag;
    }

    @Override
    public List getProductosAll() {
     List<Producto> listado = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
        String sql="from Producto";
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

    @Override
    public boolean update(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
    
    
    }

    @Override
    public boolean delete(Integer id) {
          boolean flag=false;
        Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction tx= null;
        try {
            tx= session.beginTransaction();
           Producto produc=(Producto) session.load(Producto.class, id);
            session.delete(produc);
            session.getTransaction().commit();
            flag= true;
       } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
        }
       return  flag;
    }

    
}
