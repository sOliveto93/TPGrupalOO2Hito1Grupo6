package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Enum.Estaciones;
import dao.UnidadDeVentaDAO;
import datos.Cocinero;
import datos.DetallePedido;
import datos.Festival;
import datos.Pedido;
import datos.Plato;
import datos.UnidadDeVenta;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
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
		
		
		//..........
		
		PedidoABM pedidoABM = new PedidoABM();
		PlatoABM platoABM = new PlatoABM();

		List<Plato> platos = platoABM.traerListaPlatos();

		UnidadDeVentaDAO unidadDAO = new UnidadDeVentaDAO();
		UnidadDeVenta unidad = unidadDAO.traer(1);
		
		DetallePedido detalle1 = new DetallePedido(platos.get(0), 1, null);
		DetallePedido detalle2 = new DetallePedido(platos.get(1), 2, null);
		
		Set<DetallePedido> detalles1 = new HashSet<>();
		detalles1.add(detalle1);
		
		
		Set<DetallePedido> detalles2 = new HashSet<>();
		detalles2.add(detalle2);		
		
		
		pedidoABM.crear(
			    LocalDate.of(2026, 9, 5),
			    unidad,
			    detalles1
			);
		
		pedidoABM.crear(
			    LocalDate.of(2026, 9, 6),
			    unidad,
			    detalles2
			);

			pedidoABM.crear(
			    LocalDate.of(2026, 9, 10),
			    unidad,
			    detalles1
			);
		
		
		List<Pedido> pedidos = pedidoABM.traerPedidosDeUnidadEntreFechas(unidad,LocalDate.of(2026, 9, 1),LocalDate.of(2026, 9, 6));
		
		for (Pedido pedido : pedidos) {
		    System.out.println(pedido);
		}
		
		double recaudacion = pedidoABM.recaudacionEntreFechas(unidad, LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 6));
		
		System.out.println("Recaudacion: $" + recaudacion);
 
	}

}
