package datos;

import java.util.Set;

public class PuestoDesarmable extends UnidadDeVenta {
	private int carpas;
	private int tiempoMontaje;
	
	public PuestoDesarmable() {};
	public PuestoDesarmable(String nombreComercial, Staff encargado, int superficie, int codigoChico,
			Festival nombreFestival, Set<Plato> listaDePlatos, Set<Staff> personal, int carpas, int tiempoMontaje) {
		super(nombreComercial, encargado, superficie, codigoChico, nombreFestival, listaDePlatos, personal);
		this.carpas = carpas;
		this.tiempoMontaje = tiempoMontaje;
	}
	public int getCarpas() {
		return carpas;
	}
	public void setCarpas(int carpas) {
		this.carpas = carpas;
	}
	public int getTiempoMontaje() {
		return tiempoMontaje;
	}
	public void setTiempoMontaje(int tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}
	@Override
	public String toString() {
		return "PuestoDesarmable [carpas=" + carpas + ", tiempoMontaje=" + tiempoMontaje + "]";
	}
	
}
