package test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datos.Cajero;
import datos.Cocinero;
import datos.DetallePedido;
import datos.Festival;
import datos.FoodTruck;
import datos.Pedido;
import datos.Plato;
import datos.Staff;
import datos.UnidadDeVenta;
import negocio.DetallePedidoABM;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

public class Main {

    public static void main(String[] args) {

        // este main es para inicializar la bd
        FestivalABM festivalABM = new FestivalABM();
        UnidadDeVentaABM unidadDeVentaABM = new UnidadDeVentaABM();
        StaffABM staffABM = new StaffABM();
        PlatoABM platoABM = new PlatoABM();
        PedidoABM pedidoABM = new PedidoABM();
        DetallePedidoABM detallePedidoABM = new DetallePedidoABM();

        Festival festival = festivalABM.traer(1);
        List<UnidadDeVenta> unidadesDeVentas = unidadDeVentaABM.traerTodos();
        Set<Staff> staffs = staffABM.traerTodosStaff();
        Set<Plato> platos = platoABM.traerTodos();
        Set<Pedido> pedidos = pedidoABM.traerTodos();

        if (platos.isEmpty()) {
            Plato plato1 = new Plato("Hamburguesa al vapor", 7000, 3000);
            Plato plato2 = new Plato("Pizza napolitana", 8500, 4000);
            Plato plato3 = new Plato("Pizza cuatro quesos", 9500, 4500);
            Plato plato4 = new Plato("Pizza de muzzarella", 7500, 3500);
            Plato plato5 = new Plato("Empanada de carne", 2500, 1000);
            platoABM.crearPlato(plato1);
            platoABM.crearPlato(plato2);
            platoABM.crearPlato(plato3);
            platoABM.crearPlato(plato4);
            platoABM.crearPlato(plato5);
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
                    250, null, false, null, "noche");

            Cocinero cocinero = new Cocinero("patricio", "no recuerdo", 88991122, LocalDate.of(2002, 5, 13),
                    LocalDate.now(), 300, null, false, null, "sushi", 65);
            Cajero cajero2 = new Cajero("lourdes", "crespo", 88888888, LocalDate.of(1993, 8, 7),
                    LocalDate.of(2026, 8, 23),
                    250, null, false, null, "noche");

            try {
                staffABM.crearStaff(cocinero);
                staffABM.crearStaff(cajero);
                staffABM.crearStaff(cajero2);
                staffs = staffABM.traerTodosStaff();
            } catch (Exception e) {

                e.printStackTrace();
            }

        }
        /// nunca esta vacia OJO!!!
        List<Plato> listaPlatos = platoABM.traerListaPlatos();

        DetallePedido detalle1 = new DetallePedido(listaPlatos.get(0), 2, null);

        DetallePedido detalle2 = new DetallePedido(listaPlatos.get(1), 5, null);

        DetallePedido detalle3 = new DetallePedido(listaPlatos.get(2), 1, null);

        DetallePedido detalle4 = new DetallePedido(listaPlatos.get(4), 3, null);
        
        Set<DetallePedido> detalles1 = new HashSet<>();
        detalles1.add(detalle1);
        detalles1.add(detalle2);
        Set<DetallePedido> detalles2 = new HashSet<>();
        detalles2.add(detalle3);
        detalles2.add(detalle4);

        if (unidadesDeVentas.isEmpty()) {

            UnidadDeVenta unidadDeVenta1 = new FoodTruck("El buen mordisco", null, 18, 42, festival,
                    platos, staffs, pedidos, "ABC123", true);
            UnidadDeVenta unidadDeVenta2 = new FoodTruck("El buen mordisco", null, 18, 64, festival,
                    platos, staffs, pedidos, "ABC123", true);

            unidadDeVentaABM.crear(unidadDeVenta1);
            unidadDeVentaABM.crear(unidadDeVenta2);

            if (pedidos.isEmpty()) {
                pedidos.add(pedidoABM.crear(LocalDate.now(), unidadDeVenta1, detalles1));
                pedidos.add(pedidoABM.crear(LocalDate.now(), unidadDeVenta2, detalles2));

            }

        }

    }
}
