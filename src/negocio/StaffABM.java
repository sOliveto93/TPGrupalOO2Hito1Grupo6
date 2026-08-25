package negocio;

import java.util.List;

import dao.StaffDAO;
import datos.Staff;
import datos.Cajero;
import datos.Cocinero;

public class StaffABM {

    StaffDAO dao=new StaffDAO();

    public StaffABM(){};

    public Staff crearStaff(Staff staff){
        return dao.crear(staff);
    }
    public Staff traerStaff(long id){
        return dao.traer(id);
    }

    public List<Staff> traerTodosStaff(){
        System.out.println("-------LISTA DE TODO EL PERSONAL STAFF----------");
        return dao.traerTodos();

    }

    public List<Cajero> traerTodosCajeros(){
        System.out.println("------------LISTA DE TODOS LOS CAJEROS---------------\n");
        return dao.traerCajeros();
    }

    public List<Cocinero> traerTodosCocineros(){
        System.out.println("------------LISTA DE TODOS LOS COCINEROS--------");
        return dao.traerCocineros();

    }

    public List<Cajero> traerCajerosPorTurno(String turno){
        System.out.println("--------------LISTA DE CAJEROS POR TURNO---------");
        return dao.traerCajerosPorTurno(turno);
    }

    public Staff traerStaffPorDni(long dni){
    System.out.println("---BUSCANDO A STAFF CON DNI:"+dni+" ----");
    return dao.traerStaffPorDni(dni);

    }

}


