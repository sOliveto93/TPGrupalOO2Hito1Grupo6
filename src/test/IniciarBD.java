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
import datos.PuestoDesarmable;
import datos.Staff;
import datos.UnidadDeVenta;
import negocio.DetallePedidoABM;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.StaffABM;
import negocio.UnidadDeVentaABM;

public class IniciarBD {

	public static void main(String[] args) {

		FestivalABM festivalABM = new FestivalABM();
		UnidadDeVentaABM unidadDeVentaABM = new UnidadDeVentaABM();
		StaffABM staffABM = new StaffABM();
		PlatoABM platoABM = new PlatoABM();
		PedidoABM pedidoABM = new PedidoABM();
		DetallePedidoABM detallePedidoABM = new DetallePedidoABM();

		try {

			Set<Staff> staffs = staffABM.traerTodosStaff();
			Set<Plato> platos = platoABM.traerTodos();
			Set<Pedido> pedidos = pedidoABM.traerTodos();
			List<UnidadDeVenta> unidadesDeVentas = unidadDeVentaABM.traerTodos();

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

			List<Festival> festivales = festivalABM.traerTodos();

			if (festivales.isEmpty()) {

				festivalABM.agregarFestival("la fiesta del dulce de leche", "primavera", LocalDate.of(2026, 9, 21),
						LocalDate.of(2026, 9, 23), 650, 300, 50, 100);

				festivalABM.agregarFestival("festival del membrillo", "verano", LocalDate.of(2026, 1, 10),
						LocalDate.of(2026, 1, 12), 250, 300, 50, 200);

				festivalABM.agregarFestival("la fiesta", "invierno", LocalDate.of(2026, 7, 5),
						LocalDate.of(2026, 7, 10), 500, 450, 80, 300);

				festivalABM.agregarFestival("la fiesta loca", "primavera", LocalDate.of(2026, 9, 20),
						LocalDate.of(2026, 9, 28), 750, 600, 100, 400);

				festivalABM.agregarFestival("la fiesta muy loca", "otoño", LocalDate.of(2026, 4, 15),
						LocalDate.of(2026, 4, 18), 400, 350, 70, 250);

				festivales = festivalABM.traerTodos();
			}

			if (staffs.isEmpty()) {

				Cajero cajero = new Cajero("sebas", "oliveto", 11223344, LocalDate.of(1993, 8, 7),
						LocalDate.of(2026, 8, 23), 250, null, false, null, "noche");

				Cocinero cocinero = new Cocinero("patricio", "no recuerdo", 88900122, LocalDate.of(2002, 5, 13),
						LocalDate.now(), 300, null, false, null, "sushi", 65);

				Cajero cajero2 = new Cajero("Lourdes", "Crespo", 11223450, LocalDate.of(2003, 12, 22),
						LocalDate.of(2024, 11, 15), 300, null, false, null, "tarde");

				staffABM.crearStaff(cocinero);
				staffABM.crearStaff(cajero);
				staffABM.crearStaff(cajero2);

				staffs = staffABM.traerTodosStaff();
			}

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

				Staff encargado = staffs.iterator().next();

				Festival festival1 = festivales.get(0);
				Festival festival2 = festivales.get(1);
				Festival festival3 = festivales.get(2);
				Festival festival4 = festivales.get(3);
				Festival festival5 = festivales.get(4);

				UnidadDeVenta unidadDeVenta1 = new FoodTruck("El buen mordisco", encargado, 18, 42, festival1, platos,
						staffs, pedidos, "ABC123", true);

				UnidadDeVenta unidadDeVenta2 = new FoodTruck("La hamburguesa feliz", encargado, 17, 64, festival2,
						platos, staffs, pedidos, "DEF456", true);

				UnidadDeVenta unidadDeVenta3 = new FoodTruck("Angus Burger", encargado, 12, 43, festival3, platos,
						staffs, pedidos, "GOW123", true);

				UnidadDeVenta unidadDeVenta4 = new FoodTruck("Spot Burger", encargado, 19, 46, festival4, platos,
						staffs, pedidos, "LOL456", true);

				UnidadDeVenta unidadDeVenta5 = new PuestoDesarmable("Mery Jane", encargado, 15, 44, festival5, platos,
						staffs, pedidos, 2, 30);

				UnidadDeVenta unidadDeVenta6 = new PuestoDesarmable("Highblend", encargado, 14, 45, festival1, platos,
						staffs, pedidos, 3, 45);

				unidadDeVentaABM.crear(unidadDeVenta1);
				unidadDeVentaABM.crear(unidadDeVenta2);
				unidadDeVentaABM.crear(unidadDeVenta3);
				unidadDeVentaABM.crear(unidadDeVenta4);
				unidadDeVentaABM.crear(unidadDeVenta5);
				unidadDeVentaABM.crear(unidadDeVenta6);

				if (pedidos.isEmpty()) {

					pedidos.add(pedidoABM.crear(LocalDate.now(), unidadDeVenta1, detalles1));

					pedidos.add(pedidoABM.crear(LocalDate.now(), unidadDeVenta2, detalles2));

					pedidos.add(pedidoABM.crear(LocalDate.now(), unidadDeVenta3, detalles1));

					pedidos.add(pedidoABM.crear(LocalDate.now(), unidadDeVenta4, detalles2));

					pedidos.add(pedidoABM.crear(LocalDate.now(), unidadDeVenta5, detalles1));

					pedidos.add(pedidoABM.crear(LocalDate.now(), unidadDeVenta6, detalles2));
				}
			}

			System.out.println("\n========== FESTIVALES ==========");
			System.out.println(festivalABM.traerTodos());

			System.out.println("\n========== UNIDADES ==========");
			System.out.println(unidadDeVentaABM.traerTodos());

			System.out.println("\n========== PEDIDOS ==========");
			System.out.println(pedidoABM.traerTodos());

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}