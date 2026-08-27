package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;

public class FestivalDAO {

	private Session session;
	private Transaction tx;
	private static FestivalDAO instancia = null;

	public FestivalDAO() {
	}

	protected void iniciarOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	public static FestivalDAO getInstance() {

		if (instancia == null) {
			instancia = new FestivalDAO();
		}

		return instancia;
	}

	public long agregarFestival(Festival festival) {

		try {

			iniciarOperacion();

			long id = (long) session.save(festival);

			tx.commit();

			return id;

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

			return -1;

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public Festival traer(long id) throws Exception {

		Festival festival = null;

		try {

			iniciarOperacion();

			festival = (Festival) session
					.createQuery("from Festival f where f.id = :id")
					.setParameter("id", id)
					.uniqueResult();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

			throw new Exception("Error al traer el festival", e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festival;
	}

	public List<Festival> traerTodos() throws Exception {

		List<Festival> festivales = null;

		try {

			iniciarOperacion();

			festivales = (List<Festival>) session
					.createQuery("from Festival")
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

			throw new Exception("Error al traer los festivales", e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festivales;
	}

	public List<Festival> traerFestivalesPorTemporada(String temporada) throws Exception {

		List<Festival> festivales = null;

		try {

			iniciarOperacion();

			festivales = (List<Festival>) session
					.createQuery("from Festival f where f.temporada = :temporada")
					.setParameter("temporada", temporada)
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

			throw new Exception("Error al traer los festivales por temporada", e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festivales;
	}

	public List<Festival> traerFestivalesEntreFechas(
			LocalDate fechaInicio,
			LocalDate fechaFin) throws Exception {

		List<Festival> festivales = null;

		try {

			iniciarOperacion();

			festivales = (List<Festival>) session
					.createQuery(
							"from Festival f "
							+ "where f.fechaInicio >= :fechaInicio "
							+ "and f.fechaFin <= :fechaFin")
					.setParameter("fechaInicio", fechaInicio)
					.setParameter("fechaFin", fechaFin)
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

			throw new Exception("Error al traer los festivales entre fechas", e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festivales;
	}

	public List<Festival> traerFestivalesPorCostoSuperficie(
			double costoSuperficie,
			String condicion) throws Exception {

		List<Festival> festivales = null;

		try {

			iniciarOperacion();

			if ("mayor".equalsIgnoreCase(condicion)) {

				festivales = (List<Festival>) session
						.createQuery(
								"from Festival f "
								+ "where f.costoSuperficie >= :costoSuperficie")
						.setParameter("costoSuperficie", costoSuperficie)
						.getResultList();

			} else if ("menor".equalsIgnoreCase(condicion)) {

				festivales = (List<Festival>) session
						.createQuery(
								"from Festival f "
								+ "where f.costoSuperficie <= :costoSuperficie")
						.setParameter("costoSuperficie", costoSuperficie)
						.getResultList();

			} else {

				throw new IllegalArgumentException(
						"La condición debe ser 'mayor' o 'menor'");
			}

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

			throw new Exception(
					"Error al traer los festivales por costo de superficie",
					e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festivales;
	}
}