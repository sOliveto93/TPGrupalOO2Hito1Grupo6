package test;

import java.time.LocalDate;
import java.util.List;

import datos.Festival;
import negocio.FestivalABM;

public class Main {

    public static void main(String[] args) {

        FestivalABM festivalABM = new FestivalABM();
        Festival festival1=new Festival("la fiesta del dulce de leche", "primavera", LocalDate.of(2026,9,21), LocalDate.of(2026, 9, 23), 650, 300 ,50, 100);
        festivalABM.agregarFestival(festival1);
        List<Festival> festivales = festivalABM.traerTodos();
        
        System.out.println("Festivales registrados: " + festivales.size());
        for (Festival festival : festivales) {
            System.out.println(festival);
        }
    }
}
