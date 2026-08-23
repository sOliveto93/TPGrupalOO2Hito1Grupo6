package datos;

import java.util.Set;

public class FoodTruck extends UnidadDeVenta{
	private String patente;
	private boolean usaElectricidad;
	
	public FoodTruck(){}
	public FoodTruck(String nombreComercial, Staff encargado, int superficie, int codigoChico, Festival nombreFestival,
			Set<Plato> listaDePlatos, Set<Staff> personal, String patente, boolean usaElectricidad) {
		super(nombreComercial, encargado, superficie, codigoChico, nombreFestival, listaDePlatos, personal);
		this.patente = patente;
		this.usaElectricidad = usaElectricidad;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public boolean isUsaElectricidad() {
		return usaElectricidad;
	}
	public void setUsaElectricidad(boolean usaElectricidad) {
		this.usaElectricidad = usaElectricidad;
	}
	@Override
	public String toString() {
		return "FoodTruck [patente=" + patente + ", usaElectricidad=" + usaElectricidad + "]";
	}
	
}
