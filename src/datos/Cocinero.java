package datos;

import java.time.LocalDate;

public class Cocinero extends Staff {
	private String especialidad;
	private double plusCategoria;
	
	public Cocinero() {}
	
	public Cocinero(String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			double sueldoBase, String especialidad, double plusCategoria) {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.especialidad = especialidad;
		this.plusCategoria = plusCategoria;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public double getPlusCategoria() {
		return plusCategoria;
	}
	public void setPlusCategoria(double plusCategoria) {
		this.plusCategoria = plusCategoria;
	}
	@Override
	public String toString() {
		return "Cocinero ["+super.toString()+"especialidad=" + especialidad + ", plusCategoria=" + plusCategoria + "]";
	}
	
}
