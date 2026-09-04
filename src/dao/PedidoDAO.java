package dao;

import java.time.LocalDate;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;
import datos.Pedido;
import datos.UnidadDeVenta;

public class PedidoDAO {
    public Session session;
    private Transaction tx;
    private static PedidoDAO instancia = null;

    public PedidoDAO() {
    }

    public static PedidoDAO getInstance() {
        if (instancia == null) {
            instancia = new PedidoDAO();

        }
        return instancia;
    }

    protected void iniciarOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    protected void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }
     public Pedido crear(Pedido pedidoDAO) {

        try {
            iniciarOperacion();
            session.save(pedidoDAO);
            tx.commit();
            return pedidoDAO;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        } finally {
            session.close();
        }
    }

    public Pedido traer(long id) {
        Pedido pedido;
        try {
            iniciarOperacion();
            pedido= (Pedido) session.createQuery("from Pedido u where u.id=:id")
                    .setParameter("id", id).uniqueResult();
            Hibernate.initialize(pedido.getUnidadDeVenta());
        } finally {
            session.close();
        }
        return pedido;
    }

    public Set<Pedido> traerTodos() throws Exception {

    	Set<Pedido> pedidos = null;

    	try {

    		iniciarOperacion();

    		pedidos = new HashSet<>(
    				session.createQuery("from Pedido", Pedido.class)
    						.getResultList()
    		);

    		tx.commit();

    	} catch (Exception e) {

    		if (tx != null) {
    			tx.rollback();
    		}

    		e.printStackTrace();

    		throw new Exception("Error al traer los Pedidos", e);

    	} finally {

    		if (session != null) {
    			session.close();
    		}
    	}

    	return pedidos;
    }
    public List<Pedido> traerListaPedido()throws Exception {
      List<Pedido> pedidos = null;

		try {

			iniciarOperacion();

			pedidos =  (List<Pedido>)session.createQuery("from Pedido");

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

			throw new Exception("Error al traer los Pedidos", e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return pedidos;
    }

    public Pedido actualizar(Pedido pedido) {
    try {
        iniciarOperacion();

        session.update(pedido);

        tx.commit();
        return pedido;

    } catch (HibernateException e) {
        manejaExcepcion(e);
        return null;
    } finally {
        session.close();
    }
}

public List<Pedido> traerEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
    List<Pedido> pedidos = null;

    try {
        iniciarOperacion();

        pedidos = session.createQuery(
                "from Pedido p where p.fecha between :fechaInicio and :fechaFin",
                Pedido.class)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

        tx.commit();
            
    } catch (Exception e) {
        if (tx != null) {
            tx.rollback();
        }

        e.printStackTrace();
        throw new Exception("Error al traer pedidos entre fechas", e);

    } finally {
        if (session != null) {
            session.close();
        }
    }

    return pedidos;
}

}
