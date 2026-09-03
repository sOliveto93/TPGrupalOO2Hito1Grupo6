package datos;

public class DetallePedido {
	private long id;
	private Plato plato;
	private int cantidad;
	private Pedido pedido;
	protected DetallePedido() {}
	
	public DetallePedido(Plato plato, int cantidad,Pedido pedido) {
		
		this.plato = plato;
		this.cantidad = cantidad;
		this.pedido=pedido;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
