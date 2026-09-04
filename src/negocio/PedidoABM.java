package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.DetallePedidoDAO;
import dao.PedidoDAO;
import datos.DetallePedido;
import datos.Pedido;
import datos.UnidadDeVenta;

public class PedidoABM {

    PedidoDAO dao = PedidoDAO.getInstance();
    DetallePedidoDAO daoDetalle = DetallePedidoDAO.getInstance();

    public PedidoABM() {
    }

    public Pedido crear(LocalDate fecha, UnidadDeVenta unidadDeVenta, Set<DetallePedido> detallePedido) {

        Set<DetallePedido> detalles = new HashSet<>();

        Pedido pedidoNuevo = new Pedido(fecha, unidadDeVenta, detalles);

        // Primero guardamos el Pedido
        pedidoNuevo = dao.crear(pedidoNuevo);

        // Ahora el Pedido ya tiene ID
        for (DetallePedido detalle : detallePedido) {
            detalle.setPedido(pedidoNuevo);
            detalles.add(daoDetalle.crear(detalle));
        }

        pedidoNuevo.setDetallePedido(detalles);
        return dao.actualizar(pedidoNuevo);
        

    }

    public Pedido trear(long id) {

        return dao.traer(id);
    }

    public Set<Pedido> traerTodos() {
        Set<Pedido> pedidos = new HashSet<>();
        try {
            return dao.traerTodos();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return pedidos;
    }

    public List<Pedido> traerListaPedido() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            return dao.traerListaPedido();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedidos;
    }


    public List<Pedido> traerEntreFechas(LocalDate inicio, LocalDate fin){
            List<Pedido> pedidos=new ArrayList<>();
        try {
            return dao.traerEntreFechas(inicio, fin);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return pedidos;
        
    }
}
