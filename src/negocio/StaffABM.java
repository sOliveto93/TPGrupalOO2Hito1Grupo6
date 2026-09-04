package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.StaffDAO;
import datos.Staff;
import datos.Cajero;
import datos.Cocinero;

public class StaffABM {

	StaffDAO dao = StaffDAO.getInstance();

	public StaffABM() {
	};

	public Staff crearStaff(Staff staff) throws Exception {

		if (traerStaffPorDni(staff.getDni()) != null) {
			throw new Exception("No se puede crear staff con el mismo dni");
		}

		return dao.crear(staff);
	}

	public Staff crearCajero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String turno) throws Exception {

		if (traerStaffPorDni(dni) != null) {
			throw new Exception("No se puede crear staff con el mismo dni");
		}

		Cajero cajero = new Cajero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, turno);

		return dao.crear(cajero);
	}

	public Staff crearCocinero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String especialidad, double plusCategoria) throws Exception {

		if (traerStaffPorDni(dni) != null) {
			throw new Exception("No se puede crear staff con el mismo dni");
		}

		Cocinero cocinero = new Cocinero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, especialidad,
				plusCategoria);

		return dao.crear(cocinero);
	}

	public Staff traerStaff(long id) {
		return dao.traer(id);
	}

	public Set<Staff> traerTodosStaff() {
		System.out.println("-------LISTA DE TODO EL PERSONAL STAFF----------");
		return dao.traerTodos();
	}

	public List<Cajero> traerTodosCajeros() {
		System.out.println("------------LISTA DE TODOS LOS CAJEROS---------------\n");
		return dao.traerCajeros();
	}

	public List<Cocinero> traerTodosCocineros() {
		System.out.println("------------LISTA DE TODOS LOS COCINEROS--------");
		return dao.traerCocineros();
	}

	public List<Cocinero> traerCocinerosPorEspecialidad(String especialidad) {
		System.out
				.println("------------LISTA DE COCINEROS POR ESPECIALIDAD " + especialidad.toUpperCase() + "--------");

		return dao.traerCocinerosPorEspecialidad(especialidad);
	}

	public List<Cajero> traerCajerosPorTurno(String turno) {
		System.out.println("--------------LISTA DE CAJEROS TURNO " + turno + " ---------");

		return dao.traerCajerosPorTurno(turno);
	}

	public Staff traerStaffPorDni(long dni) {
		System.out.println("---BUSCANDO A STAFF CON DNI:" + dni + " ----");

		return dao.traerStaffPorDni(dni);
	}

	public List<Staff> traerStaffPorApellido(String apellido) {
		System.out.println("\n--- STAFF CON APELLIDO: " + apellido + " ---");

		return dao.traerStaffPorApellido(apellido);
	}

	public List<Staff> traerStaffSueldoMayorA(double sueldo) {
		System.out.println("\n--- STAFF CON SUELDO MAYOR A: $" + sueldo + " ---");

		return dao.traerStaffSueldoMayorA(sueldo);
	}

	public List<Staff> traerStaffOrdenadoPorApellido() {
		System.out.println("\n--- STAFF ORDENADO POR APELLIDO ---");

		return dao.traerStaffOrdenadoPorApellido();
	}

	public List<Staff> traerStaffIngresadoDespuesDe(LocalDate fecha) {
		System.out.println("\n--- STAFF INGRESADO DESPUES DE: " + fecha + " ---");

		return dao.traerStaffIngresadoDespuesDe(fecha);
	}
}