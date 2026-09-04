package test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import datos.Festival;
import datos.Plato;
import datos.Staff;
import datos.UnidadDeVenta;
import negocio.FestivalABM;
import negocio.PlatoABM;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

public class TestFestivalPato {

	public static void main(String[] args) throws Exception {

		FestivalABM festivalABM = new FestivalABM();
		StaffABM staffABM = new StaffABM();
		PlatoABM platoABM = new PlatoABM();
		UnidadDeVentaABM unidadDeVentaABM = new UnidadDeVentaABM();

		Set<Staff> staffs = staffABM.traerTodosStaff();
		Set<Plato> platos = platoABM.traerTodos();

		if (staffs.isEmpty()) {

			staffABM.crearCocinero("Patricio", "Anrrique", 44626026, LocalDate.of(2003, 1, 6),
					LocalDate.of(2024, 3, 10), 350000, "Parrilla", 50000);

			staffABM.crearCocinero("Matias", "Torres", 12121212, LocalDate.of(1998, 7, 20), LocalDate.of(2023, 5, 15),
					400000, "Sushi", 70000);

			staffABM.crearCajero("sebas", "oliveto", 42333444, LocalDate.of(1993, 8, 7), LocalDate.of(2025, 8, 23),
					300000, "Noche");

			staffABM.crearCajero("Lourdes", "Crespo", 45495509, LocalDate.of(2003, 12, 22), LocalDate.of(2024, 11, 15),
					320000, "Tarde");

			staffABM.crearCajero("nico", "perez", 43444555, LocalDate.of(2000, 10, 5), LocalDate.of(2022, 6, 1),
					330000, "Mañana");

			staffs = staffABM.traerTodosStaff();
		}

		if (platos.isEmpty()) {

			platoABM.crearPlato(new Plato("Hamburguesa cuarto de libra", 9000, 4000));

			platoABM.crearPlato(new Plato("Pizza napolitana", 11000, 4500));

			platoABM.crearPlato(new Plato("Sushi", 15000, 7000));

			platoABM.crearPlato(new Plato("Panchos", 6000, 2500));

			platoABM.crearPlato(new Plato("Empanadas de pollo", 8000, 3500));

			platos = platoABM.traerTodos();
		}

		List<Festival> festivales = festivalABM.traerTodos();

		if (festivales.isEmpty()) {

			festivalABM.agregarFestival("festival del membrillo", "verano", LocalDate.of(2026, 1, 10),
					LocalDate.of(2026, 1, 12), 250, 300, 50, 200);

			festivalABM.agregarFestival("la fiesta", "invierno", LocalDate.of(2026, 7, 5),
					LocalDate.of(2026, 7, 10), 500, 450, 80, 300);

			festivalABM.agregarFestival("la fiesta loca", "primavera", LocalDate.of(2026, 9, 20),
					LocalDate.of(2026, 9, 28), 750, 600, 100, 400);

			festivalABM.agregarFestival("la fiesta muy loca", "otoño", LocalDate.of(2026, 4, 15),
					LocalDate.of(2026, 4, 18), 400, 350, 70, 250);

			festivalABM.agregarFestival("la fiesta del dulce de leche", "verano", LocalDate.of(2026, 2, 1), LocalDate.of(2026, 2, 15),
					900, 800, 150, 500);

			festivales = festivalABM.traerTodos();
		}

		List<UnidadDeVenta> unidadesDeVenta = unidadDeVentaABM.traerTodos();

		if (unidadesDeVenta.isEmpty()) {

			Staff encargado = staffs.iterator().next();

			for (int i = 0; i < 5; i++) {

				Festival festival = festivales.get(i);

				unidadDeVentaABM.crearFoodTruck("FoodTruck " + (i + 1), encargado, 20 + i, 100 + i, festival, platos,
						staffs, "FT" + (1000 + i), i % 2 == 0);

				unidadDeVentaABM.crearPuestoDesarmable("Puesto " + (i + 1), encargado, 15 + i, 200 + i, festival,
						platos, staffs, 2 + i, 30 + (i * 10));
			}
		}

		System.out.println("\n========== TODOS LOS FESTIVALES ==========");
		for (Festival festival : festivalABM.traerTodos()) {
			System.out.println(festival);
		}

		System.out.println("\n========== FESTIVALES DE VERANO ==========");
		for (Festival festival : festivalABM.traerFestivalesPorTemporada("verano")) {

			System.out.println(festival);
		}

		System.out.println("\n========== COSTO SUPERFICIE MAYOR O IGUAL A 500 ==========");
		for (Festival festival : festivalABM.traerFestivalesPorCostoSuperficie(500, "mayor")) {

			System.out.println(festival);
		}

		System.out.println("\n========== COSTO SUPERFICIE MENOR O IGUAL A 500 ==========");
		for (Festival festival : festivalABM.traerFestivalesPorCostoSuperficie(500, "menor")) {

			System.out.println(festival);
		}

		System.out.println("\n========== FESTIVALES ENTRE ABRIL Y SEPTIEMBRE ==========");
		for (Festival festival : festivalABM.traerFestivalesEntreFechas(LocalDate.of(2026, 4, 1),
				LocalDate.of(2026, 9, 30))) {

			System.out.println(festival);
		}

		System.out.println("\n========== MAYOR A MENOR DURACION ==========");
		for (Festival festival : festivalABM.traerFestivalesPorDuracion("mayor")) {

			System.out
					.println(festival.getNombre() + " | " + festival.getFechaInicio() + " - " + festival.getFechaFin());
		}

		System.out.println("\n========== MENOR A MAYOR DURACION ==========");
		for (Festival festival : festivalABM.traerFestivalesPorDuracion("menor")) {

			System.out
					.println(festival.getNombre() + " | " + festival.getFechaInicio() + " - " + festival.getFechaFin());
		}

		System.out.println("\n========== FESTIVALES CON FOODTRUCK ==========");
		for (Festival festival : festivalABM.traerFestivalesConFoodTruck()) {

			System.out.println(festival);
		}

		System.out.println("\n========== FESTIVALES CON PUESTO DESARMABLE ==========");
		for (Festival festival : festivalABM.traerFestivalesConPuestoDesarmable()) {

			System.out.println(festival);
		}
	}
}