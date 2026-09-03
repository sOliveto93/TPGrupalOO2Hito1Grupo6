package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Plato;

public class PlatoDAO {

    public Session session;
    private Transaction tx;
    private static PlatoDAO instancia = null;

    public PlatoDAO() {
    }

    public static PlatoDAO getInstance() {
        if (instancia == null) {
            instancia = new PlatoDAO();

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

    public Plato crear(Plato plato) {

        try {
            iniciaOperacion();
            session.save(plato);
            tx.commit();
            return plato;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        } finally {
            session.close();
        }
    }

    public Plato traer(long id) {
        Plato plato;
        try {
            iniciaOperacion();
            plato = (Plato) session.createQuery("from Plato p where p.id=:id")
                    .setParameter("id", id).uniqueResult();
        } finally {
            session.close();
        }
        return plato;
    }
    public Plato traer(String nombre) {
        Plato plato;
        try {
            iniciaOperacion();
            plato = (Plato) session.createQuery("from Plato p where p.nombre=:nombre")
                    .setParameter("nombre",nombre).uniqueResult();
        } finally {
            session.close();
        }
        return plato;
    }

    public Set<Plato> traerTodos() {
        List<Plato> lista = new ArrayList<>();
        Set<Plato> set=new HashSet<>();
        try {
            iniciaOperacion();
            lista = session.createQuery("from Plato", Plato.class).getResultList();
            if(!lista.isEmpty()){
                
                for(Plato plato:lista){
                    set.add(plato);
                }
            }
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            session.close();
        }

        return set;
    }

    public List<Plato> traerListaPlatos() {
        List<Plato> lista = new ArrayList<>();
        
        try {
            iniciaOperacion();
            lista = session.createQuery("from Plato", Plato.class).getResultList();
            
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            session.close();
        }

        return lista;
    }
    
}
