package negocio;

import dao.DetallePedidoDAO;
import datos.DetallePedido;
import datos.Pedido;
import datos.Plato;

public class DetallePedidoABM {

    DetallePedidoDAO dao= DetallePedidoDAO.getInstance();

    public DetallePedidoABM(){}

    public DetallePedido crear(Plato plato, int cantidad,Pedido pedido){

        return dao.crear(new DetallePedido(plato,cantidad,pedido));
    }
    public DetallePedido trear(long id){

        return dao.traer(id);
    }
}
