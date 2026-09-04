package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {
	
	private long id;
    private LocalDate fecha;
    private UnidadDeVenta unidadDeVenta;
    private Set<DetallePedido> detallePedido;



    public Pedido(LocalDate fecha, UnidadDeVenta unidadDeVenta,
                  Set<DetallePedido> detallePedido) {
        this.fecha = fecha;
        this.unidadDeVenta = unidadDeVenta;
        this.detallePedido = detallePedido;
    }

    public Pedido() {
    }
    
    public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public UnidadDeVenta getUnidadDeVenta() {
        return unidadDeVenta;
    }

    public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
        this.unidadDeVenta = unidadDeVenta;
    }

    public Set<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(Set<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }


    @Override
public String toString() {
    return "Pedido [id=" + id
            + ", fecha=" + fecha + "]";
}
}