package test;

import java.time.LocalDate;
import java.util.List;

import datos.Festival;
import negocio.FestivalABM;

public class TestFestivalPato {

	public static void main(String[] args) {

		FestivalABM festivalABM = new FestivalABM();
		Festival festival1 = new Festival("la fiesta del dulce de leche", "primavera", LocalDate.of(2026, 9, 21),
				LocalDate.of(2026, 9, 23), 650, 300, 50, 100);
		
		Festival festival2 = new Festival("Oktoberfest", "primavera", LocalDate.of(2026, 1, 10),
				LocalDate.of(2026, 1, 12), 700, 350, 60, 120);

		Festival festival3 = new Festival("Harvest Festival", "otoño", LocalDate.of(2026, 4, 15),
				LocalDate.of(2026, 4, 18), 500, 250, 40, 90);

		Festival festival4 = new Festival("Festival del Chocolate", "invierno", LocalDate.of(2026, 7, 5),
				LocalDate.of(2026, 7, 8), 800, 400, 70, 130);

		Festival festival5 = new Festival("Festival Plaza", "verano", LocalDate.of(2026, 2, 14),
				LocalDate.of(2026, 2, 17), 750, 320, 65, 110);

		Festival festival6 = new Festival("Festival Vegano", "primavera", LocalDate.of(2026, 10, 10),
				LocalDate.of(2026, 10, 12), 450, 200, 30, 95);

		Festival festival7 = new Festival("Fiesta de la Parrilla", "verano", LocalDate.of(2026, 2, 20),
				LocalDate.of(2026, 2, 23), 900, 450, 80, 150);

		Festival festival8 = new Festival("Festival de Pastas", "invierno", LocalDate.of(2026, 8, 5),
				LocalDate.of(2026, 8, 7), 600, 275, 45, 105);

		Festival festival9 = new Festival("Sabores Regionales", "otoño", LocalDate.of(2026, 5, 12),
				LocalDate.of(2026, 5, 15), 550, 225, 35, 85);

		Festival festival10 = new Festival("Epicentro Gourmet", "primavera", LocalDate.of(2026, 11, 15),
				LocalDate.of(2026, 11, 18), 1000, 500, 90, 175);

		festivalABM.agregarFestival(festival1);
		festivalABM.agregarFestival(festival2);
		festivalABM.agregarFestival(festival3);
		festivalABM.agregarFestival(festival4);
		festivalABM.agregarFestival(festival5);
		festivalABM.agregarFestival(festival6);
		festivalABM.agregarFestival(festival7);
		festivalABM.agregarFestival(festival8);
		festivalABM.agregarFestival(festival9);
		festivalABM.agregarFestival(festival10);
		festivalABM.agregarFestival(festival1);

		List<Festival> festivales = festivalABM.traerTodos();

		//Todos los festivales
		System.out.println("Festivales registrados: " + festivales.size());
		for (Festival festival : festivales) {
			System.out.println(festival);
		}
		
		//Festivales por temporada
		try {
		List<Festival> festivalesTemporada = festivalABM.traerFestivalesPorTemporada("Verano");
		System.out.println("Festivales registrados por temporada: " + festivalesTemporada.size());
		for (Festival festival : festivalesTemporada) {
			System.out.println(festival);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//Festivales entre fechas
		try {
		List<Festival> festivalesEntreFechas = festivalABM.traerFestivalesEntreFechas(LocalDate.of(2026, 6, 1), LocalDate.of(2026, 9, 30));

		System.out.println("Festivales registrados entre fechas: " + festivalesEntreFechas.size());
		for (Festival festival : festivalesEntreFechas) {
			System.out.println(festival);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		  try {
		        double costoSuperficie = 300;
		        String condicion = "mayor";

		        List<Festival> festivalesPorCosto =
		                festivalABM.traerFestivalesPorCostoSuperficie(
		                        costoSuperficie,
		                        condicion
		                );

		        if (festivalesPorCosto.isEmpty()) {
		            System.out.println("No se encontraron festivales.");
		        } else {
		            System.out.println("Festivales encontrados:");

		            for (Festival festival : festivalesPorCosto) {
		                System.out.println(
		                        festival.getNombre()
		                        + " - Costo de superficie: $"
		                        + festival.getCostoSuperficie()
		                );
		            }
		        }

		    } catch (IllegalArgumentException e) {
		        System.out.println("Dato inválido: " + e.getMessage());

		    } catch (Exception e) {
		        System.out.println("Error al consultar los festivales: "
		                + e.getMessage());
		    }
		
		
}


}



		
		

