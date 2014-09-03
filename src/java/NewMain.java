
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistemapedido.modelo.Categoria;
import sistemapedido.modelo.Cliente;
import sistemapedido.util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audioslave
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      List<Categoria> listado = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
        String sql="from Categoria";
         Transaction tx= null;
        try {
           tx= session.beginTransaction();
            listado= session.createQuery(sql).list();
            
            for(Categoria categoria: listado){
                System.out.println("nombre " +categoria.getNombCategoria());
            }
           
            session.getTransaction().commit();
       } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
        }
          
    }
        
    
}
