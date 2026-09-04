package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cajero;
import datos.Staff;
import datos.Cocinero;
import datos.Plato;

@SuppressWarnings("unchecked")

public class StaffDAO {

	public Session session;
	private Transaction tx;
	private static StaffDAO instancia = null;

	public StaffDAO() {
	}

	public static StaffDAO getInstance() {
		if (instancia == null) {
			instancia = new StaffDAO();

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

	public Staff crear(Staff staff) {

		try {
			iniciaOperacion();
			session.save(staff);
			tx.commit();
			return staff;
		} catch (HibernateException e) {
			manejaExcepcion(e);
			return null;
		} finally {
			session.close();
		}
	}

	public Staff traer(long id) {
		Staff staff = null;
		try {
			iniciaOperacion();
			staff = (Staff) session.createQuery("from Staff s where s.id=:id").setParameter("id", id).uniqueResult();
		} finally {
			session.close();
		}
		return staff;
	}

	public Set<Staff> traerTodos() {
		List<Staff> lista = new ArrayList<>();
		Set<Staff> set = new HashSet<>();
		try {

			iniciaOperacion();
			lista = (List<Staff>) session.createQuery("from Staff").list();
			if (!lista.isEmpty()) {

				for (Staff staff : lista) {
					set.add(staff);
				}
			}

		} finally {
			session.close();
		}
		return set;

	}

	public List<Cajero> traerCajeros() {

		List<Cajero> lista = new ArrayList<>();

		try {
			iniciaOperacion();

			List resultado = session.createQuery("from Cajero").list();

			for (Object objeto : resultado) {
				lista.add((Cajero) objeto);
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return lista;
	}

	public List<Cocinero> traerCocineros() {

		List<Cocinero> lista = new ArrayList<>();

		try {
			iniciaOperacion();

			List resultado = session.createQuery("from Cocinero").list();

			for (Object objeto : resultado) {
				lista.add((Cocinero) objeto);
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return lista;
	}

	public List<Cajero> traerCajerosPorTurno(String turno) {

		List<Cajero> lista = new ArrayList<>();

		try {
			iniciaOperacion();

			lista = (List<Cajero>) session.createQuery("from Cajero c where c.turno = :turno")
					.setParameter("turno", turno).list();

		} finally {
			session.close();
		}

		return lista;
	}

	public Staff traerStaffPorDni(long dni) {
		Staff staff = null;
		try {
			iniciaOperacion();
			staff = (Staff) session.createQuery("from Staff s where s.dni = :dni").setParameter("dni", dni)
					.uniqueResult();
		} finally {
			session.close();
		}

		return staff;

	}

	public List<Staff> traerStaffPorApellido(String apellido) {

		List<Staff> lista = new ArrayList<>();

		try {
			iniciaOperacion();

			lista = (List<Staff>) session.createQuery("from Staff s where s.apellido = :apellido")
					.setParameter("apellido", apellido).list();

		} finally {
			session.close();
		}

		return lista;
	}

	public List<Staff> traerStaffSueldoMayorA(double sueldo) {

		List<Staff> lista = new ArrayList<>();

		try {
			iniciaOperacion();

			lista = (List<Staff>) session.createQuery("from Staff s where s.sueldoBase > :sueldo")
					.setParameter("sueldo", sueldo).list();

		} finally {
			session.close();
		}

		return lista;
	}

	public List<Staff> traerStaffOrdenadoPorApellido() {

		List<Staff> lista = new ArrayList<>();

		try {
			iniciaOperacion();

			lista = (List<Staff>) session.createQuery("from Staff s order by s.apellido").list();

		} finally {
			session.close();
		}

		return lista;
	}

	public List<Staff> traerStaffIngresadoDespuesDe(LocalDate fecha) {

		List<Staff> lista = new ArrayList<>();

		try {
			iniciaOperacion();

			lista = (List<Staff>) session.createQuery("from Staff s where s.fechaIngreso > :fecha")
					.setParameter("fecha", fecha).list();
		} finally {
			session.close();
		}

		return lista;
	}

	public List<Cocinero> traerCocinerosPorEspecialidad(String especialidad) {

		List<Cocinero> lista = new ArrayList<>();

		try {
			iniciaOperacion();

			List resultado = session.createQuery("from Cocinero c where c.especialidad =:especialidad")
					.setParameter("especialidad", especialidad).getResultList();

			for (Object objeto : resultado) {

				lista.add((Cocinero) objeto);
			}

		} finally {
			if (session != null) {

				session.close();
			}
		}

		return lista;
	}

}
