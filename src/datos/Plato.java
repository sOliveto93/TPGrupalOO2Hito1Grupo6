package datos;

public class Plato {
	private long id;
	private String nombre;
	private double precio;
	private double costo;
	
	protected Plato() {};
	public Plato(String nombre, double precio, double costo) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.costo = costo;
	}

	public long getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", costo=" + costo + "]";
	}
	
}
