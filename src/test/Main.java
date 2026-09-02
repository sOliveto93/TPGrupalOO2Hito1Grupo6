package test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import datos.Cajero;
import datos.Cocinero;
import datos.Festival;
import datos.FoodTruck;
import datos.Plato;
import datos.Staff;
import datos.UnidadDeVenta;
import negocio.FestivalABM;
import negocio.PlatoABM;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

public class Main {

    public static void main(String[] args) {

    	UnidadDeVentaABM unidadDeVentaABM = new UnidadDeVentaABM();
        StaffABM staffABM = new StaffABM();
        FestivalABM festivalABM = new FestivalABM();
        PlatoABM platoABM = new PlatoABM();

        Festival festival = festivalABM.traer(1);
        List<UnidadDeVenta> unidadesDeVentas = unidadDeVentaABM.traerTodos();
        Set<Staff> staffs = staffABM.traerTodosStaff();
        Set<Plato> platos = platoABM.traerTodos();

        if (platos.isEmpty()) {
            Plato plato1 = new Plato("panchos", 5000, 2000);
            Plato plato2 = new Plato("amburguejas al vapor", 7000, 3000);
            platoABM.crearPlato(plato1);
            platoABM.crearPlato(plato2);
            platos = platoABM.traerTodos();
        }

        if (festival == null) {
            festival = new Festival("la fiesta del dulce de leche", "primavera", LocalDate.of(2026, 9, 21),
                    LocalDate.of(2026, 9, 23), 650, 300, 50, 100);
            festivalABM.agregarFestival(festival);
        }
        if (staffs.isEmpty()) {
            Cajero cajero = new Cajero("sebas", "oliveto", 1122334455, LocalDate.of(1993, 8, 7),
                    LocalDate.of(2026, 8, 23),
                    250, "noche");

            Cocinero cocinero = new Cocinero("patricio", "no recuerdo", 88991122, LocalDate.of(2002, 5, 13),
                    LocalDate.now(), 300, "sushi", 65);
            Cajero cajero2 = new Cajero("Lourdes", "Crespo", 45495509, LocalDate.of(2003, 12, 22),
                    LocalDate.of(2024, 11, 15), 400, "noche");

            try {
                staffABM.crearStaff(cocinero);
                staffABM.crearStaff(cajero);
                staffABM.crearStaff(cajero2);
                staffs = staffABM.traerTodosStaff();
            } catch (Exception e) {

                e.printStackTrace();
            }

        }

        if (unidadesDeVentas.isEmpty()) {
            UnidadDeVenta unidadDeVenta1 = new FoodTruck("El buen mordisco", staffs.iterator().next(), 18, 42, festival,
                    platos, staffs, "ABC123", true);
            UnidadDeVenta unidadDeVenta2 = new FoodTruck("El buen mordisco", staffs.iterator().next(), 18, 64, festival,
                    platos, staffs, "ABC123", true);
            UnidadDeVenta unidadDeVenta3 = new FoodTruck("El buen mordisco", staffs.iterator().next(), 18, 105,
                    festival,
                    platos, staffs, "ABC123", true);
            unidadDeVentaABM.crear(unidadDeVenta1);
            unidadDeVentaABM.crear(unidadDeVenta2);
            unidadDeVentaABM.crear(unidadDeVenta3);
        }

        
    }
}
