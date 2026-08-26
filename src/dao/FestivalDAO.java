package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;

public class FestivalDAO {

	public long agregarFestival(Festival festival) {

		Session session = HibernateUtil.getSessionFactory().openSession();
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

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			festival = (Festival) session.createQuery("from Festival f where f.id = :id").setParameter("id", id)
					.uniqueResult();

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

	public List<Festival> traerTodos() throws Exception {

		List<Festival> festivales = null;

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			festivales = session.createQuery("from Festival", Festival.class).getResultList();

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();

			}

			e.printStackTrace();

			throw new Exception("Error al traer los festivales");

		} finally {

			session.close();

		}

		return festivales;
	}

	public List<Festival> traerFestivalesPorTemporada(String temporada) throws Exception {

		List<Festival> festivales = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			festivales = (List<Festival>) session.createQuery("from Festival f where f.temporada = :temporada")
					.setParameter("temporada", temporada).getResultList();

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
			throw new Exception("Error al traer los festivales");

		} finally {
			session.close();
		}

		return festivales;
	}

	public List<Festival> traerFestivalesEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {

		List<Festival> festivales = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			festivales = (List<Festival>) session
					.createQuery("from Festival f where f.fechaInicio >= :fechaInicio and f.fechaFin <= :fechaFin")
					.setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin).getResultList();

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
			throw new Exception("Error al traer los festivales");

		} finally {
			session.close();
		}

		return festivales;
	}

	public List<Festival> traerFestivalesPorCostoSuperficie(double costoSuperficie, String condicion) throws Exception {
		List<Festival> festivales = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();
			if("mayor".equalsIgnoreCase(condicion)){
			festivales = (List<Festival>) session
					.createQuery("from Festival f where :costoSuperficie <= f.costoSuperficie")
					.setParameter("costoSuperficie", costoSuperficie).getResultList();
			} else if("menor".equalsIgnoreCase(condicion)){
				festivales = (List<Festival>) session
						.createQuery("from Festival f where :costoSuperficie >= f.costoSuperficie")
						.setParameter("costoSuperficie", costoSuperficie).getResultList();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw new Exception("Error al traer los festivales");
		} finally {
			session.close();
		}
		return festivales;
	}
}