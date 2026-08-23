package datos;

import java.time.LocalDate;

public class Pedido {
	
	private long id;
    private LocalDate fecha;
    private UnidadDeVenta unidadDeVenta;
    private DetallePedido detallePedido;
    private Festival nombreFestival;

    public Pedido(LocalDate fecha, UnidadDeVenta unidadDeVenta,
                  DetallePedido detallePedido, Festival nombreFestival) {
        this.fecha = fecha;
        this.unidadDeVenta = unidadDeVenta;
        this.detallePedido = detallePedido;
        this.nombreFestival = nombreFestival;
    }

    protected Pedido() {
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

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    public Festival getNombreFestival() {
        return nombreFestival;
    }

    public void setNombreFestival(Festival nombreFestival) {
        this.nombreFestival = nombreFestival;
    }

    @Override
    public String toString() {
        return "Pedido [fecha=" + fecha
                + ", unidadDeVenta=" + unidadDeVenta
                + ", detallePedido=" + detallePedido
                + ", nombreFestival=" + nombreFestival + "]";
    }
}