/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemapedido.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistemapedido.dao.clienteDao;
import sistemapedido.modelo.Cliente;
import sistemapedido.util.HibernateUtil;

/**
 *
 * @author Audioslave
 */
public class clienteImpl implements clienteDao {

    @Override
    public boolean create(Cliente cliente) {
         boolean flag= false;
         Transaction tx= null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx= session.beginTransaction();
            session.save(cliente);
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
    public List getClientesAll() {
      List<Cliente> listado = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
        String sql="from Cliente";
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
    public boolean update(Cliente cliente) {
        // NO FUNCIONA
       boolean flag= false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.load(Cliente.class, cliente.getIdCliente());
            session.update(cliente);
            session.getTransaction().commit();
            flag= true;
        } catch (Exception e) {
            session.beginTransaction().rollback();
        }
        return flag;
    }

    @Override
    public boolean deleteC(Integer id) {
          boolean flag=false;
        Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction tx= null;
        try {
            tx= session.beginTransaction();
           Cliente client=(Cliente) session.load(Cliente.class, id);
            session.delete(client);
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
