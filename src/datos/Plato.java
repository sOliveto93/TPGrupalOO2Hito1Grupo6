package datos;

public class Plato {
	private long id;
	private String nombre;
	private double precio;
	private double costo;

	protected Plato() {
	};

	public Plato(String nombre, double precio, double costo) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.costo = costo;
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
	public int hashCode() {
		int result = Long.hashCode(id);
		result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof Plato))
			return false;

		Plato plato = (Plato) obj;

		if (id != plato.id)
			return false;

		if (nombre == null)
			return plato.nombre == null;

		return nombre.equals(plato.nombre);
	}

	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", costo=" + costo + "]";
	}

}
