package negocio;

import java.util.List;

import dao.UnidadDeVentaDAO;
import datos.Festival;
import datos.UnidadDeVenta;

public class UnidadDeVentaABM {

    private UnidadDeVentaDAO dao =UnidadDeVentaDAO.getInstance();

    public UnidadDeVentaABM(){}

    public UnidadDeVenta crear(UnidadDeVenta nueva){
        if(dao.traerPorCodigoChico(nueva.getCodigoChico()) == null){
          return dao.crear(nueva);  
        } 
        else{
            throw new RuntimeException("No se puede crear Unidades con el mismo codigo Chico");
        }
    }
    public List<UnidadDeVenta> traerTodos(){
        return dao.traerTodos();
    }
    public UnidadDeVenta traer(long id){
        return dao.traer(id);
    }
    
    public UnidadDeVenta  traerPorCodigoChico(int codigo){
        UnidadDeVenta unidad=dao.traerPorCodigoChico(codigo);
        if(unidad != null){
            return unidad;
        }else{
            throw new RuntimeException("No existe una unidad con ese codigo");
        }
    }
    public List<UnidadDeVenta> traerPorFestival(Festival festival){
        System.out.println("\\n=========buscando unidades de venta por festival=======\n");
        return dao.traerPorFestival(festival);
    }
}
