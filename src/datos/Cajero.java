package datos;

import java.time.LocalDate;

public class Cajero extends Staff{
	private String turno;

	public Cajero() {
	}
	

	public Cajero(String turno) {
		this.turno = turno;
	}


	public Cajero(String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			double sueldoBase, UnidadDeVenta unidadDeVenta, boolean encargado, Integer codigoUnidadDeVentaEncargada,
			String turno) {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, unidadDeVenta, encargado,
				codigoUnidadDeVentaEncargada);
		this.turno = turno;
	}


	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
	    return "Cajero [" + super.toString() + ", turno=" + turno + "]\n";
	}
	
}
