package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDAO;
import datos.Festival;

public class FestivalABM {

	FestivalDAO festivalDAO = new FestivalDAO();

	public FestivalABM() {
	}

	public long agregarFestival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			double costoSuperficie, double costoMontaje, double plusElectricidad, double sueldoBase) throws Exception {

		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre del festival no puede estar vacío");
		}

		if (temporada == null || temporada.isBlank()) {
			throw new IllegalArgumentException("La temporada no puede estar vacía");
		}

		if (fechaInicio == null || fechaFin == null) {
			throw new IllegalArgumentException("Las fechas no pueden ser nulas");
		}

		if (fechaFin.isBefore(fechaInicio)) {
			throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
		}

		Festival festival = new Festival(nombre, temporada, fechaInicio, fechaFin, costoSuperficie, costoMontaje,
				plusElectricidad, sueldoBase);

		return festivalDAO.agregarFestival(festival);
	}

	public Festival traer(long id) throws Exception {

		if (id <= 0) {
			throw new IllegalArgumentException("El id debe ser mayor a cero");
		}

		return festivalDAO.traer(id);
	}

	public List<Festival> traerTodos() throws Exception {

		return festivalDAO.traerTodos();
	}

	public List<Festival> traerFestivalesPorTemporada(String temporada) throws Exception {

		if (temporada == null) {
			throw new IllegalArgumentException("La temporada no puede ser nula");
		}

		switch (temporada.toLowerCase()) {

		case "verano":
		case "otoño":
		case "invierno":
		case "primavera":

			return festivalDAO.traerFestivalesPorTemporada(temporada);

		default:

			throw new IllegalArgumentException("Temporada inválida");
		}
	}

	public List<Festival> traerFestivalesPorCostoSuperficie(double costoSuperficie, String condicion) throws Exception {

		if (costoSuperficie < 0) {
			throw new IllegalArgumentException("El costo de superficie no puede ser negativo");
		}

		if (!"mayor".equalsIgnoreCase(condicion) && !"menor".equalsIgnoreCase(condicion)) {

			throw new IllegalArgumentException("La condición debe ser 'mayor' o 'menor'");
		}

		return festivalDAO.traerFestivalesPorCostoSuperficie(costoSuperficie, condicion);
	}

	public List<Festival> traerFestivalesEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {

		if (fechaInicio == null || fechaFin == null) {
			throw new IllegalArgumentException("Las fechas no pueden ser nulas");
		}

		if (fechaFin.isBefore(fechaInicio)) {
			throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
		}

		return festivalDAO.traerFestivalesEntreFechas(fechaInicio, fechaFin);
	}

	public List<Festival> traerFestivalesPorDuracion(String condicion) throws Exception {

		if (condicion == null) {
			throw new IllegalArgumentException("La condición no puede ser nula");
		}

		if (!condicion.equalsIgnoreCase("mayor")
				&& !condicion.equalsIgnoreCase("menor")) {

			throw new IllegalArgumentException(
					"La condición debe ser 'mayor' o 'menor'"
			);
		}

		return festivalDAO.traerFestivalesPorDuracion(condicion);
	}

	public List<Festival> traerFestivalesConFoodTruck() throws Exception {

		return festivalDAO.traerFestivalesConFoodTruck();
	}

	public List<Festival> traerFestivalesConPuestoDesarmable() throws Exception {

		return festivalDAO.traerFestivalesConPuestoDesarmable();
	}
}