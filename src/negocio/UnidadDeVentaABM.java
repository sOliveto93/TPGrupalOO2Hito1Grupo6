package negocio;

import java.util.List;
import java.util.Set;

import dao.UnidadDeVentaDAO;
import datos.Festival;
import datos.FoodTruck;
import datos.Plato;
import datos.PuestoDesarmable;
import datos.Staff;
import datos.UnidadDeVenta;

public class UnidadDeVentaABM {

	private UnidadDeVentaDAO dao = UnidadDeVentaDAO.getInstance();

	public UnidadDeVentaABM() {
	}

	public UnidadDeVenta crear(UnidadDeVenta nueva) {

		if (dao.traerPorCodigoChico(nueva.getCodigoChico()) == null) {

			return dao.crear(nueva);

		} else {

			throw new RuntimeException("No se puede crear Unidades con el mismo codigo Chico");
		}
	}


	public UnidadDeVenta crearFoodTruck(String nombreComercial, Staff encargado, int superficie, int codigoChico,
			Festival festival, Set<Plato> listaDePlatos, Set<Staff> personal, String patente, boolean usaElectricidad) {

		if (dao.traerPorCodigoChico(codigoChico) == null) {

			FoodTruck foodTruck = new FoodTruck(nombreComercial, encargado, superficie, codigoChico, festival,
					listaDePlatos, personal, patente, usaElectricidad);

			return dao.crear(foodTruck);

		} else {

			throw new RuntimeException("No se puede crear Unidades con el mismo codigo Chico");
		}
	}

	public UnidadDeVenta crearPuestoDesarmable(String nombreComercial, Staff encargado, int superficie, int codigoChico,
			Festival festival, Set<Plato> listaDePlatos, Set<Staff> personal, int carpas, int tiempoMontaje) {

		if (dao.traerPorCodigoChico(codigoChico) == null) {

			PuestoDesarmable puesto = new PuestoDesarmable(nombreComercial, encargado, superficie, codigoChico,
					festival, listaDePlatos, personal, carpas, tiempoMontaje);

			return dao.crear(puesto);

		} else {

			throw new RuntimeException("No se puede crear Unidades con el mismo codigo Chico");
		}
	}

	public List<UnidadDeVenta> traerTodos() {

		return dao.traerTodos();
	}

	public UnidadDeVenta traer(long id) {

		return dao.traer(id);
	}

	public UnidadDeVenta traerPorCodigoChico(int codigo) {

		UnidadDeVenta unidad = dao.traerPorCodigoChico(codigo);

		if (unidad != null) {

			return unidad;

		} else {

			throw new RuntimeException("No existe una unidad con ese codigo");
		}
	}

	public List<UnidadDeVenta> traerPorFestival(Festival festival) {

		System.out.println("\n=========buscando unidades de venta por festival=======\n");

		return dao.traerPorFestival(festival);
	}
}