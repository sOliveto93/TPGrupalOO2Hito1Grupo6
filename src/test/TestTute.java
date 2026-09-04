package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Enum.Estaciones;
import datos.Cocinero;
import datos.Festival;
import negocio.FestivalABM;
import negocio.StaffABM;

public class TestTute {

	public static void main(String[] args) {

		StaffABM staffABM = new StaffABM();
		FestivalABM festivalABM = new FestivalABM();
		
		for (Cocinero cocinero : staffABM.traerCocinerosPorEspecialidad("parrilla")) {
			System.out.println(cocinero);
		}

		List<Festival> festivales = new ArrayList<Festival>();

		try {
			festivales = festivalABM.traerFestivalesPorTemporada(Estaciones.VERANO);
			for (Festival festival : festivales) {
				System.out.println(festival);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
 
	}

}
