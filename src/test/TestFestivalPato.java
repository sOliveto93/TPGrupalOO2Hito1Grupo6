package test;

import java.time.LocalDate;
import java.util.List;

import Enum.Estaciones;
import datos.Festival;
import negocio.FestivalABM;

public class TestFestivalPato {

	public static void main(String[] args) {

		FestivalABM festivalABM = new FestivalABM();


		List<Festival> festivales = festivalABM.traerTodos();

		//Todos los festivales
		System.out.println("Festivales registrados: " + festivales.size());
		for (Festival festival : festivales) {
			System.out.println(festival);
		}
		
		//Festivales por temporada
		try {
		List<Festival> festivalesTemporada = festivalABM.traerFestivalesPorTemporada(Estaciones.VERANO);
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
		  
			System.out.println("\n========== TODOS LOS FESTIVALES ==========");
			for (Festival festival : festivalABM.traerTodos()) {
				System.out.println(festival);
			}

			try {

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
			System.out.println("\n========== FESTIVALES DE VERANO ==========");
			for (Festival festival : festivalABM.traerFestivalesPorTemporada(Estaciones.VERANO)) {

				System.out.println(festival);
			}
			
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		

		
}

}
