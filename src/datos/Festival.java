package datos;

import java.time.LocalDate;
import java.util.Set;

public class Festival {

	private long id;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double costoSuperficie;
	private double costoMontaje;
	private double plusElectricidad;
	private double sueldoBase;
	private Set<UnidadDeVenta> unidadesDeVenta;

	protected Festival() {
	}

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, double costoSuperficie,
			double costoMontaje, double plusElectricidad, double sueldoBase) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoSuperficie = costoSuperficie;
		this.costoMontaje = costoMontaje;
		this.plusElectricidad = plusElectricidad;
		this.sueldoBase = sueldoBase;
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

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getCostoSuperficie() {
		return costoSuperficie;
	}

	public void setCostoSuperficie(double costoSuperficie) {
		this.costoSuperficie = costoSuperficie;
	}

	public double getCostoMontaje() {
		return costoMontaje;
	}

	public void setCostoMontaje(double costoMontaje) {
		this.costoMontaje = costoMontaje;
	}

	public double getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(double plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Set<UnidadDeVenta> getUnidadesDeVenta() {
		return unidadesDeVenta;
	}

	public void setUnidadesDeVenta(Set<UnidadDeVenta> unidadesDeVenta) {

		this.unidadesDeVenta = unidadesDeVenta;
	}

	public void agregarUnidadDeVenta(UnidadDeVenta unidad) {

		unidadesDeVenta.add(unidad);

		unidad.setFestival(this);
	}

	public void eliminarUnidadDeVenta(UnidadDeVenta unidad) {

		unidadesDeVenta.remove(unidad);

		unidad.setFestival(null);
	}

	@Override
	public String toString() {
		return "Festival [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", costoSuperficie=" + costoSuperficie + ", costoMontaje=" + costoMontaje
				+ ", plusElectricidad=" + plusElectricidad + ", sueldoBase=" + sueldoBase + "]";
	}

}
