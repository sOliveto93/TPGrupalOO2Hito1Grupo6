package test;

import java.util.List;

import datos.Festival;
import negocio.FestivalABM;

public class Main {

    public static void main(String[] args) {

        FestivalABM festivalABM = new FestivalABM();

        List<Festival> festivales = festivalABM.traerTodos();

        for (Festival festival : festivales) {
            System.out.println(festival);
        }
    }
}
