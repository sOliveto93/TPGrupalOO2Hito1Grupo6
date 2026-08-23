package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;

public class FestivalDAO {

    public long agregarFestival(Festival festival) {

        Session session = HibernateUtil.getSesionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            long id = (long) session.save(festival);

            transaction.commit();

            return id;

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }  
    
    public Festival traer(long id) throws Exception {

        Festival festival = null;

        Session session = HibernateUtil.getSesionFactory().openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            festival = session.createQuery("from Festival f where f.id = :id",Festival.class
            ).setParameter("id", id).uniqueResult();

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
            throw new Exception("Error al traer el festival");

        } finally {
            session.close();
        }

        return festival;
    }
    
}