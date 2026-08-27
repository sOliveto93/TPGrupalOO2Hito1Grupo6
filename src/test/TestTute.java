package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Cocinero;
import datos.Festival;
import negocio.FestivalABM;
import negocio.StaffABM;

public class TestTute {

	public static void main(String[] args) {

		StaffABM staffABM = new StaffABM();
		FestivalABM festivalABM = new FestivalABM();

		Festival festival1 = new Festival("la fiesta del dulce de leche", "primavera", LocalDate.of(2026, 9, 21),
				LocalDate.of(2026, 9, 23), 650, 300, 50, 100);
		Festival festival2 = new Festival("la fiesta loca", "verano", LocalDate.of(2026, 12, 15),
				LocalDate.of(2026, 12, 18), 650, 300, 50, 100);
		Festival festival3 = new Festival("la fiesta", "verano", LocalDate.of(2026, 12, 21), LocalDate.of(2026, 12, 23),
				650, 300, 50, 100);
		Festival festival4 = new Festival("la no fiesta", "invierno", LocalDate.of(2026, 7, 1),
				LocalDate.of(2026, 7, 12), 650, 300, 50, 100);

		festivalABM.agregarFestival(festival1);
		festivalABM.agregarFestival(festival2);
		festivalABM.agregarFestival(festival3);
		festivalABM.agregarFestival(festival4);

		Cocinero cocinero1 = new Cocinero("patricio", "no recuerdo", 88991122, LocalDate.of(1993, 8, 7),
				LocalDate.now(), 300, "sushi", 65);
		Cocinero cocinero2 = new Cocinero("Matias", "Torres", 12121212, LocalDate.of(2004, 7, 12), LocalDate.now(), 300,
				"parrilla", 65);
		Cocinero cocinero3 = new Cocinero("Sebas", "oliveto", 1122334455, LocalDate.of(2002, 5, 13), LocalDate.now(),
				300, "parrilla", 65);
		Cocinero cocinero4 = new Cocinero("Lour", "Crespo", 45495509, LocalDate.of(2003, 12, 22), LocalDate.now(), 300,
				"sushi", 65);

		try {
			staffABM.crearStaff(cocinero1);
			staffABM.crearStaff(cocinero2);
			staffABM.crearStaff(cocinero3);
			staffABM.crearStaff(cocinero4);
		} catch (Exception e) {
			System.err.println("======================\n" + e.getMessage() + "\n========================\n");
		}

		for (Cocinero cocinero : staffABM.traerCocinerosPorEspecialidad("parrilla")) {
			System.out.println(cocinero);
		}

		List<Festival> festivales = new ArrayList<Festival>();

		try {
			festivales = festivalABM.traerFestivalesPorTemporada("verano");
			for (Festival festival : festivales) {
				System.out.println(festival);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
