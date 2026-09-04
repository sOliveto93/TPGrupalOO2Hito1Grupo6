package datos;

import java.time.LocalDate;

public abstract class Staff {

	protected long id;
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;
	protected double sueldoBase;
	protected UnidadDeVenta unidadDeVenta;
	protected Integer codigoUnidadDeVentaEncargada;
	protected boolean encargado;

	public Staff() {
	}

	public Staff(String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			double sueldoBase, UnidadDeVenta unidadDeVenta,boolean encargado,Integer codigoUnidadDeVentaEncargada) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.sueldoBase = sueldoBase;
		this.unidadDeVenta = unidadDeVenta;
		this.encargado=encargado;
		this.codigoUnidadDeVentaEncargada=codigoUnidadDeVentaEncargada;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}

	public UnidadDeVenta getUnidadDeVenta() {
		return this.unidadDeVenta;
	}

	public Integer getCodigoUnidadDeVentaEncargada() {
		return codigoUnidadDeVentaEncargada;
	}

	public void setCodigoUnidadDeVentaEncargada(Integer codigoUnidadDeVentaEncargada) {
		this.codigoUnidadDeVentaEncargada = codigoUnidadDeVentaEncargada;
	}

	

	@Override
	public String toString() {
		return "Staff [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso + ", sueldoBase="
				+ sueldoBase + "]";
	}

	public boolean isEncargado() {
		return encargado;
	}

	public void setEncargado(boolean encargado) {
		this.encargado = encargado;
	}

}
