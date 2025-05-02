
package mx.itson.beathub.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mx.itson.beathub.utils.HibernateUtil;
import mx.itson.beathub.entities.Cita;
import org.hibernate.Session;

/**
 *
 * @author Kevin
 */
public class CitaDAO {
    
   public static List<Cita> getAll(){
        List<Cita> cita = new ArrayList<>();
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Cita> criteriaQuerry = session.getCriteriaBuilder().createQuery(Cita.class);
            criteriaQuerry.from(Cita.class);
            
            cita = session.createQuery(criteriaQuerry).getResultList();
        }catch(Exception ex){
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
