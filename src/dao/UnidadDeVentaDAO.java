package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;
import datos.UnidadDeVenta;

public class UnidadDeVentaDAO {

    public Session session;
    private Transaction tx;
    private static UnidadDeVentaDAO instancia = null;

    public UnidadDeVentaDAO() {
    }

    public static UnidadDeVentaDAO getInstance() {
        if (instancia == null) {
            instancia = new UnidadDeVentaDAO();

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

    public UnidadDeVenta crear(UnidadDeVenta unidadVenta) {

        try {
            iniciaOperacion();
            session.save(unidadVenta);
            tx.commit();
            return unidadVenta;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        } finally {
            session.close();
        }
    }

    public UnidadDeVenta traer(long id) {
        UnidadDeVenta unidadVenta;
        try {
            iniciaOperacion();
            unidadVenta = (UnidadDeVenta) session.createQuery("from UnidadDeVenta u where u.id=:id")
                    .setParameter("id", id).uniqueResult();
        } finally {
            session.close();
        }
        return unidadVenta;
    }

    public List<UnidadDeVenta> traerTodos() {
        List<UnidadDeVenta> lista = new ArrayList<>();

        try {
            iniciaOperacion();
            lista = session.createQuery("from UnidadDeVenta", UnidadDeVenta.class).getResultList();

        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            session.close();
        }

        return lista;
    }

    public UnidadDeVenta traerPorCodigoChico(int codigoChico) {
        UnidadDeVenta unidadVenta = null;
        try {
            iniciaOperacion();
            unidadVenta = (UnidadDeVenta) session.createQuery("from UnidadDeVenta u where u.codigoChico=:codigoChico")
                    .setParameter("codigoChico", codigoChico).uniqueResult();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            session.close();
        }
        return unidadVenta;

    }

    public List<UnidadDeVenta> traerPorFestival(Festival festival) {
        List<UnidadDeVenta> lista=new ArrayList<>();
        try {
            iniciaOperacion();
            lista= session.createQuery("from UnidadDeVenta u where u.festival=:festival", UnidadDeVenta.class)
                    .setParameter("festival", festival).getResultList();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            session.close();
        }
        return lista;
    }
}
