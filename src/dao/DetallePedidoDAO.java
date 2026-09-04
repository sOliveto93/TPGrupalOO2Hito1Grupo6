package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.DetallePedido;
import datos.UnidadDeVenta;


public class DetallePedidoDAO {

     public Session session;
    private Transaction tx;
    private static DetallePedidoDAO instancia = null;

    public DetallePedidoDAO() {
    }

    public static DetallePedidoDAO getInstance() {
        if (instancia == null) {
            instancia = new DetallePedidoDAO();

        }
        return instancia;
    }

    protected void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    protected void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

     public DetallePedido crear(DetallePedido detallePedido) {

        try {
            iniciaOperacion();
            session.save(detallePedido);
            tx.commit();
            return detallePedido;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        } finally {
            session.close();
        }
    }

    public DetallePedido traer(long id) {
        DetallePedido detallePedido;
        try {
            iniciaOperacion();
            detallePedido = (DetallePedido) session.createQuery("from DetallePedido u where u.id=:id")
                    .setParameter("id", id).uniqueResult();
                    //creo que es mejor dejarlo eager
            //Hibernate.initialize(unidadVenta.getPersonal());
        } finally {
            session.close();
        }
        return detallePedido;
    }



}
