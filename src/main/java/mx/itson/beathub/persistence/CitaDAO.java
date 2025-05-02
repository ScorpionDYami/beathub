
package mx.itson.beathub.persistence;

import mx.itson.beathub.utils.HibernateUtil;
import mx.itson.beathub.utils.entities.Cita;
import org.hibernate.Session;

/**
 *
 * @author Kevin
 */
public class CitaDAO {
    
    public static Cita getById(int id) {
        Cita cita = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            cita = session.get(Cita.class, id);
        } catch(Exception ex) {
            System.err.println("An error occurred" + ex.getMessage());
        }
        return cita;
    }
    
    public static boolean edit(Cita c){
        boolean result = false;
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.update(c);
            session.beginTransaction().commit();
            
            result = c.getId_cita() != 0;
        }catch(Exception ex){
            System.err.println("An error occurred" + ex.getMessage());
        }
        return result;
    }
    
}
