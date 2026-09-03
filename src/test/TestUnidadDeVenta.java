package test;

import java.time.LocalDate;
import java.util.ArrayList;
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

public class TestUnidadDeVenta {

    public static void main(String[] args) {

        UnidadDeVentaABM unidadDeVentaABM = new UnidadDeVentaABM();
        StaffABM staffABM = new StaffABM();
        FestivalABM festivalABM = new FestivalABM();
        PlatoABM platoABM = new PlatoABM();

        Festival festival = festivalABM.traer(1);
        List<UnidadDeVenta> unidadesDeVentas = unidadDeVentaABM.traerTodos();
        Set<Staff> staffs = staffABM.traerTodosStaff();
        Set<Plato> platos = platoABM.traerTodos();

       
       
        System.out.println(unidadDeVentaABM.traerTodos());
        System.out.println(unidadDeVentaABM.traer(1));
        

        try {
            System.out.println(unidadDeVentaABM.traerPorCodigoChico(11));
        } catch (Exception e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        System.out.println(unidadDeVentaABM.traerPorCodigoChico(64));
        
        System.out.println(unidadDeVentaABM.traerPorFestival(festival));
     }
}
