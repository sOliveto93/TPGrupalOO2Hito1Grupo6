package negocio;

import java.util.Set;

import dao.PlatoDAO;
import datos.Plato;

public class PlatoABM {

    PlatoDAO dao= PlatoDAO.getInstance();

    public PlatoABM(){}

    public Plato crearPlato(Plato plato){

        if(dao.traer(plato.getNombre())==null){
            return dao.crear(plato);
        }else{
            throw new RuntimeException("Ya existe un plato con ese nombre "+ plato.getNombre());
        }
    }
    public Set<Plato> traerTodos(){
        return dao.traerTodos();
    }
}
