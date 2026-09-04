package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
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

	protected void manejarExcepcion(Exception e) throws Exception {
		if (tx != null) {
			tx.rollback();
		}

		throw new Exception("ERROR en la capa de acceso a datos", e);
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

			manejarExcepcion(e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festival;
	}

	public Festival traerConUnidades(long id) throws Exception {

		Festival festival = null;

		try {

			iniciarOperacion();

			festival = (Festival) session
					.createQuery("from Festival f where f.id = :id")
					.setParameter("id", id)
					.uniqueResult();

			if (festival != null) {
				Hibernate.initialize(festival.getUnidadesDeVenta());
			}

			tx.commit();

		} catch (Exception e) {

			manejarExcepcion(e);

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

			manejarExcepcion(e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festivales;
	}

	public List<Festival> traerFestivalesPorTemporada(
			String temporada) throws Exception {

		List<Festival> festivales = null;

		try {

			iniciarOperacion();

			festivales = (List<Festival>) session
					.createQuery(
							"from Festival f "
							+ "where f.temporada = :temporada"
					)
					.setParameter("temporada", temporada)
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			manejarExcepcion(e);

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
							+ "and f.fechaFin <= :fechaFin"
					)
					.setParameter("fechaInicio", fechaInicio)
					.setParameter("fechaFin", fechaFin)
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			manejarExcepcion(e);

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
								+ "where f.costoSuperficie >= :costoSuperficie"
						)
						.setParameter(
								"costoSuperficie",
								costoSuperficie
						)
						.getResultList();

			} else if ("menor".equalsIgnoreCase(condicion)) {

				festivales = (List<Festival>) session
						.createQuery(
								"from Festival f "
								+ "where f.costoSuperficie <= :costoSuperficie"
						)
						.setParameter(
								"costoSuperficie",
								costoSuperficie
						)
						.getResultList();

			} else {

				throw new IllegalArgumentException(
						"La condición debe ser 'mayor' o 'menor'"
				);
			}

			tx.commit();

		} catch (Exception e) {

			manejarExcepcion(e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festivales;
	}

	public List<Festival> traerFestivalesPorDuracion(
			String condicion) throws Exception {

		List<Festival> festivales = null;

		try {

			iniciarOperacion();

			if ("mayor".equalsIgnoreCase(condicion)) {

				festivales = (List<Festival>) session
						.createQuery(
								"from Festival f "
								+ "order by function('datediff', "
								+ "f.fechaFin, f.fechaInicio) desc"
						)
						.getResultList();

			} else if ("menor".equalsIgnoreCase(condicion)) {

				festivales = (List<Festival>) session
						.createQuery(
								"from Festival f "
								+ "order by function('datediff', "
								+ "f.fechaFin, f.fechaInicio) asc"
						)
						.getResultList();

			} else {

				throw new IllegalArgumentException(
						"La condición debe ser 'mayor' o 'menor'"
				);
			}

			tx.commit();

		} catch (Exception e) {

			manejarExcepcion(e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festivales;
	}

	public List<Festival> traerFestivalesConFoodTruck()
			throws Exception {

		List<Festival> festivales = null;

		try {

			iniciarOperacion();

			festivales = (List<Festival>) session
					.createQuery(
							"select distinct f "
							+ "from Festival f "
							+ "join f.unidadesDeVenta u "
							+ "where type(u) = FoodTruck"
					)
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			manejarExcepcion(e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festivales;
	}

	public List<Festival> traerFestivalesConPuestoDesarmable()
			throws Exception {

		List<Festival> festivales = null;

		try {

			iniciarOperacion();

			festivales = (List<Festival>) session
					.createQuery(
							"select distinct f "
							+ "from Festival f "
							+ "join f.unidadesDeVenta u "
							+ "where type(u) = PuestoDesarmable"
					)
					.getResultList();

			tx.commit();

		} catch (Exception e) {

			manejarExcepcion(e);

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return festivales;
	}
}