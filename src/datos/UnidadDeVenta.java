package datos;

import java.util.Set;

public abstract class UnidadDeVenta {

	protected long id;
	protected String nombreComercial;
	protected Staff encargado;
	protected int superficie;
	protected int codigoChico;
	protected Festival festival;
	protected Set<Plato> listaDePlatos;
	protected Set<Staff> personal;

	public UnidadDeVenta() {
	}

	public UnidadDeVenta(String nombreComercial, Staff encargado, int superficie, int codigoChico, Festival festival,
			Set<Plato> listaDePlatos, Set<Staff> personal) {

		super();

		this.nombreComercial = nombreComercial;
		this.encargado = encargado;
		this.superficie = superficie;
		this.codigoChico = codigoChico;
		this.festival = festival;
		this.listaDePlatos = listaDePlatos;
		this.personal = personal;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Staff getEncargado() {
		return encargado;
	}

	public void setEncargado(Staff encargado) {
		this.encargado = encargado;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getCodigoChico() {
		return codigoChico;
	}

	public void setCodigoChico(int codigoChico) {
		this.codigoChico = codigoChico;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Set<Plato> getListaDePlatos() {
		return listaDePlatos;
	}

	public void setListaDePlatos(Set<Plato> listaDePlatos) {
		this.listaDePlatos = listaDePlatos;
	}

	public Set<Staff> getPersonal() {
		return personal;
	}

	public void setPersonal(Set<Staff> personal) {
		this.personal = personal;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {

		return "UnidadDeVenta [id=" + id + ", nombreComercial=" + nombreComercial + ", encargado=" + encargado
				+ ", superficie=" + superficie + ", codigoChico=" + codigoChico + "]";
	}
}