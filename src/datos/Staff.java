package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Staff {

	private long id;
	private String apellido;
	private String nombre;
	private int dni;
	private LocalDate fechaNacimiento;
	private boolean baja;
	
	public Staff() {}
	
	public Staff(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni= dni;
		this.baja = false;
	}
	
	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, Boolean.valueOf(baja), Integer.valueOf(dni), fechaNacimiento, Long.valueOf(id),
				nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return Objects.equals(apellido, other.apellido) && baja == other.baja && dni == other.dni
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && id == other.id
				&& Objects.equals(nombre, other.nombre);
	}



	
}